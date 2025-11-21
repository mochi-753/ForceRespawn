package com.mochi_753.force_respawn.register;

import com.mochi_753.force_respawn.ForceRespawn;
import com.mochi_753.force_respawn.network.ServerboundRespawnPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModNetworks {
    private static final String PROTOCOL_VERSION = "1";

    @SuppressWarnings("removal")
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(ForceRespawn.MOD_ID, "main"),
            () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals
    );

    public static void init() {
        // パケット1個なのでID直書き
        CHANNEL.messageBuilder(ServerboundRespawnPacket.class, 0, NetworkDirection.PLAY_TO_SERVER)
                .encoder(ServerboundRespawnPacket::encode)
                .decoder(ServerboundRespawnPacket::decode)
                .consumerMainThread(ServerboundRespawnPacket::handle)
                .add();
    }
}
