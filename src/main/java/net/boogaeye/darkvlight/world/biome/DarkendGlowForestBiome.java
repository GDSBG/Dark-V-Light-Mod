
package net.boogaeye.darkvlight.world.biome;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.CocoaTreeDecorator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.state.BooleanProperty;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.client.audio.BackgroundMusicSelector;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.boogaeye.darkvlight.entity.DarkendTallendEntity;
import net.boogaeye.darkvlight.entity.DarkendSurviverEntity;
import net.boogaeye.darkvlight.entity.DarkendLonerEntity;
import net.boogaeye.darkvlight.block.GlowingFruitBlock;
import net.boogaeye.darkvlight.block.DarkendGrassBlock;
import net.boogaeye.darkvlight.block.DarkendGlowingLeavesBlock;
import net.boogaeye.darkvlight.block.DarkDirtBlock;
import net.boogaeye.darkvlight.block.BurnGazeWoodBlock;
import net.boogaeye.darkvlight.DarkVsLightModElements;

import java.util.Set;
import java.util.Random;
import java.util.List;

import com.google.common.collect.ImmutableList;

@DarkVsLightModElements.ModElement.Tag
public class DarkendGlowForestBiome extends DarkVsLightModElements.ModElement {
	public static Biome biome;
	public DarkendGlowForestBiome(DarkVsLightModElements instance) {
		super(instance, 94);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}
	private static class BiomeRegisterHandler {
		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-6711040).setWaterColor(-103).setWaterFogColor(-6711040)
						.withSkyColor(-6711040).withFoliageColor(-10066432).withGrassColor(-13369600)
						.setAmbientSound(
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dark_vs_light:theswamp")))
						.setMusic(new BackgroundMusicSelector((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("dark_vs_light:disintegrating")), 12000, 24000, true))
						.build();
				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(DarkendGrassBlock.block.getDefaultState(),
								DarkDirtBlock.block.getDefaultState(), DarkDirtBlock.block.getDefaultState())));
				biomeGenerationSettings.withStructure(StructureFeatures.MINESHAFT);
				biomeGenerationSettings.withStructure(StructureFeatures.PILLAGER_OUTPOST);
				biomeGenerationSettings.withStructure(StructureFeatures.VILLAGE_PLAINS);
				biomeGenerationSettings.withStructure(StructureFeatures.SHIPWRECK);
				biomeGenerationSettings.withStructure(StructureFeatures.OCEAN_RUIN_COLD);
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.TREE
						.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BurnGazeWoodBlock.block.getDefaultState()),
								new SimpleBlockStateProvider(DarkendGlowingLeavesBlock.block.getDefaultState()),
								new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
								new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1)))
										.setDecorators(ImmutableList.of(CustomLeaveVineTreeDecorator.instance, CustomTrunkVineTreeDecorator.instance,
												new CustomCocoaTreeDecorator()))
										.setMaxWaterDepth(0).build())
						.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
						.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
				DefaultBiomeFeatures.withLavaAndWaterLakes(biomeGenerationSettings);
				DefaultBiomeFeatures.withOceanCavesAndCanyons(biomeGenerationSettings);
				DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
				DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
				DefaultBiomeFeatures.withFrozenTopLayer(biomeGenerationSettings);
				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(DarkendTallendEntity.entity, 35, 1, 2));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(DarkendLonerEntity.entity, 20, 1, 4));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SLIME, 15, 1, 4));
				mobSpawnInfo.withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityType.SALMON, 2, 1, 5));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(DarkendSurviverEntity.entity, 20, 2, 6));
				biome = new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.NONE).depth(0.5f).scale(0.18f)
						.temperature(0.5f).downfall(0.7f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();
				event.getRegistry().register(biome.setRegistryName("dark_vs_light:darkend_glow_forest"));
			}
		}
	}
	@Override
	public void init(FMLCommonSetupEvent event) {
	}
	private static class CustomLeaveVineTreeDecorator extends LeaveVineTreeDecorator {
		public static final CustomLeaveVineTreeDecorator instance = new CustomLeaveVineTreeDecorator();
		public static com.mojang.serialization.Codec<LeaveVineTreeDecorator> codec;
		public static TreeDecoratorType tdt;
		static {
			codec = com.mojang.serialization.Codec.unit(() -> instance);
			tdt = new TreeDecoratorType(codec);
			tdt.setRegistryName("darkend_glow_forest_lvtd");
			ForgeRegistries.TREE_DECORATOR_TYPES.register(tdt);
		}
		@Override
		protected TreeDecoratorType<?> func_230380_a_() {
			return tdt;
		}

		@Override
		protected void func_227424_a_(IWorldWriter ww, BlockPos bp, BooleanProperty bpr, Set<BlockPos> sbc, MutableBoundingBox mbb) {
			this.func_227423_a_(ww, bp, GlowingFruitBlock.block.getDefaultState(), sbc, mbb);
		}
	}

	private static class CustomTrunkVineTreeDecorator extends TrunkVineTreeDecorator {
		public static final CustomTrunkVineTreeDecorator instance = new CustomTrunkVineTreeDecorator();
		public static com.mojang.serialization.Codec<CustomTrunkVineTreeDecorator> codec;
		public static TreeDecoratorType tdt;
		static {
			codec = com.mojang.serialization.Codec.unit(() -> instance);
			tdt = new TreeDecoratorType(codec);
			tdt.setRegistryName("darkend_glow_forest_tvtd");
			ForgeRegistries.TREE_DECORATOR_TYPES.register(tdt);
		}
		@Override
		protected TreeDecoratorType<?> func_230380_a_() {
			return tdt;
		}

		@Override
		protected void func_227424_a_(IWorldWriter ww, BlockPos bp, BooleanProperty bpr, Set<BlockPos> sbc, MutableBoundingBox mbb) {
			this.func_227423_a_(ww, bp, GlowingFruitBlock.block.getDefaultState(), sbc, mbb);
		}
	}

	private static class CustomCocoaTreeDecorator extends CocoaTreeDecorator {
		public static final CustomCocoaTreeDecorator instance = new CustomCocoaTreeDecorator();
		public static com.mojang.serialization.Codec<CustomCocoaTreeDecorator> codec;
		public static TreeDecoratorType tdt;
		static {
			codec = com.mojang.serialization.Codec.unit(() -> instance);
			tdt = new TreeDecoratorType(codec);
			tdt.setRegistryName("darkend_glow_forest_ctd");
			ForgeRegistries.TREE_DECORATOR_TYPES.register(tdt);
		}
		public CustomCocoaTreeDecorator() {
			super(0.2f);
		}

		@Override
		protected TreeDecoratorType<?> func_230380_a_() {
			return tdt;
		}

		@Override
		public void func_225576_a_(ISeedReader p_225576_1_, Random p_225576_2_, List<BlockPos> p_225576_3_, List<BlockPos> p_225576_4_,
				Set<BlockPos> p_225576_5_, MutableBoundingBox p_225576_6_) {
			if (!(p_225576_2_.nextFloat() >= 0.2F)) {
				int i = p_225576_3_.get(0).getY();
				p_225576_3_.stream().filter((p_236867_1_) -> {
					return p_236867_1_.getY() - i <= 2;
				}).forEach((p_242865_5_) -> {
					for (Direction direction : Direction.Plane.HORIZONTAL) {
						if (p_225576_2_.nextFloat() <= 0.25F) {
							Direction direction1 = direction.getOpposite();
							BlockPos blockpos = p_242865_5_.add(direction1.getXOffset(), 0, direction1.getZOffset());
							if (Feature.isAirAt(p_225576_1_, blockpos)) {
								BlockState blockstate = Blocks.AIR.getDefaultState();
								this.func_227423_a_(p_225576_1_, blockpos, blockstate, p_225576_5_, p_225576_6_);
							}
						}
					}
				});
			}
		}
	}
}
