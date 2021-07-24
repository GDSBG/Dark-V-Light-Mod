
package net.boogaeye.darkvlight.world.biome;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.gen.trunkplacer.GiantTrunkPlacer;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.CocoaTreeDecorator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.foliageplacer.MegaPineFoliagePlacer;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockplacer.ColumnBlockPlacer;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.SoundAdditionsAmbience;
import net.minecraft.world.biome.ParticleEffectAmbience;
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
import net.minecraft.entity.EntityClassification;
import net.minecraft.client.audio.BackgroundMusicSelector;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.boogaeye.darkvlight.particle.DarkendDessertParticleParticle;
import net.boogaeye.darkvlight.entity.DarkendWolfEntity;
import net.boogaeye.darkvlight.entity.DarkendTeleporterEntity;
import net.boogaeye.darkvlight.entity.DarkendSurviverEntity;
import net.boogaeye.darkvlight.block.DarkendLavaLeavesBlock;
import net.boogaeye.darkvlight.block.DarkStoneBrickBlock;
import net.boogaeye.darkvlight.block.ClarniteBlock;
import net.boogaeye.darkvlight.block.BlindStoneBlock;
import net.boogaeye.darkvlight.block.BlindLogBlock;
import net.boogaeye.darkvlight.block.BasaltDarkStoneBrickBlock;
import net.boogaeye.darkvlight.DarkVsLightModElements;

import java.util.Set;
import java.util.Random;
import java.util.List;

import com.google.common.collect.ImmutableList;

@DarkVsLightModElements.ModElement.Tag
public class DeepDarkBiome extends DarkVsLightModElements.ModElement {
	public static Biome biome;
	public DeepDarkBiome(DarkVsLightModElements instance) {
		super(instance, 673);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}
	private static class BiomeRegisterHandler {
		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-16777216).setWaterColor(4159204).setWaterFogColor(329011)
						.withSkyColor(-16777216).withFoliageColor(10387789).withGrassColor(-16777216)
						.setAmbientSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("dark_vs_light:enchantedloop")))
						.setAdditionsSound(new SoundAdditionsAmbience((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("dark_vs_light:shadowarmor")), 0.0111D))
						.setMusic(new BackgroundMusicSelector((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("dark_vs_light:darkforest")), 12000, 24000, true))
						.setParticle(new ParticleEffectAmbience(DarkendDessertParticleParticle.particle, 0.0075f)).build();
				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder().withSurfaceBuilder(
						SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(BasaltDarkStoneBrickBlock.block.getDefaultState(),
								DarkStoneBrickBlock.block.getDefaultState(), DarkStoneBrickBlock.block.getDefaultState())));
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.TREE
						.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlindLogBlock.block.getDefaultState()),
								new SimpleBlockStateProvider(DarkendLavaLeavesBlock.block.getDefaultState()),
								new MegaPineFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0),
										FeatureSpread.func_242253_a(13, 4)),
								new GiantTrunkPlacer(15, 2, 14), new TwoLayerFeature(1, 1, 2)))
										.setDecorators(ImmutableList.of(CustomLeaveVineTreeDecorator.instance, CustomTrunkVineTreeDecorator.instance,
												new CustomCocoaTreeDecorator()))
										.setMaxWaterDepth(4).build())
						.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
						.withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(
								(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.BROWN_MUSHROOM.getDefaultState()),
										SimpleBlockPlacer.PLACER)).tries(4).func_227317_b_().build()));
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(
								(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.RED_MUSHROOM.getDefaultState()),
										SimpleBlockPlacer.PLACER)).tries(4).func_227317_b_().build()));
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.HUGE_BROWN_MUSHROOM.withConfiguration(new BigMushroomFeatureConfig(
								new SimpleBlockStateProvider(Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState().with(HugeMushroomBlock.UP, Boolean.TRUE)
										.with(HugeMushroomBlock.DOWN, Boolean.FALSE)),
								new SimpleBlockStateProvider(Blocks.MUSHROOM_STEM.getDefaultState().with(HugeMushroomBlock.UP, Boolean.FALSE)
										.with(HugeMushroomBlock.DOWN, Boolean.FALSE)),
								4)));
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.HUGE_RED_MUSHROOM.withConfiguration(new BigMushroomFeatureConfig(
								new SimpleBlockStateProvider(Blocks.RED_MUSHROOM_BLOCK.getDefaultState().with(HugeMushroomBlock.DOWN, Boolean.FALSE)),
								new SimpleBlockStateProvider(Blocks.MUSHROOM_STEM.getDefaultState().with(HugeMushroomBlock.UP, Boolean.FALSE)
										.with(HugeMushroomBlock.DOWN, Boolean.FALSE)),
								4)));
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.DISK
								.withConfiguration(new SphereReplaceConfig(Blocks.SAND.getDefaultState(), FeatureSpread.func_242253_a(2, 4), 2,
										ImmutableList.of(BasaltDarkStoneBrickBlock.block.getDefaultState(),
												DarkStoneBrickBlock.block.getDefaultState())))
								.withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT).func_242731_b(6));
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.DISK
								.withConfiguration(new SphereReplaceConfig(Blocks.GRAVEL.getDefaultState(), FeatureSpread.func_242253_a(2, 3), 2,
										ImmutableList.of(BasaltDarkStoneBrickBlock.block.getDefaultState(),
												DarkStoneBrickBlock.block.getDefaultState())))
								.withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT).func_242731_b(8));
				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(
								(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.CACTUS.getDefaultState()),
										new ColumnBlockPlacer(1, 2))).tries(6).func_227317_b_().build()));
				DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
				DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
				DefaultBiomeFeatures.withDesertWells(biomeGenerationSettings);
				DefaultBiomeFeatures.withFossils(biomeGenerationSettings);
				DefaultBiomeFeatures.withInfestedStone(biomeGenerationSettings);
				DefaultBiomeFeatures.withOceanCavesAndCanyons(biomeGenerationSettings);
				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(DarkendSurviverEntity.entity, 20, 2, 6));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(DarkendTeleporterEntity.entity, 5, 1, 3));
				mobSpawnInfo.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(DarkendWolfEntity.entity, 7, 3, 8));
				biome = new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.NONE).depth(-1f).scale(0.15f).temperature(0.2f)
						.downfall(1f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();
				event.getRegistry().register(biome.setRegistryName("dark_vs_light:deep_dark"));
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
			tdt.setRegistryName("deep_dark_lvtd");
			ForgeRegistries.TREE_DECORATOR_TYPES.register(tdt);
		}
		@Override
		protected TreeDecoratorType<?> func_230380_a_() {
			return tdt;
		}

		@Override
		protected void func_227424_a_(IWorldWriter ww, BlockPos bp, BooleanProperty bpr, Set<BlockPos> sbc, MutableBoundingBox mbb) {
			this.func_227423_a_(ww, bp, BlindStoneBlock.block.getDefaultState(), sbc, mbb);
		}
	}

	private static class CustomTrunkVineTreeDecorator extends TrunkVineTreeDecorator {
		public static final CustomTrunkVineTreeDecorator instance = new CustomTrunkVineTreeDecorator();
		public static com.mojang.serialization.Codec<CustomTrunkVineTreeDecorator> codec;
		public static TreeDecoratorType tdt;
		static {
			codec = com.mojang.serialization.Codec.unit(() -> instance);
			tdt = new TreeDecoratorType(codec);
			tdt.setRegistryName("deep_dark_tvtd");
			ForgeRegistries.TREE_DECORATOR_TYPES.register(tdt);
		}
		@Override
		protected TreeDecoratorType<?> func_230380_a_() {
			return tdt;
		}

		@Override
		protected void func_227424_a_(IWorldWriter ww, BlockPos bp, BooleanProperty bpr, Set<BlockPos> sbc, MutableBoundingBox mbb) {
			this.func_227423_a_(ww, bp, BlindStoneBlock.block.getDefaultState(), sbc, mbb);
		}
	}

	private static class CustomCocoaTreeDecorator extends CocoaTreeDecorator {
		public static final CustomCocoaTreeDecorator instance = new CustomCocoaTreeDecorator();
		public static com.mojang.serialization.Codec<CustomCocoaTreeDecorator> codec;
		public static TreeDecoratorType tdt;
		static {
			codec = com.mojang.serialization.Codec.unit(() -> instance);
			tdt = new TreeDecoratorType(codec);
			tdt.setRegistryName("deep_dark_ctd");
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
								BlockState blockstate = ClarniteBlock.block.getDefaultState();
								this.func_227423_a_(p_225576_1_, blockpos, blockstate, p_225576_5_, p_225576_6_);
							}
						}
					}
				});
			}
		}
	}
}
