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

public class ScreamingGhastGravityBomb extends ThrowableProjectile {
	
	private boolean isStart = false;
	private int timer = 0;
    private float maxTurningAngleCos;
    private float maxTurningAngleSin;

    public ScreamingGhastGravityBomb(EntityType<? extends ScreamingGhastGravityBomb> p_37319_, Level p_37320_) {
    	super(p_37319_, p_37320_);
    }

    public ScreamingGhastGravityBomb(EntityType<? extends ScreamingGhastGravityBomb> p_37319_, Level p_37320_, Entity owner) {
    	super(p_37319_, p_37320_);
    	this.setOwner(owner);
    }

    @Override
    protected void defineSynchedData() {
    }

    public int getTeamColor() {
      	Team team = this.getTeam();
      	return team != null && team.getColor().getColor() != null ? team.getColor().getColor() : 14448122;
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
        	if (isStart) {
        		this.push(-vec3.x, -vec3.y, -vec3.z);
        		this.setNoGravity(true);
        		timer++;
        		if (timer == 10) {
        			boolean flag = this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING);
      				this.level.explode(this.getOwner(), this.getX(), this.getY(), this.getZ(), 8.0F, flag, flag ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE);
        		}
        		if (timer >= 20 && timer <= 220) {
        			((ServerLevel) level).sendParticles(ParticleTypes.DRAGON_BREATH, this.getX(), this.getY(), this.getZ(), 40, 0, 0, 0, 0.08);
        			TrackingUtil.forceEffect(this, Entity.class, 40.0D, 40.0D, 40.0D);
        		}
        		if (timer == 230) {
        			boolean flag = this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING);
      				this.level.explode(this.getOwner(), this.getX(), this.getY(), this.getZ(), 18.0F, flag, flag ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE);
        		}
        		if (timer >= 240) {
        			((ServerLevel) level).sendParticles(ParticleTypes.DRAGON_BREATH, this.getX(), this.getY(), this.getZ(), 200, 0, 0, 0, 0.6);
        			this.discard();
        		}
        	} else {
        		TrackingUtil.TrackingEntity(this, maxTurningAngleCos, maxTurningAngleSin, false);
        	}
     	}
   	}

   	protected void onHitEntity(EntityHitResult p_37345_) {
      	super.onHitEntity(p_37345_);
      	if (!this.level.isClientSide && p_37345_.getEntity() != this.getOwner() && !(p_37345_.getEntity() instanceof ScreamingGhastPart)) {
      		isStart = true;
      	}
   	}

   	protected void onHitBlock(BlockHitResult p_37343_) {
      	super.onHitBlock(p_37343_);
      	if (!this.level.isClientSide) {
      		isStart = true;
      	}
   	}

   	public boolean isPickable() {
      	return false;
   	}

   	public boolean hurt(DamageSource p_37338_, float p_37339_) {
      	return false;
   	}

   	protected float getGravity() {
      return 0.03F;
   }
}
