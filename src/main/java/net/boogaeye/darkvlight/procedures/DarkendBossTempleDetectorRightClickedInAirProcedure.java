package net.boogaeye.darkvlight.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.boogaeye.darkvlight.DarkVsLightModVariables;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Random;
import java.util.Map;

public class DarkendBossTempleDetectorRightClickedInAirProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure DarkendBossTempleDetectorRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency itemstack for procedure DarkendBossTempleDetectorRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency x for procedure DarkendBossTempleDetectorRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency y for procedure DarkendBossTempleDetectorRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency z for procedure DarkendBossTempleDetectorRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure DarkendBossTempleDetectorRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((itemstack).getOrCreateTag().getBoolean("DetectedTemple"))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("Total Steps away from the temple in the form X Y Z: ") + ""
						+ ((new java.text.DecimalFormat("##").format((x - ((itemstack).getOrCreateTag().getDouble("TempleX")))))) + "" + (" ") + ""
						+ ((new java.text.DecimalFormat("##").format((y - ((itemstack).getOrCreateTag().getDouble("TempleY")))))) + "" + (" ") + ""
						+ ((new java.text.DecimalFormat("##").format((z - ((itemstack).getOrCreateTag().getDouble("TempleZ")))))))), (true));
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dark_vs_light:tracker")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dark_vs_light:tracker")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown((itemstack).getItem(), (int) 60);
		} else {
			if (DarkVsLightModVariables.MapVariables.get(world).TempleGen) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
							"Found a temple it will now be bounded by this item. Right Click To View how far you are from it"), (true));
				}
				(itemstack).getOrCreateTag().putBoolean("DetectedTemple", (true));
				(itemstack).getOrCreateTag().putDouble("TempleX", DarkVsLightModVariables.MapVariables.get(world).TempleX);
				(itemstack).getOrCreateTag().putDouble("TempleY", DarkVsLightModVariables.MapVariables.get(world).TempleY);
				(itemstack).getOrCreateTag().putDouble("TempleZ", DarkVsLightModVariables.MapVariables.get(world).TempleZ);
				DarkVsLightModVariables.MapVariables.get(world).TempleGen = (boolean) (false);
				DarkVsLightModVariables.MapVariables.get(world).syncData(world);
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dark_vs_light:trackerfound")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dark_vs_light:trackerfound")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown((itemstack).getItem(), (int) 600);
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Explore More I cant See a temple from here..."), (true));
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dark_vs_light:trackerdeny")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dark_vs_light:trackerdeny")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown((itemstack).getItem(), (int) 200);
			}
		}
	}
}
