
package net.boogaeye.darkvlight.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.boogaeye.darkvlight.item.DriedGlowBerryItem;
import net.boogaeye.darkvlight.DarkVsLightModElements;

@DarkVsLightModElements.ModElement.Tag
public class DVLFoodItemGroup extends DarkVsLightModElements.ModElement {
	public DVLFoodItemGroup(DarkVsLightModElements instance) {
		super(instance, 177);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabdvl_food") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(DriedGlowBerryItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
