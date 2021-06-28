
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
public class Burn_Diamond_ToolHoeItem extends DarkVsLightModElements.ModElement {
	@ObjectHolder("dark_vs_light:burn_diamond_tool_hoe")
	public static final Item block = null;
	public Burn_Diamond_ToolHoeItem(DarkVsLightModElements instance) {
		super(instance, 210);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 1741;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 56;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(BurnDiamondItem.block, (int) (1)));
			}
		}, 0, 0f, new Item.Properties().group(DVLtabItemGroup.tab)) {
		}.setRegistryName("burn_diamond_tool_hoe"));
	}
}
