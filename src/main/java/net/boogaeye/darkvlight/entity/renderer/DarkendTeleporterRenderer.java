package net.boogaeye.darkvlight.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.boogaeye.darkvlight.entity.DarkendTeleporterEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class DarkendTeleporterRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(DarkendTeleporterEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelDarkendFloater(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("dark_vs_light:textures/darkendfloaterblack.png");
					}
				};
			});
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn
					.getBuffer(RenderType.getEyes(new ResourceLocation("dark_vs_light:textures/darkendfloaterglowblack.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelDarkendFloater extends EntityModel<Entity> {
		private final ModelRenderer Head;
		private final ModelRenderer leg;
		private final ModelRenderer leg2;
		private final ModelRenderer leg3;
		private final ModelRenderer leg4;
		private final ModelRenderer leg5;
		private final ModelRenderer leg6;
		private final ModelRenderer leg7;
		private final ModelRenderer leg8;
		public ModelDarkendFloater() {
			textureWidth = 128;
			textureHeight = 128;
			Head = new ModelRenderer(this);
			Head.setRotationPoint(-7.0F, 17.0F, 0.0F);
			setRotationAngle(Head, 0.0F, -1.5708F, 0.0F);
			Head.setTextureOffset(0, 0).addBox(-7.0F, -13.0F, -14.0F, 14.0F, 9.0F, 14.0F, 0.0F, false);
			Head.setTextureOffset(35, 35).addBox(-8.0F, -13.0F, -15.0F, 1.0F, 13.0F, 16.0F, 0.0F, false);
			Head.setTextureOffset(0, 24).addBox(7.0F, -13.0F, -15.0F, 1.0F, 13.0F, 16.0F, 0.0F, false);
			Head.setTextureOffset(0, 54).addBox(-7.0F, -13.0F, -15.0F, 14.0F, 13.0F, 1.0F, 0.0F, false);
			Head.setTextureOffset(19, 24).addBox(-7.0F, -13.0F, 0.0F, 14.0F, 13.0F, 1.0F, 0.0F, false);
			leg = new ModelRenderer(this);
			leg.setRotationPoint(0.0F, 24.0F, 0.0F);
			leg.setTextureOffset(53, 0).addBox(-7.0F, -11.0F, 6.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(13.0F, 24.0F, 0.0F);
			leg2.setTextureOffset(48, 0).addBox(-7.0F, -11.0F, 6.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);
			leg3 = new ModelRenderer(this);
			leg3.setRotationPoint(13.0F, 24.0F, -13.0F);
			leg3.setTextureOffset(43, 0).addBox(-7.0F, -11.0F, 6.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);
			leg4 = new ModelRenderer(this);
			leg4.setRotationPoint(0.0F, 24.0F, -13.0F);
			leg4.setTextureOffset(10, 24).addBox(-7.0F, -11.0F, 6.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);
			leg5 = new ModelRenderer(this);
			leg5.setRotationPoint(0.0F, 24.0F, -7.0F);
			leg5.setTextureOffset(5, 24).addBox(-7.0F, -11.0F, 6.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);
			leg6 = new ModelRenderer(this);
			leg6.setRotationPoint(13.0F, 24.0F, -7.0F);
			leg6.setTextureOffset(0, 24).addBox(-7.0F, -11.0F, 6.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);
			leg7 = new ModelRenderer(this);
			leg7.setRotationPoint(7.0F, 24.0F, -13.0F);
			leg7.setTextureOffset(5, 0).addBox(-7.0F, -11.0F, 6.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);
			leg8 = new ModelRenderer(this);
			leg8.setRotationPoint(7.0F, 24.0F, 0.0F);
			leg8.setTextureOffset(0, 0).addBox(-7.0F, -11.0F, 6.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			leg.render(matrixStack, buffer, packedLight, packedOverlay);
			leg2.render(matrixStack, buffer, packedLight, packedOverlay);
			leg3.render(matrixStack, buffer, packedLight, packedOverlay);
			leg4.render(matrixStack, buffer, packedLight, packedOverlay);
			leg5.render(matrixStack, buffer, packedLight, packedOverlay);
			leg6.render(matrixStack, buffer, packedLight, packedOverlay);
			leg7.render(matrixStack, buffer, packedLight, packedOverlay);
			leg8.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
