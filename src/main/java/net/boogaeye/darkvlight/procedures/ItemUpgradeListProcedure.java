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
					ItemStack _setstack = new ItemStack(Blocks.AIR);
					_setstack.setCount((int) 1);
					((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
					_current.detectAndSendChanges();
				}
			}
		}
		if (((ItemCopy).getItem() == Items.WOODEN_PICKAXE)) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Items.STONE_PICKAXE);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (((ItemCopy).getItem() == Items.STONE_PICKAXE)) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Items.IRON_PICKAXE);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (((ItemCopy).getItem() == Items.IRON_PICKAXE)) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Items.DIAMOND_PICKAXE);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if (((ItemCopy).getItem() == Items.DIAMOND_PICKAXE)) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(Items.GOLDEN_PICKAXE);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		} else {
			if (((ItemCopy).getItem() == Items.WOODEN_SHOVEL)) {
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.STONE_SHOVEL);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else if (((ItemCopy).getItem() == Items.STONE_SHOVEL)) {
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.IRON_SHOVEL);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else if (((ItemCopy).getItem() == Items.IRON_SHOVEL)) {
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.DIAMOND_SHOVEL);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else if (((ItemCopy).getItem() == Items.DIAMOND_SHOVEL)) {
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(Items.GOLDEN_SHOVEL);
							_setstack.setCount((int) 1);
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else {
				if (((ItemCopy).getItem() == Items.WOODEN_AXE)) {
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(Items.STONE_AXE);
								_setstack.setCount((int) 1);
								((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
				} else if (((ItemCopy).getItem() == Items.STONE_AXE)) {
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(Items.IRON_AXE);
								_setstack.setCount((int) 1);
								((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
				} else if (((ItemCopy).getItem() == Items.IRON_AXE)) {
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(Items.DIAMOND_AXE);
								_setstack.setCount((int) 1);
								((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
				} else if (((ItemCopy).getItem() == Items.DIAMOND_AXE)) {
					if (entity instanceof PlayerEntity) {
						Container _current = ((PlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack _setstack = new ItemStack(Items.GOLDEN_AXE);
								_setstack.setCount((int) 1);
								((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
								_current.detectAndSendChanges();
							}
						}
					}
				} else {
					if (((ItemCopy).getItem() == Items.WOODEN_HOE)) {
						if (entity instanceof PlayerEntity) {
							Container _current = ((PlayerEntity) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									ItemStack _setstack = new ItemStack(Items.STONE_HOE);
									_setstack.setCount((int) 1);
									((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
									_current.detectAndSendChanges();
								}
							}
						}
					} else if (((ItemCopy).getItem() == Items.STONE_HOE)) {
						if (entity instanceof PlayerEntity) {
							Container _current = ((PlayerEntity) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									ItemStack _setstack = new ItemStack(Items.IRON_HOE);
									_setstack.setCount((int) 1);
									((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
									_current.detectAndSendChanges();
								}
							}
						}
					} else if (((ItemCopy).getItem() == Items.IRON_HOE)) {
						if (entity instanceof PlayerEntity) {
							Container _current = ((PlayerEntity) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									ItemStack _setstack = new ItemStack(Items.DIAMOND_HOE);
									_setstack.setCount((int) 1);
									((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
									_current.detectAndSendChanges();
								}
							}
						}
					} else if (((ItemCopy).getItem() == Items.DIAMOND_HOE)) {
						if (entity instanceof PlayerEntity) {
							Container _current = ((PlayerEntity) entity).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									ItemStack _setstack = new ItemStack(Items.GOLDEN_HOE);
									_setstack.setCount((int) 1);
									((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
									_current.detectAndSendChanges();
								}
							}
						}
					} else {
						if (((ItemCopy).getItem() == Items.WOODEN_SWORD)) {
							if (entity instanceof PlayerEntity) {
								Container _current = ((PlayerEntity) entity).openContainer;
								if (_current instanceof Supplier) {
									Object invobj = ((Supplier) _current).get();
									if (invobj instanceof Map) {
										ItemStack _setstack = new ItemStack(Items.STONE_SWORD);
										_setstack.setCount((int) 1);
										((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
										_current.detectAndSendChanges();
									}
								}
							}
						} else if (((ItemCopy).getItem() == Items.STONE_SWORD)) {
							if (entity instanceof PlayerEntity) {
								Container _current = ((PlayerEntity) entity).openContainer;
								if (_current instanceof Supplier) {
									Object invobj = ((Supplier) _current).get();
									if (invobj instanceof Map) {
										ItemStack _setstack = new ItemStack(Items.IRON_SWORD);
										_setstack.setCount((int) 1);
										((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
										_current.detectAndSendChanges();
									}
								}
							}
						} else if (((ItemCopy).getItem() == Items.IRON_SWORD)) {
							if (entity instanceof PlayerEntity) {
								Container _current = ((PlayerEntity) entity).openContainer;
								if (_current instanceof Supplier) {
									Object invobj = ((Supplier) _current).get();
									if (invobj instanceof Map) {
										ItemStack _setstack = new ItemStack(Items.DIAMOND_SWORD);
										_setstack.setCount((int) 1);
										((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
										_current.detectAndSendChanges();
									}
								}
							}
						} else if (((ItemCopy).getItem() == Items.DIAMOND_SWORD)) {
							if (entity instanceof PlayerEntity) {
								Container _current = ((PlayerEntity) entity).openContainer;
								if (_current instanceof Supplier) {
									Object invobj = ((Supplier) _current).get();
									if (invobj instanceof Map) {
										ItemStack _setstack = new ItemStack(Items.GOLDEN_SWORD);
										_setstack.setCount((int) 1);
										((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
										_current.detectAndSendChanges();
									}
								}
							}
						} else {
							if (((ItemCopy).getItem() == Blocks.OAK_LOG.asItem())) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Blocks.STONE);
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == Blocks.STONE.asItem())) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Items.IRON_INGOT);
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == Items.IRON_INGOT)) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Items.GOLD_INGOT);
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == Items.GOLD_INGOT)) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(BurnCrystalItem.block);
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == BurnCrystalItem.block)) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Items.DIAMOND);
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == Items.GLOWSTONE_DUST)) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Blocks.GLOWSTONE);
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == DarkendGlowingLeavesBlock.block.asItem())) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Items.GLOWSTONE_DUST);
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == GlowingFruitBlock.block.asItem())) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Blocks.GLOWSTONE);
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == GlowingFruitFoodItem.block)) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Blocks.TORCH);
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == DriedGlowBerryItem.block)) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(GlowingFruitFoodItem.block);
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == Blocks.TORCH.asItem())) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Items.FLINT_AND_STEEL);
											_setstack.setCount((int) 1);
											((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
											_current.detectAndSendChanges();
										}
									}
								}
							} else if (((ItemCopy).getItem() == Items.FLINT_AND_STEEL)) {
								if (entity instanceof PlayerEntity) {
									Container _current = ((PlayerEntity) entity).openContainer;
									if (_current instanceof Supplier) {
										Object invobj = ((Supplier) _current).get();
										if (invobj instanceof Map) {
											ItemStack _setstack = new ItemStack(Items.LAVA_BUCKET);
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
