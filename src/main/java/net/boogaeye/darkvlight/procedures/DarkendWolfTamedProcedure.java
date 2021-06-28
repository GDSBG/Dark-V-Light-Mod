package net.boogaeye.darkvlight.procedures;

import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class DarkendWolfTamedProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure DarkendWolfTamed!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!((entity instanceof TameableEntity) ? ((TameableEntity) entity).isTamed() : false))) {
			return (true);
		}
		return (false);
	}
}
