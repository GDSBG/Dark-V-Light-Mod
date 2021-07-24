
package net.boogaeye.darkvlight.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.boogaeye.darkvlight.itemgroup.DVLtabItemGroup;
import net.boogaeye.darkvlight.DarkVsLightModElements;

@DarkVsLightModElements.ModElement.Tag
public class UrinPickaxeItem extends DarkVsLightModElements.ModElement {
	@ObjectHolder("dark_vs_light:urin_pickaxe")
	public static final Item block = null;
	public UrinPickaxeItem(DarkVsLightModElements instance) {
		super(instance, 258);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
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
				return Ingredient.fromStacks(new ItemStack(UrinGemItem.block));
			}
		}, 1, -3.5f, new Item.Properties().group(DVLtabItemGroup.tab)) {
		}.setRegistryName("urin_pickaxe"));
	}
}
