package net.boogaeye.darkvlight.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
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
import java.util.HashMap;

public class DarkendSurviverOnInitialEntitySpawnProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure DarkendSurviverOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency x for procedure DarkendSurviverOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency y for procedure DarkendSurviverOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency z for procedure DarkendSurviverOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure DarkendSurviverOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		entity.getPersistentData().putString("Type", "Endarkend");
		if ((Math.random() < 0.6)) {
			{
				final ItemStack _setstack = new ItemStack(DarkStoneSwordItem.block);
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
				final ItemStack _setstack = new ItemStack(Burn_Diamond_ToolSwordItem.block);
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
				final ItemStack _setstack = new ItemStack(UrinSwordItem.block);
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
				final ItemStack _setstack = new ItemStack(BurnSwordItem.block);
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
				final ItemStack _setstack = new ItemStack(Burn_Diamond_ToolHoeItem.block);
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
				final ItemStack _setstack = new ItemStack(BlindShardSwordItem.block);
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
				final ItemStack _setstack = new ItemStack(Items.SHIELD);
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
				final ItemStack _setstack = new ItemStack(BurnArmorItem.helmet);
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
				final ItemStack _setstack = new ItemStack(BurnDiamondArmorArmorItem.helmet);
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
				final ItemStack _setstack = new ItemStack(UrinArmorItem.helmet);
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
				final ItemStack _setstack = new ItemStack(BlindShardArmorItem.helmet);
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
				final ItemStack _setstack = new ItemStack(BurnArmorItem.body);
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
				final ItemStack _setstack = new ItemStack(BurnDiamondArmorArmorItem.body);
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
				final ItemStack _setstack = new ItemStack(UrinArmorItem.body);
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
				final ItemStack _setstack = new ItemStack(BlindShardArmorItem.body);
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
				final ItemStack _setstack = new ItemStack(BurnArmorItem.legs);
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
				final ItemStack _setstack = new ItemStack(BurnDiamondArmorArmorItem.legs);
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
				final ItemStack _setstack = new ItemStack(UrinArmorItem.legs);
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
				final ItemStack _setstack = new ItemStack(BlindShardArmorItem.legs);
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
				final ItemStack _setstack = new ItemStack(BurnArmorItem.boots);
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
				final ItemStack _setstack = new ItemStack(BurnDiamondArmorArmorItem.boots);
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
				final ItemStack _setstack = new ItemStack(UrinArmorItem.boots);
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
				final ItemStack _setstack = new ItemStack(BlindShardArmorItem.boots);
				final int _sltid = (int) (5);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);
			DarkendSurviverOnEntityTickUpdate2Procedure.executeProcedure($_dependencies);
		}
	}
}
