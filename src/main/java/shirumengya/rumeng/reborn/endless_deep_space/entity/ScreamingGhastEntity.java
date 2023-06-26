
package shirumengya.rumeng.reborn.endless_deep_space.entity;

import shirumengya.rumeng.reborn.endless_deep_space.init.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.event.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.*;
import javax.annotation.Nullable;
import net.minecraftforge.entity.PartEntity;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.common.DungeonHooks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.monster.Ghast;
import javax.annotation.Nullable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.projectile.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.entity.projectile.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Evoker;
import java.util.function.Predicate;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.*;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.WitherSkull;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.entity.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.packet.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.java.color.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.mixin.*;

public class ScreamingGhastEntity extends Monster {

	public final ScreamingGhastPart[] Parts;
	public final ScreamingGhastPart AbovePart;
	public final ScreamingGhastPart UnderPart;
	public final ScreamingGhastPart LeftPart;
	public final ScreamingGhastPart RightPart;
	public final ScreamingGhastPart FrontPart;
	public final ScreamingGhastPart LaterPart;
	public final ScreamingGhastPart SizePart;
	public final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.WHITE, ServerBossEvent.BossBarOverlay.PROGRESS);
	public float ScreamingGhastDeathTime = 0.0F;
	private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
      	return (!p_31504_.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("endless_deep_space:screaming_ghast_can_not_attack"))));
   	};
   	private static final EntityDataAccessor<Boolean> DATA_IS_CHARGING = SynchedEntityData.defineId(ScreamingGhastEntity.class, EntityDataSerializers.BOOLEAN);
   	private static final EntityDataAccessor<Boolean> DataIntensiveBombing = SynchedEntityData.defineId(ScreamingGhastEntity.class, EntityDataSerializers.BOOLEAN);

	public ScreamingGhastEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(EndlessDeepSpaceModEntities.SCREAMING_GHAST.get(), world);
	}

	public ScreamingGhastEntity(EntityType<ScreamingGhastEntity> type, Level world) {
		super(type, world);
		xpReward = 15000;
		setNoAi(false);
		this.moveControl = new ScreamingGhastEntity.GhastMoveControl(this);
		this.AbovePart = new ScreamingGhastPart(this, 3.0F, 3.0F);
		this.UnderPart = new ScreamingGhastPart(this, 3.0F, 3.0F);
		this.LeftPart = new ScreamingGhastPart(this, 3.0F, 3.0F);
		this.RightPart = new ScreamingGhastPart(this, 3.0F, 3.0F);
		this.FrontPart = new ScreamingGhastPart(this, 3.0F, 3.0F);
		this.LaterPart = new ScreamingGhastPart(this, 3.0F, 3.0F);
		this.SizePart = new ScreamingGhastPart(this, 4.0F, 4.0F);
		this.Parts = new ScreamingGhastPart[]{this.AbovePart ,this.UnderPart, this.LeftPart, this.RightPart, this.FrontPart, this.LaterPart, this.SizePart};
		this.noCulling = true;
		if (!this.level.isClientSide) {
			ModMessages.sendToAllPlayers(new SendEndlessDeepSpaceCommonToastS2CPacket(new ItemStack(EndlessDeepSpaceModItems.SCREAMING_GHAST_SPAWN_EGG.get()), this.getDisplayName(), Component.translatable("entity.endless_deep_space.screaming_ghast.spawning"), 5000L, -11534256, -16777216));
		}
	}

	public boolean causeFallDamage(float p_147105_, float p_147106_, DamageSource p_147107_) {
      	return false;
   	}

   	protected void checkFallDamage(double p_20809_, boolean p_20810_, BlockState p_20811_, BlockPos p_20812_) {
   	}

   	public SoundSource getSoundSource() {
      return SoundSource.HOSTILE;
   }

   protected SoundEvent getAmbientSound() {
      	return SoundEvents.GHAST_AMBIENT;
   	}

   	protected SoundEvent getHurtSound(DamageSource p_32750_) {
      	return SoundEvents.GHAST_HURT;
   	}

   	protected SoundEvent getDeathSound() {
      	return SoundEvents.GHAST_DEATH;
   	}

   	protected float getStandingEyeHeight(Pose p_32741_, EntityDimensions p_32742_) {
      	return 2.6F;
   	}

   	public void setHealth(float p_21154_) {
   		if (!this.isIntensiveBombing()) {
   			super.setHealth(p_21154_);
   		}
   	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected float getSoundVolume() {
      	return 10.0F;
   	}

   	protected void defineSynchedData() {
      	super.defineSynchedData();
      	this.entityData.define(DATA_IS_CHARGING, false);
      	this.entityData.define(DataIntensiveBombing, false);
   	}

   	public boolean isCharging() {
      	return this.entityData.get(DATA_IS_CHARGING);
   	}

   	public void setCharging(boolean p_32759_) {
      	this.entityData.set(DATA_IS_CHARGING, p_32759_);
   	}

   	public boolean isIntensiveBombing() {
      	return this.entityData.get(DataIntensiveBombing);
   	}

   	public void setIntensiveBombing(boolean p_32759_) {
      	this.entityData.set(DataIntensiveBombing, p_32759_);
   	}

   	public void die(DamageSource source) {
   		super.die(source);
   		int r = Mth.nextInt(RandomSource.create(), 0, 255);
   		int g = Mth.nextInt(RandomSource.create(), 0, 255);
   		int b = Mth.nextInt(RandomSource.create(), 0, 255);
   		RGBtoTen rgb = new RGBtoTen();
   		int color = rgb.OutputResult(r, g, b);
   		if (Math.random() <= 0.5) {
   			BossItem item1 = new BossItem(this.level, this.getX(), this.getY(), this.getZ(), new ItemStack(EndlessDeepSpaceModItems.GRAVITY_CORE.get()), true, color, true);
   			item1.setPickUpDelay(0);
   			item1.setUnlimitedLifetime();
   			this.level.addFreshEntity(item1);
   		} else {
   			BossItem item2 = new BossItem(this.level, this.getX(), this.getY(), this.getZ(), new ItemStack(EndlessDeepSpaceModItems.ANTIGRAVITY_CORE.get()), true, color, true);
   			item2.setPickUpDelay(0);
   			item2.setUnlimitedLifetime();
   			this.level.addFreshEntity(item2);
   		}
   	}

	@Override
	protected void registerGoals() {
      	this.goalSelector.addGoal(5, new ScreamingGhastEntity.RandomFloatAroundGoal(this));
      	this.goalSelector.addGoal(7, new ScreamingGhastEntity.GhastLookGoal(this));
      	this.goalSelector.addGoal(7, new ScreamingGhastEntity.GhastShootFireballGoal(this));
      	this.goalSelector.addGoal(7, new ScreamingGhastEntity.ScreamingGhastSpawnGhastGoal(this));
      	this.goalSelector.addGoal(7, new ScreamingGhastEntity.ScreamingGhastShootMagicBulletGoal(this));
      	this.goalSelector.addGoal(7, new ScreamingGhastEntity.ScreamingGhastShootGravityBombGoal(this));
      	this.goalSelector.addGoal(7, new ScreamingGhastEntity.ScreamingGhastIntensiveBombingGoal(this));
      	this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
      	this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
      	this.goalSelector.addGoal(4, new ScreamingGhastEntity.ScreamingGhastApproachingTargetGoal(this));
   	}

	public int getExplosionPower() {
      return 14;
   	}

   	public boolean HalfHealth() {
   		return (this.getHealth() <= this.getMaxHealth() / 2) ? true : false;
   	}

	public static void init() {
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public void heal(float p_21116_) {
      	float f = this.getHealth();
      	if (f > 0.0F && EndlessDeepSpaceModCommonConfig.SCREAMING_GHAST_CANNOT_REGENERATE_HEALTH.get() == false) {
         	this.setHealth(f + p_21116_);
      	}
   	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 500);
		builder = builder.add(Attributes.ARMOR, 20);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 30);
		builder = builder.add(Attributes.FOLLOW_RANGE, 640);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 1.2);
		builder = builder.add(Attributes.FLYING_SPEED, 0.4);
		return builder;
	}

	@Nullable
	@Override
	public PartEntity<?>[] getParts() {
		return this.Parts;
	}

	@Override
	public boolean isMultipartEntity() {
		return true;
	}

	public boolean addEffect(MobEffectInstance p_182397_, @Nullable Entity p_182398_) {
      	return false;
   	}

   	protected boolean shouldDespawnInPeaceful() {
      	return false;
   	}

	public boolean hurt(@Nullable ScreamingGhastPart part, DamageSource source, float amount) {
		if (source.isExplosion() || 
		source.isFall() || 
		source.isFire() || 
		source == DamageSource.LIGHTNING_BOLT || 
		source == DamageSource.WITHER || 
		source.getDirectEntity() instanceof ThrownPotion || 
		source.getDirectEntity() instanceof AreaEffectCloud || 
		this.isIntensiveBombing()) {
			return false;
		} else {
			float amount1 = amount;
			if (part == null) {
				amount1 = amount / 2;
			} else {
				amount1 = amount / 4;
			}
			return super.hurt(source, amount1);
		}
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		return this.hurt(null, source, amount);
	}

	private static boolean isReflectedFireball(DamageSource p_238408_) {
      	return false;
   	}

	@Override
	public void tick() {
		super.tick();
		this.setNoGravity(true);
		if (this.HalfHealth()) {
			this.bossInfo.setColor(BossEvent.BossBarColor.RED);
		} else {
			this.bossInfo.setColor(BossEvent.BossBarColor.WHITE);
			this.setIntensiveBombing(false);
		}
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
		if (this.tickCount % 20 == 0) {
        	this.heal(2.0F);
      	}
		for (int i = 0; i < this.Parts.length; i++) {
			this.Parts[i].tick();
			this.Parts[i].setYRot(this.getYRot());
			this.Parts[i].setXRot(this.getXRot());
		}
		this.SizePart.setPos(this.getX(), this.getY(), this.getZ());
		this.AbovePart.setPos(this.getX(), this.getY() + 4, this.getZ());
		this.UnderPart.setPos(this.getX(), this.getY() - 3, this.getZ());
		this.LeftPart.setPos(this.getX() + 3.5, this.getY() + 0.5, this.getZ());
		this.RightPart.setPos(this.getX() - 3.5, this.getY() + 0.5, this.getZ());
		this.FrontPart.setPos(this.getX(), this.getY() + 0.5, this.getZ() + 3.5);
		this.LaterPart.setPos(this.getX(), this.getY() + 0.5, this.getZ() - 3.5);
		if (!this.level.isClientSide) {
			TrackingUtil.forceEffect(this, LivingEntity.class, 20.0D, -8.0D, 8.0D);
		}
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
	public void recreateFromPacket(ClientboundAddEntityPacket packet) {
		super.recreateFromPacket(packet);
		EndlessDeepSpaceEntityPart.assignPartIDs(this);
	}

	@Override
   protected void tickDeath() {
      	++this.ScreamingGhastDeathTime;
      	this.setYRot(this.getYRot() + 40.0F);
      	this.setYHeadRot(this.getYHeadRot() + 40.0F);
      	this.setDeltaMovement(new Vec3(0, 0, 0));
      	this.yBodyRot = this.getYRot();
      	this.setNoAi(true);
      	this.setHealth(0.0F);
      	this.bossInfo.setProgress(0.0F);
      	if (this.ScreamingGhastDeathTime == 100.0F && this.level instanceof ServerLevel) {
         	this.remove(Entity.RemovalReason.KILLED);
         	this.gameEvent(GameEvent.ENTITY_DIE);
         	Explosion.BlockInteraction explosion$blockinteraction = this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
         	this.level.explode(this, this.getX(), this.getEyeY(), this.getZ(), 20.0F, false, explosion$blockinteraction);
      	}
   }

	static class GhastMoveControl extends MoveControl {
      private final ScreamingGhastEntity ghast;
      private int floatDuration;

      public GhastMoveControl(ScreamingGhastEntity p_32768_) {
         super(p_32768_);
         this.ghast = p_32768_;
      }

      public boolean canUse() {
      		return !(this.ghast.isIntensiveBombing());
      }

      public void tick() {
         if (this.operation == MoveControl.Operation.MOVE_TO) {
            if (this.floatDuration-- <= 0) {
               this.floatDuration += this.ghast.getRandom().nextInt(5) + 2;
               Vec3 vec3 = new Vec3(this.wantedX - this.ghast.getX(), this.wantedY - this.ghast.getY(), this.wantedZ - this.ghast.getZ());
               double d0 = vec3.length();
               vec3 = vec3.normalize();
               if (this.canReach(vec3, Mth.ceil(d0))) {
                  this.ghast.setDeltaMovement(this.ghast.getDeltaMovement().add(vec3.scale(0.1D)));
               } else {
                  this.operation = MoveControl.Operation.WAIT;
               }
            }

         }
      }

      private boolean canReach(Vec3 p_32771_, int p_32772_) {
         AABB aabb = this.ghast.getBoundingBox();

         for(int i = 1; i < p_32772_; ++i) {
            aabb = aabb.move(p_32771_);
            if (!this.ghast.level.noCollision(this.ghast, aabb)) {
               return false;
            }
         }

         return true;
      }
   }

   static class GhastShootFireballGoal extends Goal {
      private final ScreamingGhastEntity ghast;
      public int chargeTime;

      public GhastShootFireballGoal(ScreamingGhastEntity p_32776_) {
         this.ghast = p_32776_;
      }

      public boolean canUse() {
         return this.ghast.getTarget() != null && this.ghast.HalfHealth() && !(this.ghast.isIntensiveBombing());
      }

      public void start() {
         this.chargeTime = 0;
      }

      public void stop() {
         this.ghast.setCharging(false);
      }

      public boolean requiresUpdateEveryTick() {
         return true;
      }

      public void tick() {
         LivingEntity livingentity = this.ghast.getTarget();
         if (livingentity != null) {
            double d0 = 100.0D;
            if (livingentity.distanceToSqr(this.ghast) < 4096.0D) {
               Level level = this.ghast.level;
               ++this.chargeTime;
               if (this.chargeTime == 10 && !this.ghast.isSilent()) {
                  level.levelEvent((Player)null, 1015, this.ghast.blockPosition(), 0);
               }

               if (this.chargeTime == 20) {
                  double d1 = 4.0D;
                  Vec3 vec3 = this.ghast.getViewVector(1.0F);
                  double d2 = livingentity.getX() - (this.ghast.getX() + vec3.x * 4.0D);
                  double d3 = livingentity.getY(0.5D) - (0.5D + this.ghast.getY(0.5D));
                  double d4 = livingentity.getZ() - (this.ghast.getZ() + vec3.z * 4.0D);
                  if (!this.ghast.isSilent()) {
                     level.levelEvent((Player)null, 1016, this.ghast.blockPosition(), 0);
                  }

                  ScreamingGhastFirball largefireball = new ScreamingGhastFirball(ProjectileInit.SCREAMING_GHAST_FIRBALL.get(), level, this.ghast, d2, d3, d4, this.ghast.getExplosionPower());
                  largefireball.setPos(this.ghast.getX() + vec3.x * 4.0D, this.ghast.getY(0.5D) + 0.5D, largefireball.getZ() + vec3.z * 4.0D);
                  level.addFreshEntity(largefireball);
                  this.chargeTime = 0;
               }
            } else if (this.chargeTime > 0) {
               --this.chargeTime;
            }

            this.ghast.setCharging(this.chargeTime > 10);
         }
      }
   }

   static class RandomFloatAroundGoal extends Goal {
      private final ScreamingGhastEntity ghast;

      public RandomFloatAroundGoal(ScreamingGhastEntity p_32783_) {
         this.ghast = p_32783_;
         this.setFlags(EnumSet.of(Goal.Flag.MOVE));
      }

      public boolean canUse() {
      	if (!(this.ghast.isIntensiveBombing())) {
         MoveControl movecontrol = this.ghast.getMoveControl();
         if (!movecontrol.hasWanted()) {
            return true;
         } else {
            double d0 = movecontrol.getWantedX() - this.ghast.getX();
            double d1 = movecontrol.getWantedY() - this.ghast.getY();
            double d2 = movecontrol.getWantedZ() - this.ghast.getZ();
            double d3 = d0 * d0 + d1 * d1 + d2 * d2;
            return d3 < 1.0D || d3 > 3600.0D;
         }
      	} else {
      		return false;
      	}
      }

      public boolean canContinueToUse() {
         return false;
      }

      public void start() {
         RandomSource randomsource = this.ghast.getRandom();
         double d0 = this.ghast.getX() + (double)((randomsource.nextFloat() * 2.0F - 1.0F) * 16.0F);
         double d1 = this.ghast.getY() + (double)((randomsource.nextFloat() * 2.0F - 1.0F) * 16.0F);
         double d2 = this.ghast.getZ() + (double)((randomsource.nextFloat() * 2.0F - 1.0F) * 16.0F);
         this.ghast.getMoveControl().setWantedPosition(d0, d1, d2, 1.0D);
      }
   }

   static class GhastLookGoal extends Goal {
      private final ScreamingGhastEntity ghast;

      public GhastLookGoal(ScreamingGhastEntity p_32762_) {
         this.ghast = p_32762_;
         this.setFlags(EnumSet.of(Goal.Flag.LOOK));
      }

      public boolean canUse() {
         return !(this.ghast.isIntensiveBombing());
      }

      public boolean requiresUpdateEveryTick() {
         return true;
      }

      public void tick() {
         if (this.ghast.getTarget() == null) {
            Vec3 vec3 = this.ghast.getDeltaMovement();
            this.ghast.setYRot(-((float)Mth.atan2(vec3.x, vec3.z)) * (180F / (float)Math.PI));
            this.ghast.yBodyRot = this.ghast.getYRot();
         } else {
            LivingEntity livingentity = this.ghast.getTarget();
            double d0 = 64.0D;
            if (livingentity.distanceToSqr(this.ghast) < 4096.0D) {
               double d1 = livingentity.getX() - this.ghast.getX();
               double d2 = livingentity.getZ() - this.ghast.getZ();
               this.ghast.setYRot(-((float)Mth.atan2(d1, d2)) * (180F / (float)Math.PI));
               this.ghast.yBodyRot = this.ghast.getYRot();
            }
         }

      }
   }

   	static class ScreamingGhastSpawnGhastGoal extends Goal {
   		private final ScreamingGhastEntity ghast;
   		public int chargeTimes;

   		public ScreamingGhastSpawnGhastGoal(ScreamingGhastEntity ghast) {
   			this.ghast = ghast;
   		}

   		public boolean canUse() {
         	return this.ghast.getTarget() != null && this.ghast.HalfHealth() && !(this.ghast.isIntensiveBombing());
      	}

      	public void start() {
         	this.chargeTimes = 0;
      	}

      	public void tick() {
      		LivingEntity livingentity = this.ghast.getTarget();
      		if (livingentity != null) {
      			++this.chargeTimes;
      			if (this.chargeTimes == 100) {
      				this.spawnMob();
      				this.chargeTimes = 0;
      				this.ghast.heal(3.0F);
      			}
      		}
      	}

      	public void spawnMob() {
      		LivingEntity livingentity = this.ghast.getTarget();
      		Level level = this.ghast.level;
      		for(int i = 0; i < 4; ++i) {
            	BlockPos blockpos = this.ghast.blockPosition().offset(-2 + this.ghast.random.nextInt(5), 1, -2 + this.ghast.random.nextInt(5));
            	Ghast spawn_ghast = EntityType.GHAST.create(level);
            	spawn_ghast.moveTo(blockpos, 0.0F, 0.0F);
            	spawn_ghast.setTarget(livingentity);
            	Blaze spawn_blaze = EntityType.BLAZE.create(level);
            	spawn_blaze.moveTo(blockpos, 0.0F, 0.0F);
            	spawn_blaze.setTarget(livingentity);
            	Evoker spawn_evoker = EntityType.EVOKER.create(level);
            	spawn_evoker.moveTo(blockpos, 0.0F, 0.0F);
            	spawn_evoker.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 1200, 4));
            	spawn_evoker.setTarget(livingentity);
            	if (Math.random() < 0.5) {
            		level.addFreshEntity(spawn_ghast);
            	} else if (Math.random() < 0.5) {
            		level.addFreshEntity(spawn_blaze);
            	} else {
            		level.addFreshEntity(spawn_evoker);
            	}
         	}
      	}
   	}

   	static class ScreamingGhastShootMagicBulletGoal extends Goal {
   		private final ScreamingGhastEntity ghast;
   		public int Charge_Time;

   		public ScreamingGhastShootMagicBulletGoal(ScreamingGhastEntity ghast) {
   			this.ghast = ghast;
   		}

   		public boolean canUse() {
         	return this.ghast.getTarget() != null && !(this.ghast.HalfHealth()) && !(this.ghast.isIntensiveBombing());
      	}

      	public void start() {
         	this.Charge_Time = 0;
      	}

      	public void stop() {
         	this.ghast.setCharging(false);
      	}

      	public void tick() {
         	LivingEntity livingentity = this.ghast.getTarget();
         	if (livingentity != null) {
            	double d0 = 100.0D;
            	if (livingentity.distanceToSqr(this.ghast) < 4096.0D) {
               		Level level = this.ghast.level;
               		++this.Charge_Time;
               		if (this.Charge_Time == 10 || this.Charge_Time == 30 || this.Charge_Time == 50) {
               			if (!this.ghast.isSilent()) {
                  			level.levelEvent((Player)null, 1015, this.ghast.blockPosition(), 0);
               			}
               		}
               		if (this.Charge_Time == 20 || this.Charge_Time == 40 || this.Charge_Time == 60) {
                  		double d1 = 4.0D;
                  		Vec3 vec3 = this.ghast.getViewVector(1.0F);
                  		double d2 = livingentity.getX() - (this.ghast.getX() + vec3.x * 4.0D);
                  		double d3 = livingentity.getY(0.5D) - (0.5D + this.ghast.getY(0.5D));
                  		double d4 = livingentity.getZ() - (this.ghast.getZ() + vec3.z * 4.0D);
                  		if (!this.ghast.isSilent()) {
                     		level.levelEvent((Player)null, 1016, this.ghast.blockPosition(), 0);
                  		}
                  		for (int i = 0;i < 4; i++) {
                  			ScreamingGhastMagicBullet magicBullet = new ScreamingGhastMagicBullet(level, this.ghast);
                  			magicBullet.setPos(this.ghast.getX(), this.ghast.getY(0.5D) + 0.5D, this.ghast.getZ());
                  			magicBullet.shoot(d2, d3, d4, 2, 0);
                  			level.addFreshEntity(magicBullet);
                  			continue;
                  		}
                  		if (this.Charge_Time == 60) {
                  			this.Charge_Time = 0;
                  		}
               		}
            	} else if (this.Charge_Time > 0) {
               		--this.Charge_Time;
            	}
            this.ghast.setCharging(this.Charge_Time > 10);
         	}
      	}
   	}

   	static class ScreamingGhastShootGravityBombGoal extends Goal {
   		private final ScreamingGhastEntity ghast;
   		public int Charge_Times;

   		public ScreamingGhastShootGravityBombGoal(ScreamingGhastEntity ghast) {
   			this.ghast = ghast;
   		}

   		public boolean canUse() {
         	return (this.ghast.getTarget() != null) && !(this.ghast.isIntensiveBombing());
      	}

      	public void start() {
         	this.Charge_Times = 100;
      	}

      	public void stop() {
         	this.ghast.setCharging(false);
      	}

      	public void tick() {
         	LivingEntity livingentity = this.ghast.getTarget();
         	if (livingentity != null) {
            	double d0 = 100.0D;
            	if (livingentity.distanceToSqr(this.ghast) < 4096.0D) {
               		Level level = this.ghast.level;
               		++this.Charge_Times;
               		if (this.Charge_Times == 200) {
                  		double d1 = 4.0D;
                  		Vec3 vec3 = this.ghast.getViewVector(1.0F);
                  		double d2 = livingentity.getX() - (this.ghast.getX() + vec3.x * 4.0D);
                  		double d3 = livingentity.getY(0.5D) - (0.5D + this.ghast.getY(0.5D));
                  		double d4 = livingentity.getZ() - (this.ghast.getZ() + vec3.z * 4.0D);
                  		if (!this.ghast.isSilent()) {
                     		level.levelEvent((Player)null, 1016, this.ghast.blockPosition(), 0);
                  		}
                  		if (this.ghast.HalfHealth()) {
                  			ScreamingGhastGravityBomb gravityBomb = new ScreamingGhastGravityBomb(ProjectileInit.SCREAMING_GHAST_GRAVITY_BOMB.get(), level, this.ghast, true);
                  			gravityBomb.setPos(this.ghast.getX(), this.ghast.getY(0.5D) + 0.5D, this.ghast.getZ());
                  			gravityBomb.shoot(d2, d3, d4, 2, 0);
                  			level.addFreshEntity(gravityBomb);
                  		} else {
                  			ScreamingGhastGravityBomb gravityBomb = new ScreamingGhastGravityBomb(ProjectileInit.SCREAMING_GHAST_GRAVITY_BOMB.get(), level, this.ghast);
                  			gravityBomb.setPos(this.ghast.getX(), this.ghast.getY(0.5D) + 0.5D, this.ghast.getZ());
                  			gravityBomb.shoot(d2, d3, d4, 2, 0);
                  			level.addFreshEntity(gravityBomb);
                  		}
                  		this.Charge_Times = 0;
               		}
            	} else if (this.Charge_Times > 0) {
               		--this.Charge_Times;
            	}
         	}
      	}
   	}

   	static class ScreamingGhastIntensiveBombingGoal extends Goal {
   		private final ScreamingGhastEntity ghast;
   		public int _Charge_Times;

   		public ScreamingGhastIntensiveBombingGoal(ScreamingGhastEntity ghast) {
   			this.ghast = ghast;
   		}

   		public boolean canUse() {
         	return (this.ghast.getTarget() != null) && this.ghast.HalfHealth();
      	}

      	public void start() {
         	this._Charge_Times = 400;
         	this.ghast.getNavigation().stop();
      	}

      	public void tick() {
         	LivingEntity livingentity = this.ghast.getTarget();
         	if (livingentity != null) {
            	double d0 = 100.0D;
            	if (livingentity.distanceToSqr(this.ghast) < 4096.0D) {
               		Level level = this.ghast.level;
               		++this._Charge_Times;
               		if (this._Charge_Times >= 600) {
               			this.ghast.setIntensiveBombing(true);
               			this.ghast.setCharging(true);
               			Vec3 vec3 = this.ghast.getDeltaMovement();
               			this.ghast.push(-vec3.x, -vec3.y, -vec3.z);
               		}
               		if (this._Charge_Times == 800 || this._Charge_Times == 840 || this._Charge_Times == 880 || this._Charge_Times == 920) {
                  		double d1 = 4.0D;
                  		Vec3 vec3 = this.ghast.getViewVector(1.0F);
                  		double d2 = livingentity.getX() - (this.ghast.getX() + vec3.x * 4.0D);
                  		double d3 = livingentity.getY(0.5D) - (0.5D + this.ghast.getY(0.5D));
                  		double d4 = livingentity.getZ() - (this.ghast.getZ() + vec3.z * 4.0D);
                  		if (!this.ghast.isSilent()) {
                     		level.levelEvent((Player)null, 1016, this.ghast.blockPosition(), 0);
                  		}
                  		for (int i = 0;i < 5;i++) {
                  			ScreamingGhastMagicBullet magicBullet = new ScreamingGhastMagicBullet(level, this.ghast);
                  			magicBullet.setPos(this.ghast.getX(), this.ghast.getY(0.5D) + 0.5D, this.ghast.getZ());
                  			magicBullet.shoot(d2, d3, d4, 2, 0);
                  			ScreamingGhastFirball largefireball = new ScreamingGhastFirball(ProjectileInit.SCREAMING_GHAST_FIRBALL.get(), level, this.ghast, d2, d3, d4, this.ghast.getExplosionPower());
                  			largefireball.setPos(this.ghast.getX() + vec3.x * 4.0D, this.ghast.getY(0.5D) + 0.5D, largefireball.getZ() + vec3.z * 4.0D);
                  			level.addFreshEntity(magicBullet);
                  			level.addFreshEntity(largefireball);
                  			continue;
                  		}
               		}

               		if (this._Charge_Times >= 930) {
                  		this.ghast.setIntensiveBombing(false);
               			this.ghast.setCharging(false);
               			this._Charge_Times = 0;
                  	}
            	} else if (this._Charge_Times > 0) {
               		--this._Charge_Times;
            	}
         	} else {
         		this.ghast.setIntensiveBombing(false);
         		this._Charge_Times = 0;
         	}
      	}
   	}

   	static class ScreamingGhastApproachingTargetGoal extends Goal {
   		private final ScreamingGhastEntity ghast;

   		public ScreamingGhastApproachingTargetGoal(ScreamingGhastEntity ghast) {
   			this.ghast = ghast;
   			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
   		}

   		public boolean canUse() {
			if (this.ghast.getTarget() != null && !this.ghast.getMoveControl().hasWanted() && !(this.ghast.isIntensiveBombing())) {
				return true;
			} else {
				return false;
			}
		}

		public boolean canContinueToUse() {
			return this.ghast.getMoveControl().hasWanted() && this.ghast.getTarget() != null && this.ghast.getTarget().isAlive() && !(this.ghast.isIntensiveBombing());
		}

		public void start() {
			LivingEntity livingentity = this.ghast.getTarget();
			Vec3 vec3d = livingentity.getEyePosition(1);
			this.ghast.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.2);
		}

		public void tick() {
			LivingEntity livingentity = this.ghast.getTarget();
			double d0 = this.ghast.distanceToSqr(livingentity);
			if (d0 < 320 && d0 > 32) {
				Vec3 vec3d = livingentity.getEyePosition(1);
				this.ghast.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.2);
			}
		}
   	}
}