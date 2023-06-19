
package shirumengya.rumeng.reborn.endless_deep_space.entity;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModEntities;

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

public class ScreamingGhastEntity extends Ghast {

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

	public ScreamingGhastEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(EndlessDeepSpaceModEntities.SCREAMING_GHAST.get(), world);
	}

	public ScreamingGhastEntity(EntityType<ScreamingGhastEntity> type, Level world) {
		super(type, world);
		xpReward = 300;
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
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
      	this.goalSelector.addGoal(5, new ScreamingGhastEntity.RandomFloatAroundGoal(this));
      	this.goalSelector.addGoal(7, new ScreamingGhastEntity.GhastLookGoal(this));
      	this.goalSelector.addGoal(7, new ScreamingGhastEntity.GhastShootFireballGoal(this));
      	this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, LivingEntity.class, false, false));
   	}

	public int getExplosionPower() {
      return 8;
   	}

	public static void init() {
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 500);
		builder = builder.add(Attributes.ARMOR, 20);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 30);
		builder = builder.add(Attributes.FOLLOW_RANGE, 1000);
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
		source.getDirectEntity() instanceof AreaEffectCloud) {
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
		if (this.getHealth() <= this.getMaxHealth() / 2) {
			this.bossInfo.setColor(BossEvent.BossBarColor.RED);
		} else {
			this.bossInfo.setColor(BossEvent.BossBarColor.WHITE);
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
      private final Ghast ghast;
      private int floatDuration;

      public GhastMoveControl(Ghast p_32768_) {
         super(p_32768_);
         this.ghast = p_32768_;
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
      private final Ghast ghast;
      public int chargeTime;

      public GhastShootFireballGoal(Ghast p_32776_) {
         this.ghast = p_32776_;
      }

      public boolean canUse() {
         return this.ghast.getTarget() != null;
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
            double d0 = 64.0D;
            if (livingentity.distanceToSqr(this.ghast) < 4096.0D && this.ghast.hasLineOfSight(livingentity)) {
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
      private final Ghast ghast;

      public RandomFloatAroundGoal(Ghast p_32783_) {
         this.ghast = p_32783_;
         this.setFlags(EnumSet.of(Goal.Flag.MOVE));
      }

      public boolean canUse() {
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
      private final Ghast ghast;

      public GhastLookGoal(Ghast p_32762_) {
         this.ghast = p_32762_;
         this.setFlags(EnumSet.of(Goal.Flag.LOOK));
      }

      public boolean canUse() {
         return true;
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
}