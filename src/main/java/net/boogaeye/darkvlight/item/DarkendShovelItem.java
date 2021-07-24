
package net.boogaeye.darkvlight.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.boogaeye.darkvlight.itemgroup.DVLtabItemGroup;
import net.boogaeye.darkvlight.block.DarkStoneBlock;
import net.boogaeye.darkvlight.DarkVsLightModElements;

@DarkVsLightModElements.ModElement.Tag
public class DarkendShovelItem extends DarkVsLightModElements.ModElement {
	@ObjectHolder("dark_vs_light:darkend_shovel")
	public static final Item block = null;
	public DarkendShovelItem(DarkVsLightModElements instance) {
		super(instance, 187);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 400;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 6;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DarkStoneBlock.block));
			}
		}, 1, -3f, new Item.Properties().group(DVLtabItemGroup.tab)) {
		}.setRegistryName("darkend_shovel"));
	}
}
