package shirumengya.rumeng.reborn.endless_deep_space.custom.mixin;

import com.google.common.collect.ImmutableList;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PowerableMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.world.entity.boss.wither.WitherBoss;

@Mixin(WitherBoss.class)
public class WitherBossMixin extends Monster implements PowerableMob, RangedAttackMob {
	private static final EntityDataAccessor<Float> Data_Shield = SynchedEntityData.defineId(WitherBoss.class, EntityDataSerializers.FLOAT);
	private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
      return p_31504_.getMobType() != MobType.UNDEAD && p_31504_.attackable();
   	};

//@Final
@Shadow
ServerBossEvent bossEvent;
int destroyBlocksTick;
int[] idleHeadUpdates;
int[] nextHeadUpdate;

private static TargetingConditions TARGETING_CONDITIONS;

	public WitherBossMixin(EntityType<? extends WitherBoss> p_31096_, Level p_31097_) {
      super(EntityType.WITHER, p_31097_);
   	}

	@Inject(method = {"defineSynchedData"}, at = {@At("HEAD")}, cancellable = true)
	protected void defineSynchedData(CallbackInfo info) {
	WitherBoss boss = ((WitherBoss)(Object)this);
      	boss.getEntityData().define(Data_Shield, (float)0.0);
   	}

   	@Inject(method = {"addAdditionalSaveData"}, at = {@At("HEAD")}, cancellable = true)
	protected void addAdditionalSaveData(CompoundTag p_31062_, CallbackInfo info) {
      p_31062_.putFloat("Shield", this.getShield());
   	}

   	@Inject(method = {"readAdditionalSaveData"}, at = {@At("HEAD")}, cancellable = true)
   	protected void readAdditionalSaveData(CompoundTag p_31055_, CallbackInfo info) {
    	this.setShield(p_31055_.getFloat("Shield"));
   	}

	@Overwrite
   public boolean hurt(DamageSource p_31461_, float p_31462_) {
   if (this.nextHeadUpdate == null) this.nextHeadUpdate = new int[2];
   if (this.idleHeadUpdates == null) this.idleHeadUpdates = new int[2];
   	WitherBoss boss = ((WitherBoss)(Object)this);
      if (boss.isInvulnerableTo(p_31461_)) {
         return false;
      } else if (this.getShield() > 0) {
         if (!(p_31461_.getEntity() instanceof WitherBoss)) {
            this.setShield(this.getShield() - p_31462_);
         }
         return false;
      } else if (p_31461_ != DamageSource.DROWN && !(p_31461_.getEntity() instanceof WitherBoss)) {
         if (boss.getInvulnerableTicks() > 0 && p_31461_ != DamageSource.OUT_OF_WORLD) {
            return false;
         } else {
            if (boss.isPowered()) {
               Entity entity = p_31461_.getDirectEntity();
               if (entity instanceof AbstractArrow) {
                  return false;
               }
            }

            Entity entity1 = p_31461_.getEntity();
            if (entity1 != null && !(entity1 instanceof Player) && entity1 instanceof LivingEntity && ((LivingEntity)entity1).getMobType() == boss.getMobType()) {
               return false;
            } else {
               if (this.destroyBlocksTick <= 0) {
                  this.destroyBlocksTick = 20;
               }

               for(int i = 0; i < this.idleHeadUpdates.length; ++i) {
                  this.idleHeadUpdates[i] += 3;
               }

               return super.hurt(p_31461_, p_31462_);
            }
         }
      } else {
         return false;
      }
   }

	@Overwrite
      protected void customServerAiStep() {
      	if (this.nextHeadUpdate == null) this.nextHeadUpdate = new int[2];
      	if (this.idleHeadUpdates == null) this.idleHeadUpdates = new int[2];
      	if (this.TARGETING_CONDITIONS == null) this.TARGETING_CONDITIONS = TargetingConditions.forCombat().range(20.0D).selector(LIVING_ENTITY_SELECTOR);
      	WitherBoss boss = ((WitherBoss)(Object)this);
      if (boss.getInvulnerableTicks() > 0) {
         int k1 = boss.getInvulnerableTicks() - 1;
         this.bossEvent.setProgress(1.0F - (float)k1 / 220.0F);
         this.bossEvent.setColor(BossEvent.BossBarColor.BLUE);
         if (k1 <= 0) {
            Explosion.BlockInteraction explosion$blockinteraction = boss.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
            boss.level.explode(boss, boss.getX(), boss.getEyeY(), boss.getZ(), 10.0F, true, explosion$blockinteraction);
            if (!boss.isSilent()) {
               boss.level.globalLevelEvent(1023, boss.blockPosition(), 0);
            }
         }

         boss.setInvulnerableTicks(k1);
         this.setShield(600);
         if (boss.tickCount % 10 == 0) {
            boss.heal(10.0F);
         }

      } else {
         super.customServerAiStep();

         if (this.getShield() <= 0) {
            this.setShield(0);
            if (boss.isPowered()) {
               this.bossEvent.setColor(BossEvent.BossBarColor.PURPLE);
               this.bossEvent.setCreateWorldFog(true);
            } else {
               this.bossEvent.setColor(BossEvent.BossBarColor.PINK);
               this.bossEvent.setCreateWorldFog(false);
            }
            this.bossEvent.setProgress(boss.getHealth() / boss.getMaxHealth());
            this.bossEvent.setDarkenScreen(true);
         } else {
            if (this.getShield() <= 150) {
               this.bossEvent.setColor(BossEvent.BossBarColor.RED);
            } else if (this.getShield() <= 300) {
               this.bossEvent.setColor(BossEvent.BossBarColor.YELLOW);
            } else  if (this.getShield() <= 450){
               this.bossEvent.setColor(BossEvent.BossBarColor.GREEN);
            } else {
               this.bossEvent.setColor(BossEvent.BossBarColor.WHITE);
            }
            this.bossEvent.setProgress(this.getShield() / 600.0F);
            this.bossEvent.setDarkenScreen(false);
         }

         for(int i = 1; i < 3; ++i) {
            if (boss.tickCount >= this.nextHeadUpdate[i - 1]) {
               this.nextHeadUpdate[i - 1] = boss.tickCount + 10 + this.random.nextInt(10);
               if (boss.level.getDifficulty() == Difficulty.NORMAL || this.level.getDifficulty() == Difficulty.HARD) {
                  int i3 = i - 1;
                  int j3 = this.idleHeadUpdates[i - 1];
                  this.idleHeadUpdates[i3] = this.idleHeadUpdates[i - 1] + 1;
                  if (j3 > 15) {
                     float f = 10.0F;
                     float f1 = 5.0F;
                     double d0 = Mth.nextDouble(this.random, boss.getX() - 10.0D, boss.getX() + 10.0D);
                     double d1 = Mth.nextDouble(this.random, boss.getY() - 5.0D, boss.getY() + 5.0D);
                     double d2 = Mth.nextDouble(this.random, boss.getZ() - 10.0D, boss.getZ() + 10.0D);
                     this.performRangedAttack(i + 1, d0, d1, d2, true);
                     this.idleHeadUpdates[i - 1] = 0;
                  }
               }

               int l1 = boss.getAlternativeTarget(i);
               if (l1 > 0) {
                  LivingEntity livingentity = (LivingEntity)boss.level.getEntity(l1);
                  if (livingentity != null && boss.canAttack(livingentity) && !(boss.distanceToSqr(livingentity) > 900.0D) && boss.hasLineOfSight(livingentity)) {
                     this.performRangedAttack(i + 1, livingentity);
                     this.nextHeadUpdate[i - 1] = boss.tickCount + 40 + this.random.nextInt(20);
                     this.idleHeadUpdates[i - 1] = 0;
                  } else {
                     boss.setAlternativeTarget(i, 0);
                  }
               } else {
                  List<LivingEntity> list = boss.level.getNearbyEntities(LivingEntity.class, TARGETING_CONDITIONS, boss, boss.getBoundingBox().inflate(20.0D, 8.0D, 20.0D));
                  if (!list.isEmpty()) {
                     LivingEntity livingentity1 = list.get(this.random.nextInt(list.size()));
                     boss.setAlternativeTarget(i, livingentity1.getId());
                  }
               }
            }
         }

         if (boss.getTarget() != null) {
            boss.setAlternativeTarget(0, boss.getTarget().getId());
         } else {
            boss.setAlternativeTarget(0, 0);
         }

         if (this.destroyBlocksTick > 0) {
            --this.destroyBlocksTick;
            if (this.destroyBlocksTick == 0 && boss.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
               int j1 = Mth.floor(boss.getY());
               int i2 = Mth.floor(boss.getX());
               int j2 = Mth.floor(boss.getZ());
               boolean flag = false;

               for(int j = -1; j <= 1; ++j) {
                  for(int k2 = -1; k2 <= 1; ++k2) {
                     for(int k = 0; k <= 3; ++k) {
                        int l2 = i2 + j;
                        int l = j1 + k;
                        int i1 = j2 + k2;
                        BlockPos blockpos = new BlockPos(l2, l, i1);
                        BlockState blockstate = boss.level.getBlockState(blockpos);
                        if (boss.canDestroy(blockstate)) {
                           flag = boss.level.destroyBlock(blockpos, true, boss) || flag;
                        }
                     }
                  }
               }

               if (flag) {
                  boss.level.levelEvent((Player)null, 1022, boss.blockPosition(), 0);
               }
            }
         }

         if (boss.tickCount % 20 == 0) {
            boss.heal(2.0F);
         }


      }
   }

	@Overwrite
      private void performRangedAttack(int p_31458_, LivingEntity p_31459_) {
      this.performRangedAttack(p_31458_, p_31459_.getX(), p_31459_.getY() + (double)p_31459_.getEyeHeight() * 0.5D, p_31459_.getZ(), p_31458_ == 0 && this.random.nextFloat() < 0.001F);
   }

	@Overwrite
   private void performRangedAttack(int p_31449_, double p_31450_, double p_31451_, double p_31452_, boolean p_31453_) {
   	WitherBoss boss = ((WitherBoss)(Object)this);
      if (!boss.isSilent()) {
         boss.level.levelEvent((Player)null, 1024, boss.blockPosition(), 0);
      }

      double d0 = this.getHeadX(p_31449_);
      double d1 = this.getHeadY(p_31449_);
      double d2 = this.getHeadZ(p_31449_);
      double d3 = p_31450_ - d0;
      double d4 = p_31451_ - d1;
      double d5 = p_31452_ - d2;
      WitherSkull witherskull = new WitherSkull(boss.level, boss, d3, d4, d5);
      witherskull.setOwner(boss);
      WitherSkull witherskull1 = new WitherSkull(boss.level, boss, d3, d4, d5);
      WitherSkull witherskull2 = new WitherSkull(boss.level, boss, d3, d4, d5);
      WitherSkull witherskull3 = new WitherSkull(boss.level, boss, d3, d4, d5);
      witherskull1.setOwner(boss);
      witherskull2.setOwner(boss);
      witherskull3.setOwner(boss);
      witherskull1.setDangerous(true);
      witherskull2.setDangerous(true);
      if (p_31453_) {
         witherskull.setDangerous(true);
      }

      witherskull.setPosRaw(d0, d1, d2);
      witherskull1.setPosRaw(d0, d1, d2);
      witherskull2.setPosRaw(d0, d1, d2);
      witherskull3.setPosRaw(d0, d1, d2);
      this.level.addFreshEntity(witherskull);
      this.level.addFreshEntity(witherskull1);
      this.level.addFreshEntity(witherskull2);
      this.level.addFreshEntity(witherskull3);
   }

	@Overwrite
   public void performRangedAttack(LivingEntity p_31468_, float p_31469_) {
      this.performRangedAttack(0, p_31468_);
   }

	@Overwrite
      private double getHeadX(int p_31515_) {
      	WitherBoss boss = ((WitherBoss)(Object)this);
      if (p_31515_ <= 0) {
         return boss.getX();
      } else {
         float f = (boss.yBodyRot + (float)(180 * (p_31515_ - 1))) * ((float)Math.PI / 180F);
         float f1 = Mth.cos(f);
         return boss.getX() + (double)f1 * 1.3D;
      }
   }

	@Overwrite
   private double getHeadY(int p_31517_) {
   	WitherBoss boss = ((WitherBoss)(Object)this);
      return p_31517_ <= 0 ? boss.getY() + 3.0D : boss.getY() + 2.2D;
   }

	@Overwrite
   private double getHeadZ(int p_31519_) {
   	WitherBoss boss = ((WitherBoss)(Object)this);
      if (p_31519_ <= 0) {
         return boss.getZ();
      } else {
         float f = (boss.yBodyRot + (float)(180 * (p_31519_ - 1))) * ((float)Math.PI / 180F);
         float f1 = Mth.sin(f);
         return boss.getZ() + (double)f1 * 1.3D;
      }
   }

   	public void die(DamageSource source) {
   		if ((this.getHealth() <= 0) && (this.getShield() <= 0)) {
   			super.die(source);
			this.bossEvent.setProgress(0.0F);
   		}
	}

	@Overwrite
   	public boolean isPowered() {
   		return (this.getHealth() <= this.getMaxHealth() / 2.0F && this.getShield() <= 0.0F);
   	}

   	public boolean isDeadOrDying() {
      return this.getHealth() <= 0.0F && this.getShield() <= 0.0F;
   	}

   	public void kill() {
   		this.setShield(0.0F);
   		this.setHealth(0.0F);
   		this.bossEvent.setProgress(0.0F);
   	}

   	public float getShield() {
   		WitherBoss boss = ((WitherBoss)(Object)this);
      	return boss.getEntityData().get(Data_Shield);
   	}

   	public void setShield(float p_31511_) {
   		WitherBoss boss = ((WitherBoss)(Object)this);
      	boss.getEntityData().set(Data_Shield, p_31511_);
   	}

}
