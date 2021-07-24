package net.boogaeye.darkvlight.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.potion.EnlightendPotionEffect;
import net.boogaeye.darkvlight.potion.DarkendFilteringPotionEffect;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;
import java.util.Collection;

public class GlowingFruitFoodFoodEatenProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure GlowingFruitFoodFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 1200, (int) 1));
		if ((new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == EnlightendPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(EnlightendPotionEffect.potion, (int) 100, (int) ((new Object() {
					int check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == EnlightendPotionEffect.potion)
									return effect.getAmplifier();
							}
						}
						return 0;
					}
				}.check(entity)) + 1)));
		} else {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(EnlightendPotionEffect.potion, (int) 60, (int) 0));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DarkendFilteringPotionEffect.potion, (int) 60, (int) 0));
		}
	}
}
