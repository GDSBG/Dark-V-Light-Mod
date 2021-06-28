package net.boogaeye.darkvlight.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.potion.RustingPotion;
import net.boogaeye.darkvlight.potion.DarkendFilteringPotion;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class EnlightendSpiderEntityIsHurtProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency sourceentity for procedure EnlightendSpiderEntityIsHurt!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof LivingEntity)
			((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(RustingPotion.potion, (int) 300, (int) 3, (false), (true)));
		if (sourceentity instanceof LivingEntity)
			((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(DarkendFilteringPotion.potion, (int) 300, (int) 3, (false), (true)));
	}
}
