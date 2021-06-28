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

import net.boogaeye.darkvlight.entity.DarkendWolfEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class DarkendWolfRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(DarkendWolfEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modeldarkendwolf(), 1f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("dark_vs_light:textures/darkendwolf.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("dark_vs_light:textures/darkendwolfglow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modeldarkendwolf extends EntityModel<Entity> {
		private final ModelRenderer Head;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer CompleteBody;
		private final ModelRenderer Body;
		private final ModelRenderer Body2;
		private final ModelRenderer floatingbone;
		private final ModelRenderer cube_r6;
		private final ModelRenderer LLeg1;
		private final ModelRenderer LLeg1_2;
		private final ModelRenderer LLeg2;
		private final ModelRenderer LLeg2_2;
		private final ModelRenderer RLeg2;
		private final ModelRenderer RLeg2_2;
		private final ModelRenderer RLeg1;
		private final ModelRenderer RLeg1_2;
		public Modeldarkendwolf() {
			textureWidth = 128;
			textureHeight = 128;
			Head = new ModelRenderer(this);
			Head.setRotationPoint(-0.0738F, 2.5238F, -10.7857F);
			Head.setTextureOffset(0, 34).addBox(-1.9262F, -2.5238F, -8.2143F, 4.0F, 7.0F, 8.0F, 0.0F, false);
			Head.setTextureOffset(36, 0).addBox(2.0738F, 0.4762F, -8.2143F, 2.0F, 4.0F, 8.0F, 0.0F, false);
			Head.setTextureOffset(25, 36).addBox(-3.9262F, 0.4762F, -8.2143F, 2.0F, 4.0F, 8.0F, 0.0F, false);
			Head.setTextureOffset(0, 17).addBox(2.0738F, -2.5238F, -6.2143F, 1.0F, 3.0F, 6.0F, 0.0F, false);
			Head.setTextureOffset(0, 0).addBox(-2.9262F, -2.5238F, -6.2143F, 1.0F, 3.0F, 6.0F, 0.0F, false);
			Head.setTextureOffset(56, 56).addBox(-2.9262F, -2.5238F, -9.2143F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			Head.setTextureOffset(31, 56).addBox(2.0738F, -2.5238F, -9.2143F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			Head.setTextureOffset(27, 25).addBox(-0.9262F, -1.5238F, -9.2143F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			Head.setTextureOffset(27, 19).addBox(0.0738F, -1.5238F, -9.2143F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			Head.setTextureOffset(18, 12).addBox(-1.9262F, -2.5238F, -9.2143F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			Head.setTextureOffset(0, 10).addBox(-1.9262F, 0.4762F, -10.2143F, 4.0F, 2.0F, 2.0F, 0.0F, false);
			Head.setTextureOffset(15, 72).addBox(-1.9262F, 2.4762F, -9.2143F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Head.setTextureOffset(10, 72).addBox(1.0738F, 2.4762F, -9.2143F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Head.setTextureOffset(25, 72).addBox(-0.9262F, 0.4762F, -14.2143F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Head.setTextureOffset(20, 72).addBox(0.0738F, 0.4762F, -14.2143F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Head.setTextureOffset(36, 25).addBox(-1.9262F, 1.4762F, -14.2143F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(6.0738F, 5.9762F, -14.2143F);
			Head.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.4363F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(36, 19).addBox(-8.0F, -1.0F, 2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(5.6738F, -1.5238F, -8.2143F);
			Head.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, 0.7854F);
			cube_r2.setTextureOffset(27, 0).addBox(-3.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(-1.0762F, -5.0238F, -8.2143F);
			Head.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, 0.0F, -0.6109F);
			cube_r3.setTextureOffset(27, 6).addBox(-3.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(5.0738F, 0.4762F, -8.2143F);
			Head.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.0F, 0.7854F);
			cube_r4.setTextureOffset(0, 34).addBox(-4.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0738F, -3.5238F, -8.2143F);
			Head.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.0F, -0.6109F);
			cube_r5.setTextureOffset(26, 36).addBox(-4.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			CompleteBody = new ModelRenderer(this);
			CompleteBody.setRotationPoint(4.0F, 20.0F, 2.0F);
			CompleteBody.setTextureOffset(38, 38).addBox(-5.0F, -20.0F, -13.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
			CompleteBody.setTextureOffset(22, 56).addBox(-7.0F, -19.0F, -13.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			CompleteBody.setTextureOffset(0, 56).addBox(-2.0F, -19.0F, -13.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			CompleteBody.setTextureOffset(9, 56).addBox(-7.0F, -17.0F, -13.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			CompleteBody.setTextureOffset(55, 47).addBox(-2.0F, -17.0F, -13.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			CompleteBody.setTextureOffset(6, 56).addBox(-8.0F, -17.0F, -10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			CompleteBody.setTextureOffset(0, 38).addBox(-1.0F, -17.0F, -10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			CompleteBody.setTextureOffset(41, 49).addBox(-8.0F, -19.0F, -10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			CompleteBody.setTextureOffset(45, 31).addBox(-1.0F, -19.0F, -10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			CompleteBody.setTextureOffset(18, 50).addBox(-9.0F, -17.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			CompleteBody.setTextureOffset(36, 5).addBox(0.0F, -17.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 4.0F, -5.0F);
			CompleteBody.addChild(Body);
			Body.setTextureOffset(18, 19).addBox(-5.0F, -24.0F, -4.0F, 1.0F, 1.0F, 15.0F, 0.0F, false);
			Body.setTextureOffset(18, 2).addBox(-4.0F, -24.0F, -4.0F, 1.0F, 1.0F, 15.0F, 0.0F, false);
			Body.setTextureOffset(57, 61).addBox(-8.0F, -24.0F, 10.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(36, 61).addBox(-8.0F, -24.0F, 7.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(27, 61).addBox(-8.0F, -24.0F, 4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(18, 61).addBox(-8.0F, -24.0F, 1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(9, 61).addBox(-8.0F, -24.0F, -2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(0, 61).addBox(-8.0F, -24.0F, -4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(60, 40).addBox(-3.0F, -24.0F, -4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(60, 31).addBox(-3.0F, -24.0F, -2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(60, 25).addBox(-3.0F, -24.0F, 1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(48, 60).addBox(-3.0F, -24.0F, 4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(58, 28).addBox(-3.0F, -24.0F, 7.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(58, 22).addBox(-3.0F, -24.0F, 10.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(5, 72).addBox(-9.0F, -23.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(71, 52).addBox(-9.0F, -23.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(71, 17).addBox(-9.0F, -23.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(64, 71).addBox(-9.0F, -23.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(45, 71).addBox(-9.0F, -23.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(70, 49).addBox(-9.0F, -23.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(70, 14).addBox(0.0F, -23.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(69, 64).addBox(0.0F, -23.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(69, 46).addBox(0.0F, -23.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(69, 31).addBox(0.0F, -23.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(69, 11).addBox(0.0F, -23.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(60, 69).addBox(0.0F, -23.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(0, 72).addBox(-10.0F, -22.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(71, 41).addBox(-10.0F, -22.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(69, 71).addBox(-10.0F, -22.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(50, 71).addBox(-10.0F, -22.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(70, 59).addBox(-10.0F, -22.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(70, 34).addBox(-10.0F, -22.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(70, 3).addBox(1.0F, -22.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(40, 70).addBox(1.0F, -22.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(69, 56).addBox(1.0F, -22.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(69, 38).addBox(1.0F, -22.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(69, 25).addBox(1.0F, -22.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(69, 8).addBox(1.0F, -22.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(65, 48).addBox(-11.0F, -21.0F, 10.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(65, 34).addBox(-11.0F, -21.0F, 7.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(65, 14).addBox(-11.0F, -21.0F, 4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(64, 9).addBox(-11.0F, -21.0F, 1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(64, 64).addBox(-11.0F, -21.0F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(59, 64).addBox(-11.0F, -21.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(54, 64).addBox(2.0F, -21.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(35, 64).addBox(2.0F, -21.0F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(30, 64).addBox(2.0F, -21.0F, 1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(25, 64).addBox(2.0F, -21.0F, 4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(20, 64).addBox(2.0F, -21.0F, 7.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(15, 64).addBox(2.0F, -21.0F, 10.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body2 = new ModelRenderer(this);
			Body2.setRotationPoint(0.0F, 0.0F, 0.0F);
			CompleteBody.addChild(Body2);
			setRotationAngle(Body2, 3.1416F, 0.0F, 0.0F);
			Body2.setTextureOffset(0, 17).addBox(-5.0F, 8.0F, -6.0F, 1.0F, 1.0F, 15.0F, 0.0F, false);
			Body2.setTextureOffset(0, 0).addBox(-4.0F, 8.0F, -6.0F, 1.0F, 1.0F, 15.0F, 0.0F, false);
			Body2.setTextureOffset(58, 19).addBox(-8.0F, 8.0F, 8.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(58, 3).addBox(-8.0F, 8.0F, 5.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(58, 0).addBox(-8.0F, 8.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(40, 58).addBox(-8.0F, 8.0F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(57, 52).addBox(-8.0F, 8.0F, -4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(57, 6).addBox(-8.0F, 8.0F, -6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(56, 37).addBox(-3.0F, 8.0F, -6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(56, 16).addBox(-3.0F, 8.0F, -4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(54, 34).addBox(-3.0F, 8.0F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(45, 13).addBox(-3.0F, 8.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(36, 31).addBox(-3.0F, 8.0F, 5.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(36, 13).addBox(-3.0F, 8.0F, 8.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(55, 69).addBox(-9.0F, 9.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(35, 69).addBox(-9.0F, 9.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(30, 69).addBox(-9.0F, 9.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(25, 69).addBox(-9.0F, 9.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(20, 69).addBox(-9.0F, 9.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(15, 69).addBox(-9.0F, 9.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(10, 69).addBox(0.0F, 9.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(5, 69).addBox(0.0F, 9.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(0, 69).addBox(0.0F, 9.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(68, 68).addBox(0.0F, 9.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(50, 68).addBox(0.0F, 9.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(45, 68).addBox(0.0F, 9.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(67, 43).addBox(-10.0F, 10.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(67, 28).addBox(-10.0F, 10.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(67, 22).addBox(-10.0F, 10.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(67, 19).addBox(-10.0F, 10.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(67, 0).addBox(-10.0F, 10.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(40, 67).addBox(-10.0F, 10.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(66, 61).addBox(1.0F, 10.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(66, 53).addBox(1.0F, 10.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(66, 5).addBox(1.0F, 10.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(65, 58).addBox(1.0F, 10.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(62, 55).addBox(1.0F, 10.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(28, 56).addBox(1.0F, 10.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(10, 64).addBox(-11.0F, 11.0F, 8.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(5, 64).addBox(-11.0F, 11.0F, 5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(0, 64).addBox(-11.0F, 11.0F, 2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(49, 63).addBox(-11.0F, 11.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(44, 63).addBox(-11.0F, 11.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(62, 43).addBox(-11.0F, 11.0F, -6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(36, 0).addBox(2.0F, 11.0F, -6.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(9, 27).addBox(2.0F, 11.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(9, 17).addBox(2.0F, 11.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(0, 17).addBox(2.0F, 11.0F, 2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(9, 0).addBox(2.0F, 11.0F, 5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body2.setTextureOffset(0, 0).addBox(2.0F, 11.0F, 8.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			floatingbone = new ModelRenderer(this);
			floatingbone.setRotationPoint(-3.0F, -10.0F, -14.0F);
			CompleteBody.addChild(floatingbone);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
			floatingbone.addChild(cube_r6);
			setRotationAngle(cube_r6, -1.5708F, 0.0F, 0.0F);
			cube_r6.setTextureOffset(17, 36).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
			LLeg1 = new ModelRenderer(this);
			LLeg1.setRotationPoint(3.0F, 11.6667F, -6.0F);
			LLeg1.setTextureOffset(55, 11).addBox(-1.0F, 0.3333F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			LLeg1.setTextureOffset(49, 0).addBox(-1.0F, 2.3333F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			LLeg1_2 = new ModelRenderer(this);
			LLeg1_2.setRotationPoint(1.0F, 6.6667F, -1.3333F);
			LLeg1.addChild(LLeg1_2);
			LLeg1_2.setTextureOffset(16, 54).addBox(-2.0F, -0.3333F, 0.3333F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			LLeg1_2.setTextureOffset(9, 50).addBox(-2.0F, 1.6667F, 0.3333F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			LLeg1_2.setTextureOffset(18, 25).addBox(-2.0F, 4.6667F, -1.6667F, 2.0F, 1.0F, 4.0F, 0.0F, false);
			LLeg2 = new ModelRenderer(this);
			LLeg2.setRotationPoint(3.0F, 11.6667F, 8.3333F);
			LLeg2.setTextureOffset(53, 42).addBox(-1.0F, 0.3333F, -1.3333F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			LLeg2.setTextureOffset(32, 49).addBox(-1.0F, 2.3333F, -1.3333F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			LLeg2_2 = new ModelRenderer(this);
			LLeg2_2.setRotationPoint(1.0F, 6.6667F, -1.6667F);
			LLeg2.addChild(LLeg2_2);
			LLeg2_2.setTextureOffset(50, 53).addBox(-2.0F, -0.3333F, 0.3333F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			LLeg2_2.setTextureOffset(0, 50).addBox(-2.0F, 1.6667F, 0.3333F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			LLeg2_2.setTextureOffset(18, 19).addBox(-2.0F, 4.6667F, -1.6667F, 2.0F, 1.0F, 4.0F, 0.0F, false);
			RLeg2 = new ModelRenderer(this);
			RLeg2.setRotationPoint(-3.0F, 12.6667F, 7.3333F);
			RLeg2.setTextureOffset(41, 53).addBox(-1.0F, -0.6667F, -0.3333F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			RLeg2.setTextureOffset(23, 49).addBox(-1.0F, 1.3333F, -0.3333F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			RLeg2_2 = new ModelRenderer(this);
			RLeg2_2.setRotationPoint(1.0F, 5.6667F, -0.6667F);
			RLeg2.addChild(RLeg2_2);
			RLeg2_2.setTextureOffset(51, 29).addBox(-2.0F, -0.3333F, 0.3333F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			RLeg2_2.setTextureOffset(49, 17).addBox(-2.0F, 1.6667F, 0.3333F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			RLeg2_2.setTextureOffset(18, 6).addBox(-2.0F, 4.6667F, -1.6667F, 2.0F, 1.0F, 4.0F, 0.0F, false);
			RLeg1 = new ModelRenderer(this);
			RLeg1.setRotationPoint(-3.0F, 11.6667F, -6.0F);
			RLeg1.setTextureOffset(51, 23).addBox(-1.0F, 0.3333F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			RLeg1.setTextureOffset(46, 46).addBox(-1.0F, 2.3333F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			RLeg1_2 = new ModelRenderer(this);
			RLeg1_2.setRotationPoint(1.0F, 6.6667F, -1.3333F);
			RLeg1.addChild(RLeg1_2);
			RLeg1_2.setTextureOffset(0, 27).addBox(-2.0F, -0.3333F, 0.3333F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			RLeg1_2.setTextureOffset(47, 36).addBox(-2.0F, 1.6667F, 0.3333F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			RLeg1_2.setTextureOffset(18, 0).addBox(-2.0F, 4.6667F, -1.6667F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			CompleteBody.render(matrixStack, buffer, packedLight, packedOverlay);
			LLeg1.render(matrixStack, buffer, packedLight, packedOverlay);
			LLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
			RLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
			RLeg1.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.LLeg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.floatingbone.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.RLeg1_2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.RLeg2_2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LLeg1_2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LLeg2_2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.RLeg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.RLeg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LLeg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
