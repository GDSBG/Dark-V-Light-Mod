// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelburnarmor extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftBoot;
	private final ModelRenderer RightBoot;

	public Modelburnarmor() {
		textureWidth = 128;
		textureHeight = 128;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -1.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 0.0F, 10.0F, 0.0F, false);
		Head.setTextureOffset(57, 34).addBox(-5.0F, -7.0F, 5.0F, 10.0F, 8.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(55, 15).addBox(-5.0F, -2.0F, -5.0F, 10.0F, 3.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(11, 41).addBox(5.0F, -7.0F, -5.0F, 0.0F, 8.0F, 10.0F, 0.0F, false);
		Head.setTextureOffset(31, 1).addBox(-5.0F, -7.0F, -5.0F, 0.0F, 8.0F, 10.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(32, 56).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 13.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(51, 51).addBox(-4.0F, 0.0F, -3.0F, 1.0F, 13.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(46, 14).addBox(4.0F, 0.0F, -3.0F, 1.0F, 13.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(55, 0).addBox(-3.0F, 0.0F, 2.0F, 7.0F, 13.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(57, 46).addBox(-3.0F, 0.0F, 1.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(57, 43).addBox(-3.0F, 0.0F, -2.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		RightArm.setTextureOffset(36, 36).addBox(-3.0F, -2.0F, -3.0F, 4.0F, 13.0F, 6.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		LeftArm.setTextureOffset(0, 31).addBox(-1.0F, -2.0F, -3.0F, 4.0F, 13.0F, 6.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		RightLeg.setTextureOffset(21, 21).addBox(1.9F, 0.0F, -3.0F, 4.0F, 9.0F, 6.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		LeftLeg.setTextureOffset(0, 11).addBox(-5.9F, 0.0F, -3.0F, 4.0F, 9.0F, 6.0F, 0.0F, false);

		LeftBoot = new ModelRenderer(this);
		LeftBoot.setRotationPoint(0.0F, 21.0F, 1.0F);
		LeftBoot.setTextureOffset(0, 11).addBox(-4.0F, 0.0F, -4.0F, 4.0F, 4.0F, 6.0F, 0.0F, false);

		RightBoot = new ModelRenderer(this);
		RightBoot.setRotationPoint(0.0F, 21.0F, 1.0F);
		RightBoot.setTextureOffset(0, 11).addBox(0.0F, 0.0F, -4.0F, 4.0F, 4.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftBoot.render(matrixStack, buffer, packedLight, packedOverlay);
		RightBoot.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}