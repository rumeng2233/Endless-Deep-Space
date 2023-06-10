
package shirumengya.rumeng.reborn.endless_deep_space.entity;

import shirumengya.rumeng.reborn.endless_deep_space.procedures.MadWitchDangShiTiShouShangShiProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.MadWitchDangShiTiGengXinKeShiProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModEntities;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.BreakDoorGoal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import javax.annotation.Nullable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.world.entity.PowerableMob;

public class MadWitchEntity extends Witch implements PowerableMob {
	private final ServerBossEvent bossInfo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.RED, ServerBossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true).setCreateWorldFog(false);
	private final ServerBossEvent bossInfoTwo = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.GREEN, ServerBossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(false).setCreateWorldFog(true);
	private final ServerBossEvent bossInfoBelowHalfHealth = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.BLUE, ServerBossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(false).setCreateWorldFog(false);
	private final ServerBossEvent BlockValue = new ServerBossEvent(Component.translatable("entity.endless_deep_space.mad_witch.block_value"), ServerBossEvent.BossBarColor.YELLOW,
			ServerBossEvent.BossBarOverlay.PROGRESS);

	public MadWitchEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(EndlessDeepSpaceModEntities.MAD_WITCH.get(), world);
	}

	public MadWitchEntity(EntityType<MadWitchEntity> type, Level world) {
		super(type, world);
		xpReward = 500;
		setNoAi(false);
		setPersistenceRequired();
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.NETHERITE_AXE));
//		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.NETHERITE_HELMET));
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.NETHERITE_CHESTPLATE));
//		this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.NETHERITE_LEGGINGS));
//		this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.NETHERITE_BOOTS));
		
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

   public void readAdditionalSaveData(CompoundTag p_31474_) {
      super.readAdditionalSaveData(p_31474_);
      if (this.hasCustomName()) {
         this.bossInfoBelowHalfHealth.setName(this.getDisplayName());
      }

   }

   public void setCustomName(@Nullable Component p_31476_) {
      super.setCustomName(p_31476_);
      this.bossInfoBelowHalfHealth.setName(this.getDisplayName());
   }

	@Override
	protected void registerGoals() {
		super.registerGoals();

		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {

			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return (double) (4.0 + entity.getBbWidth() * entity.getBbWidth());
			}

		});
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setAlertOthers());
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Mob.class, false, false));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 0.8));
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(7, new FloatGoal(this));
		this.goalSelector.addGoal(8, new BreakDoorGoal(this, e -> true));

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
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		MadWitchDangShiTiShouShangShiProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
		if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
			return false;
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
		return super.hurt(source, amount / 2);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		MadWitchDangShiTiGengXinKeShiProcedure.execute(this);
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
		this.bossInfoBelowHalfHealth.setProgress(this.getHealth() / this.getMaxHealth());
		this.BlockValue.setProgress((float) this.getPersistentData().getDouble("endless_deep_space:block_value") / 100.0F);
		if (Math.random() < 0.08) {
			this.bossInfoBelowHalfHealth.setProgress(2);
			this.bossInfoTwo.setProgress(2);
			this.bossInfo.setProgress(-1);
		}
		if (Math.random() < 0.07) {
			this.bossInfoBelowHalfHealth.setProgress(-1);
			this.bossInfoTwo.setProgress(-1);
			this.bossInfo.setProgress(2);
		}

	}

	@Override
	public boolean canChangeDimensions() {
		return false;
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.bossInfo.addPlayer(player);
		this.bossInfoBelowHalfHealth.addPlayer(player);
		this.BlockValue.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		this.bossInfo.removePlayer(player);
		this.bossInfoBelowHalfHealth.removePlayer(player);
		this.bossInfoTwo.removePlayer(player);
		this.BlockValue.removePlayer(player);
		super.stopSeenByPlayer(player);
	}

	@Override
	public void customServerAiStep() {
		super.customServerAiStep();
//		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
//		this.bossInfoBelowHalfHealth.setProgress(this.getHealth() / this.getMaxHealth());
//		this.BlockValue.setProgress((float) this.getPersistentData().getDouble("endless_deep_space:block_value") / 100.0F);
//		if (Math.random() < 0.08) {
//			this.bossInfoBelowHalfHealth.setProgress(2);
//			this.bossInfoTwo.setProgress(2);
//			this.bossInfo.setProgress(2);
//		}
//		if (Math.random() < 0.07) {
//			this.bossInfoBelowHalfHealth.setProgress(-1);
//			this.bossInfoTwo.setProgress(-1);
//			this.bossInfo.setProgress(-1);
//		}
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 260);
		builder = builder.add(Attributes.ARMOR, 6);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 50);
		builder = builder.add(Attributes.FOLLOW_RANGE, 64);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1000);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 4);
		return builder;
	}

	public boolean isPowered() {
		return this.getPersistentData().getDouble("endless_deep_space:block_value") <= 50;
   	}

   	protected boolean shouldDespawnInPeaceful() {
      	return false;
   	}
}
