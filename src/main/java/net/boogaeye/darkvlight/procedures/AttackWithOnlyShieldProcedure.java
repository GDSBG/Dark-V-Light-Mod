package net.boogaeye.darkvlight.procedures;

import net.minecraft.world.IWorld;

import net.boogaeye.darkvlight.world.BossAIGameRule;
import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class AttackWithOnlyShieldProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure AttackWithOnlyShield!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getWorldInfo().getGameRulesInstance().getInt(BossAIGameRule.gamerule)) != 0)) {
			return (DarkVsLightModVariables.MapVariables.get(world).BossAttackType == 1);
		}
		return (false);
	}
}
