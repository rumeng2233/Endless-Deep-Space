<<<<<<< Updated upstream
package shirumengya.rumeng.reborn.endless_deep_space.custom.mixin;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.EndlessDeepSpaceModAttributes;
import org.spongepowered.asm.mixin.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import shirumengya.rumeng.reborn.endless_deep_space.init.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;
import java.util.Iterator;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Dynamic;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.BlockUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundAnimatePacket;
import net.minecraft.network.protocol.game.ClientboundEntityEventPacket;
import net.minecraft.network.protocol.game.ClientboundSetEquipmentPacket;
import net.minecraft.network.protocol.game.ClientboundTakeItemEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.CombatTracker;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.FrostWalkerEnchantment;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractSkullBlock;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HoneyBlock;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.PowderSnowBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.PlayerTeam;
import org.slf4j.Logger;
import net.minecraftforge.common.ForgeMod;
import net.minecraft.world.entity.HumanoidArm;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
	
	@Inject(method = {"getDamageAfterMagicAbsorb"}, at = {@At("HEAD")}, cancellable = true)
	protected float getDamageAfterMagicAbsorb(DamageSource p_21193_, float p_21194_, CallbackInfoReturnable<Float> info) {
	LivingEntity livingEntity = ((LivingEntity)(Object)this);
		if (livingEntity.getAttribute(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get()) != null) {
			int k = EnchantmentHelper.getDamageProtection(livingEntity.getArmorSlots(), p_21193_);
			float amount = p_21194_ - (float)livingEntity.getAttribute(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get()).getValue();
			float amount1 = CombatRules.getDamageAfterMagicAbsorb(amount, (float)k);
			if (p_21193_.isBypassEnchantments() || p_21193_.isBypassMagic()) {
			if (amount >= 0.0F) {
				info.setReturnValue(amount);
				return amount;
			} else {
				info.setReturnValue(0.0F);
				return 0.0F;
			}
		} else {
			if (amount1 >= 0.0F) {
				if (livingEntity.hasEffect(MobEffects.DAMAGE_RESISTANCE) && p_21193_ != DamageSource.OUT_OF_WORLD) {
					int i = (livingEntity.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier() + 1) * 5;
            		int j = 25 - i;
            		float f = amount1 * (float)j;
            		float amount2 = Math.max(f / 25.0F, 0.0F);
            		if (amount2 >= 0.0F) {
            			info.setReturnValue(amount2);
						return amount2;
            		} else {
            			info.setReturnValue(0.0F);
						return 0.0F;
            		}
				} else {
					info.setReturnValue(amount1);
					return amount1;
				}
			} else {
				info.setReturnValue(0.0F);
				return 0.0F;
			}
		}
		} else {
			return p_21194_;
		}
  	}


  	@Inject(method = {"checkTotemDeathProtection"}, at = {@At("HEAD")}, cancellable = true)
    private void checkTotemDeathProtection(DamageSource source, CallbackInfoReturnable<Boolean> info) {
        LivingEntity livingEntity = ((LivingEntity)(Object)this);
        if (livingEntity.hasEffect(EndlessDeepSpaceModMobEffects.TOTEM_OF_UNDYING.get())) {
           	if (livingEntity instanceof ServerPlayer) {
               	ServerPlayer serverplayer = (ServerPlayer)livingEntity;
               	CriteriaTriggers.USED_TOTEM.trigger(serverplayer, ItemStack.EMPTY);
               	Advancement _adv = serverplayer.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:adventure/totem_of_undying"));
				AdvancementProgress _ap = serverplayer.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemainingCriteria().iterator();
						while (_iterator.hasNext())
							serverplayer.getAdvancements().award(_adv, (String) _iterator.next());
					}
            }
            livingEntity.setHealth(1.0F);
            livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200, 1));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
            livingEntity.level.broadcastEntityEvent(livingEntity, (byte)35);
            info.setReturnValue(true);
        }
    }

    @Inject(method = {"createLivingAttributes"}, at = {@At("HEAD")}, cancellable = true)
    private static AttributeSupplier.Builder createLivingAttributes(CallbackInfoReturnable info) {
    	info.setReturnValue(AttributeSupplier.builder()
      	.add(Attributes.MAX_HEALTH)
      	.add(Attributes.KNOCKBACK_RESISTANCE)
      	.add(Attributes.MOVEMENT_SPEED)
      	.add(Attributes.ARMOR)
      	.add(Attributes.ARMOR_TOUGHNESS)
      	.add(ForgeMod.ENTITY_GRAVITY.get())
      	.add(ForgeMod.SWIM_SPEED.get())
      	.add(ForgeMod.REACH_DISTANCE.get())
      	.add(ForgeMod.ATTACK_RANGE.get())
      	.add(ForgeMod.STEP_HEIGHT_ADDITION.get())
      	.add(ForgeMod.NAMETAG_DISTANCE.get())
      	.add(EndlessDeepSpaceModAttributes.TELEPORT_FAILURE_PROBABILITY.get())
      	.add(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_PROBABILITY.get())
      	.add(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_HEALTH.get())
      	.add(EndlessDeepSpaceModAttributes.HEAL_UNABLE.get())
      	.add(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get())
      	.add(EndlessDeepSpaceModAttributes.DAMAGE_PROTECTION_TIME.get()));
      	return AttributeSupplier.builder()
      	.add(Attributes.MAX_HEALTH)
      	.add(Attributes.KNOCKBACK_RESISTANCE)
      	.add(Attributes.MOVEMENT_SPEED)
      	.add(Attributes.ARMOR)
      	.add(Attributes.ARMOR_TOUGHNESS)
      	.add(ForgeMod.ENTITY_GRAVITY.get())
      	.add(ForgeMod.SWIM_SPEED.get())
      	.add(ForgeMod.REACH_DISTANCE.get())
      	.add(ForgeMod.ATTACK_RANGE.get())
      	.add(ForgeMod.STEP_HEIGHT_ADDITION.get())
      	.add(ForgeMod.NAMETAG_DISTANCE.get())
      	.add(EndlessDeepSpaceModAttributes.TELEPORT_FAILURE_PROBABILITY.get())
      	.add(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_PROBABILITY.get())
      	.add(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_HEALTH.get())
      	.add(EndlessDeepSpaceModAttributes.HEAL_UNABLE.get())
      	.add(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get())
      	.add(EndlessDeepSpaceModAttributes.DAMAGE_PROTECTION_TIME.get());
   	}
}
=======
package shirumengya.rumeng.reborn.endless_deep_space.custom.mixin;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.EndlessDeepSpaceModAttributes;
import org.spongepowered.asm.mixin.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import shirumengya.rumeng.reborn.endless_deep_space.init.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;
import java.util.Iterator;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Dynamic;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.BlockUtil;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundAnimatePacket;
import net.minecraft.network.protocol.game.ClientboundEntityEventPacket;
import net.minecraft.network.protocol.game.ClientboundSetEquipmentPacket;
import net.minecraft.network.protocol.game.ClientboundTakeItemEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.CombatTracker;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.FrostWalkerEnchantment;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractSkullBlock;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HoneyBlock;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.PowderSnowBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.PlayerTeam;
import org.slf4j.Logger;
import net.minecraftforge.common.ForgeMod;
import net.minecraft.world.entity.HumanoidArm;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.packet.*;
import shirumengya.rumeng.reborn.endless_deep_space.item.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.world.damagesource.EndlessDeepSpaceDamageSource;
import net.minecraft.stats.StatsCounter;
import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.gen.Accessor;
import net.minecraft.world.entity.Entity;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
	
	/*private static final EntityDataAccessor<Integer> DataBleedTime = SynchedEntityData.defineId(LivingEntity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Float> DataBleedLevel = SynchedEntityData.defineId(LivingEntity.class, EntityDataSerializers.FLOAT);*/

	@Inject(method = {"getDamageAfterMagicAbsorb"}, at = {@At("HEAD")}, cancellable = true)
	protected float getDamageAfterMagicAbsorb(DamageSource p_21193_, float p_21194_, CallbackInfoReturnable<Float> info) {
	LivingEntity livingEntity = ((LivingEntity)(Object)this);
		if (livingEntity.getAttribute(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get()) != null) {
			int k = EnchantmentHelper.getDamageProtection(livingEntity.getArmorSlots(), p_21193_);
			float amount = p_21194_ - (float)livingEntity.getAttribute(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get()).getValue();
			float amount1 = CombatRules.getDamageAfterMagicAbsorb(amount, (float)k);
			if (p_21193_.isBypassEnchantments() || p_21193_.isBypassMagic()) {
			if (amount >= 0.0F) {
				info.setReturnValue(amount);
				return amount;
			} else {
				info.setReturnValue(0.0F);
				return 0.0F;
			}
		} else {
			if (amount1 >= 0.0F) {
				if (livingEntity.hasEffect(MobEffects.DAMAGE_RESISTANCE) && p_21193_ != DamageSource.OUT_OF_WORLD) {
					int i = (livingEntity.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier() + 1) * 5;
            		int j = 25 - i;
            		float f = amount1 * (float)j;
            		float amount2 = Math.max(f / 25.0F, 0.0F);
            		if (amount2 >= 0.0F) {
            			info.setReturnValue(amount2);
						return amount2;
            		} else {
            			info.setReturnValue(0.0F);
						return 0.0F;
            		}
				} else {
					info.setReturnValue(amount1);
					return amount1;
				}
			} else {
				info.setReturnValue(0.0F);
				return 0.0F;
			}
		}
		} else {
			return p_21194_;
		}
  	}


  	@Inject(method = {"checkTotemDeathProtection"}, at = {@At("HEAD")}, cancellable = true)
    private void checkTotemDeathProtection(DamageSource source, CallbackInfoReturnable<Boolean> info) {
        LivingEntity livingEntity = ((LivingEntity)(Object)this);
        if (livingEntity.hasEffect(EndlessDeepSpaceModMobEffects.TOTEM_OF_UNDYING.get())) {
           	if (livingEntity instanceof ServerPlayer) {
               	ServerPlayer serverplayer = (ServerPlayer)livingEntity;
               	CriteriaTriggers.USED_TOTEM.trigger(serverplayer, ItemStack.EMPTY);
               	Advancement _adv = serverplayer.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:adventure/totem_of_undying"));
				AdvancementProgress _ap = serverplayer.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemainingCriteria().iterator();
						while (_iterator.hasNext())
							serverplayer.getAdvancements().award(_adv, (String) _iterator.next());
					}
            }
            livingEntity.setHealth(1.0F);
            livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
            livingEntity.level.broadcastEntityEvent(livingEntity, (byte)35);
            info.setReturnValue(true);
        }
        
        ItemStack itemstack = null;
		if (livingEntity instanceof Player) {
         for(InteractionHand interactionhand : InteractionHand.values()) {
            ItemStack itemstack1 = livingEntity.getItemInHand(interactionhand);
            if (livingEntity instanceof Player _player)
            if (itemstack1.is(EndlessDeepSpaceModItems.ENCHANTED_TOTEM_OF_UNDYING.get()) && (_player.getCooldowns().isOnCooldown(itemstack1.getItem()) == false) && (((itemstack1).getMaxDamage() - (itemstack1).getDamageValue()) > 0)) {
               itemstack = itemstack1.copy();
               itemstack1.hurt(1, RandomSource.create(), null);
               if (EnchantedTotemOfUndyingItem.getRestoreHealth(itemstack1) <= 0) {
               		EnchantedTotemOfUndyingItem.setRestoreHealth(itemstack1, 1);
               }
               _player.getCooldowns().addCooldown(itemstack1.getItem(), 195);
               _player.stopUsingItem();
               break;
            }
         }
		}

		if (!(livingEntity instanceof Player)) {
         for(InteractionHand interactionhand : InteractionHand.values()) {
            ItemStack itemstack1 = livingEntity.getItemInHand(interactionhand);
            if (itemstack1.is(EndlessDeepSpaceModItems.ENCHANTED_TOTEM_OF_UNDYING.get()) && (((itemstack1).getMaxDamage() - (itemstack1).getDamageValue()) > 0)) {
               itemstack = itemstack1.copy();
               itemstack1.hurt(1, RandomSource.create(), null);
               if (EnchantedTotemOfUndyingItem.getRestoreHealth(itemstack1) <= 0) {
               		EnchantedTotemOfUndyingItem.setRestoreHealth(itemstack1, 1);
               }
               break;
            }
         }
		}

         if (itemstack != null) {
            if (livingEntity instanceof ServerPlayer) {
               ServerPlayer serverplayer = (ServerPlayer)livingEntity;
               serverplayer.awardStat(Stats.ITEM_USED.get(EndlessDeepSpaceModItems.ENCHANTED_TOTEM_OF_UNDYING.get()));
               CriteriaTriggers.USED_TOTEM.trigger(serverplayer, itemstack);
               ModMessages.sendToPlayer(new CommonDisplayItemActivationS2CPacket(itemstack), serverplayer);
            }

            if (EnchantedTotemOfUndyingItem.getRestoreHealth(itemstack) <= 0) {
            	livingEntity.setHealth(1);
            } else {
            	livingEntity.setHealth((float)EnchantedTotemOfUndyingItem.getRestoreHealth(itemstack));
            }
            livingEntity.removeAllEffects();
            livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
            livingEntity.addEffect(new MobEffectInstance(EndlessDeepSpaceModMobEffects.TOTEM_OF_UNDYING.get(), 200, 0));
            livingEntity.level.broadcastEntityEvent(livingEntity, (byte)35);
            info.setReturnValue(true);
         }
         
    }

    @Inject(method = {"createLivingAttributes"}, at = {@At("HEAD")}, cancellable = true)
    private static AttributeSupplier.Builder createLivingAttributes(CallbackInfoReturnable info) {
    	info.setReturnValue(AttributeSupplier.builder()
      	.add(Attributes.MAX_HEALTH)
      	.add(Attributes.KNOCKBACK_RESISTANCE)
      	.add(Attributes.MOVEMENT_SPEED)
      	.add(Attributes.ARMOR)
      	.add(Attributes.ARMOR_TOUGHNESS)
      	.add(ForgeMod.ENTITY_GRAVITY.get())
      	.add(ForgeMod.SWIM_SPEED.get())
      	.add(ForgeMod.REACH_DISTANCE.get())
      	.add(ForgeMod.ATTACK_RANGE.get())
      	.add(ForgeMod.STEP_HEIGHT_ADDITION.get())
      	.add(ForgeMod.NAMETAG_DISTANCE.get())
      	.add(EndlessDeepSpaceModAttributes.TELEPORT_FAILURE_PROBABILITY.get())
      	.add(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_PROBABILITY.get())
      	.add(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_HEALTH.get())
      	.add(EndlessDeepSpaceModAttributes.HEAL_UNABLE.get())
      	.add(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get())
      	.add(EndlessDeepSpaceModAttributes.DAMAGE_PROTECTION_TIME.get()));
      	return AttributeSupplier.builder()
      	.add(Attributes.MAX_HEALTH)
      	.add(Attributes.KNOCKBACK_RESISTANCE)
      	.add(Attributes.MOVEMENT_SPEED)
      	.add(Attributes.ARMOR)
      	.add(Attributes.ARMOR_TOUGHNESS)
      	.add(ForgeMod.ENTITY_GRAVITY.get())
      	.add(ForgeMod.SWIM_SPEED.get())
      	.add(ForgeMod.REACH_DISTANCE.get())
      	.add(ForgeMod.ATTACK_RANGE.get())
      	.add(ForgeMod.STEP_HEIGHT_ADDITION.get())
      	.add(ForgeMod.NAMETAG_DISTANCE.get())
      	.add(EndlessDeepSpaceModAttributes.TELEPORT_FAILURE_PROBABILITY.get())
      	.add(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_PROBABILITY.get())
      	.add(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_HEALTH.get())
      	.add(EndlessDeepSpaceModAttributes.HEAL_UNABLE.get())
      	.add(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get())
      	.add(EndlessDeepSpaceModAttributes.DAMAGE_PROTECTION_TIME.get());
   	}

/*   	public int getBleedTime(LivingEntity livingEntity) {
      	return livingEntity.getEntityData().get(DataBleedTime);
   	}

   	public float getBleedLevel(LivingEntity livingEntity) {
      	return livingEntity.getEntityData().get(DataBleedLevel);
   	}

   	public void setBleedTime(int time, LivingEntity livingEntity) {
   		int i = time;
   		if (i >= 0) {
   			livingEntity.getEntityData().set(DataBleedTime, i);
   		} else {
   			livingEntity.getEntityData().set(DataBleedTime, 0);
   		}
   	}

   	public void addBleedTime(int time, LivingEntity livingEntity) {
   		int f = this.getBleedTime(livingEntity);
      	if (f > 0) {
         	this.setBleedTime(f + time, livingEntity);
      	}
   	}

   	public void setBleedLevel(float level, LivingEntity livingEntity) {
   		float i = level;
   		if (i >= 0.0F) {
   			livingEntity.getEntityData().set(DataBleedLevel, i);
   		} else {
   			livingEntity.getEntityData().set(DataBleedLevel, 0.0F);
   		}
   	}

   	public void addBleedLevel(float level, LivingEntity livingEntity) {
   		float f = this.getBleedLevel(livingEntity);
      	if (f > 0.0F) {
         	this.setBleedLevel(f + level, livingEntity);
      	}
   	}

   	public boolean isBleeding(LivingEntity livingEntity) {
   		return this.getBleedTime(livingEntity) > 0 && this.getBleedLevel(livingEntity) > 0.0F;
   	}

	@Inject(method = {"heal"}, at = {@At("HEAD")}, cancellable = true)
   	public void heal(float p_21116_, CallbackInfo info) {
   		LivingEntity livingEntity = ((LivingEntity)(Object)this);
   		if (this.isBleeding(livingEntity)) {
   			info.cancel();
   		}
   	}

	@Inject(method = {"defineSynchedData"}, at = {@At("HEAD")}, cancellable = true)
   	protected void defineSynchedData(CallbackInfo info) {
   		LivingEntity livingEntity = ((LivingEntity)(Object)this);
   		livingEntity.getEntityData().define(DataBleedLevel, 0.0F);
   		livingEntity.getEntityData().define(DataBleedTime, 0);
   	}

	@Inject(method = {"addAdditionalSaveData"}, at = {@At("HEAD")}, cancellable = true)
   	public void addAdditionalSaveData(CompoundTag p_21145_, CallbackInfo info) {
   		LivingEntity livingEntity = ((LivingEntity)(Object)this);
   		p_21145_.putInt("BleedTime", this.getBleedTime(livingEntity));
   		p_21145_.putFloat("BleedLevel", this.getBleedLevel(livingEntity));
   	}

	@Inject(method = {"readAdditionalSaveData"}, at = {@At("HEAD")}, cancellable = true)
   	public void readAdditionalSaveData(CompoundTag p_21096_, CallbackInfo info) {
   		LivingEntity livingEntity = ((LivingEntity)(Object)this);
   		this.setBleedTime(p_21096_.getInt("BleedTime"), livingEntity);
   		this.setBleedLevel(p_21096_.getFloat("BleedLevel"), livingEntity);
   	}

	@Inject(method = {"baseTick"}, at = {@At("HEAD")}, cancellable = true)
   	public void baseTick(CallbackInfo info) {
   		LivingEntity livingEntity = ((LivingEntity)(Object)this);
   		if (!livingEntity.level.isClientSide) {
   		if (this.getBleedTime(livingEntity) > 0 && livingEntity.tickCount % 20 == 0) {
   			livingEntity.hurt(EndlessDeepSpaceDamageSource.BLEEDING, this.getBleedLevel(livingEntity));
   			int amount;
   			if (this.getBleedLevel(livingEntity) <= 1000.0F) {
   				amount = (int)this.getBleedLevel(livingEntity);
   			} else {
   				amount = 1000;
   			}
   			for(int i = 0; i < amount; i++){
            	livingEntity.level.addParticle(ParticleTypes.DAMAGE_INDICATOR, livingEntity.getRandomX(1.0), livingEntity.getRandomY(), livingEntity.getRandomZ(1.0), 0, 0, 0);
        	}
   			this.addBleedTime(-1, livingEntity);
   			if (livingEntity instanceof ServerPlayer) {
   				ServerPlayer player = (ServerPlayer)livingEntity;
   				player.awardStat(StatsInit.BLEED_TIMES.get());
   			}
   		}
   		if (this.getBleedTime(livingEntity) <= 0) {
   			this.setBleedLevel(0.0F, livingEntity);
   		}
   		}
   	}*/
}
>>>>>>> Stashed changes
