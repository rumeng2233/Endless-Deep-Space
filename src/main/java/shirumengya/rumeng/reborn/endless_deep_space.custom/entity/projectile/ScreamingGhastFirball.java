package shirumengya.rumeng.reborn.endless_deep_space.custom.entity.projectile;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LightningBolt;
import shirumengya.rumeng.reborn.endless_deep_space.custom.world.damagesource.EndlessDeepSpaceDamageSource;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.entity.*;
import net.minecraft.world.scores.Team;
import net.minecraft.world.phys.Vec3;
import net.minecraft.util.Mth;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.*;

public class ScreamingGhastFirball extends Fireball {
	
	private int explosionPower = 8;
	private float maxTurningAngleCos;
	private float maxTurningAngleSin;

	public ScreamingGhastFirball(EntityType<? extends ScreamingGhastFirball> p_36892_, Level p_36893_) {
      	super(p_36892_, p_36893_);
   	}

   	public ScreamingGhastFirball(EntityType<? extends ScreamingGhastFirball> p_36892_, Level p_36903_, LivingEntity p_36904_, double p_36905_, double p_36906_, double p_36907_, int power) {
      	super(p_36892_, p_36904_, p_36905_, p_36906_, p_36907_, p_36903_);
      	this.explosionPower = power;
   	}

   	public int getTeamColor() {
      	Team team = this.getTeam();
      	return team != null && team.getColor().getColor() != null ? team.getColor().getColor() : 16733525;
   	}

   	public boolean isCurrentlyGlowing() {
      	return true;
   	}

   	public void tick() {
   		super.tick();
   		Vec3 vec3 = this.getDeltaMovement();
       	float v0 = (float) vec3.length();
    	this.maxTurningAngleCos = Mth.cos(7.1619724F * v0 * Mth.DEG_TO_RAD);
    	this.maxTurningAngleSin = Mth.sin(7.1619724F * v0 * Mth.DEG_TO_RAD);
    	if (!this.level.isClientSide) {
        	TrackingUtil.TrackingEntityOnAbstractHurtingProjectile(this, maxTurningAngleCos, maxTurningAngleSin, false);
     	}
   	}

   	protected void onHit(HitResult p_37218_) {
      	super.onHit(p_37218_);
      	if (!this.level.isClientSide) {
         	boolean flag = this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING);
         	this.level.explode(this.getOwner(), this.getX(), this.getY(), this.getZ(), (float)this.explosionPower, flag, flag ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE);
         	AreaEffectCloud areaeffectcloud = new AreaEffectCloud(this.level, this.getX(), this.getY(), this.getZ());
         	Entity entity = this.getOwner();
            if (entity instanceof LivingEntity) {
               	areaeffectcloud.setOwner((LivingEntity)entity);
            }
            areaeffectcloud.setRadius(4.0F);
            areaeffectcloud.setDuration(200);
            areaeffectcloud.addEffect(new MobEffectInstance(MobEffects.WITHER, 400, 4));
            areaeffectcloud.addEffect(new MobEffectInstance(MobEffectInit.DAMAGE_INCREASE.get(), 1600, 4));
            this.level.addFreshEntity(areaeffectcloud);
            LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level);
            lightningBolt.setPos(this.getX(), this.getY(), this.getZ());
            lightningBolt.setVisualOnly(false); 
            lightningBolt.setDamage(20.0F);
            this.level.addFreshEntity(lightningBolt);
         	this.discard();
      	}
   	}

   	protected void onHitEntity(EntityHitResult p_37216_) {
      	super.onHitEntity(p_37216_);
      	if (!this.level.isClientSide && p_37216_.getEntity() != this.getOwner() && !(p_37216_.getEntity() instanceof ScreamingGhastPart)) {
         	Entity entity = p_37216_.getEntity();
         	Entity entity1 = this.getOwner();
         	entity.invulnerableTime = 0;
         	entity.hurt(EndlessDeepSpaceDamageSource.ScreamingGhastFirball(entity1), 20.0F);
         	if (entity1 instanceof LivingEntity) {
            	this.doEnchantDamageEffects((LivingEntity)entity1, entity);
         	}
         	this.discard();
      	}
   	}

   	public void addAdditionalSaveData(CompoundTag p_37222_) {
      	super.addAdditionalSaveData(p_37222_);
      	p_37222_.putByte("ExplosionPower", (byte)this.explosionPower);
   	}

   	public void readAdditionalSaveData(CompoundTag p_37220_) {
      	super.readAdditionalSaveData(p_37220_);
      	if (p_37220_.contains("ExplosionPower", 99)) {
         	this.explosionPower = p_37220_.getByte("ExplosionPower");
      	}
   	}

   	protected float getInertia() {
      return 1.0F;
   	}

}
