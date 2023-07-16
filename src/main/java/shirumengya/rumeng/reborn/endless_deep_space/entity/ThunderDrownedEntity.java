package shirumengya.rumeng.reborn.endless_deep_space.entity;

import java.util.EnumSet;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.monster.Drowned;
import shirumengya.rumeng.reborn.endless_deep_space.init.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.event.*;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.network.PlayMessages;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import shirumengya.rumeng.reborn.endless_deep_space.custom.world.damagesource.EndlessDeepSpaceDamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.Util;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.resources.ResourceLocation;

public class ThunderDrownedEntity extends Drowned {
	
	private CustomServerBossEvent bossInfo = new CustomServerBossEvent(this, this.getDisplayName(), CustomServerBossEvent.BossBarColor.BLUE, CustomServerBossEvent.BossBarOverlay.PROGRESS);
	private static final EntityDataAccessor<Float> Data_Shield = SynchedEntityData.defineId(ThunderDrownedEntity.class, EntityDataSerializers.FLOAT);
	private int timer = 0;
	private boolean ShieldHeal = false;

	public ThunderDrownedEntity(EntityType<? extends ThunderDrownedEntity> p_32344_, Level p_32345_) {
		super(p_32344_, p_32345_);
		xpReward = 80;
		ItemStack itemstack = new ItemStack(Items.TRIDENT);
		itemstack.enchant(EndlessDeepSpaceModEnchantments.HEAVENLY_THUNDER_PUNISHMENT.get(), 1);
		this.setItemSlot(EquipmentSlot.MAINHAND, itemstack);
		if (this.level.isClientSide) {
			EndlessDeepSpaceMod.addBoss(this);
		}
	}

	public ThunderDrownedEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(EndlessDeepSpaceModEntities.THUNDER_DROWNED.get(), world);
	}

	@Override
	public void remove(Entity.RemovalReason p_146876_) {
		if (this.level.isClientSide) {
			EndlessDeepSpaceMod.removeBoss(this);
		}
		super.remove(p_146876_);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
      	this.getEntityData().define(Data_Shield, (float)60.0);
   	}

	public void addAdditionalSaveData(CompoundTag p_31062_) {
		super.addAdditionalSaveData(p_31062_);
      	p_31062_.putFloat("Shield", this.getShield());
   	}

   	public void readAdditionalSaveData(CompoundTag p_31055_) {
   		super.readAdditionalSaveData(p_31055_);
    	this.setShield(p_31055_.getFloat("Shield"));
   	}

   	public float getShield() {
      	return this.getEntityData().get(Data_Shield);
   	}

   	public float getMaxShield() {
   		return (float)this.getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:max_shield"))).getValue();
   	}

   	public void setShield(float p_31511_) {
   		if (p_31511_ > this.getMaxShield()) {
      		this.getEntityData().set(Data_Shield, this.getMaxShield());
   		} else {
   			this.getEntityData().set(Data_Shield, p_31511_);
   		}
   	}

   	public boolean hasShield() {
   		return this.getShield() > 0;
   	}

   	@Override
	public boolean canChangeDimensions() {
		return false;
	}

	@Override
   	public boolean isDeadOrDying() {
      return this.getHealth() <= 0.0F && this.getShield() <= 0.0F;
   	}

	@Override
   	public boolean isAlive() {
      	return !this.isRemoved() && (this.getHealth() > 0.0F || this.getShield() > 0.0F);
   	}

	@Override
   	public void die(DamageSource source) {
   		if ((this.getHealth() <= 0) && (this.getShield() <= 0)) {
   			super.die(source);
			this.bossInfo.setProgress(0.0F);
   		}
	}

	@Override
   	public void kill() {
   		this.setShield(0.0F);
   		super.setHealth(0.0F);
   		ShieldHeal = false;
   		this.bossInfo.setProgress(0.0F);
   	}

	@Override
   	public boolean addEffect(MobEffectInstance p_182397_, @Nullable Entity p_182398_) {
      	return false;
   	}

	@Override
   	public boolean hurt(DamageSource source, float amount) {
   		float LastAmount = ((amount / 4) > 20) ? 20 : amount / 4;
   		if (this.isInvulnerableTo(source)) {
         	return false;
      	} else if (source == EndlessDeepSpaceDamageSource.COLORFUL_LIGHTNING_BOLT) {
      		return false;
      	} else if (this.getShield() > 0) {
         	if (!(source.getEntity() instanceof ThunderDrownedEntity) && this.invulnerableTime <= 0) {
            	this.setShield(this.getShield() - LastAmount);
            	this.invulnerableTime = 10;
         	}
         	return true;
      	} else {
      		return super.hurt(source, LastAmount);
      	}
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
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		ItemStack itemstack = new ItemStack(Items.TRIDENT);
		itemstack.enchant(EndlessDeepSpaceModEnchantments.HEAVENLY_THUNDER_PUNISHMENT.get(), 1);
		this.setItemSlot(EquipmentSlot.MAINHAND, itemstack);
		super.setHealth(this.getMaxHealth());
		this.setShield(60);
		return retval;
	}

	public void tick() {
		super.tick();
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
		if (!(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.HEAVENLY_THUNDER_PUNISHMENT.get(), this.getMainHandItem()) != 0)) {
			this.getMainHandItem().enchant(EndlessDeepSpaceModEnchantments.HEAVENLY_THUNDER_PUNISHMENT.get(), 1);
		}
		if (this.tickCount % 20 == 0) {
			this.setShield(this.getShield() + 1);
			this.heal(1);
		}
		if (this.getShield() <= 0) {
			this.setShield(0);
		}
		if (this.getShield() > this.getMaxShield()) {
			this.setShield(this.getMaxShield());
		}
		ItemStack itemstack = new ItemStack(Items.TRIDENT);
		itemstack.enchant(EndlessDeepSpaceModEnchantments.HEAVENLY_THUNDER_PUNISHMENT.get(), 1);
		this.setItemSlot(EquipmentSlot.MAINHAND, itemstack);
		if (!ShieldHeal) {
			timer++;
		}
		if (timer >= 1200 && !ShieldHeal) {
			ShieldHeal = true;
			timer = 0;
		}
		if (ShieldHeal) {
			if (this.getShield() < this.getMaxShield()) {
				this.setShield(this.getShield() + 1);
			} else {
				ShieldHeal = false;
			}
		}
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	public static void init() {
		SpawnPlacements.register(EndlessDeepSpaceModEntities.THUNDER_DROWNED.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (ThunderDrownedEntity.checkThunderDrownedSpawnRules(entityType, world, reason, pos, random)));
	}

	public static boolean checkThunderDrownedSpawnRules(EntityType<ThunderDrownedEntity> p_218956_, ServerLevelAccessor p_218957_, MobSpawnType p_218958_, BlockPos p_218959_, RandomSource p_218960_) {
      	if (!p_218957_.getFluidState(p_218959_.below()).is(FluidTags.WATER)) {
         	return false;
      	} else {
         	Holder<Biome> holder = p_218957_.getBiome(p_218959_);
         	boolean flag = p_218957_.getDifficulty() != Difficulty.PEACEFUL && isDarkEnoughToSpawn(p_218957_, p_218959_, p_218960_) && (p_218958_ == MobSpawnType.SPAWNER || p_218957_.getFluidState(p_218959_).is(FluidTags.WATER));
         	if (holder.is(BiomeTags.MORE_FREQUENT_DROWNED_SPAWNS)) {
            	return p_218960_.nextInt(15) == 0 && flag;
         	} else {
            	return p_218960_.nextInt(40) == 0 && isDeepEnoughToSpawn(p_218957_, p_218959_) && flag;
         	}
      	}
   	}

   	private static boolean isDeepEnoughToSpawn(LevelAccessor p_32367_, BlockPos p_32368_) {
      	return p_32368_.getY() < p_32367_.getSeaLevel() - 5;
   	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.24);
		builder = builder.add(Attributes.MAX_HEALTH, 40);
		builder = builder.add(Attributes.ARMOR, 4);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 4);
		builder = builder.add(Attributes.FOLLOW_RANGE, 128);
		builder = builder.add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
		return builder;
	}
}