package net.boogaeye.darkvlight.procedures;

import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class OtherFloatersOnInitialEntitySpawnProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure OtherFloatersOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putString("Type", "Endarkend");
	}
}
