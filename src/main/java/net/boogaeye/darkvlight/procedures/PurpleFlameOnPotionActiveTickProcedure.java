package net.boogaeye.darkvlight.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.potion.RustingPotion;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;
import java.util.Collection;

public class PurpleFlameOnPotionActiveTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure PurpleFlameOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack vopy = ItemStack.EMPTY;
		double slot = 0;
		entity.getPersistentData().putDouble("PFlameTick", ((entity.getPersistentData().getDouble("PFlameTick")) + ((new Object() {
			int check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == RustingPotion.potion)
							return effect.getAmplifier();
					}
				}
				return 0;
			}
		}.check(entity)) + 1)));
		if (((entity.getPersistentData().getDouble("PFlameTick")) > 20)) {
			entity.setFire((int) 10);
			entity.attackEntityFrom(DamageSource.IN_FIRE, (float) 1);
			entity.getPersistentData().putDouble("PFlameTick", 0);
		}
	}
}
