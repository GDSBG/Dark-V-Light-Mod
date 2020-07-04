
package net.boogaeye.darkvlight.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import net.boogaeye.darkvlight.itemgroup.DVLtabItemGroup;
import net.boogaeye.darkvlight.DarkVLightModElements;

import java.util.Random;
import java.util.EnumSet;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@DarkVLightModElements.ModElement.Tag
public class DarkendFloaterEntity extends DarkVLightModElements.ModElement {
	public static EntityType entity = null;
	public DarkendFloaterEntity(DarkVLightModElements instance) {
		super(instance, 1);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("darkend_floater")
						.setRegistryName("darkend_floater");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -6750004, -10092442, new Item.Properties().group(DVLtabItemGroup.tab))
				.setRegistryName("darkend_floater"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelcustom_model(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("dark_v_light:textures/darkend_floater_text.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 5;
			setNoAI(false);
			this.moveController = new FlyingMovementController(this, 10, true);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new Goal() {
				{
					this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
				}
				public boolean shouldExecute() {
					if (CustomEntity.this.getAttackTarget() != null && !CustomEntity.this.getMoveHelper().isUpdating()) {
						return true;
					} else {
						return false;
					}
				}

				@Override
				public boolean shouldContinueExecuting() {
					return CustomEntity.this.getMoveHelper().isUpdating() && CustomEntity.this.getAttackTarget() != null
							&& CustomEntity.this.getAttackTarget().isAlive();
				}

				@Override
				public void startExecuting() {
					LivingEntity livingentity = CustomEntity.this.getAttackTarget();
					Vec3d vec3d = livingentity.getEyePosition(1);
					CustomEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1);
				}

				@Override
				public void tick() {
					LivingEntity livingentity = CustomEntity.this.getAttackTarget();
					if (CustomEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
						CustomEntity.this.attackEntityAsMob(livingentity);
					} else {
						double d0 = CustomEntity.this.getDistanceSq(livingentity);
						if (d0 < 16) {
							Vec3d vec3d = livingentity.getEyePosition(1);
							CustomEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1);
						}
					}
				}
			});
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.8, 20) {
				@Override
				protected Vec3d getPosition() {
					Random random = CustomEntity.this.getRNG();
					double dir_x = CustomEntity.this.getPosX() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = CustomEntity.this.getPosY() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = CustomEntity.this.getPosZ() + ((random.nextFloat() * 2 - 1) * 16);
					return new Vec3d(dir_x, dir_y, dir_z);
				}
			});
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dark_v_light:dfloater1"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dark_v_light:dfloaterhurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean onLivingFall(float l, float d) {
			return false;
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
			if (this.getAttribute(SharedMonsterAttributes.FLYING_SPEED) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.5);
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
		}
	}

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
