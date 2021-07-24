
package net.boogaeye.darkvlight.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.NonNullList;
import net.minecraft.util.Mirror;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.state.StateContainer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.NetworkManager;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.Minecraft;
import net.minecraft.block.material.PushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.boogaeye.darkvlight.procedures.UpgradeBlockUpdateTickProcedure;
import net.boogaeye.darkvlight.procedures.UpgradeBlockParticleSpawningConditionProcedure;
import net.boogaeye.darkvlight.procedures.UpgradeBlockOnBlockRightClickedProcedure;
import net.boogaeye.darkvlight.particle.DarkFireParticle;
import net.boogaeye.darkvlight.itemgroup.DVLtabItemGroup;
import net.boogaeye.darkvlight.gui.UpgradeBlockGUIReworkGui;
import net.boogaeye.darkvlight.DarkVsLightModElements;

import javax.annotation.Nullable;

import java.util.stream.IntStream;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

import io.netty.buffer.Unpooled;

import com.google.common.collect.ImmutableMap;

@DarkVsLightModElements.ModElement.Tag
public class UpgradeBlockBlock extends DarkVsLightModElements.ModElement {
	@ObjectHolder("dark_vs_light:upgrade_block")
	public static final Block block = null;
	@ObjectHolder("dark_vs_light:upgrade_block")
	public static final TileEntityType<CustomTileEntity> tileEntityType = null;
	public UpgradeBlockBlock(DarkVsLightModElements instance) {
		super(instance, 9);
		FMLJavaModLoadingContext.get().getModEventBus().register(new TileEntityRegisterHandler());
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(DVLtabItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	private static class TileEntityRegisterHandler {
		@SubscribeEvent
		public void registerTileEntity(RegistryEvent.Register<TileEntityType<?>> event) {
			event.getRegistry().register(TileEntityType.Builder.create(CustomTileEntity::new, block).build(null).setRegistryName("upgrade_block"));
		}
	}
	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	public static class CustomBlock extends FallingBlock {
		public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
		public CustomBlock() {
			super(Block.Properties.create(Material.ANVIL).sound(SoundType.ANVIL).hardnessAndResistance(-1, 3600000).setLightLevel(s -> 0).notSolid()
					.setOpaque((bs, br, bp) -> false));
			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
			setRegistryName("upgrade_block");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 0;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			Vector3d offset = state.getOffset(world, pos);
			switch ((Direction) state.get(FACING)) {
				case SOUTH :
				default :
					return VoxelShapes.or(makeCuboidShape(16, 0, 16, 0, 16, 0), makeCuboidShape(9, 14, 25, 7, 16, 16),
							makeCuboidShape(9, 0, 27, 7, 16, 25), makeCuboidShape(9, 0, 25, 7, 2, 16)).withOffset(offset.x, offset.y, offset.z);
				case NORTH :
					return VoxelShapes.or(makeCuboidShape(0, 0, 0, 16, 16, 16), makeCuboidShape(7, 14, -9, 9, 16, 0),
							makeCuboidShape(7, 0, -11, 9, 16, -9), makeCuboidShape(7, 0, -9, 9, 2, 0)).withOffset(offset.x, offset.y, offset.z);
				case EAST :
					return VoxelShapes.or(makeCuboidShape(16, 0, 0, 0, 16, 16), makeCuboidShape(25, 14, 7, 16, 16, 9),
							makeCuboidShape(27, 0, 7, 25, 16, 9), makeCuboidShape(25, 0, 7, 16, 2, 9)).withOffset(offset.x, offset.y, offset.z);
				case WEST :
					return VoxelShapes.or(makeCuboidShape(0, 0, 16, 16, 16, 0), makeCuboidShape(-9, 14, 9, 0, 16, 7),
							makeCuboidShape(-11, 0, 9, -9, 16, 7), makeCuboidShape(-9, 0, 9, 0, 2, 7)).withOffset(offset.x, offset.y, offset.z);
			}
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(FACING);
		}

		public BlockState rotate(BlockState state, Rotation rot) {
			return state.with(FACING, rot.rotate(state.get(FACING)));
		}

		public BlockState mirror(BlockState state, Mirror mirrorIn) {
			return state.rotate(mirrorIn.toRotation(state.get(FACING)));
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			;
			return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
		}

		@Override
		public PathNodeType getAiPathNodeType(BlockState state, IBlockReader world, BlockPos pos, MobEntity entity) {
			return PathNodeType.BLOCKED;
		}

		@Override
		public PushReaction getPushReaction(BlockState state) {
			return PushReaction.IGNORE;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public void onBlockAdded(BlockState blockstate, World world, BlockPos pos, BlockState oldState, boolean moving) {
			super.onBlockAdded(blockstate, world, pos, oldState, moving);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			world.getPendingBlockTicks().scheduleTick(new BlockPos(x, y, z), this, 1);
		}

		@Override
		public void tick(BlockState blockstate, ServerWorld world, BlockPos pos, Random random) {
			super.tick(blockstate, world, pos, random);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				UpgradeBlockUpdateTickProcedure.executeProcedure($_dependencies);
			}
			world.getPendingBlockTicks().scheduleTick(new BlockPos(x, y, z), this, 1);
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public void animateTick(BlockState blockstate, World world, BlockPos pos, Random random) {
			super.animateTick(blockstate, world, pos, random);
			PlayerEntity entity = Minecraft.getInstance().player;
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (UpgradeBlockParticleSpawningConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
				for (int l = 0; l < 16; ++l) {
					double d0 = (double) ((float) x + 0.5) + (double) (random.nextFloat() - 0.5) * 1D;
					double d1 = ((double) ((float) y + 0.7) + (double) (random.nextFloat() - 0.5) * 1D) + 0.5;
					double d2 = (double) ((float) z + 0.5) + (double) (random.nextFloat() - 0.5) * 1D;
					world.addParticle(DarkFireParticle.particle, d0, d1, d2, 0, 0, 0);
				}
		}

		@Override
		public ActionResultType onBlockActivated(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity, Hand hand,
				BlockRayTraceResult hit) {
			super.onBlockActivated(blockstate, world, pos, entity, hand, hit);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (entity instanceof ServerPlayerEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) entity, new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new StringTextComponent("Upgrade Block");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						return new UpgradeBlockGUIReworkGui.GuiContainerMod(id, inventory,
								new PacketBuffer(Unpooled.buffer()).writeBlockPos(new BlockPos(x, y, z)));
					}
				}, new BlockPos(x, y, z));
			}
			Direction direction = hit.getFace();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				UpgradeBlockOnBlockRightClickedProcedure.executeProcedure($_dependencies);
			}
			return ActionResultType.SUCCESS;
		}

		@Override
		public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			return tileEntity instanceof INamedContainerProvider ? (INamedContainerProvider) tileEntity : null;
		}

		@Override
		public boolean hasTileEntity(BlockState state) {
			return true;
		}

		@Override
		public TileEntity createTileEntity(BlockState state, IBlockReader world) {
			return new CustomTileEntity();
		}

		@Override
		public boolean eventReceived(BlockState state, World world, BlockPos pos, int eventID, int eventParam) {
			super.eventReceived(state, world, pos, eventID, eventParam);
			TileEntity tileentity = world.getTileEntity(pos);
			return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
		}

		@Override
		public void onReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
			if (state.getBlock() != newState.getBlock()) {
				TileEntity tileentity = world.getTileEntity(pos);
				if (tileentity instanceof CustomTileEntity) {
					InventoryHelper.dropInventoryItems(world, pos, (CustomTileEntity) tileentity);
					world.updateComparatorOutputLevel(pos, this);
				}
				super.onReplaced(state, world, pos, newState, isMoving);
			}
		}

		@Override
		public boolean hasComparatorInputOverride(BlockState state) {
			return true;
		}

		@Override
		public int getComparatorInputOverride(BlockState blockState, World world, BlockPos pos) {
			TileEntity tileentity = world.getTileEntity(pos);
			if (tileentity instanceof CustomTileEntity)
				return Container.calcRedstoneFromInventory((CustomTileEntity) tileentity);
			else
				return 0;
		}
	}

	public static class CustomTileEntity extends LockableLootTileEntity implements ISidedInventory {
		private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
		protected CustomTileEntity() {
			super(tileEntityType);
		}

		@Override
		public void read(BlockState blockState, CompoundNBT compound) {
			super.read(blockState, compound);
			if (!this.checkLootAndRead(compound)) {
				this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
			}
			ItemStackHelper.loadAllItems(compound, this.stacks);
		}

		@Override
		public CompoundNBT write(CompoundNBT compound) {
			super.write(compound);
			if (!this.checkLootAndWrite(compound)) {
				ItemStackHelper.saveAllItems(compound, this.stacks);
			}
			return compound;
		}

		@Override
		public SUpdateTileEntityPacket getUpdatePacket() {
			return new SUpdateTileEntityPacket(this.pos, 0, this.getUpdateTag());
		}

		@Override
		public CompoundNBT getUpdateTag() {
			return this.write(new CompoundNBT());
		}

		@Override
		public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
			this.read(this.getBlockState(), pkt.getNbtCompound());
		}

		@Override
		public int getSizeInventory() {
			return stacks.size();
		}

		@Override
		public boolean isEmpty() {
			for (ItemStack itemstack : this.stacks)
				if (!itemstack.isEmpty())
					return false;
			return true;
		}

		@Override
		public ITextComponent getDefaultName() {
			return new StringTextComponent("upgrade_block");
		}

		@Override
		public int getInventoryStackLimit() {
			return 1;
		}

		@Override
		public Container createMenu(int id, PlayerInventory player) {
			return new UpgradeBlockGUIReworkGui.GuiContainerMod(id, player, new PacketBuffer(Unpooled.buffer()).writeBlockPos(this.getPos()));
		}

		@Override
		public ITextComponent getDisplayName() {
			return new StringTextComponent("Upgrade Block");
		}

		@Override
		protected NonNullList<ItemStack> getItems() {
			return this.stacks;
		}

		@Override
		protected void setItems(NonNullList<ItemStack> stacks) {
			this.stacks = stacks;
		}

		@Override
		public boolean isItemValidForSlot(int index, ItemStack stack) {
			return true;
		}

		@Override
		public int[] getSlotsForFace(Direction side) {
			return IntStream.range(0, this.getSizeInventory()).toArray();
		}

		@Override
		public boolean canInsertItem(int index, ItemStack stack, @Nullable Direction direction) {
			return this.isItemValidForSlot(index, stack);
		}

		@Override
		public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
			return true;
		}
		private final LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.values());
		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
			if (!this.removed && facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
				return handlers[facing.ordinal()].cast();
			return super.getCapability(capability, facing);
		}

		@Override
		public void remove() {
			super.remove();
			for (LazyOptional<? extends IItemHandler> handler : handlers)
				handler.invalidate();
		}
	}
}
