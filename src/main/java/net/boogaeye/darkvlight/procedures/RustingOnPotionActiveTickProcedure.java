package net.boogaeye.darkvlight.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.boogaeye.darkvlight.potion.RustingPotionEffect;
import net.boogaeye.darkvlight.particle.DarkendDessertParticleParticle;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Random;
import java.util.Map;
import java.util.Collection;

public class RustingOnPotionActiveTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure RustingOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency x for procedure RustingOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency y for procedure RustingOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency z for procedure RustingOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure RustingOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack vopy = ItemStack.EMPTY;
		double slot = 0;
		entity.getPersistentData().putDouble("RustTick", ((entity.getPersistentData().getDouble("RustTick")) + ((new Object() {
			int check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == RustingPotionEffect.potion)
							return effect.getAmplifier();
					}
				}
				return 0;
			}
		}.check(entity)) + 1)));
		if (((entity.getPersistentData().getDouble("RustTick")) > 60)) {
			{
				AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
				if (_iitemhandlerref.get() != null) {
					for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
						ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
						vopy = (itemstackiterator);
						{
							ItemStack _ist = (vopy);
							if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
								_ist.shrink(1);
								_ist.setDamage(0);
							}
						}
						if (((((vopy)).getDamage()) != (((vopy)).getMaxDamage()))) {
							{
								final ItemStack _setstack = (vopy);
								final int _sltid = (int) (slot);
								_setstack.setCount((int) (((vopy)).getCount()));
								entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						} else {
							if ((!(Blocks.AIR.asItem() == (vopy).getItem()))) {
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).attackEntityFrom(new DamageSource("rust").setDamageBypassesArmor(), (float) 1);
								}
							}
						}
						slot = (double) (slot + 1);
					}
				}
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(DarkendDessertParticleParticle.particle, x, y, z, (int) 5, 1, 1, 1, 1);
			}
			entity.getPersistentData().putDouble("RustTick", ((new Object() {
				int check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == RustingPotionEffect.potion)
								return effect.getAmplifier();
						}
					}
					return 0;
				}
			}.check(entity)) * 3));
		}
	}
}
