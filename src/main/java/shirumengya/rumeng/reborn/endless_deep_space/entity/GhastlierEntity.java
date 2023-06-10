
package shirumengya.rumeng.reborn.endless_deep_space.entity;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.*;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import java.util.EnumSet;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.nbt.CompoundTag;

public class GhastlierEntity extends Monster {
	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.WHITE, ServerBossEvent.BossBarOverlay.PROGRESS);
	public static final EntityDataAccessor<Integer> Data_Energy = SynchedEntityData.defineId(GhastlierEntity.class, EntityDataSerializers.INT);

	public GhastlierEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(EndlessDeepSpaceModEntities.GHASTLIER.get(), world);
	}

	public void defineSynchedData() {
		super.defineSynchedData();
      	this.getEntityData().define(Data_Energy, 80);
   	}

   	public void addAdditionalSaveData(CompoundTag p_31062_) {
   	  	super.addAdditionalSaveData(p_31062_);
      	p_31062_.putInt("Energy", this.getEnergy());
   	}

   	public void readAdditionalSaveData(CompoundTag p_31055_) {
   		super.readAdditionalSaveData(p_31055_);
    	this.setEnergy(p_31055_.getInt("Energy"));
   	}

   	public void setEnergy(int p_31511_) {
      	this.entityData.set(Data_Energy, p_31511_);
   	}

   	public int getEnergy() {
      	return this.entityData.get(Data_Energy);
   	}

   	protected float getSoundVolume() {
      	return 5.0F;
   	}

	public GhastlierEntity(EntityType<GhastlierEntity> type, Level world) {
		super(type, world);
		xpReward = 10000;
		setNoAi(false);
		setPersistenceRequired();
		this.moveControl = new FlyingMoveControl(this, 10, true);
		this.noCulling = true;
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, LivingEntity.class, false, false));
		this.targetSelector.addGoal(2, new GhastlierEntity.GhastlierEntityAttackGoal(this));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, (float) 64));
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 0.6, 20) {
			@Override
			protected Vec3 getPosition() {
				RandomSource random = GhastlierEntity.this.getRandom();
				double dir_x = GhastlierEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = GhastlierEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = GhastlierEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}
		});
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.death"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean canChangeDimensions() {
		return false;
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void customServerAiStep() {
		super.customServerAiStep();
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	public void aiStep() {
		super.aiStep();
		this.setNoGravity(true);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.6);
		builder = builder.add(Attributes.MAX_HEALTH, 800);
		builder = builder.add(Attributes.ARMOR, 8);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 10);
		builder = builder.add(Attributes.FOLLOW_RANGE, 100);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1000);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 2);
		builder = builder.add(Attributes.FLYING_SPEED, 0.6);
		return builder;
	}

	static class GhastlierEntityAttackGoal extends Goal {
      private final GhastlierEntity ghast;
      public int energy;

      public GhastlierEntityAttackGoal(GhastlierEntity p_32776_) {
         this.ghast = p_32776_;
      }

      public boolean canUse() {
         return this.ghast.getTarget() != null;
      }

      public boolean canContinueToUse() {
		 return this.ghast.getTarget() != null && this.ghast.getTarget().isAlive();
      }

      public void start() {
      	LivingEntity livingentity = this.ghast.getTarget();
       	this.energy = this.ghast.getEnergy();
       	Vec3 vec3d = livingentity.getEyePosition(1);
		this.ghast.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 0.8);
      }

      public boolean requiresUpdateEveryTick() {
         return true;
      }

      public void tick() {
         LivingEntity livingentity = this.ghast.getTarget();
         this.ghast.setEnergy(this.energy);
         if (livingentity != null) {
            if (livingentity.distanceToSqr(this.ghast) < 4096.0D) {
            	if (this.energy > 0) {
            		Vec3 vec3d = livingentity.getEyePosition(1);
					this.ghast.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 0.8);
            		--this.energy;
//            		System.out.println(this.energy);
            		livingentity.invulnerableTime = 0;
            		if (this.energy >= 40) {
            			livingentity.hurt(new EntityDamageSource("mob", this.ghast).setProjectile(), 2);
            		} else {
            			livingentity.hurt(new EntityDamageSource("mob", this.ghast).setProjectile(), 1);
            		}
            		livingentity.addEffect(new MobEffectInstance(MobEffectInit.DAMAGE_INCREASE.get(), 200, 1));
            		livingentity.setSecondsOnFire(10);
            		livingentity.setDeltaMovement(Vec3.ZERO);
            		this.ghast.setEnergy(this.energy);
            	} else {
            		if (this.energy < 80) {
            			++this.energy;
            			this.ghast.setEnergy(this.energy);
            		}
            	}
            } else {
				this.ghast.setEnergy(this.energy);
            	if (this.energy < 80) {
            		++this.energy;
            		this.ghast.setEnergy(this.energy);
            	}
            }
         }
      }
   }
}
