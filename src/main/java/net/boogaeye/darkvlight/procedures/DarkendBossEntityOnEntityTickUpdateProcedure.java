package net.boogaeye.darkvlight.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.boogaeye.darkvlight.item.DarkendOrbItem;
import net.boogaeye.darkvlight.item.DarkStoneSwordItem;
import net.boogaeye.darkvlight.entity.DarkendFloaterEntity;
import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class DarkendBossEntityOnEntityTickUpdateProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure DarkendBossEntityOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency x for procedure DarkendBossEntityOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency y for procedure DarkendBossEntityOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency z for procedure DarkendBossEntityOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure DarkendBossEntityOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double attacks = 0;
		attacks = (double) 7;
		if ((DarkVsLightModVariables.MapVariables.get(world).BossAI != 0)) {
			if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType == 1)) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(DarkStoneSwordItem.block, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Items.SHIELD, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 2, (false), (false)));
				if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick > 500)) {
					if ((DarkVsLightModVariables.MapVariables.get(world).BossAI != 2)) {
						DarkVsLightModVariables.MapVariables.get(world).BossAttackType = (double) Math.round((Math.random() * attacks));
						DarkVsLightModVariables.MapVariables.get(world).syncData(world);
					}
					DarkVsLightModVariables.MapVariables.get(world).BossWorldTick = (double) 0;
					DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				}
			} else if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType == 2)) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(DarkStoneSwordItem.block, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick > 1000)) {
					if ((DarkVsLightModVariables.MapVariables.get(world).BossAI != 2)) {
						DarkVsLightModVariables.MapVariables.get(world).BossAttackType = (double) Math.round((Math.random() * attacks));
						DarkVsLightModVariables.MapVariables.get(world).syncData(world);
					}
					DarkVsLightModVariables.MapVariables.get(world).BossWorldTick = (double) 0;
					DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				}
			} else if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType == 3)) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Items.POTION, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				if ((((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getHealth()
						: -1) < (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) * 0.2))) {
					if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick > 600)) {
						if (world instanceof World && !world.isRemote()) {
							((World) world)
									.playSound(null, new BlockPos((int) x, (int) y, (int) z),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("dark_vs_light:waterfill")),
											SoundCategory.NEUTRAL, (float) 1, (float) 1);
						} else {
							((World) world).playSound(x, y, z,
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("dark_vs_light:waterfill")),
									SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 20, (int) 1));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 200, (int) 1));
						DarkVsLightModVariables.MapVariables.get(world).BossWorldTick = (double) 0;
						DarkVsLightModVariables.MapVariables.get(world).syncData(world);
						if ((DarkVsLightModVariables.MapVariables.get(world).BossAI != 2)) {
							DarkVsLightModVariables.MapVariables.get(world).BossAttackType = (double) Math.round((Math.random() * attacks));
							DarkVsLightModVariables.MapVariables.get(world).syncData(world);
						}
					}
				} else {
					if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick > 300)) {
						if (world instanceof World && !world.isRemote()) {
							((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.empty")),
									SoundCategory.NEUTRAL, (float) 1, (float) 1);
						} else {
							((World) world).playSound(x, y, z,
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.empty")),
									SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
						}
						if ((Math.random() < 0.3)) {
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 20, (int) 1));
						} else if ((Math.random() < 0.5)) {
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 200, (int) 1));
						} else if ((Math.random() < 0.6)) {
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 200, (int) 1));
						} else {
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 200, (int) 1));
						}
						DarkVsLightModVariables.MapVariables.get(world).BossWorldTick = (double) 0;
						DarkVsLightModVariables.MapVariables.get(world).syncData(world);
						if ((DarkVsLightModVariables.MapVariables.get(world).BossAI != 2)) {
							DarkVsLightModVariables.MapVariables.get(world).BossAttackType = (double) Math.round((Math.random() * attacks));
							DarkVsLightModVariables.MapVariables.get(world).syncData(world);
						}
					}
				}
			} else if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType == 4)) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Items.ENCHANTED_BOOK, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(DarkendOrbItem.block, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick > 300)) {
					for (int index0 = 0; index0 < (int) ((Math.random() * 3)); index0++) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new DarkendFloaterEntity.CustomEntity(DarkendFloaterEntity.entity, (World) world);
							entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world)
								.playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("dark_vs_light:bossspell")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("dark_vs_light:bossspell")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					DarkVsLightModVariables.MapVariables.get(world).BossWorldTick = (double) 0;
					DarkVsLightModVariables.MapVariables.get(world).syncData(world);
					if ((DarkVsLightModVariables.MapVariables.get(world).BossAI != 2)) {
						DarkVsLightModVariables.MapVariables.get(world).BossAttackType = (double) Math.round((Math.random() * attacks));
						DarkVsLightModVariables.MapVariables.get(world).syncData(world);
					}
				}
			} else if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType == 5)) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Items.ENCHANTED_BOOK, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Items.BONE, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick > 300)) {
					for (int index1 = 0; index1 < (int) ((Math.random() * 2)); index1++) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new SkeletonEntity(EntityType.SKELETON, (World) world);
							entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world)
								.playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("dark_vs_light:bossspell")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("dark_vs_light:bossspell")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if ((DarkVsLightModVariables.MapVariables.get(world).BossAI != 2)) {
						DarkVsLightModVariables.MapVariables.get(world).BossAttackType = (double) Math.round((Math.random() * attacks));
						DarkVsLightModVariables.MapVariables.get(world).syncData(world);
					}
					DarkVsLightModVariables.MapVariables.get(world).BossWorldTick = (double) 0;
					DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				}
			} else if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType == 6)) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Items.ENCHANTED_BOOK, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Items.ROTTEN_FLESH, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick > 300)) {
					for (int index2 = 0; index2 < (int) ((Math.random() * 2)); index2++) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new ZombieEntity(EntityType.ZOMBIE, (World) world);
							entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world)
								.playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("dark_vs_light:bossspell")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("dark_vs_light:bossspell")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if ((DarkVsLightModVariables.MapVariables.get(world).BossAI != 2)) {
						DarkVsLightModVariables.MapVariables.get(world).BossAttackType = (double) Math.round((Math.random() * attacks));
						DarkVsLightModVariables.MapVariables.get(world).syncData(world);
					}
					DarkVsLightModVariables.MapVariables.get(world).BossWorldTick = (double) 0;
					DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				}
			} else if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType == 7)) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(DarkStoneSwordItem.block, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Items.BOW, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if ((Math.random() < 0.1)) {
					if (entity instanceof LivingEntity) {
						Entity _ent = entity;
						if (!_ent.world.isRemote()) {
							ArrowEntity entityToSpawn = new ArrowEntity(_ent.world, (LivingEntity) entity);
							entityToSpawn.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, (float) 1, 0);
							entityToSpawn.setDamage((float) 5);
							entityToSpawn.setKnockbackStrength((int) 5);
							_ent.world.addEntity(entityToSpawn);
						}
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
					}
				}
				if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick > 400)) {
					if ((DarkVsLightModVariables.MapVariables.get(world).BossAI != 2)) {
						DarkVsLightModVariables.MapVariables.get(world).BossAttackType = (double) Math.round((Math.random() * attacks));
						DarkVsLightModVariables.MapVariables.get(world).syncData(world);
					}
					DarkVsLightModVariables.MapVariables.get(world).BossWorldTick = (double) 0;
					DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				}
			} else {
				DarkVsLightModVariables.MapVariables.get(world).BossAttackType = (double) Math.round((Math.random() * attacks));
				DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				DarkVsLightModVariables.MapVariables.get(world).BossWorldTick = (double) 0;
				DarkVsLightModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
