package net.boogaeye.darkvlight.procedures;

import net.minecraft.world.IWorld;

import net.boogaeye.darkvlight.world.BossAIGameRule;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class NoAIBossProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure NoAIBoss!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return ((world.getWorldInfo().getGameRulesInstance().getInt(BossAIGameRule.gamerule)) == 0);
	}
}
