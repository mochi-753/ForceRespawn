package com.mochi_753.force_respawn;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

@OnlyIn(Dist.CLIENT)
public class ModKeyMappings {
    public static final KeyMapping RESPAWN_KEY = new KeyMapping(
            "key.force_respawn.respawn",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_DELETE),
            "key.force_respawn.category"
    );
}
