package shirumengya.rumeng.reborn.endless_deep_space.custom.mixin;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.*;

@Mixin(DamageEnchantment.class)
public class DamageEnchantmentMixin {
	//@Final
	@Shadow
	int type;
	@Overwrite
	public int getMaxLevel() {
      	return 10;
   	}
   	
   	@Overwrite
	public float getDamageBonus(int p_44635_, MobType p_44636_) {
      	if (this.type == 0) {
         	return 1.25F + (float)Math.max(0, p_44635_ - 1) * 1.25F;
      	} else if (this.type == 1 && p_44636_ == MobType.UNDEAD) {
         	return (float)p_44635_ * 2.5F;
      	} else {
         	return this.type == 2 && p_44636_ == MobType.ARTHROPOD ? (float)p_44635_ * 2.5F : 0.0F;
      	}
   	}

	@Overwrite
   	public boolean checkCompatibility(Enchantment p_44644_) {
      	return true;
   	}
}
