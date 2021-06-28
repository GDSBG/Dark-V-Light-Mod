
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
public class Burn_Diamond_ToolSwordItem extends DarkVsLightModElements.ModElement {
	@ObjectHolder("dark_vs_light:burn_diamond_tool_sword")
	public static final Item block = null;
	public Burn_Diamond_ToolSwordItem(DarkVsLightModElements instance) {
		super(instance, 208);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1741;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 22f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 56;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(BurnDiamondItem.block, (int) (1)));
			}
		}, 3, -3.4f, new Item.Properties().group(DVLtabItemGroup.tab)) {
		}.setRegistryName("burn_diamond_tool_sword"));
	}
}
