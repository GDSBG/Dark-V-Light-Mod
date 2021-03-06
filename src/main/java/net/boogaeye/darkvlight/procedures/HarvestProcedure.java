package net.boogaeye.darkvlight.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class HarvestProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBlockBreak(BlockEvent.BreakEvent event) {
			Entity entity = event.getPlayer();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("xpAmount", event.getExpToDrop());
			dependencies.put("x", event.getPos().getX());
			dependencies.put("y", event.getPos().getY());
			dependencies.put("z", event.getPos().getZ());
			dependencies.put("px", entity.getPosX());
			dependencies.put("py", entity.getPosY());
			dependencies.put("pz", entity.getPosZ());
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure Harvest!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency x for procedure Harvest!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency y for procedure Harvest!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency z for procedure Harvest!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure Harvest!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((false)) {
			if ((!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false))) {
				if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlockHardness(world,
						new BlockPos((int) x, (int) y, (int) z))) != 0)) {
					if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getHarvestLevel()) != 0)) {
						if ((!(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
								.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))))) {
							if (dependencies.get("event") != null) {
								Object _obj = dependencies.get("event");
								if (_obj instanceof Event) {
									Event _evt = (Event) _obj;
									if (_evt.isCancelable())
										_evt.setCanceled(true);
								}
							}
							{
								ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
								if (_ist.attemptDamageItem((int) (world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlockHardness(world,
										new BlockPos((int) x, (int) y, (int) z))), new Random(), null)) {
									_ist.shrink(1);
									_ist.setDamage(0);
								}
							}
						}
					}
				}
			}
		}
	}
}
