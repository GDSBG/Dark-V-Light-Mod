
package net.boogaeye.darkvlight.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.boogaeye.darkvlight.item.BurnCrystalItem;

@Mod.EventBusSubscriber
public class BurnCrystalFuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == BurnCrystalItem.block)
			event.setBurnTime(3200);
	}
}
