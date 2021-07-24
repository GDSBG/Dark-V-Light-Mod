package net.boogaeye.darkvlight.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.potion.EffectInstance;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.potion.EnlightendFilteringPotionEffect;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

public class DarkendFloaterEntityIsHurtProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency sourceentity for procedure DarkendFloaterEntityIsHurt!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency x for procedure DarkendFloaterEntityIsHurt!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency y for procedure DarkendFloaterEntityIsHurt!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency z for procedure DarkendFloaterEntityIsHurt!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure DarkendFloaterEntityIsHurt!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.random() < 0.2)) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.DRAGON_BREATH, x, y, z, (int) 15, 5, 5, 5, 1);
			}
			if ((((Entity) world
					.getEntitiesWithinAABB(PlayerEntity.class,
							new AxisAlignedBB(x - (5 / 2d), y - (5 / 2d), z - (5 / 2d), x + (5 / 2d), y + (5 / 2d), z + (5 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null)) {
				if (sourceentity instanceof LivingEntity)
					((LivingEntity) sourceentity)
							.addPotionEffect(new EffectInstance(EnlightendFilteringPotionEffect.potion, (int) 200, (int) 0, (false), (true)));
			}
			if ((((Entity) world
					.getEntitiesWithinAABB(ServerPlayerEntity.class,
							new AxisAlignedBB(x - (5 / 2d), y - (5 / 2d), z - (5 / 2d), x + (5 / 2d), y + (5 / 2d), z + (5 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null)) {
				if (sourceentity instanceof LivingEntity)
					((LivingEntity) sourceentity)
							.addPotionEffect(new EffectInstance(EnlightendFilteringPotionEffect.potion, (int) 200, (int) 0, (false), (true)));
			}
		}
	}
}
