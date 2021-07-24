
package net.boogaeye.darkvlight.world.biome;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.audio.BackgroundMusicSelector;

import net.boogaeye.darkvlight.block.DarkStoneBrickBlock;
import net.boogaeye.darkvlight.block.CarbonatedDarkStoneBlock;
import net.boogaeye.darkvlight.DarkVsLightModElements;

@DarkVsLightModElements.ModElement.Tag
public class DeeperDarkBiome extends DarkVsLightModElements.ModElement {
	public static Biome biome;
	public DeeperDarkBiome(DarkVsLightModElements instance) {
		super(instance, 689);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}
	private static class BiomeRegisterHandler {
		@SubscribeEvent
		public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-16777216).setWaterColor(4159204).setWaterFogColor(329011)
						.withSkyColor(-16777216).withFoliageColor(10387789).withGrassColor(9470285)
						.setMusic(new BackgroundMusicSelector(
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dark_vs_light:deepdark")),
								12000, 24000, true))
						.build();
				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(DarkStoneBrickBlock.block.getDefaultState(),
								CarbonatedDarkStoneBlock.block.getDefaultState(), CarbonatedDarkStoneBlock.block.getDefaultState())));
				DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
				DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
				DefaultBiomeFeatures.withFrozenTopLayer(biomeGenerationSettings);
				DefaultBiomeFeatures.withOceanCavesAndCanyons(biomeGenerationSettings);
				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
				biome = new Biome.Builder().precipitation(Biome.RainType.SNOW).category(Biome.Category.NONE).depth(-2f).scale(1f).temperature(0.1f)
						.downfall(1f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build()).build();
				event.getRegistry().register(biome.setRegistryName("dark_vs_light:deeper_dark"));
			}
		}
	}
	@Override
	public void init(FMLCommonSetupEvent event) {
	}
}
