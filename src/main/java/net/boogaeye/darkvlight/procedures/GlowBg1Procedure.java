package net.boogaeye.darkvlight.procedures;

import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class GlowBg1Procedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure GlowBg1!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (1 < ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier));
	}
}
