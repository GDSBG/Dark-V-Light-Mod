package net.boogaeye.darkvlight.procedures;

import net.minecraft.item.ItemStack;

import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class WaypointDetectorMakeItemGlowProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency itemstack for procedure WaypointDetectorMakeItemGlow!");
			return false;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((itemstack).getOrCreateTag().getBoolean("HasLocationSet"))) {
			return (true);
		}
		return (false);
	}
}
