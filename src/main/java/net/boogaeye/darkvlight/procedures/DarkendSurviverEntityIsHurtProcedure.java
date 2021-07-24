package net.boogaeye.darkvlight.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.potion.AngerPotionEffect;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class DarkendSurviverEntityIsHurtProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure DarkendSurviverEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack ItemWow = ItemStack.EMPTY;
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(AngerPotionEffect.potion, (int) 200, (int) 1, (false), (true)));
	}
}
