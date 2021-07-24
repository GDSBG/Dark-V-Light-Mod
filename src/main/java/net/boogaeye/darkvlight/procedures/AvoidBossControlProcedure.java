package net.boogaeye.darkvlight.procedures;

import net.minecraft.world.IWorld;

import net.boogaeye.darkvlight.world.BossAIGameRule;
import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class AvoidBossControlProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure AvoidBossControl!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getWorldInfo().getGameRulesInstance().getInt(BossAIGameRule.gamerule)) != 0)) {
			if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType >= 3)) {
				return (true);
			}
		}
		return (false);
	}
}
