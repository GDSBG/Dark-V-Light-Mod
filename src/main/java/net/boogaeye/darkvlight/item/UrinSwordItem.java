
package net.boogaeye.darkvlight.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.boogaeye.darkvlight.itemgroup.DVLtabItemGroup;
import net.boogaeye.darkvlight.DarkVsLightModElements;

@DarkVsLightModElements.ModElement.Tag
public class UrinSwordItem extends DarkVsLightModElements.ModElement {
	@ObjectHolder("dark_vs_light:urin_sword")
	public static final Item block = null;
	public UrinSwordItem(DarkVsLightModElements instance) {
		super(instance, 260);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 250;
			}

			public float getEfficiency() {
				return 2f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(UrinGemItem.block));
			}
		}, 3, -3f, new Item.Properties().group(DVLtabItemGroup.tab)) {
		}.setRegistryName("urin_sword"));
	}
}
