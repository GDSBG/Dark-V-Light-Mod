// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer leg;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;
	private final ModelRenderer leg5;
	private final ModelRenderer leg6;
	private final ModelRenderer leg7;
	private final ModelRenderer leg8;

	public Modelcustom_model() {
		textureWidth = 320;
		textureHeight = 320;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(-7.0F, 17.0F, 0.0F);
		setRotationAngle(Head, 0.0F, -1.5708F, 0.0F);
		Head.setTextureOffset(265, 298).addBox(-7.0F, -13.0F, -14.0F, 14.0F, 9.0F, 14.0F, 0.0F, false);
		Head.setTextureOffset(0, 0).addBox(-8.0F, -13.0F, -15.0F, 1.0F, 13.0F, 16.0F, 0.0F, false);
		Head.setTextureOffset(0, 292).addBox(7.0F, -13.0F, -15.0F, 1.0F, 13.0F, 16.0F, 0.0F, false);
		Head.setTextureOffset(129, 0).addBox(-7.0F, -13.0F, -15.0F, 14.0F, 13.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(144, 307).addBox(-7.0F, -13.0F, 0.0F, 14.0F, 13.0F, 1.0F, 0.0F, false);

		leg = new ModelRenderer(this);
		leg.setRotationPoint(0.0F, 24.0F, 0.0F);
		leg.setTextureOffset(200, 200).addBox(-7.0F, -11.0F, 6.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(13.0F, 24.0F, 0.0F);
		leg2.setTextureOffset(200, 200).addBox(-7.0F, -11.0F, 6.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(13.0F, 24.0F, -13.0F);
		leg3.setTextureOffset(200, 200).addBox(-7.0F, -11.0F, 6.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(0.0F, 24.0F, -13.0F);
		leg4.setTextureOffset(200, 200).addBox(-7.0F, -11.0F, 6.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);

		leg5 = new ModelRenderer(this);
		leg5.setRotationPoint(0.0F, 24.0F, -7.0F);
		leg5.setTextureOffset(200, 200).addBox(-7.0F, -11.0F, 6.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);

		leg6 = new ModelRenderer(this);
		leg6.setRotationPoint(13.0F, 24.0F, -7.0F);
		leg6.setTextureOffset(200, 200).addBox(-7.0F, -11.0F, 6.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);

		leg7 = new ModelRenderer(this);
		leg7.setRotationPoint(7.0F, 24.0F, -13.0F);
		leg7.setTextureOffset(200, 200).addBox(-7.0F, -11.0F, 6.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);

		leg8 = new ModelRenderer(this);
		leg8.setRotationPoint(7.0F, 24.0F, 0.0F);
		leg8.setTextureOffset(200, 200).addBox(-7.0F, -11.0F, 6.0F, 1.0F, 11.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}