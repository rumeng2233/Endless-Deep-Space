
package shirumengya.rumeng.reborn.endless_deep_space.entity;

import shirumengya.rumeng.reborn.endless_deep_space.init.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.projectile.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.*;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.entity.projectile.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.BreakDoorGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.entity.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.packet.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.java.color.*;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.effect.MobEffectInstance;
import javax.annotation.Nullable;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.*;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.BossEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.entity.projectile.EvokerFangs;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.Direction;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.event.*;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

public class TheVoidCubeEntity extends Monster {
	private CustomServerBossEvent bossInfo = new CustomServerBossEvent(this, this.getDisplayName(), CustomServerBossEvent.BossBarColor.PURPLE, CustomServerBossEvent.BossBarOverlay.PROGRESS);
	private static final EntityDataAccessor<Boolean> DataSummoned = SynchedEntityData.defineId(TheVoidCubeEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> BossProgress = SynchedEntityData.defineId(TheVoidCubeEntity.class, EntityDataSerializers.INT);
	public int TheVoidCubeDeathTime = 0;
	private boolean OnDeath = false;
	public long seed;
	public boolean AddBossProgress = false;
	public DamageSource LastDamageSource = DamageSource.GENERIC;

	public TheVoidCubeEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(EndlessDeepSpaceModEntities.THE_VOID_CUBE.get(), world);
	}

	public TheVoidCubeEntity(EntityType<TheVoidCubeEntity> type, Level world) {
		super(type, world);
		xpReward = 20000;
		setNoAi(false);
		setPersistenceRequired();
		this.noCulling = true;
		this.seed = this.random.nextLong();
		if (this.level.isClientSide) {
			EndlessDeepSpaceMod.addBoss(this);
		}
	}

	@Override
	public void remove(Entity.RemovalReason p_146876_) {
		if (this.level.isClientSide) {
			EndlessDeepSpaceMod.removeBoss(this);
		}
		super.remove(p_146876_);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	protected void defineSynchedData() {
      	super.defineSynchedData();
      	this.entityData.define(DataSummoned, false);
      	this.entityData.define(BossProgress, 0);
   	}

   	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

   	public int getIntegerData(EntityDataAccessor data) {
		return (int)this.entityData.get(data);
	}

	public void setIntegerData(EntityDataAccessor data, int number) {
		this.entityData.set(data, number);
	}

   	public void addAdditionalSaveData(CompoundTag p_31485_) {
   		super.addAdditionalSaveData(p_31485_);
   		p_31485_.putBoolean("summoned", this.entityData.get(DataSummoned));
   		p_31485_.putInt("BossProgress", this.getIntegerData(BossProgress));
   	}

   	public void readAdditionalSaveData(CompoundTag p_31055_) {
   		super.readAdditionalSaveData(p_31055_);
   		this.entityData.set(DataSummoned, p_31055_.getBoolean("summoned"));
   		this.setIntegerData(BossProgress, p_31055_.getInt("BossProgress"));
   	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, LivingEntity.class, false, false));
		this.goalSelector.addGoal(3, new TheVoidCubeEntity.TheVoidCubeAttackGoal(this));
		this.goalSelector.addGoal(3, new TheVoidCubeEntity.TheVoidCubeGoToVoidForTargetGoal(this));
		this.goalSelector.addGoal(3, new TheVoidCubeEntity.TheVoidCubeAttackByColorfulLightningBoltForTargetGoal(this));
		this.goalSelector.addGoal(3, new TheVoidCubeEntity.ScreamingGhastShootMagicBulletGoal(this));
      	this.goalSelector.addGoal(3, new TheVoidCubeEntity.ScreamingGhastShootGravityBombGoal(this));
      	this.goalSelector.addGoal(3, new TheVoidCubeEntity.GhastShootFireballGoal(this));
      	this.goalSelector.addGoal(3, new TheVoidCubeEntity.TheVoidCubeEffectByColorfulLightningBoltForTargetGoal(this));
      	this.goalSelector.addGoal(3, new TheVoidCubeEntity.TheVoidCubeAttackByEvokerFangsForTargetGoal(this));
      	this.goalSelector.addGoal(3, new TheVoidCubeEntity.GhastShootEnderDragonWindBombGoal(this));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new FloatGoal(this));
		this.goalSelector.addGoal(6, new BreakDoorGoal(this, e -> true));
	}

	public boolean addEffect(MobEffectInstance p_182397_, @Nullable Entity p_182398_) {
      	return false;
   	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getAmbientSound() {
		if (this.getIntegerData(BossProgress) == 2 && !this.AddBossProgress) {
			return SoundEvents.GHAST_AMBIENT;
		} else {
			return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport"));
		}
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.hurt"));
	}

	protected float getSoundVolume() {
      	return 10.0F;
   	}

   	public boolean isAlive() {
      	return !this.isRemoved() && this.getIntegerData(BossProgress) != -1;
   	}

   	public void die(DamageSource source) {
   		if (this.getIntegerData(BossProgress) == -1) {
   			super.die(source);
			this.bossInfo.setProgress(0.0F);
   		}
	}

	public boolean isDeadOrDying() {
      	return this.getIntegerData(BossProgress) == -1;
   	}

   	public void heal(float amount) {
   		if (this.getIntegerData(BossProgress) != 2 && this.getIntegerData(BossProgress) != -1) {
   			super.heal(amount);
   		}
   	}

   	public void setHealth(float amount) {
   		if (this.getIntegerData(BossProgress) != 2) {
   			super.setHealth(amount);
   		}
   	}

	public void tick() {
		super.tick();
		this.setNoGravity(true);
		this.seed = this.random.nextLong();
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
		Vec3 vec3 = this.getDeltaMovement();
      	this.push(-vec3.x, -vec3.y, -vec3.z);
		if (!this.level.isClientSide && !this.entityData.get(DataSummoned)) {
			ModMessages.sendToAllPlayers(new SendEndlessDeepSpaceCommonToastS2CPacket(new ItemStack(EndlessDeepSpaceModItems.THE_VOID_CUBE_SPAWN_EGG.get()), this.getDisplayName(), Component.translatable("endless_deep_space.boss.spawning", this.getDisplayName()), 5000L, -11534256, -16777216));
			this.entityData.set(DataSummoned, true);
		}
		if (this.tickCount % 20 == 0) {
			if (this.getIntegerData(BossProgress) == 0) {
        		this.heal(0.5F);
			} else if (this.getIntegerData(BossProgress) == 1) {
				this.heal(1.0F);
			} else if (this.getIntegerData(BossProgress) == 3) {
				this.heal(2.0F);
			}
      	}
		if (!this.level.isClientSide) {
			if (!this.isAlive()) {
				TrackingUtil.forceEffect(this, LivingEntity.class, 40.0D, -100.0D, 100.0D);
			} else {
				if (this.getIntegerData(BossProgress) == 0 && !this.AddBossProgress) {
					TrackingUtil.forceEffect(this, LivingEntity.class, 40.0D, 100.0D, 100.0D);
				}
			}
		}
		if (this.tickCount % 20 == 0 && this.getIntegerData(BossProgress) == 2 && !this.AddBossProgress) {
			super.setHealth(this.getHealth() - 2);
			if (this.getHealth() <= 0) {
				this.AddBossProgress = true;
			}
		}
		if (this.getIntegerData(BossProgress) != 2) {
			this.bossInfo.setColor(BossEvent.BossBarColor.PURPLE);
			this.bossInfo.setName(this.getDisplayName());
		}
		if (this.getIntegerData(BossProgress) >= 3 && this.getHealth() <= 1) {
			this.setIntegerData(BossProgress, -1);
			this.OnDeath = true;
			super.setHealth(0.0F);
		}
		if (this.getIntegerData(BossProgress) > 3) {
			this.hurt(LastDamageSource, Float.MAX_VALUE);
			this.setIntegerData(BossProgress, -1);
			this.OnDeath = true;
			super.setHealth(0.0F);
		}
		if (this.getIntegerData(BossProgress) == 2 && !this.AddBossProgress) {
			if (this.HalfHealth()) {
				this.bossInfo.setColor(BossEvent.BossBarColor.RED);
			} else {
				this.bossInfo.setColor(BossEvent.BossBarColor.WHITE);
			}
			this.bossInfo.setName(Component.translatable("entity.endless_deep_space.screaming_ghast"));
			this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
		}
		if (this.AddBossProgress && this.getIntegerData(BossProgress) != -1) {
			int timer = 0;
			timer++;
			if (this.getHealth() < this.getMaxHealth()) {
				this.setNoAi(true);
				super.setHealth(this.getHealth() + 1);
				this.bossInfo.setColor(BossEvent.BossBarColor.PURPLE);
				this.bossInfo.setName(this.getDisplayName());
			} else {
				this.setNoAi(false);
				this.AddBossProgress = false;
				this.setIntegerData(BossProgress, this.getIntegerData(BossProgress) + 1);
			}
		}
	}

	public void kill() {
		this.setIntegerData(BossProgress, -1);
		super.kill();
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		float LastAmount = amount / ((this.getIntegerData(BossProgress) == 3) ? 6 : 4);
		LastDamageSource = source;
		if (source == DamageSource.FALL)
			return false;
		if (source == DamageSource.CACTUS)
			return false;
		if (source == DamageSource.DROWN)
			return false;
		if (source == DamageSource.LIGHTNING_BOLT)
			return false;
		if (source.isExplosion())
			return false;
		if (source == DamageSource.ANVIL)
			return false;
		if (source == DamageSource.DRAGON_BREATH)
			return false;
		if (source == DamageSource.WITHER)
			return false;
		if (source.getMsgId().equals("witherSkull"))
			return false;
		if (this.AddBossProgress)
			return false;
		if (this.getIntegerData(BossProgress) == 2)
			return false;
		if ((this.getIntegerData(BossProgress) != -1 || this.getIntegerData(BossProgress) <= 3) && LastAmount >= this.getHealth() && !this.AddBossProgress && !this.OnDeath) {
			this.AddBossProgress = true;
			super.setHealth(0.1F);
			return true;
		}
		return super.hurt(source, LastAmount);
	}

	@Override
	public boolean canCollideWith(Entity entity) {
		return true;
	}

	public boolean HalfHealth() {
   		return (this.getHealth() <= this.getMaxHealth() / 2) ? true : false;
   	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	@Override
	public boolean canChangeDimensions() {
		return false;
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void customServerAiStep() {
		super.customServerAiStep();
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 400);
		builder = builder.add(Attributes.ARMOR, 4);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 6);
		builder = builder.add(Attributes.FOLLOW_RANGE, 2048);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1000);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 3);
		return builder;
	}

	protected boolean shouldDespawnInPeaceful() {
      	return false;
   	}

   	protected void tickDeath() {
   		if (this.getIntegerData(BossProgress) == -1) {
   			TheVoidCubeDeathTime++;
   			OnDeath = true;
   			this.noPhysics = true;
   			this.bossInfo.setProgress(0.0F);
   			if (TheVoidCubeDeathTime == 1) {
   				if (!this.level.isClientSide()) {
					this.level.playSound(null, new BlockPos(this.getX(), this.getY(), this.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.death")), SoundSource.HOSTILE, 10, 1);
				} else {
					this.level.playLocalSound(this.getX(), this.getY(), this.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.death")), SoundSource.HOSTILE, 10, 1, false);
				}
   			}
   			this.move(MoverType.SELF, new Vec3(0.0D, (double)0.1F, 0.0D));
      		this.setYRot(this.getYRot() + 20.0F);
      		this.yBodyRot = this.getYRot();
   			if (TheVoidCubeDeathTime == 200 && this.level instanceof ServerLevel) {
   				this.remove(Entity.RemovalReason.KILLED);
         		this.gameEvent(GameEvent.ENTITY_DIE);
         		if (LastDamageSource != null && LastDamageSource.getEntity() != null) {
         			this.dropAllDeathLoot(LastDamageSource);
         			for(int i = 0;i < 10;i++) {
         				this.level.addFreshEntity(new ExperienceOrb(this.level, this.getX(), this.getY(), this.getZ(), 2000));
         			}
         			if (LastDamageSource.getEntity() instanceof ServerPlayer) {
						ServerPlayer player = (ServerPlayer)LastDamageSource.getEntity();
						player.awardStat(StatsInit.BOSS_DEFEAT_TIMES.get());
					}
         			if (!(LastDamageSource.getEntity() instanceof Player)) {
         				LastDamageSource.getEntity().remove(Entity.RemovalReason.KILLED);
         				LastDamageSource.getEntity().gameEvent(GameEvent.ENTITY_DIE);
         			}
         		}
   			}
   		}
   	}

	static class TheVoidCubeAttackGoal extends Goal {
		
		private TheVoidCubeEntity voidCube;
		private int NextAttackTick;
		
		public TheVoidCubeAttackGoal(TheVoidCubeEntity voidCubes) {
			this.voidCube = voidCubes;
		}

		public boolean canUse() {
			LivingEntity livingentity = this.voidCube.getTarget();
      		if (livingentity == null) {
         		return false;
      		} else if (!livingentity.isAlive()) {
         		return false;
      		} else if (this.voidCube.OnDeath) {
      			return false;
      		} else if (this.voidCube.getIntegerData(this.voidCube.BossProgress) != 0) {
      			return false;
      		} else {
      			return true;
      		}
		}

		public boolean canContinueToUse() {
			LivingEntity livingentity = this.voidCube.getTarget();
      		if (livingentity == null) {
         		return false;
      		} else if (!livingentity.isAlive()) {
         		return false;
      		} else if (this.voidCube.getIntegerData(this.voidCube.BossProgress) != 0) {
      			return false;
      		} else if (this.voidCube.OnDeath) {
      			return false;
      		} else {
      			return true;
      		}
		}

		public void start() {
      		this.voidCube.setAggressive(true);
      		this.NextAttackTick = -20;
   		}

   		public void stop() {
      		LivingEntity livingentity = this.voidCube.getTarget();
      		this.voidCube.setAggressive(false);
   		}

   		public boolean requiresUpdateEveryTick() {
      		return true;
   		}

   		public void tick() {
      		LivingEntity livingentity = this.voidCube.getTarget();
      		if (livingentity != null) {
      			this.NextAttackTick++;
      			if (this.NextAttackTick < 40) {
      				((ServerLevel) livingentity.level).sendParticles(ParticleTypes.DRAGON_BREATH, livingentity.getX(), livingentity.getY(), livingentity.getZ(), 40, 0, 0, 0, 0.08);
      			}
      			if (this.NextAttackTick >= 40) {
      				((ServerLevel) livingentity.level).sendParticles(ParticleTypes.DRAGON_BREATH, livingentity.getX(), livingentity.getY(), livingentity.getZ(), 60, 0, 0, 0, 0.02);
      				livingentity.invulnerableTime = 0;
      				this.voidCube.doHurtTarget(livingentity);
      				Vec3 vec3 = livingentity.getDeltaMovement();
      				livingentity.push(-vec3.x, -vec3.y, -vec3.z);
      				if (livingentity instanceof ServerPlayer player && !player.getAbilities().instabuild) {
                		player.connection.send(new ClientboundSetEntityMotionPacket(livingentity));
            		}
      				if (this.NextAttackTick >= 100) {
      					this.NextAttackTick = 0;
      					((ServerLevel) livingentity.level).sendParticles(ParticleTypes.DRAGON_BREATH, livingentity.getX(), livingentity.getY(), livingentity.getZ(), 80, 0, 0, 0, 0.2);
      				}
      			}
			}
   		}
	}

	static class TheVoidCubeGoToVoidForTargetGoal extends Goal {
		private TheVoidCubeEntity voidCube;
		private int Cooldown;

		public TheVoidCubeGoToVoidForTargetGoal(TheVoidCubeEntity voidCubes) {
			this.voidCube = voidCubes;
		}

		public boolean canUse() {
			return this.voidCube.getTarget() != null && this.voidCube.getIntegerData(this.voidCube.BossProgress) == 0;
		}

		public void start() {
			this.Cooldown = 100;
		}

		public boolean requiresUpdateEveryTick() {
         	return true;
      	}

		public void tick() {
			LivingEntity livingentity = this.voidCube.getTarget();
         	if (livingentity != null) {
         		this.Cooldown--;
         		if (this.Cooldown == 0) {
         			livingentity.hurt(DamageSource.OUT_OF_WORLD, livingentity.getMaxHealth() / 3);
         			this.Cooldown = 100;
         		}
         	} else {
         		if (this.Cooldown > 100) {
         			this.Cooldown++;
         		}
         	}
		}
	}

	static class TheVoidCubeAttackByColorfulLightningBoltForTargetGoal extends Goal {
		private TheVoidCubeEntity voidCube;
		private int chargeTime1;

		public TheVoidCubeAttackByColorfulLightningBoltForTargetGoal(TheVoidCubeEntity voidCubes) {
			this.voidCube = voidCubes;
		}

		public boolean canUse() {
			return this.voidCube.getTarget() != null && this.voidCube.getIntegerData(this.voidCube.BossProgress) == 1;
		}

		public void start() {
			this.chargeTime1 = 0;
		}

		public boolean requiresUpdateEveryTick() {
         	return true;
      	}

		public void tick() {
			LivingEntity livingentity = this.voidCube.getTarget();
         	if (livingentity != null) {
         		this.chargeTime1++;
         		if (this.chargeTime1 == 40) {
         			if (this.voidCube.level instanceof ServerLevel _level) {
						ColorfulLightningBolt entityToSpawn = new ColorfulLightningBolt(_level, livingentity.getX(), livingentity.getY(), livingentity.getZ(), this.voidCube.HalfHealth() ? 255 : 0, this.voidCube.HalfHealth() ? 62 : 238, this.voidCube.HalfHealth() ? 17 : 184);
						entityToSpawn.setVisualOnly(false);
						entityToSpawn.setDamage(this.voidCube.HalfHealth() ? 8.0F : 5.0F);
						_level.addFreshEntity(entityToSpawn);
					}
         			this.chargeTime1 = 0;
         		}
         	} else {
         		if (this.chargeTime1 > 0) {
         			this.chargeTime1--;
         		}
         	}
		}
	}

	static class GhastShootFireballGoal extends Goal {
      	private final TheVoidCubeEntity ghast;
      	public int chargeTime;

      	public GhastShootFireballGoal(TheVoidCubeEntity p_32776_) {
         	this.ghast = p_32776_;
      	}

      	public boolean canUse() {
         	return this.ghast.getTarget() != null && this.ghast.HalfHealth() && this.ghast.getIntegerData(this.ghast.BossProgress) == 2;
      	}

      	public void start() {
         	this.chargeTime = 0;
      	}

      	public boolean requiresUpdateEveryTick() {
         	return true;
      	}

      	public void tick() {
         	LivingEntity livingentity = this.ghast.getTarget();
         	if (livingentity != null) {
            	double d0 = 100.0D;
            	if (livingentity.distanceToSqr(this.ghast) < 4096.0D) {
               		Level level = this.ghast.level;
               		++this.chargeTime;
               		if (this.chargeTime == 10 && !this.ghast.isSilent()) {
                  		level.levelEvent((Player)null, 1015, this.ghast.blockPosition(), 0);
               		}

               		if (this.chargeTime == 20) {
                  		double d1 = 4.0D;
                  		Vec3 vec3 = this.ghast.getViewVector(1.0F);
                  		double d2 = livingentity.getX() - (this.ghast.getX() + vec3.x * 4.0D);
                  		double d3 = livingentity.getY(0.5D) - (0.5D + this.ghast.getY(0.5D));
                  		double d4 = livingentity.getZ() - (this.ghast.getZ() + vec3.z * 4.0D);
                  		if (!this.ghast.isSilent()) {
                     		level.levelEvent((Player)null, 1016, this.ghast.blockPosition(), 0);
                  		}

                  		ScreamingGhastFirball largefireball = new ScreamingGhastFirball(ProjectileInit.SCREAMING_GHAST_FIRBALL.get(), level, this.ghast, d2, d3, d4, 14);
                  		largefireball.setPos(this.ghast.getX() + vec3.x * 4.0D, this.ghast.getY(0.5D) + 0.5D, largefireball.getZ() + vec3.z * 4.0D);
                  		level.addFreshEntity(largefireball);
                  		this.chargeTime = 0;
               		}
            	} else if (this.chargeTime > 0) {
               		--this.chargeTime;
            	}
         	}
      	}
   	}

   	static class ScreamingGhastShootMagicBulletGoal extends Goal {
   		private final TheVoidCubeEntity ghast;
   		public int Charge_Time;

   		public ScreamingGhastShootMagicBulletGoal(TheVoidCubeEntity ghast) {
   			this.ghast = ghast;
   		}

   		public boolean canUse() {
         	return this.ghast.getTarget() != null && !(this.ghast.HalfHealth()) && this.ghast.getIntegerData(this.ghast.BossProgress) == 2;
      	}

      	public void start() {
         	this.Charge_Time = 0;
      	}

      	public void tick() {
         	LivingEntity livingentity = this.ghast.getTarget();
         	if (livingentity != null) {
            	double d0 = 100.0D;
            	if (livingentity.distanceToSqr(this.ghast) < 4096.0D) {
               		Level level = this.ghast.level;
               		++this.Charge_Time;
               		if (this.Charge_Time == 10 || this.Charge_Time == 30 || this.Charge_Time == 50) {
               			if (!this.ghast.isSilent()) {
                  			level.levelEvent((Player)null, 1015, this.ghast.blockPosition(), 0);
               			}
               		}
               		if (this.Charge_Time == 20 || this.Charge_Time == 40 || this.Charge_Time == 60) {
                  		double d1 = 4.0D;
                  		Vec3 vec3 = this.ghast.getViewVector(1.0F);
                  		double d2 = livingentity.getX() - (this.ghast.getX() + vec3.x * 4.0D);
                  		double d3 = livingentity.getY(0.5D) - (0.5D + this.ghast.getY(0.5D));
                  		double d4 = livingentity.getZ() - (this.ghast.getZ() + vec3.z * 4.0D);
                  		if (!this.ghast.isSilent()) {
                     		level.levelEvent((Player)null, 1016, this.ghast.blockPosition(), 0);
                  		}
                  		for (int i = 0;i < 4; i++) {
                  			ScreamingGhastMagicBullet magicBullet = new ScreamingGhastMagicBullet(level, this.ghast);
                  			magicBullet.setPos(this.ghast.getX(), this.ghast.getY(0.5D) + 0.5D, this.ghast.getZ());
                  			magicBullet.shoot(d2, d3, d4, 2, 0);
                  			level.addFreshEntity(magicBullet);
                  			continue;
                  		}
                  		if (this.Charge_Time == 60) {
                  			this.Charge_Time = 0;
                  		}
               		}
            	} else if (this.Charge_Time > 0) {
               		--this.Charge_Time;
            	}
         	}
      	}
   	}

   	static class ScreamingGhastShootGravityBombGoal extends Goal {
   		private final TheVoidCubeEntity ghast;
   		public int Charge_Times;

   		public ScreamingGhastShootGravityBombGoal(TheVoidCubeEntity ghast) {
   			this.ghast = ghast;
   		}

   		public boolean canUse() {
         	return (this.ghast.getTarget() != null) && this.ghast.getIntegerData(this.ghast.BossProgress) == 2;
      	}

      	public void start() {
         	this.Charge_Times = 100;
      	}

      	public void tick() {
         	LivingEntity livingentity = this.ghast.getTarget();
         	if (livingentity != null) {
            	double d0 = 100.0D;
            	if (livingentity.distanceToSqr(this.ghast) < 4096.0D) {
               		Level level = this.ghast.level;
               		++this.Charge_Times;
               		if (this.Charge_Times == 200) {
                  		double d1 = 4.0D;
                  		Vec3 vec3 = this.ghast.getViewVector(1.0F);
                  		double d2 = livingentity.getX() - (this.ghast.getX() + vec3.x * 4.0D);
                  		double d3 = livingentity.getY(0.5D) - (0.5D + this.ghast.getY(0.5D));
                  		double d4 = livingentity.getZ() - (this.ghast.getZ() + vec3.z * 4.0D);
                  		if (!this.ghast.isSilent()) {
                     		level.levelEvent((Player)null, 1016, this.ghast.blockPosition(), 0);
                  		}
                  		if (this.ghast.HalfHealth()) {
                  			ScreamingGhastGravityBomb gravityBomb = new ScreamingGhastGravityBomb(ProjectileInit.SCREAMING_GHAST_GRAVITY_BOMB.get(), level, this.ghast, true);
                  			gravityBomb.setPos(this.ghast.getX(), this.ghast.getY(0.5D) + 0.5D, this.ghast.getZ());
                  			gravityBomb.shoot(d2, d3, d4, 2, 0);
                  			level.addFreshEntity(gravityBomb);
                  		} else {
                  			ScreamingGhastGravityBomb gravityBomb = new ScreamingGhastGravityBomb(ProjectileInit.SCREAMING_GHAST_GRAVITY_BOMB.get(), level, this.ghast);
                  			gravityBomb.setPos(this.ghast.getX(), this.ghast.getY(0.5D) + 0.5D, this.ghast.getZ());
                  			gravityBomb.shoot(d2, d3, d4, 2, 0);
                  			level.addFreshEntity(gravityBomb);
                  		}
                  		this.Charge_Times = 0;
               		}
            	} else if (this.Charge_Times > 0) {
               		--this.Charge_Times;
            	}
         	}
      	}
   	}

   	static class TheVoidCubeEffectByColorfulLightningBoltForTargetGoal extends Goal {
		private TheVoidCubeEntity voidCube;

		public TheVoidCubeEffectByColorfulLightningBoltForTargetGoal(TheVoidCubeEntity voidCubes) {
			this.voidCube = voidCubes;
		}

		public boolean canUse() {
			return this.voidCube.getTarget() != null && this.voidCube.getIntegerData(this.voidCube.BossProgress) == 3;
		}

		public boolean requiresUpdateEveryTick() {
         	return true;
      	}

		public void tick() {
			LivingEntity livingentity = this.voidCube.getTarget();
         	if (livingentity != null) {
         		if (this.voidCube.level instanceof ServerLevel _level) {
					ColorfulLightningBolt effect1 = new ColorfulLightningBolt(_level, livingentity.getX(), livingentity.getY(), livingentity.getZ(), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255));
					effect1.setVisualOnly(true);
					_level.addFreshEntity(effect1);
				}
         	}
		}
	}

	static class TheVoidCubeAttackByEvokerFangsForTargetGoal extends Goal {
		private TheVoidCubeEntity voidCube;
		private int chargeTime2;

		public TheVoidCubeAttackByEvokerFangsForTargetGoal(TheVoidCubeEntity voidCubes) {
			this.voidCube = voidCubes;
		}

		public boolean canUse() {
			return this.voidCube.getTarget() != null && this.voidCube.getIntegerData(this.voidCube.BossProgress) == 3 && !(this.voidCube.HalfHealth());
		}

		public void start() {
			this.chargeTime2 = 0;
		}

		public boolean requiresUpdateEveryTick() {
         	return true;
      	}

		public void tick() {
			LivingEntity livingentity = this.voidCube.getTarget();
         	if (livingentity != null) {
         		this.chargeTime2++;
         		if (this.chargeTime2 == 20) {
         			if (this.voidCube.level instanceof ServerLevel _level) {
         				livingentity.invulnerableTime = 0;
						double d0 = Math.min(livingentity.getY(), this.voidCube.getY());
         				double d1 = Math.max(livingentity.getY(), this.voidCube.getY()) + 1.0D;
         				float f = (float)Mth.atan2(livingentity.getZ() - this.voidCube.getZ(), livingentity.getX() - this.voidCube.getX());
         				if (this.voidCube.distanceToSqr(livingentity) < 40.0D) {
            				for(int i = 0; i < 5; ++i) {
               					float f1 = f + (float)i * (float)Math.PI * 0.4F;
               					this.createSpellEntity(this.voidCube.getX() + (double)Mth.cos(f1) * 1.5D, this.voidCube.getZ() + (double)Mth.sin(f1) * 1.5D, d0, d1, f1, 0);
            				}

            				for(int k = 0; k < 8; ++k) {
               					float f2 = f + (float)k * (float)Math.PI * 2.0F / 8.0F + 1.2566371F;
               					this.createSpellEntity(this.voidCube.getX() + (double)Mth.cos(f2) * 2.5D, this.voidCube.getZ() + (double)Mth.sin(f2) * 2.5D, d0, d1, f2, 3);
            				}
         				} else {
            				for(int l = 0; l < 60; ++l) {
               					double d2 = 1.25D * (double)(l + 1);
               					int j = 1 * l;
               					this.createSpellEntity(this.voidCube.getX() + (double)Mth.cos(f) * d2, this.voidCube.getZ() + (double)Mth.sin(f) * d2, d0, d1, f, j);
            				}
         				}
         				livingentity.invulnerableTime = 0;
					}
         			this.chargeTime2 = 0;
         		}
         	} else {
         		if (this.chargeTime2 > 0) {
         			this.chargeTime2--;
         		}
         	}
		}

		private void createSpellEntity(double p_32673_, double p_32674_, double p_32675_, double p_32676_, float p_32677_, int p_32678_) {
         	BlockPos blockpos = new BlockPos(p_32673_, p_32676_, p_32674_);
         	boolean flag = false;
         	double d0 = 0.0D;

         	do {
            	BlockPos blockpos1 = blockpos.below();
            	BlockState blockstate = this.voidCube.level.getBlockState(blockpos1);
            	if (blockstate.isFaceSturdy(this.voidCube.level, blockpos1, Direction.UP)) {
               		if (!this.voidCube.level.isEmptyBlock(blockpos)) {
                  		BlockState blockstate1 = this.voidCube.level.getBlockState(blockpos);
                  		VoxelShape voxelshape = blockstate1.getCollisionShape(this.voidCube.level, blockpos);
                  		if (!voxelshape.isEmpty()) {
                     		d0 = voxelshape.max(Direction.Axis.Y);
                  		}
               		}

               		flag = true;
               		break;
            	}

            	blockpos = blockpos.below();
         	} while(blockpos.getY() >= Mth.floor(p_32675_) - 1);

         	if (flag) {
            	this.voidCube.level.addFreshEntity(new EvokerFangs(this.voidCube.level, p_32673_, (double)blockpos.getY() + d0, p_32674_, p_32677_, p_32678_, this.voidCube));
         	}
         	
      	}
	}

	static class GhastShootEnderDragonWindBombGoal extends Goal {
      	private final TheVoidCubeEntity ghast;
      	public int chargeTime3;

      	public GhastShootEnderDragonWindBombGoal(TheVoidCubeEntity p_32776_) {
         	this.ghast = p_32776_;
      	}

      	public boolean canUse() {
         	return this.ghast.getTarget() != null && this.ghast.getIntegerData(this.ghast.BossProgress) == 3;
      	}

      	public void start() {
         	this.chargeTime3 = 0;
      	}

      	public boolean requiresUpdateEveryTick() {
         	return true;
      	}

      	public void tick() {
         	LivingEntity livingentity = this.ghast.getTarget();
         	if (livingentity != null) {
            	double d0 = 100.0D;
            	if (livingentity.distanceToSqr(this.ghast) < 4096.0D) {
               		Level level = this.ghast.level;
               		++this.chargeTime3;
               		if (this.chargeTime3 == 30 && !this.ghast.isSilent()) {
                  		level.levelEvent((Player)null, 1015, this.ghast.blockPosition(), 0);
               		}

               		if (this.chargeTime3 == 40) {
                  		double d1 = 4.0D;
                  		Vec3 vec3 = this.ghast.getViewVector(1.0F);
                  		double d2 = livingentity.getX() - (this.ghast.getX() + vec3.x * 4.0D);
                  		double d3 = livingentity.getY(0.5D) - (0.5D + this.ghast.getY(0.5D));
                  		double d4 = livingentity.getZ() - (this.ghast.getZ() + vec3.z * 4.0D);
                  		if (!this.ghast.isSilent()) {
                     		level.levelEvent((Player)null, 1016, this.ghast.blockPosition(), 0);
                  		}

                  		EnderDragonWindBomb largefireball = new EnderDragonWindBomb(ProjectileInit.ENDER_DRAGON_WIND_BOMB.get(), level, this.ghast, d2, d3, d4);
                  		largefireball.setPos(this.ghast.getX() + vec3.x * 4.0D, this.ghast.getY(0.5D) + 0.5D, largefireball.getZ() + vec3.z * 4.0D);
                  		level.addFreshEntity(largefireball);
                  		this.chargeTime3 = 0;
               		}
            	} else if (this.chargeTime3 > 0) {
               		--this.chargeTime3;
            	}
         	}
      	}
   	}
}
