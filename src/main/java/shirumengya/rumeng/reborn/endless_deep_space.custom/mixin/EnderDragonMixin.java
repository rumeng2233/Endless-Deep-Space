package shirumengya.rumeng.reborn.endless_deep_space.custom.mixin;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.*;
import com.google.common.collect.Lists;
import com.mojang.logging.LogUtils;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.entity.boss.enderdragon.phases.DragonPhaseInstance;
import net.minecraft.world.entity.boss.enderdragon.phases.EnderDragonPhase;
import net.minecraft.world.entity.boss.enderdragon.phases.EnderDragonPhaseManager;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.end.EndDragonFight;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.EndPodiumFeature;
import net.minecraft.world.level.pathfinder.BinaryHeap;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.slf4j.Logger;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.EndlessDeepSpaceModAttributes;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.world.BossEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

@Mixin(EnderDragon.class)
public class EnderDragonMixin extends Mob implements Enemy{

private static final ServerBossEvent dragonEvent = (ServerBossEvent)(new ServerBossEvent(Component.translatable("entity.minecraft.ender_dragon"), BossEvent.BossBarColor.PINK, BossEvent.BossBarOverlay.PROGRESS)).setPlayBossMusic(true).setCreateWorldFog(true);
	
@Final
@Shadow
EndDragonFight dragonFight;
EnderDragonPhaseManager phaseManager;
EnderDragonPart head;
EnderDragonPart neck;
EnderDragonPart body;
EnderDragonPart tail1;
EnderDragonPart tail2;
EnderDragonPart tail3;
EnderDragonPart wing1;
EnderDragonPart wing2;
float sittingDamageReceived;

	public EnderDragonMixin(EntityType<? extends EnderDragon> p_31096_, Level p_31097_) {
      super(EntityType.ENDER_DRAGON, p_31097_);
   }

	@Overwrite
	public void kill() {
	EnderDragon dragon = ((EnderDragon)(Object)this);
	  dragon.setHealth(0.0F);
      dragon.gameEvent(GameEvent.ENTITY_DIE);
      if (this.dragonFight != null) {
         this.dragonFight.updateDragon(dragon);
         this.dragonFight.setDragonKilled(dragon);
      }
   	}

	@Overwrite
   	public static AttributeSupplier.Builder createAttributes() {
      	return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 600.0D).add(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get(), 8.0D);
   	}

	public void baseTick() {
	EnderDragon dragon = ((EnderDragon)(Object)this);
		super.baseTick();
		this.dragonEvent.setProgress(dragon.getHealth() / dragon.getMaxHealth());
		dragon.noCulling = true;
	}

	public void startSeenByPlayer(ServerPlayer player) {
	EnderDragon dragon = ((EnderDragon)(Object)this);
		super.startSeenByPlayer(player);
		this.dragonEvent.addPlayer(player);
	}

	public void stopSeenByPlayer(ServerPlayer player) {
	EnderDragon dragon = ((EnderDragon)(Object)this);
		super.stopSeenByPlayer(player);
		this.dragonEvent.removePlayer(player);
	}

/*	@Overwrite
      public boolean hurt(EnderDragonPart p_31121_, DamageSource p_31122_, float p_31123_) {
      EnderDragon dragon = ((EnderDragon)(Object)this);
      if (this.phaseManager.getCurrentPhase().getPhase() == EnderDragonPhase.DYING) {
         return false;
      } else {
         p_31123_ = this.phaseManager.getCurrentPhase().onHurt(p_31122_, p_31123_);
         if (p_31121_ == this.head || p_31121_ == this.neck || p_31121_ == this.tail1 || p_31121_ == this.tail2 || p_31121_ == this.tail3) {
            p_31123_ = p_31123_ * 4.0F + Math.min(p_31123_, 1.0F);
         } else if (p_31121_ == this.body) {
         	p_31123_ = p_31123_ * 2.0F + Math.min(p_31123_, 1.0F);
         } else if (p_31121_ == this.wing1 || p_31121_ == this.wing2) {
         	p_31123_ = p_31123_ / 10.0F + Math.min(p_31123_, 1.0F);
         }

         if (p_31123_ < 0.01F) {
            return false;
         } else {
            if (p_31122_.getEntity() instanceof Player || p_31122_.isExplosion()) {
               float f = dragon.getHealth();
               this.hurt(p_31122_, p_31123_);
               if (dragon.isDeadOrDying() && !this.phaseManager.getCurrentPhase().isSitting()) {
                  dragon.setHealth(1.0F);
                  this.phaseManager.setPhase(EnderDragonPhase.DYING);
               }

               if (this.phaseManager.getCurrentPhase().isSitting()) {
                  this.sittingDamageReceived = this.sittingDamageReceived + f - dragon.getHealth();
                  if (this.sittingDamageReceived > 0.25F * dragon.getMaxHealth()) {
                     this.sittingDamageReceived = 0.0F;
                     this.phaseManager.setPhase(EnderDragonPhase.TAKEOFF);
                  }
               }
            }

            return true;
         }
      }
   }

	@Overwrite
   public boolean hurt(DamageSource p_31113_, float p_31114_) {
      return super.hurt(p_31113_, p_31114_);
   }

	@Overwrite
   	private void knockBack(List<Entity> p_31132_) {
   	EnderDragon dragon = ((EnderDragon)(Object)this);
      double d0 = (dragon.getBoundingBox().minX + dragon.getBoundingBox().maxX);
      double d1 = (dragon.getBoundingBox().minZ + dragon.getBoundingBox().maxZ);
      for(Entity entity : p_31132_) {
         if (entity instanceof LivingEntity) {
            double d2 = entity.getX() - d0;
            double d3 = entity.getZ() - d1;
            double d4 = Math.max(d2 * d2 + d3 * d3, 0.1D);
            entity.push(d2 / d4 * 4.0D, (double)0.2F, d3 / d4 * 4.0D);
            if (!this.phaseManager.getCurrentPhase().isSitting() && ((LivingEntity)entity).getLastHurtByMobTimestamp() < entity.tickCount - 2) {
               entity.hurt(DamageSource.mobAttack(dragon), 15.0F);
               dragon.doEnchantDamageEffects(dragon, entity);
            }
         }
      }
   	}
*/}
