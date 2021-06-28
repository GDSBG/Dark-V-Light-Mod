
package net.boogaeye.darkvlight.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.boogaeye.darkvlight.itemgroup.DVLtabItemGroup;
import net.boogaeye.darkvlight.DarkVsLightModElements;

@DarkVsLightModElements.ModElement.Tag
public class DarkHornSongItem extends DarkVsLightModElements.ModElement {
	@ObjectHolder("dark_vs_light:dark_horn_song")
	public static final Item block = null;
	public DarkHornSongItem(DarkVsLightModElements instance) {
		super(instance, 498);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, DarkVsLightModElements.sounds.get(new ResourceLocation("dark_vs_light:hornsong")),
					new Item.Properties().group(DVLtabItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("dark_horn_song");
		}
	}
}
