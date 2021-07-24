package net.boogaeye.darkvlight.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.boogaeye.darkvlight.enchantment.TeleportationEnchantment;
import net.boogaeye.darkvlight.enchantment.BlazingEnchantment;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Collections;

public class RightClickEnchantsProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
			PlayerEntity entity = event.getPlayer();
			if (event.getHand() != entity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
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
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure RightClickEnchants!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency x for procedure RightClickEnchants!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency y for procedure RightClickEnchants!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency z for procedure RightClickEnchants!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure RightClickEnchants!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double HpMob = 0;
		double Mobx = 0;
		double Moby = 0;
		double Mobz = 0;
		double CoolDown = 0;
		HpMob = (double) 9999;
		if (((EnchantmentHelper.getEnchantmentLevel(TeleportationEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0))) {
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
					if ((((entityiterator instanceof LivingEntity) ? ((LivingEntity) entityiterator).getHealth() : -1) < HpMob)) {
						if ((!(entityiterator == entity))) {
							HpMob = (double) ((entityiterator instanceof LivingEntity) ? ((LivingEntity) entityiterator).getHealth() : -1);
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
												.getValue(new ResourceLocation("entity.enderman.teleport")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.enderman.teleport")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
							}
							CoolDown = (double) (CoolDown + (600 - ((EnchantmentHelper.getEnchantmentLevel(TeleportationEnchantment.enchantment,
									((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) * 100)));
						}
					}
				}
			}
		}
		if (((EnchantmentHelper.getEnchantmentLevel(BlazingEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0))) {
			{
				List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(
						x - (((EnchantmentHelper.getEnchantmentLevel(BlazingEnchantment.enchantment,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) * 2) / 2d),
						y - (((EnchantmentHelper.getEnchantmentLevel(BlazingEnchantment.enchantment,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) * 2) / 2d),
						z - (((EnchantmentHelper.getEnchantmentLevel(BlazingEnchantment.enchantment,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) * 2) / 2d),
						x + (((EnchantmentHelper.getEnchantmentLevel(BlazingEnchantment.enchantment,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) * 2) / 2d),
						y + (((EnchantmentHelper.getEnchantmentLevel(BlazingEnchantment.enchantment,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) * 2) / 2d),
						z + (((EnchantmentHelper.getEnchantmentLevel(BlazingEnchantment.enchantment,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) * 2) / 2d)),
						null).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if ((!(entityiterator == entity))) {
						if (world instanceof World && !world.isRemote()) {
							((World) world)
									.playSound(null, new BlockPos((int) x, (int) y, (int) z),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("dark_vs_light:upgrade")),
											SoundCategory.NEUTRAL, (float) 1, (float) 1);
						} else {
							((World) world).playSound(x, y, z,
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("dark_vs_light:upgrade")),
									SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
						}
						entityiterator.setFire((int) ((EnchantmentHelper.getEnchantmentLevel(BlazingEnchantment.enchantment,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) * 10));
						CoolDown = (double) (CoolDown + (600 - ((EnchantmentHelper.getEnchantmentLevel(BlazingEnchantment.enchantment,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) * 40)));
						if (entity instanceof ServerPlayerEntity) {
							Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("dark_vs_light:blaze_power"));
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
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem(), (int) CoolDown);
	}
}
