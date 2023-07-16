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
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.entity.*;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Blocks;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.*;

public class SuperBomb extends Entity {
	
	private int timer = 0;
	
	public SuperBomb(EntityType<? extends SuperBomb> p_31991_, Level p_31992_) {
		super(p_31991_, p_31992_);
	}

	public SuperBomb(Level level) {
		super(EntityInit.SUPER_BOMB.get(), level);
	}

	protected void defineSynchedData() {
	}

	public Packet<?> getAddEntityPacket() {
      	return new ClientboundAddEntityPacket(this);
   	}

   	public void addAdditionalSaveData(CompoundTag p_31062_) {
   	}

   	public void readAdditionalSaveData(CompoundTag p_31055_) {
   	}

	public void tick() {
   		super.tick();
   		this.setNoGravity(true);
   		this.noCulling = true;
   		this.clearFire();
   		if (!this.level.isClientSide) {
   			timer++;
   			double x = this.getX();
   			double y = this.getY();
   			double z = this.getZ();
   			if (EndlessDeepSpaceModCommonConfig.DISABLE_SUPER_BOMB.get() == false) {
   				if (timer == 1) {
					this.level.destroyBlock(new BlockPos(x, y, z), false);
					if (this.level instanceof ServerLevel _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")), SoundSource.BLOCKS, 1, 1, false);
						}
						LikeEnderDragonDeathAnimationEffect effect = new LikeEnderDragonDeathAnimationEffect(_level, x, y, z, 200.0F, 255, 102, 0, false, 432.0F, 2F);
						this.level.addFreshEntity(effect);
					}
   				}
				if (timer == 200) {
					if (!this.level.isClientSide()) {
						Level _level = this.level;
						_level.explode(null, x, y, z, 30, Explosion.BlockInteraction.DESTROY);
						LikeEnderDragonDeathAnimationEffect effect1 = new LikeEnderDragonDeathAnimationEffect(_level, x, y, z, 80.0F, 236, 225, 159, false, 432.0F, 0.2F);
						_level.addFreshEntity(effect1);
						_level.explode(null, x, y + 10.0D, z, 30, Explosion.BlockInteraction.DESTROY);
						LikeEnderDragonDeathAnimationEffect effect2 = new LikeEnderDragonDeathAnimationEffect(_level, x, y + 10.0D, z, 80.0F, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), false, 432.0F, 0.2F);
						_level.addFreshEntity(effect2);
						_level.explode(null, x, y - 10.0D, z, 30, Explosion.BlockInteraction.DESTROY);
						LikeEnderDragonDeathAnimationEffect effect3 = new LikeEnderDragonDeathAnimationEffect(_level, x, y - 10.0D, z, 80.0F, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), false, 432.0F, 0.2F);
						_level.addFreshEntity(effect3);
						_level.explode(null, x + 10.0D, y, z, 30, Explosion.BlockInteraction.DESTROY);
						LikeEnderDragonDeathAnimationEffect effect4 = new LikeEnderDragonDeathAnimationEffect(_level, x + 10.0D, y, z, 80.0F, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), false, 432.0F, 0.2F);
						_level.addFreshEntity(effect4);
						_level.explode(null, x - 10.0D, y, z, 30, Explosion.BlockInteraction.DESTROY);
						LikeEnderDragonDeathAnimationEffect effect5 = new LikeEnderDragonDeathAnimationEffect(_level, x - 10.0D, y, z, 80.0F, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), false, 432.0F, 0.2F);
						_level.addFreshEntity(effect5);
						_level.explode(null, x, y, z + 10.0D, 30, Explosion.BlockInteraction.DESTROY);
						LikeEnderDragonDeathAnimationEffect effect6 = new LikeEnderDragonDeathAnimationEffect(_level, x, y, z + 10.0D, 80.0F, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), false, 432.0F, 0.2F);
						_level.addFreshEntity(effect6);
						_level.explode(null, x, y, z - 10.0D, 30, Explosion.BlockInteraction.DESTROY);
						LikeEnderDragonDeathAnimationEffect effect7 = new LikeEnderDragonDeathAnimationEffect(_level, x, y, z - 10.0D, 80.0F, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), false, 432.0F, 0.2F);
						_level.addFreshEntity(effect7);
					}
				}
				if (timer == 280) {
					this.discard();
					if (this.level instanceof ServerLevel _level) {
						LikeEnderDragonDeathAnimationEffect effect8 = new LikeEnderDragonDeathAnimationEffect(_level, x, y, z, 400.0F, 153, 255, 102, false, 432.0F, 4F);
						_level.addFreshEntity(effect8);
					}
					int horizontalRadiusSphere = (int) 80 - 1;
					int verticalRadiusSphere = (int) 80 - 1;
					int yIterationsSphere = verticalRadiusSphere;
					for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
						for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
							for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
								double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
										+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
								if (distanceSq <= 1.0) {
									this.level.setBlock(new BlockPos(x + xi, y + i, z + zi), Blocks.AIR.defaultBlockState(), 3);
								}
							}
						}
					}
				}
			} else {
				this.discard();
			}
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
