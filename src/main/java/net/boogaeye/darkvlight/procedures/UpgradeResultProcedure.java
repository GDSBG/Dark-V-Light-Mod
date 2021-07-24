package net.boogaeye.darkvlight.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

import com.google.common.collect.ImmutableMap;

public class UpgradeResultProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure UpgradeResult!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency x for procedure UpgradeResult!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency y for procedure UpgradeResult!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency z for procedure UpgradeResult!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure UpgradeResult!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack result = ItemStack.EMPTY;
		double Buckets = 0;
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dark_vs_light:upgradestart")),
					SoundCategory.BLOCKS, (float) 1, (float) 1);
		} else {
			((World) world).playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dark_vs_light:upgradestart")),
					SoundCategory.BLOCKS, (float) 1, (float) 1, false);
		}
		result = Tier1UpgradeProcedure.executeProcedure(ImmutableMap.of("entity", entity));
		Buckets = (double) (Buckets + 1);
		if ((!((result).getItem() == Blocks.AIR.asItem()))) {
			if ((Buckets <= (new Object() {
				public double getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Water")))) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("Working", (true));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("Water", ((new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Water")) - 1));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (1);
						final ItemStack _setstack = new ItemStack(Blocks.AIR);
						_setstack.setCount((int) 1);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				{
					ItemStack _ist = (result);
					if (_ist.attemptDamageItem((int) ((((new Object() {
						public ItemStack getItemStack(BlockPos pos, int sltid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null) {
								_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									_retval.set(capability.getStackInSlot(sltid).copy());
								});
							}
							return _retval.get();
						}
					}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1)))).getDamage()) + 5), new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (2);
						final ItemStack _setstack = (result);
						_setstack.setCount((int) 1);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof PlayerEntity)
							((PlayerEntity) entityiterator).closeScreen();
					}
				}
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;
					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (!world.isRemote()) {
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							TileEntity _tileEntity = world.getTileEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getTileData().putBoolean("Working", (false));
							if (world instanceof World)
								((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
						}
						if (world instanceof World && !world.isRemote()) {
							((World) world)
									.playSound(null, new BlockPos((int) x, (int) y, (int) z),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("dark_vs_light:upgradeend")),
											SoundCategory.BLOCKS, (float) 1, (float) 1);
						} else {
							((World) world).playSound(x, y, z,
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("dark_vs_light:upgradeend")),
									SoundCategory.BLOCKS, (float) 1, (float) 1, false);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 120);
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("Requires ") + "" + (Buckets) + "" + (" Buckets of water"))),
							(false));
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).closeScreen();
			}
		} else {
			result = Tier2UpgradeProcedure.executeProcedure(ImmutableMap.of("entity", entity));
			Buckets = (double) (Buckets + 1);
			if ((!((result).getItem() == Blocks.AIR.asItem()))) {
				if ((Buckets <= (new Object() {
					public double getValue(IWorld world, BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Water")))) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("Working", (true));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("Water", ((new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Water")) - Buckets));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _sltid = (int) (1);
							final ItemStack _setstack = new ItemStack(Blocks.AIR);
							_setstack.setCount((int) 1);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable) {
									((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
								}
							});
						}
					}
					{
						ItemStack _ist = (result);
						if (_ist.attemptDamageItem((int) ((((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1)))).getDamage()) + 10), new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _sltid = (int) (2);
							final ItemStack _setstack = (result);
							_setstack.setCount((int) 1);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable) {
									((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
								}
							});
						}
					}
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof PlayerEntity)
								((PlayerEntity) entityiterator).closeScreen();
						}
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;
						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("dark_vs_light:upgradeend")),
										SoundCategory.BLOCKS, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("dark_vs_light:upgradeend")),
										SoundCategory.BLOCKS, (float) 1, (float) 1, false);
							}
							if (!world.isRemote()) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putBoolean("Working", (false));
								if (world instanceof World)
									((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 400);
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity)
								.sendStatusMessage(new StringTextComponent((("Requires ") + "" + (Buckets) + "" + (" Buckets of water"))), (false));
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).closeScreen();
				}
			} else {
				result = Tier3UpgradeProcedure.executeProcedure(ImmutableMap.of("entity", entity));
				Buckets = (double) (Buckets + 1);
				if ((!((result).getItem() == Blocks.AIR.asItem()))) {
					if ((Buckets <= (new Object() {
						public double getValue(IWorld world, BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Water")))) {
						if ((Buckets <= (new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "DarkLiquid")))) {
							if (!world.isRemote()) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putBoolean("Working", (true));
								if (world instanceof World)
									((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
							if (!world.isRemote()) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("Water", ((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Water")) - Buckets));
								if (world instanceof World)
									((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
							if (!world.isRemote()) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("DarkLiquid", ((new Object() {
										public double getValue(IWorld world, BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "DarkLiquid")) - Buckets));
								if (world instanceof World)
									((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
							{
								TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
								if (_ent != null) {
									final int _sltid = (int) (1);
									final ItemStack _setstack = new ItemStack(Blocks.AIR);
									_setstack.setCount((int) 1);
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable) {
											((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
										}
									});
								}
							}
							{
								ItemStack _ist = (result);
								if (_ist.attemptDamageItem((int) ((((new Object() {
									public ItemStack getItemStack(BlockPos pos, int sltid) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
										}
										return _retval.get();
									}
								}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1)))).getDamage()) + 18), new Random(), null)) {
									_ist.shrink(1);
									_ist.setDamage(0);
								}
							}
							{
								TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
								if (_ent != null) {
									final int _sltid = (int) (2);
									final ItemStack _setstack = (result);
									_setstack.setCount((int) 1);
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable) {
											((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
										}
									});
								}
							}
							{
								List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)),
										null).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, z)).collect(Collectors.toList());
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof PlayerEntity)
										((PlayerEntity) entityiterator).closeScreen();
								}
							}
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;
								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									if (!world.isRemote()) {
										BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
										TileEntity _tileEntity = world.getTileEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_tileEntity != null)
											_tileEntity.getTileData().putBoolean("Working", (false));
										if (world instanceof World)
											((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("dark_vs_light:upgradeend")),
												SoundCategory.NEUTRAL, (float) 1, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("dark_vs_light:upgradeend")),
												SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 600);
						} else {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(
										new StringTextComponent((("Requires ") + "" + (Buckets) + "" + (" Buckets of Dark Fluid"))), (false));
							}
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).closeScreen();
						}
					} else {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(
									new StringTextComponent((("Requires ") + "" + (Buckets) + "" + (" Buckets of water"))), (false));
						}
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).closeScreen();
					}
				} else {
					result = Tier4UpgradeProcedure.executeProcedure(ImmutableMap.of("entity", entity));
					Buckets = (double) Tier4BucketValuesProcedure.executeProcedure(ImmutableMap.of("entity", entity));
					if ((!((result).getItem() == Blocks.AIR.asItem()))) {
						if ((Buckets <= (new Object() {
							public double getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Water")))) {
							if ((Buckets <= (new Object() {
								public double getValue(IWorld world, BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "DarkLiquid")))) {
								if ((Buckets <= (new Object() {
									public double getValue(IWorld world, BlockPos pos, String tag) {
										TileEntity tileEntity = world.getTileEntity(pos);
										if (tileEntity != null)
											return tileEntity.getTileData().getDouble(tag);
										return -1;
									}
								}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "HotDarkLiquid")))) {
									if (!world.isRemote()) {
										BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
										TileEntity _tileEntity = world.getTileEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_tileEntity != null)
											_tileEntity.getTileData().putBoolean("Working", (true));
										if (world instanceof World)
											((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
									}
									if (!world.isRemote()) {
										BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
										TileEntity _tileEntity = world.getTileEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_tileEntity != null)
											_tileEntity.getTileData().putDouble("Water", ((new Object() {
												public double getValue(IWorld world, BlockPos pos, String tag) {
													TileEntity tileEntity = world.getTileEntity(pos);
													if (tileEntity != null)
														return tileEntity.getTileData().getDouble(tag);
													return -1;
												}
											}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Water")) - Buckets));
										if (world instanceof World)
											((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
									}
									if (!world.isRemote()) {
										BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
										TileEntity _tileEntity = world.getTileEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_tileEntity != null)
											_tileEntity.getTileData().putDouble("DarkLiquid", ((new Object() {
												public double getValue(IWorld world, BlockPos pos, String tag) {
													TileEntity tileEntity = world.getTileEntity(pos);
													if (tileEntity != null)
														return tileEntity.getTileData().getDouble(tag);
													return -1;
												}
											}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "DarkLiquid")) - Buckets));
										if (world instanceof World)
											((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
									}
									if (!world.isRemote()) {
										BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
										TileEntity _tileEntity = world.getTileEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_tileEntity != null)
											_tileEntity.getTileData().putDouble("HotDarkLiquid", ((new Object() {
												public double getValue(IWorld world, BlockPos pos, String tag) {
													TileEntity tileEntity = world.getTileEntity(pos);
													if (tileEntity != null)
														return tileEntity.getTileData().getDouble(tag);
													return -1;
												}
											}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "HotDarkLiquid")) - Buckets));
										if (world instanceof World)
											((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
									}
									{
										TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
										if (_ent != null) {
											final int _sltid = (int) (1);
											final ItemStack _setstack = new ItemStack(Blocks.AIR);
											_setstack.setCount((int) 1);
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												if (capability instanceof IItemHandlerModifiable) {
													((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
												}
											});
										}
									}
									{
										ItemStack _ist = (result);
										if (_ist.attemptDamageItem((int) ((((new Object() {
											public ItemStack getItemStack(BlockPos pos, int sltid) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												TileEntity _ent = world.getTileEntity(pos);
												if (_ent != null) {
													_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
														_retval.set(capability.getStackInSlot(sltid).copy());
													});
												}
												return _retval.get();
											}
										}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (1)))).getDamage()) + 25), new Random(),
												null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
									{
										TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
										if (_ent != null) {
											final int _sltid = (int) (2);
											final ItemStack _setstack = (result);
											_setstack.setCount((int) 1);
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												if (capability instanceof IItemHandlerModifiable) {
													((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
												}
											});
										}
									}
									{
										List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (10 / 2d),
												y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null).stream()
												.sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof PlayerEntity)
												((PlayerEntity) entityiterator).closeScreen();
										}
									}
									new Object() {
										private int ticks = 0;
										private float waitTicks;
										private IWorld world;
										public void start(IWorld world, int waitTicks) {
											this.waitTicks = waitTicks;
											MinecraftForge.EVENT_BUS.register(this);
											this.world = world;
										}

										@SubscribeEvent
										public void tick(TickEvent.ServerTickEvent event) {
											if (event.phase == TickEvent.Phase.END) {
												this.ticks += 1;
												if (this.ticks >= this.waitTicks)
													run();
											}
										}

										private void run() {
											if (!world.isRemote()) {
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												TileEntity _tileEntity = world.getTileEntity(_bp);
												BlockState _bs = world.getBlockState(_bp);
												if (_tileEntity != null)
													_tileEntity.getTileData().putBoolean("Working", (false));
												if (world instanceof World)
													((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
											}
											if (world instanceof World && !world.isRemote()) {
												((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
														(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																.getValue(new ResourceLocation("dark_vs_light:upgradeend")),
														SoundCategory.BLOCKS, (float) 1, (float) 1);
											} else {
												((World) world).playSound(x, y, z,
														(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																.getValue(new ResourceLocation("dark_vs_light:upgradeend")),
														SoundCategory.BLOCKS, (float) 1, (float) 1, false);
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 1200);
								} else {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(
												new StringTextComponent((("Requires ") + "" + (Buckets) + "" + (" Buckets of Hot Dark Fluid"))),
												(false));
									}
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).closeScreen();
								}
							} else {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent((("Requires ") + "" + (Buckets) + "" + (" Buckets of Dark Fluid"))), (false));
								}
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).closeScreen();
							}
						} else {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(
										new StringTextComponent((("Requires ") + "" + (Buckets) + "" + (" Buckets of water"))), (false));
							}
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).closeScreen();
						}
					}
				}
			}
		}
	}
}
