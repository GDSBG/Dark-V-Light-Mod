package net.boogaeye.darkvlight.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.world.BossAIGameRule;
import net.boogaeye.darkvlight.potion.RustingPotionEffect;
import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class DeepDarkBossOnEntityTickUpdateProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure DeepDarkBossOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency x for procedure DeepDarkBossOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency y for procedure DeepDarkBossOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency z for procedure DeepDarkBossOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure DeepDarkBossOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double attacks = 0;
		double primelocX = 0;
		double primelocY = 0;
		double primelocZ = 0;
		double rolling = 0;
		attacks = (double) 3;
		if (((world.getWorldInfo().getGameRulesInstance().getInt(BossAIGameRule.gamerule)) != 0)) {
			if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType3 == 0)) {
				DarkVsLightModVariables.MapVariables.get(world).BossWorldTick3 = (double) 0;
				DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				DarkVsLightModVariables.MapVariables.get(world).BossAttackType3 = (double) Math.round((attacks * Math.random()));
				DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				rolling = (double) 0;
			} else if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType3 == 1)) {
				if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick3 == 0)) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.ambient")),
								SoundCategory.HOSTILE, (float) 1, (float) 0.7);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.ambient")),
								SoundCategory.HOSTILE, (float) 1, (float) 0.7, false);
					}
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 10, (int) 1, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING, (int) 10, (int) 1, (false), (false)));
				if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick3 > 500)) {
					DarkVsLightModVariables.MapVariables.get(world).BossAttackType3 = (double) 0;
					DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				}
			} else if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType3 == 2)) {
				entity.extinguish();
				if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick3 > 500)) {
					rolling = (double) (rolling + 1);
					if ((((rolling * 10) * Math.random()) < ((rolling * (15 / rolling)) * Math.random()))) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, (World) world);
							entityToSpawn.setLocationAndAngles((x + (((rolling * 10) * Math.random()) - 5)), y,
									(z + (((rolling * 10) * Math.random()) - 5)), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
					}
				}
				if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick3 > 1000)) {
					DarkVsLightModVariables.MapVariables.get(world).BossAttackType3 = (double) 0;
					DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				}
			} else if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType3 == 3)) {
				if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick3 == 20)) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.death")),
								SoundCategory.HOSTILE, (float) 1, (float) 0.7);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.death")),
								SoundCategory.HOSTILE, (float) 1, (float) 0.7, false);
					}
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (16 / 2d), y - (16 / 2d), z - (16 / 2d), x + (16 / 2d), y + (16 / 2d), z + (16 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (entity instanceof LivingEntity)
								((LivingEntity) entity)
										.addPotionEffect(new EffectInstance(RustingPotionEffect.potion, (int) 60, (int) 1, (false), (true)));
						}
					}
				}
				if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick3 > 1000)) {
					DarkVsLightModVariables.MapVariables.get(world).BossAttackType3 = (double) 0;
					DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				}
			}
		}
	}
}
