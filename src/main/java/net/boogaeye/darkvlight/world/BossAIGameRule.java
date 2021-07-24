package net.boogaeye.darkvlight.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.boogaeye.darkvlight.DarkVsLightModElements;

import java.lang.reflect.Method;

@DarkVsLightModElements.ModElement.Tag
public class BossAIGameRule extends DarkVsLightModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.IntegerValue> gamerule = GameRules.register("bossAI", GameRules.Category.MOBS, create(1));
	public BossAIGameRule(DarkVsLightModElements instance) {
		super(instance, 691);
	}

	public static GameRules.RuleType<GameRules.IntegerValue> create(int defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.IntegerValue.class, "func_223559_b", int.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.IntegerValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
