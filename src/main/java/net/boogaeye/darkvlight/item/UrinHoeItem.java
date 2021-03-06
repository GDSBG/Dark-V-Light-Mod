
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
public class UrinHoeItem extends DarkVsLightModElements.ModElement {
	@ObjectHolder("dark_vs_light:urin_hoe")
	public static final Item block = null;
	public UrinHoeItem(DarkVsLightModElements instance) {
		super(instance, 262);
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
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(UrinGemItem.block, (int) (1)));
			}
		}, 0, -3f, new Item.Properties().group(DVLtabItemGroup.tab)) {
		}.setRegistryName("urin_hoe"));
	}
}
