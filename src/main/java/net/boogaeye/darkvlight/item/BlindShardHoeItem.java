
package net.boogaeye.darkvlight.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.boogaeye.darkvlight.itemgroup.DVLtabItemGroup;
import net.boogaeye.darkvlight.DarkVsLightModElements;

@DarkVsLightModElements.ModElement.Tag
public class BlindShardHoeItem extends DarkVsLightModElements.ModElement {
	@ObjectHolder("dark_vs_light:blind_shard_hoe")
	public static final Item block = null;
	public BlindShardHoeItem(DarkVsLightModElements instance) {
		super(instance, 324);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 250;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DarkShardItem.block));
			}
		}, 0, -3f, new Item.Properties().group(DVLtabItemGroup.tab)) {
		}.setRegistryName("blind_shard_hoe"));
	}
}
