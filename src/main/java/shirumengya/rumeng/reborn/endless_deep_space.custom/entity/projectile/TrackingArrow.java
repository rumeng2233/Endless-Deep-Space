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
import net.minecraft.world.entity.boss.EnderDragonPart;

public class TrackingArrow extends CommonArrow {

	private float maxTurningAngleCos;
   	private float maxTurningAngleSin;
   	private boolean canTracking;
	
	public TrackingArrow(EntityType<? extends TrackingArrow> type, Level worldIn) {
		super(type, worldIn);
		this.canTracking = false;
	}

	public TrackingArrow(EntityType<? extends TrackingArrow> type, Level worldIn, Entity shooter) {
		super(type, worldIn);
		this.setOwner(shooter);
		this.setPos(shooter.getX(), shooter.getEyeY() - 0.1D, shooter.getZ());
		this.canTracking = true;
	}

	@Override
	public void tick() {
		super.tick();
		Vec3 vec3 = this.getDeltaMovement();
       	float v0 = (float) vec3.length();
    	this.maxTurningAngleCos = Mth.cos(7.1619724F * v0 * Mth.DEG_TO_RAD);
    	this.maxTurningAngleSin = Mth.sin(7.1619724F * v0 * Mth.DEG_TO_RAD);
    	if (!this.level.isClientSide && this.canTracking) {
    		if (this.getOwner() instanceof Mob) {
    			TrackingUtil.TrackingEntity(this, maxTurningAngleCos, maxTurningAngleSin, false);
    		} else {
        		TrackingUtil.TrackingEntityClass(this, Monster.class, 20.0D, false, maxTurningAngleCos, maxTurningAngleSin, false);
        		TrackingUtil.TrackingEntityClass(this, Ghast.class, 20.0D, false, maxTurningAngleCos, maxTurningAngleSin, false);
        		TrackingUtil.TrackingEntityClass(this, Shulker.class, 20.0D, false, maxTurningAngleCos, maxTurningAngleSin, false);
        		TrackingUtil.TrackingEntityClass(this, Slime.class, 20.0D, false, maxTurningAngleCos, maxTurningAngleSin, false);
        		TrackingUtil.TrackingEntityClass(this, EnderDragonPart.class, 20.0D, false, maxTurningAngleCos, maxTurningAngleSin, false);
        		//TrackingUtil.TrackingEntityClass(this, Player.class, 20.0D, false, maxTurningAngleCos, maxTurningAngleSin, false);
    		}
     	}
	}
}
