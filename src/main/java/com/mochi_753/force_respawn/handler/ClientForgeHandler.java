package com.mochi_753.force_respawn.handler;

import com.mochi_753.force_respawn.ForceRespawn;
import com.mochi_753.force_respawn.ModKeyMappings;
import com.mochi_753.force_respawn.network.ServerboundRespawnPacket;
import com.mochi_753.force_respawn.register.ModNetworks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = ForceRespawn.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientForgeHandler {
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (ModKeyMappings.RESPAWN_KEY.isDown() && ModKeyMappings.RESPAWN_KEY.consumeClick()) {
            ModNetworks.CHANNEL.sendToServer(new ServerboundRespawnPacket());
        }
    }
}
