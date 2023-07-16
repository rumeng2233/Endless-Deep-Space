package shirumengya.rumeng.reborn.endless_deep_space.custom.mixin;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Accessor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.TheEndGatewayBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.nbt.CompoundTag;

@Mixin(ThrowableProjectile.class)
public class ThrowableProjectileMixin extends Projectile {
	
	public ThrowableProjectileMixin(EntityType<? extends ThrowableProjectileMixin> p_37319_, Level p_37320_) {
   		super(p_37319_, p_37320_);
   	}

   	protected void defineSynchedData() {
   	}

   	public void addAdditionalSaveData(CompoundTag p_36848_) {
   	}

   	public void readAdditionalSaveData(CompoundTag p_36844_) {
   	}

	@Overwrite
   	protected float getGravity() {
      	return 0.03F;
   	}

	@Overwrite
	public void tick() {
		ThrowableProjectile projectile = ((ThrowableProjectile)(Object)this);
      	super.tick();
      	HitResult hitresult = ProjectileUtil.getHitResult(projectile, this::canHitEntity);
      	boolean flag = false;
      	if (hitresult.getType() == HitResult.Type.BLOCK) {
         	BlockPos blockpos = ((BlockHitResult)hitresult).getBlockPos();
         	BlockState blockstate = projectile.level.getBlockState(blockpos);
         	if (blockstate.is(Blocks.NETHER_PORTAL)) {
            	projectile.handleInsidePortal(blockpos);
            	flag = true;
         	} else if (blockstate.is(Blocks.END_GATEWAY)) {
            	BlockEntity blockentity = projectile.level.getBlockEntity(blockpos);
            	if (blockentity instanceof TheEndGatewayBlockEntity && TheEndGatewayBlockEntity.canEntityTeleport(projectile)) {
               		TheEndGatewayBlockEntity.teleportEntity(projectile.level, blockpos, blockstate, projectile, (TheEndGatewayBlockEntity)blockentity);
            	}

            	flag = true;
         	}
      	}

      	if (hitresult.getType() != HitResult.Type.MISS && !flag && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(projectile, hitresult)) {
         	this.onHit(hitresult);
      	}

      	this.checkInsideBlocks();
      	Vec3 vec3 = projectile.getDeltaMovement();
      	double d2 = projectile.getX() + vec3.x;
      	double d0 = projectile.getY() + vec3.y;
      	double d1 = projectile.getZ() + vec3.z;
      	this.updateRotation();
      	float f;
      	if (projectile.isInWater() && !(projectile.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:can_not_retard_in_water"))))) {
         	for(int i = 0; i < 4; ++i) {
            	float f1 = 0.25F;
            	projectile.level.addParticle(ParticleTypes.BUBBLE, d2 - vec3.x * 0.25D, d0 - vec3.y * 0.25D, d1 - vec3.z * 0.25D, vec3.x, vec3.y, vec3.z);
         	}

         	f = 0.8F;
      	} else {
         	f = 0.99F;
      	}

      	projectile.setDeltaMovement(vec3.scale((double)f));
      	if (!this.isNoGravity()) {
         	Vec3 vec31 = projectile.getDeltaMovement();
         	projectile.setDeltaMovement(vec31.x, vec31.y - (double)this.getGravity(), vec31.z);
      	}

      	projectile.setPos(d2, d0, d1);
   	}
}
