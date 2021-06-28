
package net.boogaeye.darkvlight.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.boogaeye.darkvlight.itemgroup.DVLtabItemGroup;
import net.boogaeye.darkvlight.DarkVsLightModElements;

@DarkVsLightModElements.ModElement.Tag
public class Burn_Diamond_ToolAxeItem extends DarkVsLightModElements.ModElement {
	@ObjectHolder("dark_vs_light:burn_diamond_tool_axe")
	public static final Item block = null;
	public Burn_Diamond_ToolAxeItem(DarkVsLightModElements instance) {
		super(instance, 207);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1741;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 34f;
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
		}, 1, -3.8f, new Item.Properties().group(DVLtabItemGroup.tab)) {
		}.setRegistryName("burn_diamond_tool_axe"));
	}
}
