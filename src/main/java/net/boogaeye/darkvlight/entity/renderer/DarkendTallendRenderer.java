package net.boogaeye.darkvlight.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.boogaeye.darkvlight.entity.DarkendTallendEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class DarkendTallendRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(DarkendTallendEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelDarkendTallend(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("dark_vs_light:textures/texture.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelDarkendTallend extends EntityModel<Entity> {
		private final ModelRenderer RightLeg3;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer RightLeg2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer Head;
		private final ModelRenderer Jaw;
		private final ModelRenderer Teath;
		private final ModelRenderer TopHead;
		private final ModelRenderer Teeth;
		public ModelDarkendTallend() {
			textureWidth = 64;
			textureHeight = 64;
			RightLeg3 = new ModelRenderer(this);
			RightLeg3.setRotationPoint(-5.0F, 4.0F, 7.0F);
			RightLeg3.setTextureOffset(10, 31).addBox(-3.0F, 15.6F, -12.4F, 5.0F, 1.0F, 2.0F, 0.0F, false);
			RightLeg3.setTextureOffset(32, 32).addBox(-2.0F, 15.6F, -10.4F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			RightLeg3.setTextureOffset(39, 28).addBox(-3.0F, 15.6F, -13.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			RightLeg3.setTextureOffset(39, 25).addBox(1.0F, 15.6F, -13.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			RightLeg3.setTextureOffset(39, 22).addBox(-1.0F, 15.6F, -13.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 6.0F, 1.3F);
			RightLeg3.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.8727F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(0, 31).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 16.0F, 1.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 0.5F, 0.05F);
			RightLeg3.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.3054F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(10, 35).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
			RightLeg2 = new ModelRenderer(this);
			RightLeg2.setRotationPoint(4.0F, 4.0F, 7.0F);
			RightLeg2.setTextureOffset(32, 15).addBox(-2.0F, 15.6F, -12.4F, 5.0F, 1.0F, 2.0F, 0.0F, false);
			RightLeg2.setTextureOffset(32, 19).addBox(-1.0F, 15.6F, -10.4F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			RightLeg2.setTextureOffset(25, 40).addBox(-2.0F, 15.6F, -13.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			RightLeg2.setTextureOffset(20, 40).addBox(2.0F, 15.6F, -13.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			RightLeg2.setTextureOffset(39, 35).addBox(0.0F, 15.6F, -13.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(1.0F, 6.0F, 1.3F);
			RightLeg2.addChild(cube_r3);
			setRotationAngle(cube_r3, -0.8727F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(5, 31).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 16.0F, 1.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(1.0F, 0.5F, 0.05F);
			RightLeg2.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.3054F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(15, 35).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 3.0F, 8.0F);
			Jaw = new ModelRenderer(this);
			Jaw.setRotationPoint(0.0F, 21.0F, -1.0F);
			Head.addChild(Jaw);
			setRotationAngle(Jaw, -0.48F, 3.1416F, 0.0F);
			Jaw.setTextureOffset(0, 0).addBox(-4.0F, -16.5311F, -9.0027F, 9.0F, 1.0F, 8.0F, 0.0F, false);
			Teath = new ModelRenderer(this);
			Teath.setRotationPoint(0.0F, -4.0F, -3.0F);
			Jaw.addChild(Teath);
			Teath.setTextureOffset(44, 41).addBox(-4.0F, -13.5311F, -5.0027F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Teath.setTextureOffset(44, 25).addBox(4.0F, -13.5311F, -5.0027F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Teath.setTextureOffset(44, 0).addBox(0.0F, -13.5311F, 0.9973F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Teath.setTextureOffset(44, 37).addBox(-4.0F, -13.5311F, -3.0027F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Teath.setTextureOffset(44, 22).addBox(4.0F, -13.5311F, -3.0027F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Teath.setTextureOffset(43, 44).addBox(2.0F, -13.5311F, 0.9973F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Teath.setTextureOffset(44, 34).addBox(-4.0F, -13.5311F, -1.0027F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Teath.setTextureOffset(44, 28).addBox(4.0F, -13.5311F, -1.0027F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Teath.setTextureOffset(44, 3).addBox(-2.0F, -13.5311F, 0.9973F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			TopHead = new ModelRenderer(this);
			TopHead.setRotationPoint(0.0F, 21.0F, -5.0F);
			Head.addChild(TopHead);
			setRotationAngle(TopHead, 0.0F, 3.1416F, 0.0F);
			TopHead.setTextureOffset(0, 10).addBox(-3.0F, -24.0F, -4.0F, 7.0F, 4.0F, 7.0F, 0.0F, false);
			TopHead.setTextureOffset(22, 10).addBox(-4.0F, -23.0F, 3.0F, 9.0F, 3.0F, 1.0F, 0.0F, false);
			TopHead.setTextureOffset(22, 28).addBox(-4.0F, -24.0F, -4.0F, 1.0F, 4.0F, 7.0F, 0.0F, false);
			TopHead.setTextureOffset(0, 10).addBox(-4.0F, -22.0F, -5.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			TopHead.setTextureOffset(0, 0).addBox(4.0F, -22.0F, -5.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			TopHead.setTextureOffset(27, 0).addBox(-3.0F, -24.0F, -5.0F, 7.0F, 6.0F, 1.0F, 0.0F, false);
			TopHead.setTextureOffset(22, 15).addBox(4.0F, -24.0F, -4.0F, 1.0F, 4.0F, 7.0F, 0.0F, false);
			TopHead.setTextureOffset(0, 22).addBox(-3.0F, -25.0F, -4.0F, 7.0F, 1.0F, 7.0F, 0.0F, false);
			TopHead.setTextureOffset(38, 39).addBox(3.0F, -24.0F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			TopHead.setTextureOffset(0, 25).addBox(1.0F, -25.0F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			TopHead.setTextureOffset(0, 22).addBox(-2.0F, -25.0F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			TopHead.setTextureOffset(10, 44).addBox(0.0F, -24.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			TopHead.setTextureOffset(32, 28).addBox(-4.0F, -24.0F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			Teeth = new ModelRenderer(this);
			Teeth.setRotationPoint(-6.0F, -10.0F, 7.0F);
			TopHead.addChild(Teeth);
			Teeth.setTextureOffset(43, 11).addBox(3.0F, -10.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Teeth.setTextureOffset(42, 8).addBox(9.0F, -10.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Teeth.setTextureOffset(41, 19).addBox(7.0F, -10.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Teeth.setTextureOffset(30, 40).addBox(5.0F, -10.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Teeth.setTextureOffset(29, 43).addBox(3.0F, -10.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Teeth.setTextureOffset(39, 42).addBox(9.0F, -10.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Teeth.setTextureOffset(24, 43).addBox(3.0F, -10.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Teeth.setTextureOffset(34, 42).addBox(9.0F, -10.0F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Teeth.setTextureOffset(19, 43).addBox(3.0F, -10.0F, -11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Teeth.setTextureOffset(41, 31).addBox(9.0F, -10.0F, -11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			RightLeg3.render(matrixStack, buffer, packedLight, packedOverlay);
			RightLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.RightLeg3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.RightLeg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
