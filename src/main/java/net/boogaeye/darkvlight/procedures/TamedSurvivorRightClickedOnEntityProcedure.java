package net.boogaeye.darkvlight.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class TamedSurvivorRightClickedOnEntityProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure TamedSurvivorRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency sourceentity for procedure TamedSurvivorRightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		sourceentity.getPersistentData().putDouble("SHP", ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1));
		sourceentity.getPersistentData().putDouble("SArmor", ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getTotalArmorValue() : 0));
	}
}
