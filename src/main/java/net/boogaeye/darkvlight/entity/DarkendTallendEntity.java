
package net.boogaeye.darkvlight.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.World;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.FollowMobGoal;
import net.minecraft.entity.ai.goal.BreakDoorGoal;
import net.minecraft.entity.ai.goal.BreakBlockGoal;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.block.Blocks;

import net.boogaeye.darkvlight.procedures.DarkendTallendOnInitialEntitySpawnProcedure;
import net.boogaeye.darkvlight.procedures.DarkendTallendOnEntityTickUpdateProcedure;
import net.boogaeye.darkvlight.itemgroup.DVLtabItemGroup;
import net.boogaeye.darkvlight.entity.renderer.DarkendTallendRenderer;
import net.boogaeye.darkvlight.block.SmoothDarkStoneBlock;
import net.boogaeye.darkvlight.block.DarkStoneBlock;
import net.boogaeye.darkvlight.block.DarkDirtBlock;
import net.boogaeye.darkvlight.block.BurnGazeWoodenPlankBlock;
import net.boogaeye.darkvlight.DarkVsLightModElements;

import javax.annotation.Nullable;

import java.util.Map;
import java.util.HashMap;

@DarkVsLightModElements.ModElement.Tag
public class DarkendTallendEntity extends DarkVsLightModElements.ModElement {
	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
			.size(0.6f, 1.8f)).build("darkend_tallend").setRegistryName("darkend_tallend");
	public DarkendTallendEntity(DarkVsLightModElements instance) {
		super(instance, 18);
		FMLJavaModLoadingContext.get().getModEventBus().register(new DarkendTallendRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -10092442, -65281, new Item.Properties().group(DVLtabItemGroup.tab))
				.setRegistryName("darkend_tallend_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
	private static class EntityAttributesRegisterHandler {
		@SubscribeEvent
		public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 15);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 3);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 5);
			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.5);
			event.put(entity, ammma.create());
		}
	}

	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 5;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new AvoidEntityGoal(this, DarkendDestroyerEntity.CustomEntity.class, (float) 16, 1.5, 0.8));
			this.goalSelector.addGoal(2, new AvoidEntityGoal(this, DarkendFloaterEntity.CustomEntity.class, (float) 5, 1.5, 0.8));
			this.goalSelector.addGoal(3, new AvoidEntityGoal(this, DarkendShooterEntity.CustomEntity.class, (float) 10, 1.5, 0.8));
			this.goalSelector.addGoal(4, new AvoidEntityGoal(this, GhastEntity.class, (float) 5, 1.5, 0.8));
			this.goalSelector.addGoal(5, new AvoidEntityGoal(this, PhantomEntity.class, (float) 5, 1.5, 0.8));
			this.goalSelector.addGoal(6, new AvoidEntityGoal(this, VexEntity.class, (float) 5, 1.5, 0.8));
			this.goalSelector.addGoal(7, new AvoidEntityGoal(this, SlimeEntity.class, (float) 5, 1.5, 0.8));
			this.goalSelector.addGoal(8, new BreakDoorGoal(this, e -> true));
			this.goalSelector.addGoal(9, new LookAtGoal(this, PlayerEntity.class, (float) 6));
			this.goalSelector.addGoal(10, new LookAtGoal(this, ServerPlayerEntity.class, (float) 6));
			this.targetSelector.addGoal(11, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(12, new MeleeAttackGoal(this, 1.2, false));
			this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, ZombieEntity.class, false, true));
			this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, DarkendHornEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, DarkendLonerEntity.CustomEntity.class, false, true));
			this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, ZombieEntity.class, false, true));
			this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, PlayerEntity.class, true, true));
			this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, ServerPlayerEntity.class, true, true));
			this.goalSelector.addGoal(19, new FollowMobGoal(this, (float) 1.5, 16, 8));
			this.goalSelector.addGoal(20, new RandomWalkingGoal(this, 0.5));
			this.goalSelector.addGoal(21, new RandomSwimmingGoal(this, 0.3, 40));
			this.goalSelector.addGoal(22, new BreakBlockGoal(DarkStoneBlock.block, this, 1, (int) 5));
			this.goalSelector.addGoal(23, new BreakBlockGoal(BurnGazeWoodenPlankBlock.block, this, 1, (int) 5));
			this.goalSelector.addGoal(24, new BreakBlockGoal(SmoothDarkStoneBlock.block, this, 1, (int) 5));
			this.goalSelector.addGoal(25, new BreakBlockGoal(Blocks.SAND, this, 1, (int) 5));
			this.goalSelector.addGoal(26, new BreakBlockGoal(DarkDirtBlock.block, this, 1, (int) 5));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEAD;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dark_vs_light:darkendtallend"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("dark_vs_light:darkendtallendhurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason,
				@Nullable ILivingEntityData livingdata, @Nullable CompoundNBT tag) {
			ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				DarkendTallendOnInitialEntitySpawnProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

		@Override
		public void baseTick() {
			super.baseTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				DarkendTallendOnEntityTickUpdateProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
