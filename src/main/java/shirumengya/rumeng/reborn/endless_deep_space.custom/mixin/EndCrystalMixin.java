package shirumengya.rumeng.reborn.endless_deep_space.custom.mixin;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.*;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.dimension.end.EndDragonFight;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;

@Mixin(EndCrystal.class)
public class EndCrystalMixin {

private static final EntityDataAccessor<Integer> DATA_ATTACK_TIMES = SynchedEntityData.defineId(EndCrystal.class, EntityDataSerializers.INT);

	@Inject(method = {"defineSynchedData"}, at = {@At("HEAD")}, cancellable = true)
	protected void defineSynchedData(CallbackInfo info) {
	EndCrystal crystal = ((EndCrystal)(Object)this);
      	crystal.getEntityData().define(DATA_ATTACK_TIMES, 0);
   	}

	@Inject(method = {"addAdditionalSaveData"}, at = {@At("HEAD")}, cancellable = true)
	protected void addAdditionalSaveData(CompoundTag p_31062_, CallbackInfo info) {
      p_31062_.putInt("AttackTimes", this.getAttackTimes());
   	}

	@Inject(method = {"readAdditionalSaveData"}, at = {@At("HEAD")}, cancellable = true)
   	protected void readAdditionalSaveData(CompoundTag p_31055_, CallbackInfo info) {
    	this.setAttackTimes(p_31055_.getInt("AttackTimes"));
   	}

   	public void setAttackTimes(int p_31511_) {
   	EndCrystal crystal = ((EndCrystal)(Object)this);
      	crystal.getEntityData().set(DATA_ATTACK_TIMES, p_31511_);
   	}

   	public int getAttackTimes() {
   	EndCrystal crystal = ((EndCrystal)(Object)this);
      	return crystal.getEntityData().get(DATA_ATTACK_TIMES);
   	}

	@Overwrite
   	public boolean hurt(DamageSource p_31050_, float p_31051_) {
   	EndCrystal crystal = ((EndCrystal)(Object)this);
      if (crystal.isInvulnerableTo(p_31050_)) {
         return false;
      } else if (p_31050_.getEntity() instanceof EnderDragon) {
         return false;
      } else {
         if (!crystal.isRemoved() && !crystal.level.isClientSide) {
         	if (p_31051_ >= 20.0F && p_31051_ <= 50.0F) {
         	if (this.getAttackTimes() < 10) {
         		this.setAttackTimes(this.getAttackTimes() + 1);
         	} else {
            crystal.remove(Entity.RemovalReason.KILLED);
               crystal.level.explode((Entity)null, crystal.getX(), crystal.getY(), crystal.getZ(), 10.0F, Explosion.BlockInteraction.DESTROY);
            this.onDestroyedBy(p_31050_);
         	}
         	}
         }
         return true;
      }
   }

	@Overwrite
   	private void onDestroyedBy(DamageSource p_31048_) {
   	EndCrystal crystal = ((EndCrystal)(Object)this);
      if (crystal.level instanceof ServerLevel) {
         EndDragonFight enddragonfight = ((ServerLevel)crystal.level).dragonFight();
         if (enddragonfight != null) {
            enddragonfight.onCrystalDestroyed(crystal, p_31048_);
         }
      }
   	}

   	@Overwrite
   	public void kill() {
   	EndCrystal crystal = ((EndCrystal)(Object)this);
   		for (int i = 0; i < 114514; i++) {
   			if (crystal != null) {
      			crystal.hurt(DamageSource.OUT_OF_WORLD, 25.0F);
   			}
   		}
   	}

//   	@Overwrite
   	public boolean canBeCollidedWith() {
   		EndCrystal crystal = ((EndCrystal)(Object)this);
		if (this.getAttackTimes() < 10) {
			return true;
		} else {
			crystal.setGlowingTag(true);
			return false;
		}
   	}
}
