package net.boogaeye.darkvlight.procedures;

import net.minecraft.item.ItemStack;

import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class TamedSurvivorOnInitialEntitySpawnProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency itemstack for procedure TamedSurvivorOnInitialEntitySpawn!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		(itemstack).getOrCreateTag().putString("Type", "Enlightend");
	}
}
