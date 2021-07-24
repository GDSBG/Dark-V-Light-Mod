package net.boogaeye.darkvlight.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Random;
import java.util.Map;

public class TamedSurvivorThisEntityKillsAnotherOneProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure TamedSurvivorThisEntityKillsAnotherOne!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack Bruh = ItemStack.EMPTY;
		Bruh = (new Object() {
			public ItemStack getItemStack(int sltid, Entity entity) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack((int) (0), entity));
		{
			ItemStack _ist = (Bruh);
			if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
				_ist.shrink(1);
				_ist.setDamage(0);
			}
		}
		{
			final ItemStack _setstack = (Bruh);
			final int _sltid = (int) (0);
			_setstack.setCount((int) (((Bruh)).getCount()));
			entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
	}
}
