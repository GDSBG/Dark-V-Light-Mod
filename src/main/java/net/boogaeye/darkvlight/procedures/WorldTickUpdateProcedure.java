package net.boogaeye.darkvlight.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.IWorld;

import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;
import java.util.HashMap;

public class WorldTickUpdateProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onWorldTick(TickEvent.WorldTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				IWorld world = event.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("world", world);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure WorldTickUpdate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		DarkVsLightModVariables.MapVariables.get(world).BossWorldTick = (double) (DarkVsLightModVariables.MapVariables.get(world).BossWorldTick + 1);
		DarkVsLightModVariables.MapVariables.get(world).syncData(world);
		DarkVsLightModVariables.MapVariables
				.get(world).BossWorldTick2 = (double) (DarkVsLightModVariables.MapVariables.get(world).BossWorldTick2 + 1);
		DarkVsLightModVariables.MapVariables.get(world).syncData(world);
	}
}
