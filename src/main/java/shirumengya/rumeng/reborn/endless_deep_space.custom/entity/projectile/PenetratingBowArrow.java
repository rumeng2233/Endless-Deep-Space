package shirumengya.rumeng.reborn.endless_deep_space.custom.entity.projectile;

import java.util.List;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.nbt.CompoundTag;

public class PenetratingBowArrow extends AbstractHurtingProjectile {

   public PenetratingBowArrow(EntityType<? extends PenetratingBowArrow> p_36892_, Level p_36893_) {
      super(p_36892_, p_36893_);
   }

   public PenetratingBowArrow(EntityType<? extends PenetratingBowArrow> p_36892_, Level p_36903_, LivingEntity p_36904_, double p_36905_, double p_36906_, double p_36907_) {
      super(p_36892_, p_36904_, p_36905_, p_36906_, p_36907_, p_36903_);
   }

   	public void tick() {
   		super.tick();
   		int life = 0;
   		++life;
   		if (life >= 400) {
   			this.discard();
   		}
   	}

   public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		entityHitResult.getEntity().invulnerableTime = 0;
       	if (this.getOwner() != null) {
       		entityHitResult.getEntity().hurt(new EntityDamageSource("arrow", this.getOwner()).bypassMagic().bypassEnchantments().bypassArmor().bypassInvul(), 20.0F);
       	} else {
       		entityHitResult.getEntity().hurt(new EntityDamageSource("arrow", this).bypassMagic().bypassEnchantments().bypassArmor().bypassInvul(), 20.0F);
       	}
   }

	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
	}

   public boolean isPickable() {
      return true;
   }

   protected boolean shouldBurn() {
      return false;
   }

   protected ParticleOptions getTrailParticle() {
      return ParticleTypes.CRIT;
   }

   public boolean isPushable() {
		return false;
   }

   protected float getInertia() {
      return 1.0F;
   }
}