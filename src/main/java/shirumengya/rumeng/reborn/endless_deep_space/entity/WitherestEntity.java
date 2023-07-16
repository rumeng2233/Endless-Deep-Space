
package shirumengya.rumeng.reborn.endless_deep_space.entity;

import shirumengya.rumeng.reborn.endless_deep_space.init.*;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.WitherestTickProcedure;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.AABB;
import java.util.EnumSet;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.core.particles.ParticleTypes;
import shirumengya.rumeng.reborn.endless_deep_space.custom.world.damagesource.EndlessDeepSpaceDamageSource;
<<<<<<< Updated upstream
=======
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.entity.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.packet.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.nbt.CompoundTag;
import shirumengya.rumeng.reborn.endless_deep_space.custom.event.*;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
>>>>>>> Stashed changes

public class WitherestEntity extends WitherBoss {
	private final ServerBossEvent AssaultValue = new ServerBossEvent(Component.translatable("entity.endless_deep_space.witherest.assault_value"), ServerBossEvent.BossBarColor.BLUE,
			ServerBossEvent.BossBarOverlay.PROGRESS);
	public int WitherestDeathTime = 0;

	public WitherestEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(EndlessDeepSpaceModEntities.WITHEREST.get(), world);
	}

	public WitherestEntity(EntityType<WitherestEntity> type, Level world) {
		super(type, world);
		xpReward = 5000;
		setNoAi(false);
		setPersistenceRequired();
		this.moveControl = new FlyingMoveControl(this, 10, false);
		this.noCulling = true;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		WitherestTickProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
		this.AssaultValue.setProgress((float) this.getPersistentData().getDouble("endless_deep_space:assault_value") / 100.0F);
<<<<<<< Updated upstream
=======
		if (!this.level.isClientSide && !this.entityData.get(DataSummoned)) {
			ModMessages.sendToAllPlayers(new SendEndlessDeepSpaceCommonToastS2CPacket(new ItemStack(EndlessDeepSpaceModItems.WITHEREST_SPAWN_EGG.get()), this.getDisplayName(), Component.translatable("endless_deep_space.boss.spawning", this.getDisplayName()), 5000L, -11534256, -16777216));
			this.entityData.set(DataSummoned, true);
		}
>>>>>>> Stashed changes
	}

	@Override
	public void makeInvulnerable() {
		super.makeInvulnerable();
      	this.setHealth(this.getMaxHealth());
   	}

	@Override
	public boolean canChangeDimensions() {
		return false;
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.AssaultValue.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.AssaultValue.removePlayer(player);
	}

	public void aiStep() {
		super.aiStep();
		this.setNoGravity(true);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.5);
		builder = builder.add(Attributes.MAX_HEALTH, 400);
		builder = builder.add(Attributes.ARMOR, 6);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 5);
		builder = builder.add(Attributes.FOLLOW_RANGE, 64);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 10);
		builder = builder.add(Attributes.FLYING_SPEED, 0.8);
		return builder;
	}

	@Override
   protected void tickDeath() {
      ++this.WitherestDeathTime;
//      this.move(MoverType.SELF, new Vec3(0.0D, (double)0.05F, 0.0D));
      this.setYRot(this.getYRot() + 10.0F);
      this.setYHeadRot(this.getYHeadRot() + 10.0F);
      this.setDeltaMovement(new Vec3(0, 0, 0));
      this.yBodyRot = this.getYRot();
      this.setNoAi(true);
      this.setHealth(0.0F);
      if (this.WitherestDeathTime == 400 && this.level instanceof ServerLevel) {
         this.remove(Entity.RemovalReason.KILLED);
         this.gameEvent(GameEvent.ENTITY_DIE);
         this.deathKillAll();
         Explosion.BlockInteraction explosion$blockinteraction = this.level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
         this.level.explode(this, this.getX(), this.getEyeY(), this.getZ(), 20.0F, false, explosion$blockinteraction);
      }
   }

   	private void deathKillAll () {
   		{
			final Vec3 _center = new Vec3(this.getX(), this.getY(), this.getZ());
			List<Entity> _entfound = this.level.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(38 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player) {
					entityiterator.hurt(EndlessDeepSpaceDamageSource.WrathOfWither(this), Float.MAX_VALUE);
				} else {
					if (!entityiterator.level.isClientSide())
						entityiterator.remove(Entity.RemovalReason.DISCARDED);
						entityiterator.remove(Entity.RemovalReason.KILLED);
						this.level.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 0, 0, 0);
					if (entityiterator instanceof LivingEntity _entity)
						_entity.setHealth(0);
				}
			}
		}
   	}

   public boolean canBeCollidedWith() {
      return true;
   }

   	protected boolean shouldDespawnInPeaceful() {
      	return false;
   	}
}
