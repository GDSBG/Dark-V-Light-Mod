package net.boogaeye.darkvlight.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class XPFragmentRightClickedInAirProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure XPFragmentRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency itemstack for procedure XPFragmentRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure XPFragmentRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).addExperienceLevel((int) ((itemstack).getOrCreateTag().getDouble("XP")));
		((itemstack)).shrink((int) 1);
		if (world.isRemote()) {
			Minecraft.getInstance().gameRenderer.displayItemActivation((itemstack));
		}
	}
}
