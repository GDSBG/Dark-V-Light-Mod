package net.boogaeye.darkvlight.procedures;

import net.minecraft.world.IWorld;

import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class Boss2RunProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure Boss2Run!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return (DarkVsLightModVariables.MapVariables.get(world).BossAttackType2 == 5);
	}
}
