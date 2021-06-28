
package net.boogaeye.darkvlight.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
import net.minecraft.item.BucketItem;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.boogaeye.darkvlight.procedures.EndarkendFluidUpdateTickProcedure;
import net.boogaeye.darkvlight.procedures.EndarkendFluidMobplayerCollidesBlockProcedure;
import net.boogaeye.darkvlight.itemgroup.DVLtabItemGroup;
import net.boogaeye.darkvlight.DarkVsLightModElements;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

@DarkVsLightModElements.ModElement.Tag
public class EndarkendFluidBlock extends DarkVsLightModElements.ModElement {
	@ObjectHolder("dark_vs_light:endarkend_fluid")
	public static final FlowingFluidBlock block = null;
	@ObjectHolder("dark_vs_light:endarkend_fluid_bucket")
	public static final Item bucket = null;
	public static FlowingFluid flowing = null;
	public static FlowingFluid still = null;
	private ForgeFlowingFluid.Properties fluidproperties = null;
	public EndarkendFluidBlock(DarkVsLightModElements instance) {
		super(instance, 229);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FluidRegisterHandler());
	}
	private static class FluidRegisterHandler {
		@SubscribeEvent
		public void registerFluids(RegistryEvent.Register<Fluid> event) {
			event.getRegistry().register(still);
			event.getRegistry().register(flowing);
		}
	}
	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(still, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(flowing, RenderType.getTranslucent());
	}

	@Override
	public void initElements() {
		fluidproperties = new ForgeFlowingFluid.Properties(() -> still, () -> flowing, FluidAttributes
				.builder(new ResourceLocation("dark_vs_light:blocks/darkwaterstill"), new ResourceLocation("dark_vs_light:blocks/darkwaterflow"))
				.luminosity(0).density(1000).viscosity(3000).rarity(Rarity.COMMON)).explosionResistance(100f).bucket(() -> bucket).block(() -> block);
		still = (FlowingFluid) new ForgeFlowingFluid.Source(fluidproperties).setRegistryName("endarkend_fluid");
		flowing = (FlowingFluid) new ForgeFlowingFluid.Flowing(fluidproperties).setRegistryName("endarkend_fluid_flowing");
		elements.blocks
				.add(() -> new FlowingFluidBlock(still, Block.Properties.create(Material.WATER).hardnessAndResistance(100f).setLightLevel(s -> 0)) {
					@Override
					public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
						super.tick(state, world, pos, random);
						int x = pos.getX();
						int y = pos.getY();
						int z = pos.getZ();
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("x", x);
							$_dependencies.put("y", y);
							$_dependencies.put("z", z);
							$_dependencies.put("world", world);
							EndarkendFluidUpdateTickProcedure.executeProcedure($_dependencies);
						}
						world.getPendingBlockTicks().scheduleTick(new BlockPos(x, y, z), this, 10);
					}

					@Override
					public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
						super.onEntityCollision(state, world, pos, entity);
						int x = pos.getX();
						int y = pos.getY();
						int z = pos.getZ();
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("entity", entity);
							$_dependencies.put("world", world);
							EndarkendFluidMobplayerCollidesBlockProcedure.executeProcedure($_dependencies);
						}
					}
				}.setRegistryName("endarkend_fluid"));
		elements.items.add(() -> new BucketItem(still,
				new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(DVLtabItemGroup.tab).rarity(Rarity.COMMON))
						.setRegistryName("endarkend_fluid_bucket"));
	}
}
