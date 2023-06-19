package shirumengya.rumeng.reborn.endless_deep_space.custom.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraftforge.entity.PartEntity;
import java.util.Objects;
import net.minecraft.util.Mth;

public class EndlessDeepSpaceEntityPart<T extends Entity> extends PartEntity<T> {

	public Entity parent;
	protected EntityDimensions realSize;
	protected int newPosRotationIncrements;
	protected double interpTargetX;
	protected double interpTargetY;
	protected double interpTargetZ;
	protected double interpTargetYaw;
	protected double interpTargetPitch;
	public float renderYawOffset;
	public float prevRenderYawOffset;
	public int deathTime;
	public int hurtTime;

   	public EndlessDeepSpaceEntityPart(T parent) {
      	super(parent);
      	this.parent = parent;
   	}

	@Override
   	public boolean isPickable() {
      	return true;
   	}

	@Override
   	public boolean isCurrentlyGlowing() {
		return this.getParent().isCurrentlyGlowing();
	}

	@Override
	public boolean isInvisible() {
		return this.getParent().isInvisible();
	}

	@Override
    protected void readAdditionalSaveData(CompoundTag compound) {
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
    }

    @Override
    protected void defineSynchedData() {
    }

    @Override
	public void tick() {
		updateLastPos();
		super.tick();
		if (this.newPosRotationIncrements > 0) {
			double d0 = this.getX() + (this.interpTargetX - this.getX()) / (double) this.newPosRotationIncrements;
			double d2 = this.getY() + (this.interpTargetY - this.getY()) / (double) this.newPosRotationIncrements;
			double d4 = this.getZ() + (this.interpTargetZ - this.getZ()) / (double) this.newPosRotationIncrements;
			double d6 = Mth.wrapDegrees(this.interpTargetYaw - (double) this.getYRot());
			this.setYRot((float) ((double) this.getYRot() + d6 / (double) this.newPosRotationIncrements));
			this.setXRot((float) ((double) this.getXRot() + (this.interpTargetPitch - (double) this.getXRot()) / (double) this.newPosRotationIncrements));
			--this.newPosRotationIncrements;
			this.setPos(d0, d2, d4);
			this.setRot(this.getYRot(), this.getXRot());
		}

		while (getYRot() - this.yRotO < -180F) this.yRotO -= 360F;
		while (getYRot() - this.yRotO >= 180F) this.yRotO += 360F;

		while (this.renderYawOffset - this.prevRenderYawOffset < -180F) this.prevRenderYawOffset -= 360F;
		while (this.renderYawOffset - this.prevRenderYawOffset >= 180F) this.prevRenderYawOffset += 360F;

		while (getXRot() - this.xRotO < -180F) this.xRotO -= 360F;
		while (getXRot() - this.xRotO >= 180F) this.xRotO += 360F;
	}

	public final void updateLastPos() {
		this.moveTo(this.getX(), this.getY(), this.getZ());
		this.yRotO = this.getYRot();
		this.xRotO = this.getXRot();
		this.tickCount++;
	}

	protected void setSize(EntityDimensions size) {
		this.realSize = size;
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose pose) {
		return this.realSize;
	}

    public static void assignPartIDs(Entity parent) {
		PartEntity<?>[] parts = parent.getParts();
		for (int i = 0, partsLength = Objects.requireNonNull(parts).length; i < partsLength; i++) {
			PartEntity<?> part = parts[i];
			part.setId(parent.getId() + i);
		}
	}
}
