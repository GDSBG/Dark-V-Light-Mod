package net.boogaeye.darkvlight.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.block.BlockState;

import net.boogaeye.darkvlight.item.XPFragmentItem;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.Map;
import java.util.HashMap;

public class ConvertToXpProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure ConvertToXp!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency guistate for procedure ConvertToXp!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency x for procedure ConvertToXp!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency y for procedure ConvertToXp!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency z for procedure ConvertToXp!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency world for procedure ConvertToXp!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack spawner = ItemStack.EMPTY;
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("LHP", (new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert((new Object() {
					public String getText() {
						TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:hptoxp");
						if (_tf != null) {
							return _tf.getText();
						}
						return "";
					}
				}.getText())) * 3));
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false)) {
			if ((new Object() {
				public boolean getValue(IWorld world, BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getBoolean(tag);
					return false;
				}
			}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Confirm"))) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).addExperienceLevel(-((int) new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:hptoxp");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText()))));
				spawner = new ItemStack(XPFragmentItem.block);
				(spawner).getOrCreateTag().putDouble("XP", new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert((new Object() {
					public String getText() {
						TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:hptoxp");
						if (_tf != null) {
							return _tf.getText();
						}
						return "";
					}
				}.getText())));
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, (spawner));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putBoolean("Confirm", (true));
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if ((!((new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:hptoxp");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText()).contains("-")))) {
				if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) > (new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert((new Object() {
					public String getText() {
						TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:hptoxp");
						if (_tf != null) {
							return _tf.getText();
						}
						return "";
					}
				}.getText())) * 3))) {
					if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0) >= new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:hptoxp");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText())))) {
						if ((new Object() {
							public boolean getValue(IWorld world, BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getBoolean(tag);
								return false;
							}
						}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "Confirm"))) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).addExperienceLevel(-((int) new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert((new Object() {
									public String getText() {
										TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:hptoxp");
										if (_tf != null) {
											return _tf.getText();
										}
										return "";
									}
								}.getText()))));
							entity.attackEntityFrom(DamageSource.GENERIC, (float) (new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert((new Object() {
								public String getText() {
									TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:hptoxp");
									if (_tf != null) {
										return _tf.getText();
									}
									return "";
								}
							}.getText())) * 3));
							spawner = new ItemStack(XPFragmentItem.block);
							(spawner).getOrCreateTag().putDouble("XP", new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert((new Object() {
								public String getText() {
									TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:hptoxp");
									if (_tf != null) {
										return _tf.getText();
									}
									return "";
								}
							}.getText())));
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, (spawner));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
						} else {
							if (!world.isRemote()) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putBoolean("Confirm", (true));
								if (world instanceof World)
									((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						}
					} else {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("XP is too low for that!"), (true));
						}
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).closeScreen();
					}
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("HP is too low for that!"), (true));
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).closeScreen();
				}
			}
		}
	}
}
