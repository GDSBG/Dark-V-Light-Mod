package net.boogaeye.darkvlight.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.potion.EnlightendPotionEffect;
import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;
import java.util.Collection;

public class EnlightendOnPotionActiveTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure EnlightendOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("EnlightendTick", ((entity.getPersistentData().getDouble("EnlightendTick")) + ((new Object() {
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
		if (((entity.getPersistentData().getDouble("EnlightendTick")) >= 20)) {
			{
				double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend) + 1);
				entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Enlightend = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.getPersistentData().putDouble("EnlightendTick", 0);
			if ((((entity.getPersistentData().getString("Type"))).equals("Endarkend"))) {
				entity.attackEntityFrom(DamageSource.STARVE, (float) 1);
			}
		}
	}
}
