package net.boogaeye.darkvlight.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.potion.PurpleFlamePotionEffect;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;
import java.util.Collection;

public class PurpFireDisplayOverlayIngameProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure PurpFireDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return ((new Object() {
			int check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == PurpleFlamePotionEffect.potion)
							return effect.getDuration();
					}
				}
				return 0;
			}
		}.check(entity)) != 0);
	}
}
