package shirumengya.rumeng.reborn.endless_deep_space.custom.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.WitherSkull;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.*;

@Mixin(WitherSkull.class)
public class WitherSkullMixin extends AbstractHurtingProjectile {

   public WitherSkullMixin(EntityType<? extends WitherSkull> p_37598_, Level p_37599_) {
      super(p_37598_, p_37599_);
   }

   @Overwrite
   protected void onHitEntity(EntityHitResult p_37626_) {
   	WitherSkull skull = ((WitherSkull)(Object)this);
      super.onHitEntity(p_37626_);
      if (!skull.level.isClientSide) {
         Entity entity = p_37626_.getEntity();
         entity.invulnerableTime = 0;
         Entity entity1 = skull.getOwner();
         boolean flag;
         if (entity1 instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity)entity1;
            flag = entity.hurt(DamageSource.witherSkull(skull, livingentity), 10.0F);
            if (flag) {
               if (entity.isAlive()) {
                  skull.doEnchantDamageEffects(livingentity, entity);
               } else {
                  livingentity.heal(10.0F);
               }
            }
         } else {
            flag = entity.hurt(DamageSource.MAGIC, 10.0F);
         }

         if (flag && entity instanceof LivingEntity) {
            int i = 0;
            if (skull.level.getDifficulty() == Difficulty.NORMAL) {
               i = 10;
            } else if (skull.level.getDifficulty() == Difficulty.HARD) {
               i = 40;
            }

            if (i > 0) {
               ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.WITHER, 20 * i, 1), skull.getEffectSource());
               ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffectInit.DAMAGE_INCREASE.get(), 40 * i, 4), skull.getEffectSource());
            }
         }

      }
   	}

   @Overwrite
   protected float getInertia() {
      return 0.98F;
   }

}
