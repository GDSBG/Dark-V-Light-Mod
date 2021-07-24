package net.boogaeye.darkvlight.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.potion.SinkingPotionEffect;
import net.boogaeye.darkvlight.potion.EnlightendFilteringPotionEffect;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class EndarkendFluidMobplayerCollidesBlockProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure EndarkendFluidMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("dark_vs_light:nooooooooooooo")))
						.isDone()
				: false))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(SinkingPotionEffect.potion, (int) 60, (int) 0, (false), (true)));
		}
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(EnlightendFilteringPotionEffect.potion, (int) 60, (int) 2, (false), (true)));
	}
}
