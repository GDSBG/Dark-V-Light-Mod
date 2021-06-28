package net.boogaeye.darkvlight.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.boogaeye.darkvlight.potion.EnlightendBlindnessPotion;
import net.boogaeye.darkvlight.item.DarkStoneDustItem;
import net.boogaeye.darkvlight.item.BlindShardArmorItem;
import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Random;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

public class EnlightendMeterProProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure EnlightendMeterPro!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency x for procedure EnlightendMeterPro!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency y for procedure EnlightendMeterPro!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency z for procedure EnlightendMeterPro!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure EnlightendMeterPro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendTick) + 1);
			entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.EnlightendTick = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((100 < ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendTick))) {
			if (((RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(
					"dark_vs_light:enlightend_dimension"))) == (world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD))) {
				if ((5 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier))) {
					if ((0.15 > Math.random())) {
						{
							double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier) + 1);
							entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.EnlightendMultiplier = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
				if ((100 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend))) {
					{
						double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend)
								+ ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier));
						entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Enlightend = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if ((0 < ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend))) {
					if ((0 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).Darkend))) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.addPotionEffect(new EffectInstance(EnlightendBlindnessPotion.potion, (int) 200, (int) 1, (false), (false)));
					}
				}
				{
					double _setval = (double) 0;
					entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.EnlightendTick = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
						: ItemStack.EMPTY).getItem() == new ItemStack(BlindShardArmorItem.boots, (int) (1)).getItem())) {
					if ((((((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
							: ItemStack.EMPTY))
									.getMaxDamage()) < (15 + ((((entity instanceof LivingEntity)
											? ((LivingEntity) entity).getItemStackFromSlot(
													EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
											: ItemStack.EMPTY)).getDamage())))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(DarkStoneDustItem.block, (int) (1)));
							entityToSpawn.setPickupDelay((int) 60);
							world.addEntity(entityToSpawn);
						}
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world)
								.playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("dark_vs_light:shadowarmor")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("dark_vs_light:shadowarmor")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					{
						ItemStack _ist = ((entity instanceof LivingEntity)
								? ((LivingEntity) entity)
										.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 15, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
				if ((((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
						: ItemStack.EMPTY).getItem() == new ItemStack(BlindShardArmorItem.legs, (int) (1)).getItem())) {
					if ((((((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
							: ItemStack.EMPTY))
									.getMaxDamage()) < (15 + ((((entity instanceof LivingEntity)
											? ((LivingEntity) entity).getItemStackFromSlot(
													EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
											: ItemStack.EMPTY)).getDamage())))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(DarkStoneDustItem.block, (int) (1)));
							entityToSpawn.setPickupDelay((int) 60);
							world.addEntity(entityToSpawn);
						}
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world)
								.playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("dark_vs_light:shadowarmor")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("dark_vs_light:shadowarmor")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					{
						ItemStack _ist = ((entity instanceof LivingEntity)
								? ((LivingEntity) entity)
										.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 15, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
				if ((((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
						: ItemStack.EMPTY).getItem() == new ItemStack(BlindShardArmorItem.body, (int) (1)).getItem())) {
					if ((((((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
							: ItemStack.EMPTY))
									.getMaxDamage()) < (15 + ((((entity instanceof LivingEntity)
											? ((LivingEntity) entity).getItemStackFromSlot(
													EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
											: ItemStack.EMPTY)).getDamage())))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(DarkStoneDustItem.block, (int) (1)));
							entityToSpawn.setPickupDelay((int) 60);
							world.addEntity(entityToSpawn);
						}
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world)
								.playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("dark_vs_light:shadowarmor")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("dark_vs_light:shadowarmor")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					{
						ItemStack _ist = ((entity instanceof LivingEntity)
								? ((LivingEntity) entity)
										.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 15, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
				if ((((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
						: ItemStack.EMPTY).getItem() == new ItemStack(BlindShardArmorItem.helmet, (int) (1)).getItem())) {
					if ((((((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
							: ItemStack.EMPTY))
									.getMaxDamage()) < (15 + ((((entity instanceof LivingEntity)
											? ((LivingEntity) entity).getItemStackFromSlot(
													EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
											: ItemStack.EMPTY)).getDamage())))) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(DarkStoneDustItem.block, (int) (1)));
							entityToSpawn.setPickupDelay((int) 60);
							world.addEntity(entityToSpawn);
						}
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world)
								.playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("dark_vs_light:shadowarmor")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("dark_vs_light:shadowarmor")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					{
						ItemStack _ist = ((entity instanceof LivingEntity)
								? ((LivingEntity) entity)
										.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 15, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
			} else {
				if ((((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
						: ItemStack.EMPTY).getItem() == new ItemStack(BlindShardArmorItem.boots, (int) (1)).getItem())) {
					if ((5 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier))) {
						if ((0.15 > Math.random())) {
							{
								double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier) + 1);
								entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EnlightendMultiplier = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
					if ((100 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend))) {
						{
							double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend)
									+ ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier));
							entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Enlightend = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((0 < ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend))) {
						if ((0 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new DarkVsLightModVariables.PlayerVariables())).Darkend))) {
							if (entity instanceof LivingEntity)
								((LivingEntity) entity)
										.addPotionEffect(new EffectInstance(EnlightendBlindnessPotion.potion, (int) 200, (int) 1, (false), (false)));
						}
					}
					{
						double _setval = (double) 50;
						entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.EnlightendTick = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
						: ItemStack.EMPTY).getItem() == new ItemStack(BlindShardArmorItem.legs, (int) (1)).getItem())) {
					if ((5 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier))) {
						if ((0.15 > Math.random())) {
							{
								double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier) + 1);
								entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EnlightendMultiplier = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
					if ((100 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend))) {
						{
							double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend)
									+ ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier));
							entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Enlightend = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((0 < ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend))) {
						if ((0 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new DarkVsLightModVariables.PlayerVariables())).Darkend))) {
							if (entity instanceof LivingEntity)
								((LivingEntity) entity)
										.addPotionEffect(new EffectInstance(EnlightendBlindnessPotion.potion, (int) 200, (int) 1, (false), (false)));
						}
					}
					{
						double _setval = (double) 50;
						entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.EnlightendTick = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
						: ItemStack.EMPTY).getItem() == new ItemStack(BlindShardArmorItem.body, (int) (1)).getItem())) {
					if ((5 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier))) {
						if ((0.15 > Math.random())) {
							{
								double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier) + 1);
								entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EnlightendMultiplier = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
					if ((100 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend))) {
						{
							double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend)
									+ ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier));
							entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Enlightend = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((0 < ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend))) {
						if ((0 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new DarkVsLightModVariables.PlayerVariables())).Darkend))) {
							if (entity instanceof LivingEntity)
								((LivingEntity) entity)
										.addPotionEffect(new EffectInstance(EnlightendBlindnessPotion.potion, (int) 200, (int) 1, (false), (false)));
						}
					}
					{
						double _setval = (double) 50;
						entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.EnlightendTick = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
						: ItemStack.EMPTY).getItem() == new ItemStack(BlindShardArmorItem.helmet, (int) (1)).getItem())) {
					if ((5 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier))) {
						if ((0.15 > Math.random())) {
							{
								double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier) + 1);
								entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.EnlightendMultiplier = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
					if ((100 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend))) {
						{
							double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend)
									+ ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier));
							entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Enlightend = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((0 < ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend))) {
						if ((0 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new DarkVsLightModVariables.PlayerVariables())).Darkend))) {
							if (entity instanceof LivingEntity)
								((LivingEntity) entity)
										.addPotionEffect(new EffectInstance(EnlightendBlindnessPotion.potion, (int) 200, (int) 1, (false), (false)));
						}
					}
					{
						double _setval = (double) 50;
						entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.EnlightendTick = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					if ((5 < (world.getLight(new BlockPos((int) x, (int) y, (int) z))))) {
						if ((5 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier))) {
							if ((0.15 > Math.random())) {
								{
									double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier) + 1);
									entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.EnlightendMultiplier = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
						if ((100 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend))) {
							{
								double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend)
										+ ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier));
								entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.Enlightend = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						if ((0 < ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend))) {
							if ((0 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DarkVsLightModVariables.PlayerVariables())).Darkend))) {
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addPotionEffect(
											new EffectInstance(EnlightendBlindnessPotion.potion, (int) 200, (int) 1, (false), (false)));
								if (entity instanceof ServerPlayerEntity) {
									Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("dark_vs_light:is_this_blindness"));
									AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
									if (!_ap.isDone()) {
										Iterator _iterator = _ap.getRemaningCriteria().iterator();
										while (_iterator.hasNext()) {
											String _criterion = (String) _iterator.next();
											((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
										}
									}
								}
							}
						}
					} else {
						if (((-100) < ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend))) {
							{
								double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend)
										- ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new DarkVsLightModVariables.PlayerVariables())).DarkendMultiplier));
								entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.Enlightend = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						if ((1 < ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier))) {
							if ((0.25 > Math.random())) {
								{
									double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier) - 1);
									entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.EnlightendMultiplier = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					}
					{
						double _setval = (double) 0;
						entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.EnlightendTick = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier) == 5)) {
						if ((((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new DarkVsLightModVariables.PlayerVariables())).DarkendMultiplier) == 5)) {
							if ((entity.isAlive())) {
								if (entity instanceof ServerPlayerEntity) {
									Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("dark_vs_light:perfectly_balanced_as_it_should_be"));
									AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
									if (!_ap.isDone()) {
										Iterator _iterator = _ap.getRemaningCriteria().iterator();
										while (_iterator.hasNext()) {
											String _criterion = (String) _iterator.next();
											((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
