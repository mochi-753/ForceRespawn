package com.mochi_753.force_respawn.network;

import com.mochi_753.force_respawn.ForceRespawn;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record ServerboundRespawnPacket() {
    public static void encode(ServerboundRespawnPacket packet, FriendlyByteBuf buf) {
    }

    public static ServerboundRespawnPacket decode(FriendlyByteBuf buf) {
        return new ServerboundRespawnPacket();
    }

    public static void handle(ServerboundRespawnPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player == null) {
                ForceRespawn.LOGGER.warn("Serverbound packet received without a valid sender!");
            } else {
                boolean keepInventory = player.level().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY);
                if (!keepInventory) player.getInventory().dropAll();
                player.connection.player = player.server.getPlayerList().respawn(player, keepInventory);
            }
        });
        context.setPacketHandled(true);
    }
}
