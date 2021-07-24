package net.boogaeye.darkvlight.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.item.DarkStoneSwordItem;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class Tier4BucketValuesProcedure {
	public static double executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure Tier4BucketValues!");
			return 0;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((Tier4UpgradeProcedure.executeProcedure(ImmutableMap.of("entity", entity)).getItem() == DarkStoneSwordItem.block)) {
			return 1;
		}
		if ((ItemTags.getCollection().getTagByID(new ResourceLocation(("urenupgrade").toLowerCase(java.util.Locale.ENGLISH)))
				.contains(Tier4UpgradeProcedure.executeProcedure(ImmutableMap.of("entity", entity)).getItem()))) {
			return 2;
		}
		if ((ItemTags.getCollection().getTagByID(new ResourceLocation(("burnupgrade").toLowerCase(java.util.Locale.ENGLISH)))
				.contains(Tier4UpgradeProcedure.executeProcedure(ImmutableMap.of("entity", entity)).getItem()))) {
			return 5;
		}
		if ((ItemTags.getCollection().getTagByID(new ResourceLocation(("burndiamondupgrade").toLowerCase(java.util.Locale.ENGLISH)))
				.contains(Tier4UpgradeProcedure.executeProcedure(ImmutableMap.of("entity", entity)).getItem()))) {
			return 7;
		}
		return 4;
	}
}
