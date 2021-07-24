package net.boogaeye.darkvlight.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.DamageSource;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.boogaeye.darkvlight.enchantment.DarkendProtectionEnchantment;
import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class DarkendMeterProProcedure {
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
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure DarkendMeterPro!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency x for procedure DarkendMeterPro!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency y for procedure DarkendMeterPro!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency z for procedure DarkendMeterPro!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure DarkendMeterPro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new DarkVsLightModVariables.PlayerVariables())).DarkendTick) + 1);
			entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.DarkendTick = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = (boolean) (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("dark_vs_light:nooooooooooooo")))
							.isDone()
					: false);
			entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Boss1Defeated = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((160 < ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new DarkVsLightModVariables.PlayerVariables())).DarkendTick))) {
			if (((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
					new ResourceLocation("dark_vs_light:enlightend_dimension"))))) {
				if (((-100) < ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new DarkVsLightModVariables.PlayerVariables())).Darkend))) {
					{
						double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new DarkVsLightModVariables.PlayerVariables())).Darkend)
								- ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier));
						entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Darkend = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if ((1 < ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new DarkVsLightModVariables.PlayerVariables())).DarkendMultiplier))) {
					if ((0.25 > Math.random())) {
						{
							double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DarkVsLightModVariables.PlayerVariables())).DarkendMultiplier) - 1);
							entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.DarkendMultiplier = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			} else {
				if ((5 > (world.getLight(new BlockPos((int) x, (int) y, (int) z))))) {
					if ((5 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).DarkendMultiplier))) {
						if ((0.15 > Math.random())) {
							{
								double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DarkVsLightModVariables.PlayerVariables())).DarkendMultiplier) + 1);
								entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.DarkendMultiplier = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
					if ((100 > ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).Darkend))) {
						{
							double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DarkVsLightModVariables.PlayerVariables())).Darkend)
									+ ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new DarkVsLightModVariables.PlayerVariables())).DarkendMultiplier));
							entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Darkend = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).Enlightend) < 1)) {
						if ((((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new DarkVsLightModVariables.PlayerVariables())).Darkend) > (-1))) {
							if (((EnchantmentHelper.getEnchantmentLevel(DarkendProtectionEnchantment.enchantment,
									((entity instanceof LivingEntity)
											? ((LivingEntity) entity).getItemStackFromSlot(
													EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
											: ItemStack.EMPTY)) != 0))) {
								{
									ItemStack _ist = ((entity instanceof LivingEntity)
											? ((LivingEntity) entity).getItemStackFromSlot(
													EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
											: ItemStack.EMPTY);
									if (_ist.attemptDamageItem((int) ((5
											+ ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new DarkVsLightModVariables.PlayerVariables())).DarkendMultiplier))
											- (EnchantmentHelper.getEnchantmentLevel(DarkendProtectionEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getItemStackFromSlot(
																	EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
															: ItemStack.EMPTY)))),
											new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamage(0);
									}
								}
							} else if (((EnchantmentHelper.getEnchantmentLevel(DarkendProtectionEnchantment.enchantment,
									((entity instanceof LivingEntity)
											? ((LivingEntity) entity).getItemStackFromSlot(
													EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
											: ItemStack.EMPTY)) != 0))) {
								{
									ItemStack _ist = ((entity instanceof LivingEntity)
											? ((LivingEntity) entity).getItemStackFromSlot(
													EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
											: ItemStack.EMPTY);
									if (_ist.attemptDamageItem((int) ((5
											+ ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new DarkVsLightModVariables.PlayerVariables())).DarkendMultiplier))
											- (EnchantmentHelper.getEnchantmentLevel(DarkendProtectionEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getItemStackFromSlot(
																	EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
															: ItemStack.EMPTY)))),
											new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamage(0);
									}
								}
							} else if (((EnchantmentHelper.getEnchantmentLevel(DarkendProtectionEnchantment.enchantment,
									((entity instanceof LivingEntity)
											? ((LivingEntity) entity).getItemStackFromSlot(
													EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
											: ItemStack.EMPTY)) != 0))) {
								{
									ItemStack _ist = ((entity instanceof LivingEntity)
											? ((LivingEntity) entity).getItemStackFromSlot(
													EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
											: ItemStack.EMPTY);
									if (_ist.attemptDamageItem((int) ((5
											+ ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new DarkVsLightModVariables.PlayerVariables())).DarkendMultiplier))
											- (EnchantmentHelper.getEnchantmentLevel(DarkendProtectionEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getItemStackFromSlot(
																	EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
															: ItemStack.EMPTY)))),
											new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamage(0);
									}
								}
							} else if (((EnchantmentHelper.getEnchantmentLevel(DarkendProtectionEnchantment.enchantment,
									((entity instanceof LivingEntity)
											? ((LivingEntity) entity).getItemStackFromSlot(
													EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
											: ItemStack.EMPTY)) != 0))) {
								{
									ItemStack _ist = ((entity instanceof LivingEntity)
											? ((LivingEntity) entity).getItemStackFromSlot(
													EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
											: ItemStack.EMPTY);
									if (_ist.attemptDamageItem((int) ((5
											+ ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new DarkVsLightModVariables.PlayerVariables())).DarkendMultiplier))
											- (EnchantmentHelper.getEnchantmentLevel(DarkendProtectionEnchantment.enchantment,
													((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getItemStackFromSlot(
																	EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
															: ItemStack.EMPTY)))),
											new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamage(0);
									}
								}
							} else {
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).attackEntityFrom(new DamageSource("darkness").setDamageBypassesArmor(), (float) 2);
								}
							}
						}
					}
				} else {
					if (((-100) < ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).Darkend))) {
						{
							double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DarkVsLightModVariables.PlayerVariables())).Darkend)
									- ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new DarkVsLightModVariables.PlayerVariables())).EnlightendMultiplier));
							entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Darkend = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((1 < ((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new DarkVsLightModVariables.PlayerVariables())).DarkendMultiplier))) {
						if ((0.25 > Math.random())) {
							{
								double _setval = (double) (((entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DarkVsLightModVariables.PlayerVariables())).DarkendMultiplier) - 1);
								entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.DarkendMultiplier = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
				{
					double _setval = (double) 0;
					entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DarkendTick = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
