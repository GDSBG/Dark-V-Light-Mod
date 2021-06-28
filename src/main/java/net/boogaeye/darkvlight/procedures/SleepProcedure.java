package net.boogaeye.darkvlight.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;
import java.util.HashMap;

public class SleepProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerInBed(PlayerSleepInBedEvent event) {
			PlayerEntity entity = event.getPlayer();
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			World world = entity.world;
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
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure Sleep!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = (double) 150;
			entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Enlightend = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (double) 150;
			entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Darkend = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (double) 1;
			entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.DarkendMultiplier = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (double) 1;
			entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.EnlightendMultiplier = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (double) 1;
			entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.EnlightendMultiplier = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
