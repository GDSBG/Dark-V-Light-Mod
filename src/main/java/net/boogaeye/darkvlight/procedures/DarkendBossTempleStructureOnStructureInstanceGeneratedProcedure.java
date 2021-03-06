package net.boogaeye.darkvlight.procedures;

import net.minecraft.world.IWorld;

import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class DarkendBossTempleStructureOnStructureInstanceGeneratedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency x for procedure DarkendBossTempleStructureOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency y for procedure DarkendBossTempleStructureOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency z for procedure DarkendBossTempleStructureOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure DarkendBossTempleStructureOnStructureInstanceGenerated!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		DarkVsLightModVariables.MapVariables.get(world).TempleX = (double) x;
		DarkVsLightModVariables.MapVariables.get(world).syncData(world);
		DarkVsLightModVariables.MapVariables.get(world).TempleY = (double) y;
		DarkVsLightModVariables.MapVariables.get(world).syncData(world);
		DarkVsLightModVariables.MapVariables.get(world).TempleZ = (double) z;
		DarkVsLightModVariables.MapVariables.get(world).syncData(world);
		DarkVsLightModVariables.MapVariables.get(world).TempleGen = (boolean) (true);
		DarkVsLightModVariables.MapVariables.get(world).syncData(world);
	}
}
