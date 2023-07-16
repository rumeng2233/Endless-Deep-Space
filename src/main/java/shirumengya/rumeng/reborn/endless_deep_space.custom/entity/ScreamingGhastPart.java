package shirumengya.rumeng.reborn.endless_deep_space.custom.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import shirumengya.rumeng.reborn.endless_deep_space.entity.*;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.HitResult;

public class ScreamingGhastPart extends EndlessDeepSpaceEntityPart<ScreamingGhastEntity> {

	public final EntityDimensions size;

	public ScreamingGhastPart(ScreamingGhastEntity parent, float Xsize, float Ysize) {
		super(parent);
		this.size = EntityDimensions.scalable(Xsize, Ysize);
		this.refreshDimensions();
	}

	public EntityDimensions getDimensions(Pose p_31023_) {
      	return this.size;
   	}
   	
   	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		boolean flag = this.getParent() != null && this.getParent().hurt(this, source, amount);
		if (flag) {
			this.markHurt();
			this.gameEvent(GameEvent.ENTITY_DAMAGE/*, source.getEntity()*/);
		}
		return flag;
	}

	@Override
	public boolean isAttackable() {
      	return true;
   	}

   	public boolean isPickable() {
      	return true;
   	}

	@Override
	public boolean canChangeDimensions() {
		return false;
	}

	@Override
	public boolean is(Entity entity) {
		return entity == this || entity == this.getParent();
	}
	
}
