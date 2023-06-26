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

public class EnderDragonWindBomb extends AbstractHurtingProjectile {

   public EnderDragonWindBomb(EntityType<? extends EnderDragonWindBomb> p_36892_, Level p_36893_) {
      super(p_36892_, p_36893_);
   }

   public EnderDragonWindBomb(EntityType<? extends EnderDragonWindBomb> p_36892_, Level p_36903_, LivingEntity p_36904_, double p_36905_, double p_36906_, double p_36907_) {
      super(p_36892_, p_36904_, p_36905_, p_36906_, p_36907_, p_36903_);
   }

   public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
<<<<<<< Updated upstream
		boolean flag = this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING);
       	this.level.explode(this.getOwner(), this.getX(), this.getY(), this.getZ(), (float)15.0F, false, flag ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE);
       	if (entityHitResult.getEntity() instanceof LivingEntity _entity)
       	if (this.getOwner() != null) {
       		_entity.hurt(new EntityDamageSource("ender_dragon_wind_bomb", this.getOwner()).bypassMagic().bypassEnchantments().bypassInvul().bypassArmor(), Float.MAX_VALUE);
       	} else {
       		_entity.hurt(new EntityDamageSource("ender_dragon_wind_bomb", _entity).bypassMagic().bypassEnchantments().bypassInvul().bypassArmor(), Float.MAX_VALUE);
       	}
       	entityHitResult.getEntity().setDeltaMovement(new Vec3(0, 2, 0));
       	this.discard();
=======
		if (!this.level.isClientSide) {
			boolean flag = this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING);
       		this.level.explode(this.getOwner(), this.getX(), this.getY(), this.getZ(), (float)15.0F, false, flag ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE);
       		if (entityHitResult.getEntity() instanceof LivingEntity _entity)
       		if (this.getOwner() != null) {
       			_entity.hurt(new EntityDamageSource("ender_dragon_wind_bomb", this.getOwner()).bypassMagic().bypassEnchantments().bypassInvul().bypassArmor(), Float.MAX_VALUE);
       		} else {
       			_entity.hurt(new EntityDamageSource("ender_dragon_wind_bomb", this).bypassMagic().bypassEnchantments().bypassInvul().bypassArmor(), Float.MAX_VALUE);
       		}
       		entityHitResult.getEntity().setDeltaMovement(new Vec3(0, 2, 0));
       		this.discard();
		}
>>>>>>> Stashed changes
   }

	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		boolean flag = this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING);
		this.level.explode(this.getOwner(), this.getX(), this.getY(), this.getZ(), (float)15.0F, false, flag ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE);
		this.discard();
	}

   public boolean isPickable() {
      return true;
   }

   protected boolean shouldBurn() {
      return false;
   }

   protected ParticleOptions getTrailParticle() {
      return ParticleTypes.CLOUD;
   }

   public boolean isPushable() {
		return false;
   }

   protected float getInertia() {
      return 0.98F;
   }
}