package shirumengya.rumeng.reborn.endless_deep_space.custom.mixin;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Accessor;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.gameevent.GameEvent;

@Mixin(AbstractHurtingProjectile.class)
public class AbstractHurtingProjectileMixin extends Projectile {
	
	public AbstractHurtingProjectileMixin(EntityType<? extends AbstractHurtingProjectileMixin> p_37319_, Level p_37320_) {
   		super(p_37319_, p_37320_);
   	}

   	protected void defineSynchedData() {
   	}

   	public void addAdditionalSaveData(CompoundTag p_36848_) {
   	}

   	public void readAdditionalSaveData(CompoundTag p_36844_) {
   	}

	@Overwrite
	protected boolean canHitEntity(Entity p_36842_) {
      	return super.canHitEntity(p_36842_) && !p_36842_.noPhysics;
   	}

	@Overwrite
   	protected boolean shouldBurn() {
      	return true;
   	}

	@Overwrite
   	protected ParticleOptions getTrailParticle() {
      	return ParticleTypes.SMOKE;
   	}

	@Overwrite
   	protected float getInertia() {
      	return 0.95F;
   	}

	@Overwrite
	public void tick() {
		AbstractHurtingProjectile projectile = ((AbstractHurtingProjectile)(Object)this);
      	Entity entity = projectile.getOwner();
      	if (projectile.level.isClientSide || (entity == null || !entity.isRemoved()) && projectile.level.hasChunkAt(projectile.blockPosition())) {
         	super.tick();
         	if (this.shouldBurn()) {
            	projectile.setSecondsOnFire(1);
         	}

         	HitResult hitresult = ProjectileUtil.getHitResult(projectile, this::canHitEntity);
	         if (hitresult.getType() != HitResult.Type.MISS && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(projectile, hitresult)) {
            	this.onHit(hitresult);
         	}

         	this.checkInsideBlocks();
         	Vec3 vec3 = projectile.getDeltaMovement();
         	double d0 = projectile.getX() + vec3.x;
         	double d1 = projectile.getY() + vec3.y;
         	double d2 = projectile.getZ() + vec3.z;
         	ProjectileUtil.rotateTowardsMovement(projectile, 0.2F);
         	float f = this.getInertia();
         	if (projectile.isInWater() && !(projectile.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:can_not_retard_in_water"))))) {
            	for(int i = 0; i < 4; ++i) {
               		float f1 = 0.25F;
               		projectile.level.addParticle(ParticleTypes.BUBBLE, d0 - vec3.x * 0.25D, d1 - vec3.y * 0.25D, d2 - vec3.z * 0.25D, vec3.x, vec3.y, vec3.z);
            	}

            	f = 0.8F;
         	}

         	projectile.setDeltaMovement(vec3.add(projectile.xPower, projectile.yPower, projectile.zPower).scale((double)f));
         	projectile.level.addParticle(this.getTrailParticle(), d0, d1 + 0.5D, d2, 0.0D, 0.0D, 0.0D);
         	projectile.setPos(d0, d1, d2);
      	} else {
         	projectile.discard();
      	}
   	}
}
