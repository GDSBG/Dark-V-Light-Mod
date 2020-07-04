
package net.boogaeye.darkvlight.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.boogaeye.darkvlight.block.DarkStoneBlock;
import net.boogaeye.darkvlight.DarkVLightModElements;

@DarkVLightModElements.ModElement.Tag
public class DVLtabItemGroup extends DarkVLightModElements.ModElement {
	public DVLtabItemGroup(DarkVLightModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabdv_ltab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(DarkStoneBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
