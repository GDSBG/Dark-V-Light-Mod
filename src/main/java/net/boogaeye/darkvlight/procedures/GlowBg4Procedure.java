package net.boogaeye.darkvlight.procedures;

import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class GlowBg4Procedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure GlowBg4!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (4 < ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier));
	}
}
