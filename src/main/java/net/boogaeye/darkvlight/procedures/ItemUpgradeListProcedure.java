package net.boogaeye.darkvlight.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.boogaeye.darkvlight.item.GlowingFruitFoodItem;
import net.boogaeye.darkvlight.item.DriedGlowBerryItem;
import net.boogaeye.darkvlight.item.BurnCrystalItem;
import net.boogaeye.darkvlight.block.GlowingFruitBlock;
import net.boogaeye.darkvlight.block.DarkendGlowingLeavesBlock;
import net.boogaeye.darkvlight.DarkVsLightMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.Iterator;

public class ItemUpgradeListProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DarkVsLightMod.LOGGER.warn("Failed to load dependency entity for procedure ItemUpgradeList!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack ItemCopy = ItemStack.EMPTY;
		ItemCopy = (new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (0)));
		if (entity instanceof PlayerEntity) {
			Container _current = ((PlayerEntity) entity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
					_setstack.setCount((int) 1);
					((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
					_current.detectAndSendChanges();
				}
			}
		}
		if (((ItemCopy).getItem() == new ItemStack(Items.WOODEN_PICKAXE, (int) (1)).getItem())) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Items.STONE_PICKAXE, (int) (1));
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (((ItemCopy).getItem() == new ItemStack(Items.STONE_PICKAXE, (int) (1)).getItem())) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Items.IRON_PICKAXE, (int) (1));
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (((ItemCopy).getItem() == new ItemStack(Items.IRON_PICKAXE, (int) (1)).getItem())) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Items.DIAMOND_PICKAXE, (int) (1));
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (((ItemCopy).getItem() == new ItemStack(Items.DIAMOND_PICKAXE, (int) (1)).getItem())) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Items.GOLDEN_PICKAXE, (int) (1));
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else {
			if (((ItemCopy).getItem() == new ItemStack(Items.WOODEN_SHOVEL, (int) (1)).getItem())) {
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.STONE_SHOVEL, (int) (1));
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else if (((ItemCopy).getItem() == new ItemStack(Items.STONE_SHOVEL, (int) (1)).getItem())) {
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.IRON_SHOVEL, (int) (1));
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else if (((ItemCopy).getItem() == new ItemStack(Items.IRON_SHOVEL, (int) (1)).getItem())) {
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.DIAMOND_SHOVEL, (int) (1));
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else if (((ItemCopy).getItem() == new ItemStack(Items.DIAMOND_SHOVEL, (int) (1)).getItem())) {
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.GOLDEN_SHOVEL, (int) (1));
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else {
				if (((ItemCopy).getItem() == new ItemStack(Items.WOODEN_AXE, (int) (1)).getItem())) {
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(Items.STONE_AXE, (int) (1));
								_setstack.setCount((int) 1);
								((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
				} else if (((ItemCopy).getItem() == new ItemStack(Items.STONE_AXE, (int) (1)).getItem())) {
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(Items.IRON_AXE, (int) (1));
								_setstack.setCount((int) 1);
								((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
				} else if (((ItemCopy).getItem() == new ItemStack(Items.IRON_AXE, (int) (1)).getItem())) {
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(Items.DIAMOND_AXE, (int) (1));
								_setstack.setCount((int) 1);
								((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
				} else if (((ItemCopy).getItem() == new ItemStack(Items.DIAMOND_AXE, (int) (1)).getItem())) {
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(Items.GOLDEN_AXE, (int) (1));
								_setstack.setCount((int) 1);
								((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
				} else {
					if (((ItemCopy).getItem() == new ItemStack(Items.WOODEN_HOE, (int) (1)).getItem())) {
						if (entity instanceof PlayerEntity) {
							Container _current = ((PlayerEntity) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									ItemStack _setstack = new ItemStack(Items.STONE_HOE, (int) (1));
									_setstack.setCount((int) 1);
									((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
									_current.detectAndSendChanges();
								}
							}
						}
					} else if (((ItemCopy).getItem() == new ItemStack(Items.STONE_HOE, (int) (1)).getItem())) {
						if (entity instanceof PlayerEntity) {
							Container _current = ((PlayerEntity) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									ItemStack _setstack = new ItemStack(Items.IRON_HOE, (int) (1));
									_setstack.setCount((int) 1);
									((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
									_current.detectAndSendChanges();
								}
							}
						}
					} else if (((ItemCopy).getItem() == new ItemStack(Items.IRON_HOE, (int) (1)).getItem())) {
						if (entity instanceof PlayerEntity) {
							Container _current = ((PlayerEntity) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									ItemStack _setstack = new ItemStack(Items.DIAMOND_HOE, (int) (1));
									_setstack.setCount((int) 1);
									((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
									_current.detectAndSendChanges();
								}
							}
						}
					} else if (((ItemCopy).getItem() == new ItemStack(Items.DIAMOND_HOE, (int) (1)).getItem())) {
						if (entity instanceof PlayerEntity) {
							Container _current = ((PlayerEntity) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									ItemStack _setstack = new ItemStack(Items.GOLDEN_HOE, (int) (1));
									_setstack.setCount((int) 1);
									((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
									_current.detectAndSendChanges();
								}
							}
						}
					} else {
						if (((ItemCopy).getItem() == new ItemStack(Items.WOODEN_SWORD, (int) (1)).getItem())) {
							if (entity instanceof PlayerEntity) {
								Container _current = ((PlayerEntity) entity).openContainer;
								if (_current instanceof Supplier) {
									Object invobj = ((Supplier) _current).get();
									if (invobj instanceof Map) {
										ItemStack _setstack = new ItemStack(Items.STONE_SWORD, (int) (1));
										_setstack.setCount((int) 1);
										((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
										_current.detectAndSendChanges();
									}
								}
							}
						} else if (((ItemCopy).getItem() == new ItemStack(Items.STONE_SWORD, (int) (1)).getItem())) {
							if (entity instanceof PlayerEntity) {
								Container _current = ((PlayerEntity) entity).openContainer;
								if (_current instanceof Supplier) {
									Object invobj = ((Supplier) _current).get();
									if (invobj instanceof Map) {
										ItemStack _setstack = new ItemStack(Items.IRON_SWORD, (int) (1));
										_setstack.setCount((int) 1);
										((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
										_current.detectAndSendChanges();
									}
								}
							}
						} else if (((ItemCopy).getItem() == new ItemStack(Items.IRON_SWORD, (int) (1)).getItem())) {
							if (entity instanceof PlayerEntity) {
								Container _current = ((PlayerEntity) entity).openContainer;
								if (_current instanceof Supplier) {
									Object invobj = ((Supplier) _current).get();
									if (invobj instanceof Map) {
										ItemStack _setstack = new ItemStack(Items.DIAMOND_SWORD, (int) (1));
										_setstack.setCount((int) 1);
										((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
										_current.detectAndSendChanges();
									}
								}
							}
						} else if (((ItemCopy).getItem() == new ItemStack(Items.DIAMOND_SWORD, (int) (1)).getItem())) {
							if (entity instanceof PlayerEntity) {
								Container _current = ((PlayerEntity) entity).openContainer;
								if (_current instanceof Supplier) {
									Object invobj = ((Supplier) _current).get();
									if (invobj instanceof Map) {
										ItemStack _setstack = new ItemStack(Items.GOLDEN_SWORD, (int) (1));
										_setstack.setCount((int) 1);
										((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
										_current.detectAndSendChanges();
									}
								}
							}
						} else {
							if (((ItemCopy).getItem() == new ItemStack(Blocks.OAK_LOG, (int) (1)).getItem())) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Blocks.STONE, (int) (1));
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == new ItemStack(Blocks.STONE, (int) (1)).getItem())) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Items.IRON_INGOT, (int) (1));
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == new ItemStack(Items.IRON_INGOT, (int) (1)).getItem())) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Items.GOLD_INGOT, (int) (1));
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == new ItemStack(Items.GOLD_INGOT, (int) (1)).getItem())) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(BurnCrystalItem.block, (int) (1));
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == new ItemStack(BurnCrystalItem.block, (int) (1)).getItem())) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Items.DIAMOND, (int) (1));
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == new ItemStack(Items.GLOWSTONE_DUST, (int) (1)).getItem())) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Blocks.GLOWSTONE, (int) (1));
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == new ItemStack(DarkendGlowingLeavesBlock.block, (int) (1)).getItem())) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Items.GLOWSTONE_DUST, (int) (1));
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == new ItemStack(GlowingFruitBlock.block, (int) (1)).getItem())) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Blocks.GLOWSTONE, (int) (1));
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == new ItemStack(GlowingFruitFoodItem.block, (int) (1)).getItem())) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Blocks.TORCH, (int) (1));
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == new ItemStack(DriedGlowBerryItem.block, (int) (1)).getItem())) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(GlowingFruitFoodItem.block, (int) (1));
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == new ItemStack(Blocks.TORCH, (int) (1)).getItem())) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Items.FLINT_AND_STEEL, (int) (1));
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == new ItemStack(Items.FLINT_AND_STEEL, (int) (1)).getItem())) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Items.LAVA_BUCKET, (int) (1));
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else {
								if (entity instanceof ServerPlayerEntity) {
									Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("dark_vs_light:failure_to_upgrade"));
									AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
									if (!_ap.isDone()) {
										Iterator _iterator = _ap.getRemaningCriteria().iterator();
										while (_iterator.hasNext()) {
											String _criterion = (String) _iterator.next();
											((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
	}
}
