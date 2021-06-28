
package net.boogaeye.darkvlight.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.boogaeye.darkvlight.itemgroup.EnlightendDimensionTabItemGroup;
import net.boogaeye.darkvlight.block.EnlightendStoneBlock;
import net.boogaeye.darkvlight.DarkVsLightModElements;

@DarkVsLightModElements.ModElement.Tag
public class LightendStonePickaxeItem extends DarkVsLightModElements.ModElement {
	@ObjectHolder("dark_vs_light:lightend_stone_pickaxe")
	public static final Item block = null;
	public LightendStonePickaxeItem(DarkVsLightModElements instance) {
		super(instance, 600);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 660;
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
				return 28;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(EnlightendStoneBlock.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(EnlightendDimensionTabItemGroup.tab)) {
		}.setRegistryName("lightend_stone_pickaxe"));
	}
}
