package net.boogaeye.darkvlight.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
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
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.boogaeye.darkvlight.potion.RustingPotion;
import net.boogaeye.darkvlight.item.GliphsSwordItem;
import net.boogaeye.darkvlight.item.DarkShardItem;
import net.boogaeye.darkvlight.entity.HealDroneEntity;
import net.boogaeye.darkvlight.entity.DarkendBossEntity2Entity;
import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class DarkendBossEntity2OnEntityTickUpdateProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure DarkendBossEntity2OnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency x for procedure DarkendBossEntity2OnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency y for procedure DarkendBossEntity2OnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency z for procedure DarkendBossEntity2OnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure DarkendBossEntity2OnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double suckx = 0;
		double sucky = 0;
		double suckz = 0;
		double forcex = 0;
		double forcey = 0;
		double forcez = 0;
		double attacks = 0;
		attacks = (double) 6;
		if (world instanceof ServerWorld)
			((ServerWorld) world).setDayTime((int) ((world.getWorldInfo().getDayTime()) + 100));
		world.getWorldInfo().setRaining((true));
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if ((entityiterator instanceof HealDroneEntity.CustomEntity)) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 20, (int) 4, (false), (true)));
				}
			}
		}
		if ((((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getHealth()
				: -1) <= (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) * 0.5))) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					suckx = (double) (x - (entityiterator.getPosX()));
					sucky = (double) (y - (entityiterator.getPosY()));
					suckz = (double) (z - (entityiterator.getPosZ()));
					if ((!(entityiterator instanceof DarkendBossEntity2Entity.CustomEntity))) {
						if ((entityiterator instanceof LivingEntity)) {
							if (((new java.text.DecimalFormat("##.##").format(suckx)).contains("-"))) {
								forcex = (double) 0.01;
							} else {
								forcex = (double) (-0.01);
							}
							if (((new java.text.DecimalFormat("##.##").format(sucky)).contains("-"))) {
								forcey = (double) (-0.01);
							} else {
								forcey = (double) 0.01;
							}
							if (((new java.text.DecimalFormat("##.##").format(suckz)).contains("-"))) {
								forcez = (double) 0.01;
							} else {
								forcez = (double) (-0.01);
							}
							entityiterator.setMotion(forcex, forcey, forcez);
						}
					}
				}
			}
		}
		if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType2 == 0)) {
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if ((!(entityiterator instanceof DarkendBossEntity2Entity.CustomEntity))) {
						if (entityiterator instanceof LivingEntity)
							((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(RustingPotion.potion, (int) 600, (int) 3));
					}
				}
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.elder_guardian.curse")),
						SoundCategory.NEUTRAL, (float) 1, (float) 0.5);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.elder_guardian.curse")),
						SoundCategory.NEUTRAL, (float) 1, (float) 0.5, false);
			}
			DarkVsLightModVariables.MapVariables.get(world).BossAttackType2 = (double) Math.round((Math.random() * attacks));
			DarkVsLightModVariables.MapVariables.get(world).syncData(world);
			DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2 = (double) 0;
			DarkVsLightModVariables.MapVariables.get(world).syncData(world);
		} else if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType2 == 1)) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(GliphsSwordItem.block, (int) (1));
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
			if ((((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getHealth()
					: -1) <= (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) * 0.5))) {
				DarkVsLightModVariables.MapVariables.get(world).BossAttackType2 = (double) Math.round((Math.random() * attacks));
				DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2 = (double) 0;
				DarkVsLightModVariables.MapVariables.get(world).syncData(world);
			}
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (30 / 2d), y - (30 / 2d), z - (30 / 2d), x + (30 / 2d), y + (30 / 2d), z + (30 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					suckx = (double) (x - (entityiterator.getPosX()));
					sucky = (double) (y - (entityiterator.getPosY()));
					suckz = (double) (z - (entityiterator.getPosZ()));
					if ((!(entityiterator instanceof DarkendBossEntity2Entity.CustomEntity))) {
						if (((new java.text.DecimalFormat("##.##").format(suckx)).contains("-"))) {
							forcex = (double) (-0.01);
						} else {
							forcex = (double) 0.01;
						}
						if (((new java.text.DecimalFormat("##.##").format(sucky)).contains("-"))) {
							forcey = (double) (-0.01);
						} else {
							forcey = (double) 0.01;
						}
						if (((new java.text.DecimalFormat("##.##").format(suckz)).contains("-"))) {
							forcez = (double) (-0.01);
						} else {
							forcez = (double) 0.01;
						}
						entityiterator.setMotion(forcex, forcey, forcez);
					}
				}
			}
			if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2 > 2000)) {
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dark_vs_light:drag")),
							SoundCategory.NEUTRAL, (float) 1, (float) 2);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dark_vs_light:drag")),
							SoundCategory.NEUTRAL, (float) 1, (float) 2, false);
				}
				DarkVsLightModVariables.MapVariables.get(world).BossAttackType2 = (double) Math.round((Math.random() * attacks));
				DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2 = (double) 0;
				DarkVsLightModVariables.MapVariables.get(world).syncData(world);
			}
		} else if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType2 == 2)) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(GliphsSwordItem.block, (int) (1));
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(Items.ENDER_PEARL, (int) (1));
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			if ((Math.random() < 0.15)) {
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if ((Math.random() < 0.5)) {
							{
								Entity _ent = entity;
								_ent.setPositionAndUpdate((entityiterator.getPosX()), (entityiterator.getPosY()), (entityiterator.getPosZ()));
								if (_ent instanceof ServerPlayerEntity) {
									((ServerPlayerEntity) _ent).connection.setPlayerLocation((entityiterator.getPosX()), (entityiterator.getPosY()),
											(entityiterator.getPosZ()), _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
								}
							}
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("dark_vs_light:upgrade")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("dark_vs_light:upgrade")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
							}
						}
					}
				}
			}
			if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2 > 500)) {
				DarkVsLightModVariables.MapVariables.get(world).BossAttackType2 = (double) Math.round((Math.random() * attacks));
				DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2 = (double) 0;
				DarkVsLightModVariables.MapVariables.get(world).syncData(world);
			}
		} else if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType2 == 3)) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(DarkShardItem.block, (int) (1));
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
			if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2 == 500)) {
				for (int index0 = 0; index0 < (int) (((Math.random() * 5) + 2)); index0++) {
					if (world instanceof ServerWorld) {
						LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
						_ent.moveForced(Vector3d.copyCenteredHorizontally(
								new BlockPos((int) (x + (10 - (Math.random() * 20))), (int) y, (int) (z + (10 - (Math.random() * 20))))));
						_ent.setEffectOnly(false);
						((World) world).addEntity(_ent);
					}
				}
			}
			if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2 > 1000)) {
				DarkVsLightModVariables.MapVariables.get(world).BossAttackType2 = (double) Math.round((Math.random() * attacks));
				DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2 = (double) 0;
				DarkVsLightModVariables.MapVariables.get(world).syncData(world);
			}
		} else if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType2 == 4)) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(Items.CROSSBOW, (int) (1));
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
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new ArrowEntity(EntityType.ARROW, (World) world);
				entityToSpawn.setLocationAndAngles((x + (10 - (Math.random() * 20))), 100, (z + (10 - (Math.random() * 20))),
						world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2 > 1000)) {
				DarkVsLightModVariables.MapVariables.get(world).BossAttackType2 = (double) Math.round((Math.random() * attacks));
				DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2 = (double) 0;
				DarkVsLightModVariables.MapVariables.get(world).syncData(world);
			}
		} else if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType2 == 5)) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(GliphsSwordItem.block, (int) (1));
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
			if ((DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2 > 1000)) {
				DarkVsLightModVariables.MapVariables.get(world).BossAttackType2 = (double) Math.round((Math.random() * attacks));
				DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2 = (double) 0;
				DarkVsLightModVariables.MapVariables.get(world).syncData(world);
			}
		} else if ((DarkVsLightModVariables.MapVariables.get(world).BossAttackType2 == 6)) {
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new HealDroneEntity.CustomEntity(HealDroneEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			DarkVsLightModVariables.MapVariables.get(world).BossAttackType2 = (double) Math.round((Math.random() * attacks));
			DarkVsLightModVariables.MapVariables.get(world).syncData(world);
			DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2 = (double) 0;
			DarkVsLightModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.death")),
						SoundCategory.NEUTRAL, (float) 1, (float) 0.7);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.death")),
						SoundCategory.NEUTRAL, (float) 1, (float) 0.7, false);
			}
		} else {
			DarkVsLightModVariables.MapVariables.get(world).BossAttackType2 = (double) Math.round((Math.random() * 6));
			DarkVsLightModVariables.MapVariables.get(world).syncData(world);
			DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2 = (double) 0;
			DarkVsLightModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
