// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelDLoners extends EntityModel<Entity> {
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer head;

	public ModelDLoners() {
		textureWidth = 32;
		textureHeight = 32;

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-3.0F, 9.0F, 0.0F);
		RightLeg.setTextureOffset(4, 12).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		RightLeg.setTextureOffset(8, 12).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		RightLeg.setTextureOffset(0, 3).addBox(-1.0F, 14.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(3.0F, 9.0F, 0.0F);
		LeftLeg.setTextureOffset(0, 12).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		LeftLeg.setTextureOffset(13, 14).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		LeftLeg.setTextureOffset(0, 0).addBox(-1.0F, 14.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(-1.0F, 10.0F, 1.0F);
		setRotationAngle(head, 0.0F, 3.1416F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-3.0F, -5.0F, -3.0F, 5.0F, 5.0F, 7.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}