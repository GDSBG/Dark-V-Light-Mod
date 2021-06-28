package net.boogaeye.darkvlight.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;
import java.util.Collections;

public class EnlightendDimensionPlayerEntersDimensionProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure EnlightendDimensionPlayerEntersDimension!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure EnlightendDimensionPlayerEntersDimension!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double tryx = 0;
		double tryy = 0;
		double tryz = 0;
		double increaseraduis = 0;
		double tries = 0;
		increaseraduis = (double) 10000;
		while ((!(world.getBlockState(new BlockPos((int) tryx, (int) tryy, (int) tryz)).isSolid()))) {
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate(0, 100, 0);
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation(0, 100, 0, _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
				}
			}
			tryx = (double) (Math.random() * increaseraduis);
			tryz = (double) (Math.random() * increaseraduis);
			tryy = (double) (Math.random() * 100);
			tries = (double) (tries + 1);
			if ((30 < tries)) {
				increaseraduis = (double) (increaseraduis + 10000);
				tries = (double) 0;
			}
		}
		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate(tryx, 100, tryz);
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation(tryx, 100, tryz, _ent.rotationYaw, _ent.rotationPitch,
						Collections.emptySet());
			}
		}
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1000, (int) 255, (false), (false)));
	}
}
