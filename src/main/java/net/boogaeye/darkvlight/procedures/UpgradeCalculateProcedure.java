package net.boogaeye.darkvlight.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class UpgradeCalculateProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure UpgradeCalculate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack result = ItemStack.EMPTY;
		double Buckets = 0;
		result = Tier1UpgradeProcedure.executeProcedure(ImmutableMap.of("entity", entity));
		Buckets = (double) (Buckets + 1);
		if ((!((result).getItem() == Blocks.AIR.asItem()))) {
			entity.getPersistentData().putDouble("usingWater", Buckets);
			entity.getPersistentData().putDouble("usingDL", 0);
			entity.getPersistentData().putDouble("usingHL", 0);
		} else {
			result = Tier2UpgradeProcedure.executeProcedure(ImmutableMap.of("entity", entity));
			Buckets = (double) (Buckets + 1);
			if ((!((result).getItem() == Blocks.AIR.asItem()))) {
				entity.getPersistentData().putDouble("usingWater", Buckets);
				entity.getPersistentData().putDouble("usingDL", 0);
				entity.getPersistentData().putDouble("usingHL", 0);
			} else {
				result = Tier3UpgradeProcedure.executeProcedure(ImmutableMap.of("entity", entity));
				Buckets = (double) (Buckets + 1);
				if ((!((result).getItem() == Blocks.AIR.asItem()))) {
					entity.getPersistentData().putDouble("usingWater", Buckets);
					entity.getPersistentData().putDouble("usingDL", Buckets);
					entity.getPersistentData().putDouble("usingHL", 0);
				} else {
					result = Tier4UpgradeProcedure.executeProcedure(ImmutableMap.of("entity", entity));
					Buckets = (double) Tier4BucketValuesProcedure.executeProcedure(ImmutableMap.of("entity", entity));
					if ((!((result).getItem() == Blocks.AIR.asItem()))) {
						entity.getPersistentData().putDouble("usingWater", Buckets);
						entity.getPersistentData().putDouble("usingDL", Buckets);
						entity.getPersistentData().putDouble("usingHL", Buckets);
					} else {
						entity.getPersistentData().putDouble("usingWater", 0);
						entity.getPersistentData().putDouble("usingDL", 0);
						entity.getPersistentData().putDouble("usingHL", 0);
					}
				}
			}
		}
	}
}
