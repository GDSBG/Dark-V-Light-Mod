package net.boogaeye.darkvlight.procedures;

import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class Armor20Procedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure Armor20!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (19 < (entity.getPersistentData().getDouble("SArmor")));
	}
}
