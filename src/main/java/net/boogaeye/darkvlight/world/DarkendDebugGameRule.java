package net.boogaeye.darkvlight.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.boogaeye.darkvlight.DarkVsLightModElements;

import java.lang.reflect.Method;

@DarkVsLightModElements.ModElement.Tag
public class DarkendDebugGameRule extends DarkVsLightModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.BooleanValue> gamerule = GameRules.register("darkendDebug", GameRules.Category.PLAYER,
			create(false));
	public DarkendDebugGameRule(DarkVsLightModElements instance) {
		super(instance, 569);
	}

	public static GameRules.RuleType<GameRules.BooleanValue> create(boolean defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.BooleanValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
