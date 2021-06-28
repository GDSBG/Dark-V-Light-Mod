
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
public class UrinShovelItem extends DarkVsLightModElements.ModElement {
	@ObjectHolder("dark_vs_light:urin_shovel")
	public static final Item block = null;
	public UrinShovelItem(DarkVsLightModElements instance) {
		super(instance, 261);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 400;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 7;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(UrinGemItem.block, (int) (1)));
			}
		}, 1, -3.2f, new Item.Properties().group(DVLtabItemGroup.tab)) {
		}.setRegistryName("urin_shovel"));
	}
}
