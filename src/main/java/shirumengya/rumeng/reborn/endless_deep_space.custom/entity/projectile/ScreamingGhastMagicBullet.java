package shirumengya.rumeng.reborn.endless_deep_space.custom.entity.projectile;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import shirumengya.rumeng.reborn.endless_deep_space.custom.world.damagesource.EndlessDeepSpaceDamageSource;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Explosion;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.entity.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.entity.projectile.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.*;
import net.minecraft.world.scores.Team;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.Mob;

public class ScreamingGhastMagicBullet extends AbstractHurtingProjectile {

   	private float maxTurningAngleCos;
    private float maxTurningAngleSin;

   	public ScreamingGhastMagicBullet(Level p_37320_, LivingEntity p_37331_) {
   		this(ProjectileInit.SCREAMING_GHAST_MAGIC_BULLET.get(), p_37320_);
   		this.noPhysics = true;
   		this.noCulling = true;
   		this.setOwner(p_37331_);
   	}

   	public ScreamingGhastMagicBullet(EntityType<? extends ScreamingGhastMagicBullet> p_37319_, Level p_37320_) {
   		super(p_37319_, p_37320_);
   		this.noPhysics = true;
   		this.noCulling = true;
   	}

   	public SoundSource getSoundSource() {
      	return SoundSource.HOSTILE;
   	}

   	protected float getInertia() {
      	return 1.0F;
   	}

   	public int getTeamColor() {
      	Team team = this.getTeam();
      	return team != null && team.getColor().getColor() != null ? team.getColor().getColor() : 5636095;
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
     	} else {
     		Vec3 vec31 = this.getDeltaMovement();
     		this.level.addParticle(ParticleTypes.END_ROD, this.getX() - vec31.x, this.getY() - vec31.y + 0.15D, this.getZ() - vec31.z, 0.0D, 0.0D, 0.0D);
     	}
   	}

   	public boolean isOnFire() {
      	return false;
   	}

   	protected void onHitEntity(EntityHitResult p_37345_) {
      	super.onHitEntity(p_37345_);
      	if (!this.level.isClientSide && p_37345_.getEntity() != this.getOwner() && !(p_37345_.getEntity() instanceof ScreamingGhastPart)) {
      		Entity entity = p_37345_.getEntity();
      		Entity entity1 = this.getOwner();
      		LivingEntity livingentity = entity1 instanceof LivingEntity ? (LivingEntity)entity1 : null;
      		entity.invulnerableTime = 0;
      		if (entity1 == null) {
      			entity.hurt(EndlessDeepSpaceDamageSource.ScreamingGhastFirball(this), 16.0F);
      		} else {
      			entity.hurt(EndlessDeepSpaceDamageSource.ScreamingGhastFirball(entity1), 16.0F);
      		}
      		if (entity1 instanceof LivingEntity) {
         		this.doEnchantDamageEffects(livingentity, entity);
         		if (entity instanceof LivingEntity) {
            		((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 4), MoreObjects.firstNonNull(entity1, this));
            		((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffectInit.DAMAGE_INCREASE.get(), 800, 4), MoreObjects.firstNonNull(entity1, this));
         		}
      		}
      		/*if (entity instanceof Mob && entity1 instanceof LivingEntity) {
         		((Mob)entity).setTarget(((LivingEntity)entity1));
         	}
         	if (entity1 instanceof Mob && entity instanceof LivingEntity) {
         		((Mob)entity1).setTarget(((LivingEntity)entity));
         	}*/
      		boolean flag1 = this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING);
      		this.level.explode(this.getOwner(), this.getX(), this.getY(), this.getZ(), 6.0F, flag1, flag1 ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE);
      		this.discard();
      	}
   	}

   	protected ParticleOptions getTrailParticle() {
      	return ParticleTypes.END_ROD;
   	}

   	protected void onHitBlock(BlockHitResult p_37343_) {
      	super.onHitBlock(p_37343_);
      	if (!this.level.isClientSide) {
      		boolean flag = this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING);
      		this.level.explode(this.getOwner(), this.getX(), this.getY(), this.getZ(), 6.0F, flag, flag ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE);
      		this.discard();
      	}
   	}

   	public boolean isPickable() {
      	return false;
   	}

   	public boolean hurt(DamageSource p_37338_, float p_37339_) {
      	return false;
   	}
}
