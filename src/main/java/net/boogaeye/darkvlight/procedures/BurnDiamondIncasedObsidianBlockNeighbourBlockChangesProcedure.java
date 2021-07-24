package net.boogaeye.darkvlight.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.boogaeye.darkvlight.item.BurnDiamondItem;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class BurnDiamondIncasedObsidianBlockNeighbourBlockChangesProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency x for procedure BurnDiamondIncasedObsidianBlockNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency y for procedure BurnDiamondIncasedObsidianBlockNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency z for procedure BurnDiamondIncasedObsidianBlockNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure BurnDiamondIncasedObsidianBlockNeighbourBlockChanges!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.WATER)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.OBSIDIAN.getDefaultState(), 3);
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(BurnDiamondItem.block));
				entityToSpawn.setPickupDelay((int) 60);
				world.addEntity(entityToSpawn);
			}
		} else {
			if ((!((world instanceof World) ? ((World) world).isBlockPowered(new BlockPos((int) x, (int) y, (int) z)) : false))) {
				if ((Math.random() > 0.6)) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (world instanceof ServerWorld) {
								LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
								_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos((int) x, (int) y, (int) z)));
								_ent.setEffectOnly(false);
								((World) world).addEntity(_ent);
							}
						}
					}
					if (world instanceof World && !((World) world).isRemote) {
						((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 16, Explosion.Mode.BREAK);
					}
				}
			}
		}
	}
}
