package net.boogaeye.darkvlight.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import net.boogaeye.darkvlight.potion.GlowBerryRevivalPotionEffect;
import net.boogaeye.darkvlight.item.RevivalBerryItem;
import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class RevivalProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityAttacked(LivingHurtEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				double amount = event.getAmount();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("amount", amount);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure Revival!");
			return;
		}
		if (dependencies.get("amount") == null) {
			if (!dependencies.containsKey("amount"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency amount for procedure Revival!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure Revival!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double amount = dependencies.get("amount") instanceof Integer ? (int) dependencies.get("amount") : (double) dependencies.get("amount");
		IWorld world = (IWorld) dependencies.get("world");
		if ((new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == GlowBerryRevivalPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity))) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= (amount))) {
				if (entity instanceof PlayerEntity) {
					((PlayerEntity) entity).abilities.disableDamage = (true);
					((PlayerEntity) entity).sendPlayerAbilities();
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
				if (world.isRemote()) {
					Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(RevivalBerryItem.block));
				}
				if (entity instanceof PlayerEntity) {
					((PlayerEntity) entity).abilities.disableDamage = (false);
					((PlayerEntity) entity).sendPlayerAbilities();
				}
				{
					double _setval = (double) 100;
					entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Darkend = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) 100;
					entity.getCapability(DarkVsLightModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Enlightend = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).clearActivePotions();
				if (dependencies.get("event") != null) {
					Object _obj = dependencies.get("event");
					if (_obj instanceof Event) {
						Event _evt = (Event) _obj;
						if (_evt.isCancelable())
							_evt.setCanceled(true);
					}
				}
			}
		}
	}
}
