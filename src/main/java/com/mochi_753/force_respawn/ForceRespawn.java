package com.mochi_753.force_respawn;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ForceRespawn.MOD_ID)
public class ForceRespawn {
    public static final String MOD_ID = "force_respawn";

    @SuppressWarnings("removal")
    public ForceRespawn() {
        FMLJavaModLoadingContext context = FMLJavaModLoadingContext.get();
        IEventBus eventBus = context.getModEventBus();
    }
}
