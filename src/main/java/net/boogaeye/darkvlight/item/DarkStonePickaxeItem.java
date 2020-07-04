
package net.boogaeye.darkvlight.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.boogaeye.darkvlight.itemgroup.DVLtabItemGroup;
import net.boogaeye.darkvlight.block.DarkStoneBlock;
import net.boogaeye.darkvlight.DarkVLightModElements;

@DarkVLightModElements.ModElement.Tag
public class DarkStonePickaxeItem extends DarkVLightModElements.ModElement {
	@ObjectHolder("dark_v_light:dark_stone_pickaxe")
	public static final Item block = null;
	public DarkStonePickaxeItem(DarkVLightModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 250;
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
				return 35;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DarkStoneBlock.block, (int) (1)));
			}
		}, 1, 2f, new Item.Properties().group(DVLtabItemGroup.tab)) {
		}.setRegistryName("dark_stone_pickaxe"));
	}
}
