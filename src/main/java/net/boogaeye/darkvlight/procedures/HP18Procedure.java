package net.boogaeye.darkvlight.procedures;

import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class HP18Procedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure HP18!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (17 < (entity.getPersistentData().getDouble("SHP")));
	}
}
