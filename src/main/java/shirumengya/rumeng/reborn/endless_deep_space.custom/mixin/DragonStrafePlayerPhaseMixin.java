package shirumengya.rumeng.reborn.endless_deep_space.custom.mixin;

import com.mojang.logging.LogUtils;
import javax.annotation.Nullable;
import net.minecraft.core.Vec3i;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.DragonFireball;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.projectile.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.entity.projectile.*;
import net.minecraft.world.entity.boss.enderdragon.phases.*;

@Mixin(DragonStrafePlayerPhase.class)
public class DragonStrafePlayerPhaseMixin extends AbstractDragonPhaseInstance {

private static final Logger LOGGER = LogUtils.getLogger();

@Shadow
boolean holdingPatternClockwise;
int fireballCharge;
Path currentPath;
LivingEntity attackTarget;
Vec3 targetLocation;

	public DragonStrafePlayerPhaseMixin(EnderDragon p_31357_) {
      super(p_31357_);
   	}

   	public EnderDragonPhase<DragonStrafePlayerPhase> getPhase() {
      return EnderDragonPhase.STRAFE_PLAYER;
   	}

	@Overwrite
	public void doServerTick() {
      if (this.attackTarget == null) {
         LOGGER.warn("Skipping player strafe phase because no player was found");
         this.dragon.getPhaseManager().setPhase(EnderDragonPhase.HOLDING_PATTERN);
      } else {
         if (this.currentPath != null && this.currentPath.isDone()) {
            double d0 = this.attackTarget.getX();
            double d1 = this.attackTarget.getZ();
            double d2 = d0 - this.dragon.getX();
            double d3 = d1 - this.dragon.getZ();
            double d4 = Math.sqrt(d2 * d2 + d3 * d3);
            double d5 = Math.min((double)0.4F + d4 / 80.0D - 1.0D, 10.0D);
            this.targetLocation = new Vec3(d0, this.attackTarget.getY() + d5, d1);
         }

         double d12 = this.targetLocation == null ? 0.0D : this.targetLocation.distanceToSqr(this.dragon.getX(), this.dragon.getY(), this.dragon.getZ());
         if (d12 < 100.0D || d12 > 22500.0D) {
            this.findNewTarget();
         }

         double d13 = 128.0D;
         if (this.attackTarget.distanceToSqr(this.dragon) < 512.0D) {
            if (this.dragon.hasLineOfSight(this.attackTarget)) {
               ++this.fireballCharge;
               Vec3 vec31 = (new Vec3(this.attackTarget.getX() - this.dragon.getX(), 0.0D, this.attackTarget.getZ() - this.dragon.getZ())).normalize();
               Vec3 vec3 = (new Vec3((double)Mth.sin(this.dragon.getYRot() * ((float)Math.PI / 180F)), 0.0D, (double)(-Mth.cos(this.dragon.getYRot() * ((float)Math.PI / 180F))))).normalize();
               float f1 = (float)vec3.dot(vec31);
               float f = (float)(Math.acos((double)f1) * (double)(180F / (float)Math.PI));
               f += 0.5F;
               if (this.fireballCharge >= 2 && f >= 0.0F && f < 10.0F) {
                  double d14 = 1.0D;
                  Vec3 vec32 = this.dragon.getViewVector(1.0F);
                  double d6 = this.dragon.head.getX() - vec32.x * 1.0D;
                  double d7 = this.dragon.head.getY(0.5D) + 0.5D;
                  double d8 = this.dragon.head.getZ() - vec32.z * 1.0D;
                  double d9 = this.attackTarget.getX() - d6;
                  double d10 = this.attackTarget.getY(0.5D) - d7;
                  double d11 = this.attackTarget.getZ() - d8;
                  if (!this.dragon.isSilent()) {
                     this.dragon.level.levelEvent((Player)null, 1017, this.dragon.blockPosition(), 0);
                  }

				  if (Math.random() < 0.4) {
				  DragonFireball dragonfireball = new DragonFireball(this.dragon.level, this.dragon, d9, d10, d11);
                  dragonfireball.moveTo(d6, d7, d8, 0.0F, 0.0F);
                  this.dragon.level.addFreshEntity(dragonfireball);
                  DragonFireball dragonfireball1 = new DragonFireball(this.dragon.level, this.dragon, d9, d10, d11);
                  dragonfireball1.moveTo(d6 + 1, d7, d8 + 1, 0.0F, 0.0F);
                  this.dragon.level.addFreshEntity(dragonfireball1);
                  DragonFireball dragonfireball2 = new DragonFireball(this.dragon.level, this.dragon, d9, d10, d11);
                  dragonfireball2.moveTo(d6 - 1, d7, d8 - 1, 0.0F, 0.0F);
                  this.dragon.level.addFreshEntity(dragonfireball2);
				  } else {
				  EnderDragonWindBomb dragonWindBomb = new EnderDragonWindBomb(ProjectileInit.ENDER_DRAGON_WIND_BOMB.get(), this.dragon.level, this.dragon, d9, d10, d11);
				  dragonWindBomb.moveTo(d6, d7, d8, 0.0F, 0.0F);
				  this.dragon.level.addFreshEntity(dragonWindBomb);
		          }
		          
                  this.fireballCharge = 0;
                  if (this.currentPath != null) {
                     while(!this.currentPath.isDone()) {
                        this.currentPath.advance();
                     }
                  }

                  this.dragon.getPhaseManager().setPhase(EnderDragonPhase.HOLDING_PATTERN);
               }
            } else if (this.fireballCharge > 0) {
               --this.fireballCharge;
            }
         } else if (this.fireballCharge > 0) {
            --this.fireballCharge;
         }

      }
   }

   @Overwrite
   private void findNewTarget() {
      if (this.currentPath == null || this.currentPath.isDone()) {
         int i = this.dragon.findClosestNode();
         int j = i;
         if (this.dragon.getRandom().nextInt(8) == 0) {
            this.holdingPatternClockwise = !this.holdingPatternClockwise;
            j = i + 6;
         }

         if (this.holdingPatternClockwise) {
            ++j;
         } else {
            --j;
         }

         if (this.dragon.getDragonFight() != null && this.dragon.getDragonFight().getCrystalsAlive() > 0) {
            j %= 12;
            if (j < 0) {
               j += 12;
            }
         } else {
            j -= 12;
            j &= 7;
            j += 12;
         }

         this.currentPath = this.dragon.findPath(i, j, (Node)null);
         if (this.currentPath != null) {
            this.currentPath.advance();
         }
      }

      this.navigateToNextPathNode();
   }

   @Overwrite
   private void navigateToNextPathNode() {
      if (this.currentPath != null && !this.currentPath.isDone()) {
         Vec3i vec3i = this.currentPath.getNextNodePos();
         this.currentPath.advance();
         double d0 = (double)vec3i.getX();
         double d2 = (double)vec3i.getZ();

         double d1;
         do {
            d1 = (double)((float)vec3i.getY() + this.dragon.getRandom().nextFloat() * 20.0F);
         } while(d1 < (double)vec3i.getY());

         this.targetLocation = new Vec3(d0, d1, d2);
      }

   }
}
