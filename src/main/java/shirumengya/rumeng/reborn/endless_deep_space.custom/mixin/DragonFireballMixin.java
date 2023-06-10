package shirumengya.rumeng.reborn.endless_deep_space.custom.mixin;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.*;
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
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import shirumengya.rumeng.reborn.endless_deep_space.init.*;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;

@Mixin(DragonFireball.class)
public class DragonFireballMixin extends AbstractHurtingProjectile {

	public DragonFireballMixin(EntityType<? extends DragonFireball> p_36892_, Level p_36893_) {
      	super(p_36892_, p_36893_);
   	}

	@Overwrite
	protected void onHit(HitResult p_36913_) {
      super.onHit(p_36913_);
      if (p_36913_.getType() != HitResult.Type.ENTITY || !this.ownedBy(((EntityHitResult)p_36913_).getEntity())) {
         if (!this.level.isClientSide) {
            List<LivingEntity> list = this.level.getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(4.0D, 2.0D, 4.0D));
            AreaEffectCloud areaeffectcloud = new AreaEffectCloud(this.level, this.getX(), this.getY(), this.getZ());
            Entity entity = this.getOwner();
            if (entity instanceof LivingEntity) {
               areaeffectcloud.setOwner((LivingEntity)entity);
            }
            areaeffectcloud.setParticle(ParticleTypes.DRAGON_BREATH);
            areaeffectcloud.setRadius(10.0F);
            areaeffectcloud.setDuration(1200);
            areaeffectcloud.setRadiusPerTick((7.0F - areaeffectcloud.getRadius()) / (float)areaeffectcloud.getDuration());
            areaeffectcloud.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 1));
            areaeffectcloud.addEffect(new MobEffectInstance(EndlessDeepSpaceModMobEffects.NAUSEA.get(), 10, 1));
            if (!list.isEmpty()) {
               for(LivingEntity livingentity : list) {
                  double d0 = this.distanceToSqr(livingentity);
                  if (d0 < 20.0D) {
                     areaeffectcloud.setPos(livingentity.getX(), livingentity.getY(), livingentity.getZ());
                     break;
                  }
               }
            }
            this.level.levelEvent(2006, this.blockPosition(), this.isSilent() ? -1 : 1);
            this.level.addFreshEntity(areaeffectcloud);
            boolean flag = this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING);
         	this.level.explode(entity, this.getX(), this.getY(), this.getZ(), (float)10.0F, flag, flag ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE);
            this.discard();
         }
      }
   }

	@Overwrite
   	protected boolean shouldBurn() {
      	return true;
   	}

	@Overwrite
   	public boolean isPickable() {
      	return true;
   	}

	@Overwrite
   	public boolean hurt(DamageSource p_36839_, float p_36840_) {
   		return true;
   	}
}
