package net.boogaeye.darkvlight.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
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

import net.boogaeye.darkvlight.entity.EnlightendSpiderEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class EnlightendSpiderRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(EnlightendSpiderEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelenlightendspider(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("dark_vs_light:textures/enlightendspider.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("dark_vs_light:textures/enlightendspiderglow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelenlightendspider extends EntityModel<Entity> {
		private final ModelRenderer Leg4;
		private final ModelRenderer cube_r1;
		private final ModelRenderer EndLeg4;
		private final ModelRenderer cube_r2;
		private final ModelRenderer Leg5;
		private final ModelRenderer cube_r3;
		private final ModelRenderer EndLeg5;
		private final ModelRenderer cube_r4;
		private final ModelRenderer Leg6;
		private final ModelRenderer cube_r5;
		private final ModelRenderer EndLeg6;
		private final ModelRenderer cube_r6;
		private final ModelRenderer MainBody;
		private final ModelRenderer FakeHead;
		private final ModelRenderer Head;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer Jaw;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer Leg7;
		private final ModelRenderer cube_r11;
		private final ModelRenderer EndLeg7;
		private final ModelRenderer cube_r12;
		private final ModelRenderer Leg8;
		private final ModelRenderer cube_r13;
		private final ModelRenderer EndLeg8;
		private final ModelRenderer cube_r14;
		private final ModelRenderer Leg9;
		private final ModelRenderer cube_r15;
		private final ModelRenderer EndLeg9;
		private final ModelRenderer cube_r16;
		private final ModelRenderer Leg10;
		private final ModelRenderer cube_r17;
		private final ModelRenderer EndLeg10;
		private final ModelRenderer cube_r18;
		private final ModelRenderer Leg11;
		private final ModelRenderer cube_r19;
		private final ModelRenderer EndLeg11;
		private final ModelRenderer cube_r20;
		public Modelenlightendspider() {
			textureWidth = 128;
			textureHeight = 128;
			Leg4 = new ModelRenderer(this);
			Leg4.setRotationPoint(-7.5F, 23.5F, 7.0F);
			setRotationAngle(Leg4, 0.0F, -1.5708F, 0.0F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, -1.75F, 2.0F);
			Leg4.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.6545F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(46, 65).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
			EndLeg4 = new ModelRenderer(this);
			EndLeg4.setRotationPoint(0.0F, -8.25F, 10.0F);
			Leg4.addChild(EndLeg4);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 2.0F, 2.0F);
			EndLeg4.addChild(cube_r2);
			setRotationAngle(cube_r2, -0.7854F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(50, 50).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
			Leg5 = new ModelRenderer(this);
			Leg5.setRotationPoint(-7.5F, 23.5F, -1.0F);
			setRotationAngle(Leg5, 0.0F, -1.5708F, 0.0F);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, -1.75F, 2.0F);
			Leg5.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.6545F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(64, 29).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
			EndLeg5 = new ModelRenderer(this);
			EndLeg5.setRotationPoint(0.0F, -8.25F, 11.0F);
			Leg5.addChild(EndLeg5);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, 2.0F, 1.0F);
			EndLeg5.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.7854F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(48, 32).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
			Leg6 = new ModelRenderer(this);
			Leg6.setRotationPoint(-7.5F, 23.5F, -7.0F);
			setRotationAngle(Leg6, 0.0F, -1.5708F, 0.0F);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, -1.75F, 2.0F);
			Leg6.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.6545F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(64, 14).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
			EndLeg6 = new ModelRenderer(this);
			EndLeg6.setRotationPoint(-0.5F, -6.5F, 8.0F);
			Leg6.addChild(EndLeg6);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.5F, 0.25F, 4.0F);
			EndLeg6.addChild(cube_r6);
			setRotationAngle(cube_r6, -0.7854F, 0.0F, 0.0F);
			cube_r6.setTextureOffset(30, 56).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
			MainBody = new ModelRenderer(this);
			MainBody.setRotationPoint(0.0F, 24.0F, 0.0F);
			MainBody.setTextureOffset(0, 32).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 4.0F, 16.0F, 0.0F, false);
			FakeHead = new ModelRenderer(this);
			FakeHead.setRotationPoint(0.0F, -12.0F, 0.0F);
			MainBody.addChild(FakeHead);
			FakeHead.setTextureOffset(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(-1.0F, 20.0F, -8.0F);
			Head.setTextureOffset(4, 0).addBox(-3.0F, 0.0F, -11.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			Head.setTextureOffset(0, 0).addBox(4.0F, 0.0F, -11.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			Head.setTextureOffset(0, 3).addBox(-1.0F, 0.0F, -10.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			Head.setTextureOffset(4, 4).addBox(2.0F, 0.0F, -10.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(1.0F, 0.0F, -11.0F);
			Head.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0F, 1.5708F, 0.0F);
			cube_r7.setTextureOffset(32, 71).addBox(-1.0F, -4.0F, -5.0F, 1.0F, 4.0F, 10.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(1.0F, 0.0F, -1.0F);
			Head.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0F, 1.5708F, 0.0F);
			cube_r8.setTextureOffset(0, 52).addBox(-1.0F, -6.0F, -6.0F, 10.0F, 6.0F, 12.0F, 0.0F, false);
			Jaw = new ModelRenderer(this);
			Jaw.setRotationPoint(1.0F, 1.0F, 1.0F);
			Head.addChild(Jaw);
			setRotationAngle(Jaw, 0.0F, 1.5708F, 0.0F);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(1.0F, 2.0F, 0.0F);
			Jaw.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.0F, 0.0F, 0.4363F);
			cube_r9.setTextureOffset(4, 7).addBox(9.0F, -6.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r9.setTextureOffset(0, 6).addBox(9.0F, -6.0F, 5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(0.0F, 4.0F, 0.0F);
			Jaw.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.0F, 0.0F, 0.4363F);
			cube_r10.setTextureOffset(48, 0).addBox(-1.0F, -6.0F, -6.0F, 11.0F, 2.0F, 12.0F, 0.0F, false);
			Leg7 = new ModelRenderer(this);
			Leg7.setRotationPoint(7.5F, 23.5F, -7.0F);
			setRotationAngle(Leg7, 0.0F, 1.5708F, 0.0F);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(0.0F, -1.75F, 2.0F);
			Leg7.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.6545F, 0.0F, 0.0F);
			cube_r11.setTextureOffset(64, 14).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 14.0F, 0.0F, true);
			EndLeg7 = new ModelRenderer(this);
			EndLeg7.setRotationPoint(0.5F, -6.5F, 8.0F);
			Leg7.addChild(EndLeg7);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(-0.5F, 0.25F, 4.0F);
			EndLeg7.addChild(cube_r12);
			setRotationAngle(cube_r12, -0.7854F, 0.0F, 0.0F);
			cube_r12.setTextureOffset(30, 56).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 14.0F, 0.0F, true);
			Leg8 = new ModelRenderer(this);
			Leg8.setRotationPoint(7.5F, 23.5F, -1.0F);
			setRotationAngle(Leg8, 0.0F, 1.5708F, 0.0F);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(0.0F, -1.75F, 2.0F);
			Leg8.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.6545F, 0.0F, 0.0F);
			cube_r13.setTextureOffset(64, 29).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 14.0F, 0.0F, true);
			EndLeg8 = new ModelRenderer(this);
			EndLeg8.setRotationPoint(0.0F, -8.25F, 11.0F);
			Leg8.addChild(EndLeg8);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(0.0F, 2.0F, 1.0F);
			EndLeg8.addChild(cube_r14);
			setRotationAngle(cube_r14, -0.7854F, 0.0F, 0.0F);
			cube_r14.setTextureOffset(48, 32).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 14.0F, 0.0F, true);
			Leg9 = new ModelRenderer(this);
			Leg9.setRotationPoint(7.5F, 23.5F, 7.0F);
			setRotationAngle(Leg9, 0.0F, 1.5708F, 0.0F);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(0.0F, -1.75F, 2.0F);
			Leg9.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.6545F, 0.0F, 0.0F);
			cube_r15.setTextureOffset(46, 65).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 14.0F, 0.0F, true);
			EndLeg9 = new ModelRenderer(this);
			EndLeg9.setRotationPoint(0.0F, -8.25F, 10.0F);
			Leg9.addChild(EndLeg9);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(0.0F, 2.0F, 2.0F);
			EndLeg9.addChild(cube_r16);
			setRotationAngle(cube_r16, -0.7854F, 0.0F, 0.0F);
			cube_r16.setTextureOffset(50, 50).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 14.0F, 0.0F, true);
			Leg10 = new ModelRenderer(this);
			Leg10.setRotationPoint(7.5F, 23.5F, 3.0F);
			setRotationAngle(Leg10, 0.0F, 1.5708F, 0.0F);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(0.0F, -1.75F, 2.0F);
			Leg10.addChild(cube_r17);
			setRotationAngle(cube_r17, 0.6545F, 0.0F, 0.0F);
			cube_r17.setTextureOffset(46, 65).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 14.0F, 0.0F, true);
			EndLeg10 = new ModelRenderer(this);
			EndLeg10.setRotationPoint(0.0F, -8.25F, 10.0F);
			Leg10.addChild(EndLeg10);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(0.0F, 2.0F, 2.0F);
			EndLeg10.addChild(cube_r18);
			setRotationAngle(cube_r18, -0.7854F, 0.0F, 0.0F);
			cube_r18.setTextureOffset(50, 50).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 14.0F, 0.0F, true);
			Leg11 = new ModelRenderer(this);
			Leg11.setRotationPoint(-7.5F, 23.5F, 3.0F);
			setRotationAngle(Leg11, 0.0F, -1.5708F, 0.0F);
			cube_r19 = new ModelRenderer(this);
			cube_r19.setRotationPoint(0.0F, -1.75F, 2.0F);
			Leg11.addChild(cube_r19);
			setRotationAngle(cube_r19, 0.6545F, 0.0F, 0.0F);
			cube_r19.setTextureOffset(46, 65).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
			EndLeg11 = new ModelRenderer(this);
			EndLeg11.setRotationPoint(0.0F, -8.25F, 10.0F);
			Leg11.addChild(EndLeg11);
			cube_r20 = new ModelRenderer(this);
			cube_r20.setRotationPoint(0.0F, 2.0F, 2.0F);
			EndLeg11.addChild(cube_r20);
			setRotationAngle(cube_r20, -0.7854F, 0.0F, 0.0F);
			cube_r20.setTextureOffset(50, 50).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Leg4.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg5.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg6.render(matrixStack, buffer, packedLight, packedOverlay);
			MainBody.render(matrixStack, buffer, packedLight, packedOverlay);
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg7.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg8.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg9.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg10.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg11.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Jaw.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Leg11.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.EndLeg11.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.Leg10.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.EndLeg10.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.Leg4.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Leg5.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.FakeHead.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.FakeHead.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.EndLeg4.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.EndLeg5.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.EndLeg6.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.Leg6.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.EndLeg7.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.Leg7.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.EndLeg8.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
			this.Leg8.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.EndLeg9.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.Leg9.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
