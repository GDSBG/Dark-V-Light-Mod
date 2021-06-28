
package net.boogaeye.darkvlight.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.boogaeye.darkvlight.item.EnlightendTeleporterItem;
import net.boogaeye.darkvlight.DarkVsLightModElements;

@DarkVsLightModElements.ModElement.Tag
public class EnlightendDimensionTabItemGroup extends DarkVsLightModElements.ModElement {
	public EnlightendDimensionTabItemGroup(DarkVsLightModElements instance) {
		super(instance, 219);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabenlightend_dimension_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(EnlightendTeleporterItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
