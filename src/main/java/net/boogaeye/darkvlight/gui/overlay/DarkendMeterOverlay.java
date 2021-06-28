
package net.boogaeye.darkvlight.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.boogaeye.darkvlight.procedures.GlowoverProcedure;
import net.boogaeye.darkvlight.procedures.GlowBg4Procedure;
import net.boogaeye.darkvlight.procedures.GlowBg3Procedure;
import net.boogaeye.darkvlight.procedures.GlowBg2Procedure;
import net.boogaeye.darkvlight.procedures.GlowBg1Procedure;
import net.boogaeye.darkvlight.procedures.Glow9Procedure;
import net.boogaeye.darkvlight.procedures.Glow8Procedure;
import net.boogaeye.darkvlight.procedures.Glow7Procedure;
import net.boogaeye.darkvlight.procedures.Glow6Procedure;
import net.boogaeye.darkvlight.procedures.Glow5Procedure;
import net.boogaeye.darkvlight.procedures.Glow4Procedure;
import net.boogaeye.darkvlight.procedures.Glow3Procedure;
import net.boogaeye.darkvlight.procedures.Glow2Procedure;
import net.boogaeye.darkvlight.procedures.EnlightendMeterDisplayProcedure;
import net.boogaeye.darkvlight.procedures.DarkendMeterDisplayOverlayIngameProcedure;
import net.boogaeye.darkvlight.procedures.DarkOverProcedure;
import net.boogaeye.darkvlight.procedures.DarkBg4Procedure;
import net.boogaeye.darkvlight.procedures.DarkBg3Procedure;
import net.boogaeye.darkvlight.procedures.DarkBg2Procedure;
import net.boogaeye.darkvlight.procedures.DarkBg1Procedure;
import net.boogaeye.darkvlight.procedures.Dark9Procedure;
import net.boogaeye.darkvlight.procedures.Dark8Procedure;
import net.boogaeye.darkvlight.procedures.Dark7Procedure;
import net.boogaeye.darkvlight.procedures.Dark6Procedure;
import net.boogaeye.darkvlight.procedures.Dark5Procedure;
import net.boogaeye.darkvlight.procedures.Dark4Procedure;
import net.boogaeye.darkvlight.procedures.Dark3Procedure;
import net.boogaeye.darkvlight.procedures.Dark2Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

import com.google.common.collect.ImmutableMap;

@Mod.EventBusSubscriber
public class DarkendMeterOverlay {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();
			if (true) {
				if (DarkendMeterDisplayOverlayIngameProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/darkingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -207, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				if (EnlightendMeterDisplayProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/glowingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -207, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				if (Dark2Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/darkingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -198, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				if (Glow2Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/glowingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -198, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				if (Dark3Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/darkingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -189, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				if (Glow3Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/glowingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -189, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				if (Dark4Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/darkingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -180, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				if (Glow4Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/glowingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -180, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				if (Dark5Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/darkingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -171, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				if (Glow5Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/glowingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -171, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				if (Dark6Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/darkingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -162, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				if (Glow6Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/glowingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -162, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				if (Dark7Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/darkingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -153, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				if (Glow7Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/glowingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -153, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				if (Dark8Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/darkingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -144, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				if (Glow8Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/glowingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -144, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				if (Dark9Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/darkingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -135, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				if (Glow9Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/glowingberry.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -135, posY + 104, 0, 0, 8, 8, 8, 8);
				}
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/glowbg.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -135, posY + 95, 0, 0, 8, 8, 8, 8);
				if (GlowBg1Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/glowbg.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -144, posY + 95, 0, 0, 8, 8, 8, 8);
				}
				if (GlowBg2Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/glowbg.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -153, posY + 95, 0, 0, 8, 8, 8, 8);
				}
				if (GlowBg3Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/glowbg.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -162, posY + 95, 0, 0, 8, 8, 8, 8);
				}
				if (GlowBg4Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/glowbg.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -171, posY + 95, 0, 0, 8, 8, 8, 8);
				}
				if (GlowoverProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/glowplus.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -144, posY + 77, 0, 0, 16, 16, 16, 16);
				}
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/darkingberrybg.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -207, posY + 95, 0, 0, 8, 8, 8, 8);
				if (DarkBg1Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/darkingberrybg.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -198, posY + 95, 0, 0, 8, 8, 8, 8);
				}
				if (DarkBg2Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/darkingberrybg.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -189, posY + 95, 0, 0, 8, 8, 8, 8);
				}
				if (DarkBg3Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/darkingberrybg.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -180, posY + 95, 0, 0, 8, 8, 8, 8);
				}
				if (DarkBg4Procedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/darkingberrybg.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -171, posY + 95, 0, 0, 8, 8, 8, 8);
				}
				if (DarkOverProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("dark_vs_light:textures/darkextra.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -207, posY + 77, 0, 0, 16, 16, 16, 16);
				}
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
