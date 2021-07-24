package net.boogaeye.darkvlight.procedures;

import net.minecraft.util.Hand;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.potion.SurvivorTradePotionEffect;
import net.boogaeye.darkvlight.potion.AngerPotionEffect;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;
import java.util.Collection;

public class DarkendSurviverRightClickedOnEntityProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure DarkendSurviverRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency sourceentity for procedure DarkendSurviverRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency itemstack for procedure DarkendSurviverRightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		ItemStack CurItem = ItemStack.EMPTY;
		double WaitTime = 0;
		if (sourceentity instanceof PlayerEntity)
			((PlayerEntity) sourceentity).closeScreen();
		if ((!(new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == AngerPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity)))) {
			entity.getPersistentData().putBoolean("Trade", (true));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(
						new EffectInstance(SurvivorTradePotionEffect.potion, (int) (100 + (Math.random() * 100)), (int) 0, (false), (true)));
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = ((itemstack).copy());
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			((itemstack)).shrink((int) 1);
		}
	}
}
