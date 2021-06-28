package net.boogaeye.darkvlight.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class DarkendBossEntityEntityDiesProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure DarkendBossEntityEntityDies!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		{
			List<? extends PlayerEntity> _players = new ArrayList<>(world.getPlayers());
			for (Entity entityiterator : _players) {
				if ((!DarkVsLightModVariables.MapVariables.get(world).Boss1Defeated)) {
					if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
						((PlayerEntity) entityiterator).sendStatusMessage(new StringTextComponent("The Darkend Dimension Is A little Lighter Now"),
								(true));
					}
				}
				if (entityiterator instanceof ServerPlayerEntity) {
					Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entityiterator).server).getAdvancementManager()
							.getAdvancement(new ResourceLocation("dark_vs_light:nooooooooooooo"));
					AdvancementProgress _ap = ((ServerPlayerEntity) entityiterator).getAdvancements().getProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemaningCriteria().iterator();
						while (_iterator.hasNext()) {
							String _criterion = (String) _iterator.next();
							((ServerPlayerEntity) entityiterator).getAdvancements().grantCriterion(_adv, _criterion);
						}
					}
				}
			}
		}
		DarkVsLightModVariables.MapVariables.get(world).Boss1Defeated = (boolean) (true);
		DarkVsLightModVariables.MapVariables.get(world).syncData(world);
	}
}
