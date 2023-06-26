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
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.scores.Team;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.entity.*;

public class BossItem extends ItemEntity {
	
	public static final EntityDataAccessor<Integer> DATA_TEAM_COLOR = SynchedEntityData.defineId(BossItem.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_GLOWING = SynchedEntityData.defineId(BossItem.class, EntityDataSerializers.BOOLEAN);
	public boolean NoGravity;

	public BossItem(EntityType<? extends BossItem> p_31991_, Level p_31992_) {
      	super(p_31991_, p_31992_);
   	}

	public BossItem(Level p_32001_, double p_32002_, double p_32003_, double p_32004_, ItemStack p_32005_) {
     	this(p_32001_, p_32002_, p_32003_, p_32004_, p_32005_, p_32001_.random.nextDouble() * 0.2D - 0.1D, 0.2D, p_32001_.random.nextDouble() * 0.2D - 0.1D, false, 16777215, false);
   	}

   	public BossItem(Level p_32001_, double p_32002_, double p_32003_, double p_32004_, ItemStack p_32005_, boolean glowing, int color, boolean gravity) {
     	this(p_32001_, p_32002_, p_32003_, p_32004_, p_32005_, p_32001_.random.nextDouble() * 0.2D - 0.1D, 0.2D, p_32001_.random.nextDouble() * 0.2D - 0.1D, glowing, color, gravity);
   	}

   	public BossItem(Level p_149663_, double p_149664_, double p_149665_, double p_149666_, ItemStack p_149667_, double p_149668_, double p_149669_, double p_149670_, boolean glowing, int color, boolean gravity) {
      	this(EntityInit.BOSS_ITEM.get(), p_149663_);
      	this.setPos(p_149664_, p_149665_, p_149666_);
      	this.setDeltaMovement(p_149668_, p_149669_, p_149670_);
      	this.setItem(p_149667_);
      	this.getEntityData().set(DATA_TEAM_COLOR, color);
    	this.getEntityData().set(DATA_GLOWING, glowing);
      	this.setNoGravity(gravity);
      	this.NoGravity = gravity;
   	}

   	protected void defineSynchedData() {
   		super.defineSynchedData();
      	this.getEntityData().define(DATA_TEAM_COLOR, 16777215);
      	this.getEntityData().define(DATA_GLOWING, false);
   	}

	public void addAdditionalSaveData(CompoundTag p_31062_) {
		super.addAdditionalSaveData(p_31062_);
      	p_31062_.putInt("GlowingColor", this.getEntityData().get(DATA_TEAM_COLOR));
      	p_31062_.putBoolean("CurrentlyGlowing", this.getEntityData().get(DATA_GLOWING));
   	}

   	public void readAdditionalSaveData(CompoundTag p_31055_) {
   		super.readAdditionalSaveData(p_31055_);
    	this.getEntityData().set(DATA_TEAM_COLOR, p_31055_.getInt("GlowingColor"));
    	this.getEntityData().set(DATA_GLOWING, p_31055_.getBoolean("CurrentlyGlowing"));
   	}

   	public boolean isPushedByFluid() {
      	return false;
   	}

   	public boolean ignoreExplosion() {
      	return true;
   	}

   	public void push(double p_20286_, double p_20287_, double p_20288_) {
   		if (!NoGravity) {
   			super.push(p_20286_, p_20287_, p_20288_);
   		}
   	}

   	public void setDeltaMovement(Vec3 p_20257_) {
   		if (!NoGravity) {
   			super.setDeltaMovement(p_20257_);
   		} else {
   			super.setDeltaMovement(Vec3.ZERO);
   		}
   	}

	@Override
   	public int getTeamColor() {
      	Team team = this.getTeam();
      	return team != null && team.getColor().getColor() != null ? team.getColor().getColor() : this.getEntityData().get(DATA_TEAM_COLOR);
   	}

	@Override
   	public boolean isCurrentlyGlowing() {
      	return this.getEntityData().get(DATA_GLOWING);
   	}

   	public boolean hurt(DamageSource p_32013_, float p_32014_) {
   		return false;
   	}
}
