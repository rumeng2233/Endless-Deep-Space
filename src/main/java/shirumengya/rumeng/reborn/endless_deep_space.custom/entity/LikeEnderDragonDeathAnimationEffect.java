package shirumengya.rumeng.reborn.endless_deep_space.custom.entity;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.entity.*;
import net.minecraft.util.RandomSource;

public class LikeEnderDragonDeathAnimationEffect extends Entity {
	
	public static final EntityDataAccessor<Float> MaxDurationTime = SynchedEntityData.defineId(LikeEnderDragonDeathAnimationEffect.class, EntityDataSerializers.FLOAT);
	public static final EntityDataAccessor<Integer> ColorRed = SynchedEntityData.defineId(LikeEnderDragonDeathAnimationEffect.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> ColorGreen = SynchedEntityData.defineId(LikeEnderDragonDeathAnimationEffect.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> ColorBlue = SynchedEntityData.defineId(LikeEnderDragonDeathAnimationEffect.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> HasWhite = SynchedEntityData.defineId(LikeEnderDragonDeathAnimationEffect.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Float> randomSource = SynchedEntityData.defineId(LikeEnderDragonDeathAnimationEffect.class, EntityDataSerializers.FLOAT);
	public static final EntityDataAccessor<Float> Size = SynchedEntityData.defineId(LikeEnderDragonDeathAnimationEffect.class, EntityDataSerializers.FLOAT);
	public static final EntityDataAccessor<Float> Timer = SynchedEntityData.defineId(LikeEnderDragonDeathAnimationEffect.class, EntityDataSerializers.FLOAT);
	
	public LikeEnderDragonDeathAnimationEffect(EntityType<? extends LikeEnderDragonDeathAnimationEffect> p_31991_, Level p_31992_) {
		super(p_31991_, p_31992_);
		this.setFloatData(MaxDurationTime, 200.0F);
		this.setIntegerData(ColorRed, 255);
		this.setIntegerData(ColorGreen, 0);
		this.setIntegerData(ColorBlue, 255);
		this.setBooleanData(HasWhite, true);
		this.setFloatData(randomSource, 432.0F);
		this.setFloatData(Size, 1.0F);
	}

	public LikeEnderDragonDeathAnimationEffect(Level p_31992_, double p_149664_, double p_149665_, double p_149666_, float time, int red, int green, int blue, boolean white, float random, float size) {
		super(EntityInit.LIKE_ENDER_DRAGON_DEATH_ANIMATION_EFFECT.get(), p_31992_);
		this.setPos(p_149664_, p_149665_, p_149666_);
		this.setFloatData(MaxDurationTime, time);
		this.setIntegerData(ColorRed, red);
		this.setIntegerData(ColorGreen, green);
		this.setIntegerData(ColorBlue, blue);
		this.setBooleanData(HasWhite, white);
		this.setFloatData(randomSource, random);
		this.setFloatData(Size, size);
	}

	public void setFloatData(EntityDataAccessor data, float number) {
		this.entityData.set(data, number);
	}

	public float getFloatData(EntityDataAccessor data) {
		return (float)this.entityData.get(data);
	}

	public void setIntegerData(EntityDataAccessor data, int number) {
		this.entityData.set(data, number);
	}

	public int getIntegerData(EntityDataAccessor data) {
		return (int)this.entityData.get(data);
	}

	public void setBooleanData(EntityDataAccessor data, boolean number) {
		this.entityData.set(data, number);
	}

	public boolean getBooleanData(EntityDataAccessor data) {
		return (boolean)this.entityData.get(data);
	}

	public Packet<?> getAddEntityPacket() {
      	return new ClientboundAddEntityPacket(this);
   	}

   	public boolean shouldRender(double p_20296_, double p_20297_, double p_20298_) {
      	return true;
   	}

   	public boolean shouldRenderAtSqrDistance(double p_19883_) {
      	return true;
   	}

	protected void defineSynchedData() {
      	this.getEntityData().define(MaxDurationTime, 200.0F);
      	this.getEntityData().define(ColorRed, 255);
      	this.getEntityData().define(ColorBlue, 0);
      	this.getEntityData().define(ColorGreen, 255);
      	this.getEntityData().define(HasWhite, true);
      	this.getEntityData().define(randomSource, 432.0F);
      	this.getEntityData().define(Size, 1.0F);
      	this.getEntityData().define(Timer, 0.0F);
   	}

	public void addAdditionalSaveData(CompoundTag p_31062_) {
		p_31062_.putFloat("MaxDurationTime", this.getFloatData(MaxDurationTime));
      	p_31062_.putInt("ColorRed", this.getIntegerData(ColorRed));
      	p_31062_.putInt("ColorGreen", this.getIntegerData(ColorGreen));
      	p_31062_.putInt("ColorBlue", this.getIntegerData(ColorBlue));
      	p_31062_.putBoolean("HasWhite", this.getBooleanData(HasWhite));
      	p_31062_.putFloat("RandomSource", this.getFloatData(randomSource));
      	p_31062_.putFloat("Size", this.getFloatData(Size));
   	}

   	public void readAdditionalSaveData(CompoundTag p_31055_) {
    	this.setFloatData(MaxDurationTime, p_31055_.getFloat("MaxDurationTime"));
    	this.setIntegerData(ColorRed, p_31055_.getInt("ColorRed"));
    	this.setIntegerData(ColorGreen, p_31055_.getInt("ColorGreen"));
    	this.setIntegerData(ColorBlue, p_31055_.getInt("ColorBlue"));
    	this.setBooleanData(HasWhite, p_31055_.getBoolean("HasWhite"));
    	this.setFloatData(randomSource, p_31055_.getFloat("RandomSource"));
    	this.setFloatData(Size, p_31055_.getFloat("Size"));
   	}

   	public void tick() {
   		super.tick();
   		this.setNoGravity(true);
   		this.noCulling = true;
   		this.clearFire();
   		this.setFloatData(Timer, this.getFloatData(Timer) + 1.0F);
   		if (this.getFloatData(Timer) >= this.getFloatData(MaxDurationTime)) {
   			this.discard();
   		}
   	}

   	public boolean isPushedByFluid() {
      	return false;
   	}

   	public boolean ignoreExplosion() {
      	return true;
   	}

   	public void push(double p_20286_, double p_20287_, double p_20288_) {
   	}

   	public boolean isAttackable() {
      	return false;
   	}

   	public void setDeltaMovement(Vec3 p_20257_) {
   	}

   	public boolean hurt(DamageSource p_32013_, float p_32014_) {
   		return false;
   	}
}
