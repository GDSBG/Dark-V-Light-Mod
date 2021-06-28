// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelDark_Horn extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer LLeg1;
	private final ModelRenderer LLeg2;
	private final ModelRenderer RLeg1;
	private final ModelRenderer RLeg2;

	public ModelDark_Horn() {
		textureWidth = 256;
		textureHeight = 256;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -2.0F, -16.0F);
		Head.setTextureOffset(0, 99).addBox(-8.0F, -6.0F, -16.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
		Head.setTextureOffset(65, 107).addBox(4.0F, -11.0F, -16.0F, 0.0F, 5.0F, 16.0F, 0.0F, false);
		Head.setTextureOffset(97, 0).addBox(-4.0F, -11.0F, -16.0F, 0.0F, 5.0F, 16.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 5.0769F);
		Body.setTextureOffset(0, 0).addBox(-16.0F, -16.0F, -21.0769F, 32.0F, 32.0F, 32.0F, 0.0F, false);
		Body.setTextureOffset(121, 124).addBox(-16.0F, -16.0F, 10.9231F, 0.0F, 32.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(118, 124).addBox(16.0F, -16.0F, 10.9231F, 0.0F, 32.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(74, 68).addBox(-16.0F, -16.0F, 10.9231F, 32.0F, 0.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(74, 66).addBox(-16.0F, 16.0F, 10.9231F, 32.0F, 0.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(97, 33).addBox(-18.0F, -16.0F, -21.0769F, 2.0F, 0.0F, 32.0F, 0.0F, false);
		Body.setTextureOffset(37, 66).addBox(16.0F, -16.0F, -21.0769F, 2.0F, 0.0F, 32.0F, 0.0F, false);
		Body.setTextureOffset(0, 65).addBox(16.0F, 16.0F, -21.0769F, 2.0F, 0.0F, 32.0F, 0.0F, false);
		Body.setTextureOffset(113, 124).addBox(-18.0F, -16.0F, -21.0769F, 2.0F, 32.0F, 0.0F, 0.0F, false);
		Body.setTextureOffset(108, 124).addBox(-18.0F, -16.0F, 10.9231F, 2.0F, 32.0F, 0.0F, 0.0F, false);
		Body.setTextureOffset(103, 124).addBox(16.0F, -16.0F, 10.9231F, 2.0F, 32.0F, 0.0F, 0.0F, false);
		Body.setTextureOffset(98, 124).addBox(16.0F, -16.0F, -21.0769F, 2.0F, 32.0F, 0.0F, 0.0F, false);
		Body.setTextureOffset(74, 74).addBox(-18.0F, 16.0F, -21.0769F, 2.0F, 0.0F, 32.0F, 0.0F, false);

		LLeg1 = new ModelRenderer(this);
		LLeg1.setRotationPoint(12.0F, 16.0F, -12.0F);
		LLeg1.setTextureOffset(122, 14).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		LLeg2 = new ModelRenderer(this);
		LLeg2.setRotationPoint(12.0F, 16.0F, 12.0F);
		LLeg2.setTextureOffset(111, 87).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		RLeg1 = new ModelRenderer(this);
		RLeg1.setRotationPoint(-12.0F, 16.0F, -12.0F);
		RLeg1.setTextureOffset(98, 107).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		RLeg2 = new ModelRenderer(this);
		RLeg2.setRotationPoint(-12.0F, 16.0F, 12.0F);
		RLeg2.setTextureOffset(111, 70).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		LLeg1.render(matrixStack, buffer, packedLight, packedOverlay);
		LLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
		RLeg1.render(matrixStack, buffer, packedLight, packedOverlay);
		RLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.RLeg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.RLeg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.LLeg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.LLeg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}