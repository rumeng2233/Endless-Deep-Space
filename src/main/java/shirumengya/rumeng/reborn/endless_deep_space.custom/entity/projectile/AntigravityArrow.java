package shirumengya.rumeng.reborn.endless_deep_space.custom.entity.projectile;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModItems;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;

public class AntigravityArrow extends CommonArrow {

	private boolean isStart = false;
	private int timer = 0;
	private int AutoDetonationTime = 0;
	boolean canDiscard = false;
	
	public AntigravityArrow(EntityType<? extends AntigravityArrow> type, Level worldIn) {
		super(type, worldIn);
	}

	public AntigravityArrow(EntityType<? extends AntigravityArrow> type, Level worldIn, Entity shooter) {
		super(type, worldIn);
		this.setOwner(shooter);
		this.setPos(shooter.getX(), shooter.getEyeY() - 0.1D, shooter.getZ());
	}

	@Override
	public void tick() {
		super.tick();
    	if (!this.level.isClientSide) {
    		AutoDetonationTime++;
    		this.pickup = AbstractArrow.Pickup.DISALLOWED;
    		Vec3 velocity = this.getDeltaMovement();
    		if (velocity.lengthSqr() < 0.25 && !(isStart)) {
    			this.setNoGravity(false);
    		} else {
    			this.setNoGravity(true);
    		}
    		if (AutoDetonationTime == 400 && !(isStart)) {
    			isStart = true;
    		}
    		if (isStart) {
    			this.push(-velocity.x, -velocity.y, -velocity.z);
        		this.setNoGravity(true);
        		timer++;
        		if (timer > 0 && timer < 200) {
        			((ServerLevel) level).sendParticles(ParticleTypes.WITCH, this.getX(), this.getY(), this.getZ(), 40, 0, 0, 0, 0.08);
        			TrackingUtil.forceEffect(this, Entity.class, 20.0D, -8.0D, 8.0D);
        		}
        		if (timer > 200) {
        			canDiscard = true;
        			((ServerLevel) level).sendParticles(ParticleTypes.WITCH, this.getX(), this.getY(), this.getZ(), 200, 0, 0, 0, 0.6);
        			this.discard();
        		}
    		}
     	}
	}

	protected void onHitEntity(EntityHitResult p_37345_) {
      	if (!this.level.isClientSide && !(isStart)) {
      		isStart = true;
      		if (timer > 200) {
      			super.onHitEntity(p_37345_);
      		}
      	}
   	}

   	protected void onHitBlock(BlockHitResult p_37343_) {
      	super.onHitBlock(p_37343_);
      	if (!this.level.isClientSide && !(isStart)) {
      		isStart = true;
      	}
   	}
}
