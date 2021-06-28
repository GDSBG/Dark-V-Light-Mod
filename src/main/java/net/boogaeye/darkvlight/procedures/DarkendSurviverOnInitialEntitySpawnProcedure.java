package net.boogaeye.darkvlight.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.item.UrinSwordItem;
import net.boogaeye.darkvlight.item.UrinArmorItem;
import net.boogaeye.darkvlight.item.DarkStoneSwordItem;
import net.boogaeye.darkvlight.item.Burn_Diamond_ToolSwordItem;
import net.boogaeye.darkvlight.item.Burn_Diamond_ToolHoeItem;
import net.boogaeye.darkvlight.item.BurnSwordItem;
import net.boogaeye.darkvlight.item.BurnDiamondArmorArmorItem;
import net.boogaeye.darkvlight.item.BurnArmorItem;
import net.boogaeye.darkvlight.item.BlindShardSwordItem;
import net.boogaeye.darkvlight.item.BlindShardArmorItem;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class DarkendSurviverOnInitialEntitySpawnProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure DarkendSurviverOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putString("Type", "Endarkend");
		if ((Math.random() < 0.6)) {
			{
				final ItemStack _setstack = new ItemStack(DarkStoneSwordItem.block, (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else if ((Math.random() < 0.02)) {
			{
				final ItemStack _setstack = new ItemStack(Burn_Diamond_ToolSwordItem.block, (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else if ((Math.random() < 0.6)) {
			{
				final ItemStack _setstack = new ItemStack(UrinSwordItem.block, (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else if ((Math.random() < 0.4)) {
			{
				final ItemStack _setstack = new ItemStack(BurnSwordItem.block, (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else if ((Math.random() < 0.2)) {
			{
				final ItemStack _setstack = new ItemStack(Burn_Diamond_ToolHoeItem.block, (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else {
			{
				final ItemStack _setstack = new ItemStack(BlindShardSwordItem.block, (int) (1));
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		}
		if ((Math.random() < 0.5)) {
			{
				final ItemStack _setstack = new ItemStack(Items.SHIELD, (int) (1));
				final int _sltid = (int) (1);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		}
		if ((Math.random() < 0.6)) {
			{
				final ItemStack _setstack = new ItemStack(BurnArmorItem.helmet, (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else if ((Math.random() < 0.02)) {
			{
				final ItemStack _setstack = new ItemStack(BurnDiamondArmorArmorItem.helmet, (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else if ((Math.random() < 0.6)) {
			{
				final ItemStack _setstack = new ItemStack(UrinArmorItem.helmet, (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else if ((Math.random() < 0.4)) {
			{
				final ItemStack _setstack = new ItemStack(BlindShardArmorItem.helmet, (int) (1));
				final int _sltid = (int) (2);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		}
		if ((Math.random() < 0.6)) {
			{
				final ItemStack _setstack = new ItemStack(BurnArmorItem.body, (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else if ((Math.random() < 0.02)) {
			{
				final ItemStack _setstack = new ItemStack(BurnDiamondArmorArmorItem.body, (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else if ((Math.random() < 0.6)) {
			{
				final ItemStack _setstack = new ItemStack(UrinArmorItem.body, (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else if ((Math.random() < 0.4)) {
			{
				final ItemStack _setstack = new ItemStack(BlindShardArmorItem.body, (int) (1));
				final int _sltid = (int) (3);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		}
		if ((Math.random() < 0.6)) {
			{
				final ItemStack _setstack = new ItemStack(BurnArmorItem.legs, (int) (1));
				final int _sltid = (int) (4);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else if ((Math.random() < 0.02)) {
			{
				final ItemStack _setstack = new ItemStack(BurnDiamondArmorArmorItem.legs, (int) (1));
				final int _sltid = (int) (4);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else if ((Math.random() < 0.6)) {
			{
				final ItemStack _setstack = new ItemStack(UrinArmorItem.legs, (int) (1));
				final int _sltid = (int) (4);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else if ((Math.random() < 0.4)) {
			{
				final ItemStack _setstack = new ItemStack(BlindShardArmorItem.legs, (int) (1));
				final int _sltid = (int) (4);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		}
		if ((Math.random() < 0.6)) {
			{
				final ItemStack _setstack = new ItemStack(BurnArmorItem.boots, (int) (1));
				final int _sltid = (int) (5);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else if ((Math.random() < 0.02)) {
			{
				final ItemStack _setstack = new ItemStack(BurnDiamondArmorArmorItem.boots, (int) (1));
				final int _sltid = (int) (5);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else if ((Math.random() < 0.6)) {
			{
				final ItemStack _setstack = new ItemStack(UrinArmorItem.boots, (int) (1));
				final int _sltid = (int) (5);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else if ((Math.random() < 0.4)) {
			{
				final ItemStack _setstack = new ItemStack(BlindShardArmorItem.boots, (int) (1));
				final int _sltid = (int) (5);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		}
	}
}
