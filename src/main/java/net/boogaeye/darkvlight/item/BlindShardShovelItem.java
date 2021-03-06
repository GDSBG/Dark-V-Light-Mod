
package net.boogaeye.darkvlight.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.boogaeye.darkvlight.itemgroup.DVLtabItemGroup;
import net.boogaeye.darkvlight.DarkVsLightModElements;

@DarkVsLightModElements.ModElement.Tag
public class BlindShardShovelItem extends DarkVsLightModElements.ModElement {
	@ObjectHolder("dark_vs_light:blind_shard_shovel")
	public static final Item block = null;
	public BlindShardShovelItem(DarkVsLightModElements instance) {
		super(instance, 323);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 400;
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
				return Ingredient.fromStacks(new ItemStack(DarkShardItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(DVLtabItemGroup.tab)) {
		}.setRegistryName("blind_shard_shovel"));
	}
}
