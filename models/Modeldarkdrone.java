// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modeldarkdrone extends EntityModel<Entity> {
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer Attachments;
	private final ModelRenderer cube_r1;
	private final ModelRenderer Head;
	private final ModelRenderer cube_r2;

	public Modeldarkdrone() {
		textureWidth = 128;
		textureHeight = 128;

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(0.0F, 24.0F, 0.0F);
		leg1.setTextureOffset(0, 18).addBox(8.0F, -1.0F, -8.0F, 16.0F, 1.0F, 16.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(0.0F, 24.0F, 0.0F);
		leg2.setTextureOffset(0, 0).addBox(-24.0F, -1.0F, -8.0F, 16.0F, 1.0F, 16.0F, 0.0F, false);

		Attachments = new ModelRenderer(this);
		Attachments.setRotationPoint(0.0F, 24.0F, 0.0F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(5.0F, -0.3F, 0.0F);
		Attachments.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.7854F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 3).addBox(-13.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 24.0F, 0.0F);
		Head.setTextureOffset(26, 36).addBox(-4.0F, -5.0F, -3.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Head.setTextureOffset(0, 6).addBox(-1.0F, -6.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(0, 36).addBox(-2.0F, -3.0F, -20.0F, 4.0F, 4.0F, 17.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-4.0F, -9.0F, -1.5F);
		Head.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.9163F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(49, 0).addBox(0.0F, 3.0F, -3.0F, 8.0F, 0.0F, 7.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		leg1.render(matrixStack, buffer, packedLight, packedOverlay);
		leg2.render(matrixStack, buffer, packedLight, packedOverlay);
		Attachments.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}