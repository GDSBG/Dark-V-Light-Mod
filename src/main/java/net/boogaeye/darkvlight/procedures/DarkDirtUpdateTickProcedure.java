package net.boogaeye.darkvlight.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.boogaeye.darkvlight.block.PurpleFireBlock;
import net.boogaeye.darkvlight.block.DarkendGrassBlock;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;

public class DarkDirtUpdateTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency x for procedure DarkDirtUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency y for procedure DarkDirtUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency z for procedure DarkDirtUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure DarkDirtUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z)))) {
			if ((Math.random() <= 0.3)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DarkendGrassBlock.block.getDefaultState(), 3);
			}
			if ((Math.random() <= 0.1)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), PurpleFireBlock.block.getDefaultState(), 3);
			}
		}
	}
}
