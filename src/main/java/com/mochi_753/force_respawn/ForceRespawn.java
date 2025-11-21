package com.mochi_753.force_respawn;

import com.mochi_753.force_respawn.register.ModNetworks;
import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(ForceRespawn.MOD_ID)
public class ForceRespawn {
    public static final String MOD_ID = "force_respawn";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ForceRespawn() {
        ModNetworks.init();
    }
}
