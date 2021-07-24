package net.boogaeye.darkvlight.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.boogaeye.darkvlight.potion.EnlightendFilteringPotionEffect;
import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;
import java.util.Iterator;
import java.util.Collection;

public class EnlightendFilteringOnTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure EnlightendFilteringOnTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("LightendFilterTick", ((entity.getPersistentData().getDouble("LightendFilterTick")) + ((new Object() {
			int check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == EnlightendFilteringPotionEffect.potion)
							return effect.getAmplifier();
					}
				}
				return 0;
			}
		}.check(entity)) + 1)));
		if (((entity.getPersistentData().getDouble("LightendFilterTick")) >= 20)) {
			{
				double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend) - 1);
				entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Enlightend = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.getPersistentData().putDouble("LightendFilterTick", 0);
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("dark_vs_light:i_dont_feel_so_good"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		}
	}
}
