package shirumengya.rumeng.reborn.endless_deep_space.custom.entity;

import com.google.common.collect.Sets;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LightningRodBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.entity.EntityType;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.entity.*;

public class ColorfulLightningBolt extends LightningBolt {
	
	public static final EntityDataAccessor<Integer> ColorRed = SynchedEntityData.defineId(ColorfulLightningBolt.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> ColorGreen = SynchedEntityData.defineId(ColorfulLightningBolt.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> ColorBlue = SynchedEntityData.defineId(ColorfulLightningBolt.class, EntityDataSerializers.INT);
	
	public ColorfulLightningBolt(EntityType<? extends ColorfulLightningBolt> p_20865_, Level p_20866_) {
		super(p_20865_, p_20866_);
		this.setIntegerData(ColorRed, 114);
		this.setIntegerData(ColorGreen, 114);
		this.setIntegerData(ColorBlue, 127);
	}

	public ColorfulLightningBolt(Level p_20866_, int red, int green, int blue) {
		super(EntityInit.COLORFUL_LIGHTNING_BOLT.get(), p_20866_);
		this.setIntegerData(ColorRed, red);
		this.setIntegerData(ColorGreen, green);
		this.setIntegerData(ColorBlue, blue);
	}

	public ColorfulLightningBolt(Level p_20866_, double p_149664_, double p_149665_, double p_149666_, int red, int green, int blue) {
		super(EntityInit.COLORFUL_LIGHTNING_BOLT.get(), p_20866_);
		this.setPos(p_149664_, p_149665_, p_149666_);
		this.setIntegerData(ColorRed, red);
		this.setIntegerData(ColorGreen, green);
		this.setIntegerData(ColorBlue, blue);
	}

	public Packet<?> getAddEntityPacket() {
      	return new ClientboundAddEntityPacket(this);
   	}

   	public int getIntegerData(EntityDataAccessor data) {
		return (int)this.entityData.get(data);
	}

	public void setIntegerData(EntityDataAccessor data, int number) {
		this.entityData.set(data, number);
	}

	protected void defineSynchedData() {
      	this.getEntityData().define(ColorRed, 114);
      	this.getEntityData().define(ColorBlue, 114);
      	this.getEntityData().define(ColorGreen, 127);
   	}

	public void addAdditionalSaveData(CompoundTag p_31062_) {
      	p_31062_.putInt("ColorRed", this.getIntegerData(ColorRed));
      	p_31062_.putInt("ColorGreen", this.getIntegerData(ColorGreen));
      	p_31062_.putInt("ColorBlue", this.getIntegerData(ColorBlue));
   	}

   	public void readAdditionalSaveData(CompoundTag p_31055_) {
    	this.setIntegerData(ColorRed, p_31055_.getInt("ColorRed"));
    	this.setIntegerData(ColorGreen, p_31055_.getInt("ColorGreen"));
    	this.setIntegerData(ColorBlue, p_31055_.getInt("ColorBlue"));
   	}

   	public boolean shouldRender(double p_20296_, double p_20297_, double p_20298_) {
      	return true;
   	}

   	public boolean shouldRenderAtSqrDistance(double p_19883_) {
      	return true;
   	}
}
