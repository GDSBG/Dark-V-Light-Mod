package net.boogaeye.darkvlight.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.boogaeye.darkvlight.entity.DarkendBossEntity2Entity;
import net.boogaeye.darkvlight.block.SmoothDarkStoneBlock;
import net.boogaeye.darkvlight.block.GliphBlockBlock;
import net.boogaeye.darkvlight.block.DarkendDioriteBlock;
import net.boogaeye.darkvlight.block.DarkendDiamondsBlock;
import net.boogaeye.darkvlight.block.DarkStoneBlock;
import net.boogaeye.darkvlight.block.BlindStoneBlock;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

public class GliphBlockUpdateTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency x for procedure GliphBlockUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency y for procedure GliphBlockUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency z for procedure GliphBlockUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure GliphBlockUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double tryblockx = 0;
		double tryblocky = 0;
		double tryblockz = 0;
		double blox = 0;
		if ((new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Active"))) {
			if (((new Object() {
				public int getAmount(IWorld world, BlockPos pos, int sltid) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).getCount());
						});
					}
					return _retval.get();
				}
			}.getAmount(world, new BlockPos((int) x, (int) y, (int) z), (int) (0))) != 0)) {
				if (((new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "layers")) == 100)) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
					if (world instanceof World && !((World) world).isRemote) {
						((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 10, Explosion.Mode.BREAK);
					}
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new DarkendBossEntity2Entity.CustomEntity(DarkendBossEntity2Entity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
				} else {
					tryblockx = (double) (x - (50 - (new Object() {
						public double getValue(IWorld world, BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "layers"))));
					tryblocky = (double) (y - 1);
					tryblockz = (double) (z - 50);
					for (int index0 = 0; index0 < (int) (100); index0++) {
						if ((Math.random() < 0.7)) {
							world.setBlockState(new BlockPos((int) tryblockx, (int) tryblocky, (int) tryblockz),
									DarkStoneBlock.block.getDefaultState(), 3);
						} else if ((Math.random() < 0.65)) {
							world.setBlockState(new BlockPos((int) tryblockx, (int) tryblocky, (int) tryblockz),
									SmoothDarkStoneBlock.block.getDefaultState(), 3);
						} else if ((Math.random() < 0.2)) {
							world.setBlockState(new BlockPos((int) tryblockx, (int) tryblocky, (int) tryblockz),
									BlindStoneBlock.block.getDefaultState(), 3);
						} else if ((Math.random() < 0.05)) {
							world.setBlockState(new BlockPos((int) tryblockx, (int) tryblocky, (int) tryblockz),
									DarkendDiamondsBlock.block.getDefaultState(), 3);
						} else {
							world.setBlockState(new BlockPos((int) tryblockx, (int) tryblocky, (int) tryblockz),
									DarkendDioriteBlock.block.getDefaultState(), 3);
						}
						tryblockz = (double) (tryblockz + 1);
						for (int index1 = 0; index1 < (int) (100); index1++) {
							if ((!((world.getBlockState(new BlockPos((int) tryblockx, (int) tryblocky, (int) tryblockz)))
									.getBlock() == GliphBlockBlock.block))) {
								world.setBlockState(new BlockPos((int) tryblockx, (int) tryblocky, (int) tryblockz), Blocks.AIR.getDefaultState(), 3);
							}
							tryblocky = (double) (tryblocky + 1);
						}
						tryblocky = (double) (y - 1);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("layers", ((new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "layers")) + 1));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _sltid = (int) (0);
							final int _amount = (int) 1;
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable) {
									ItemStack _stk = capability.getStackInSlot(_sltid).copy();
									_stk.shrink(_amount);
									((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
								}
							});
						}
					}
				}
			}
		}
	}
}
