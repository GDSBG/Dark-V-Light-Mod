package net.boogaeye.darkvlight.procedures;

import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class AngerForDarkHornAIProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure AngerForDarkHornAI!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (!(entity.getPersistentData().getBoolean("Anger")));
	}
}
