
package shirumengya.rumeng.reborn.endless_deep_space.enchantment;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;

public class SharpnessWeakenedEnchantment extends Enchantment {
	public SharpnessWeakenedEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 10;
	}

	@Override
	public boolean isCurse() {
		return true;
	}

	@Override
	public boolean canEnchant(ItemStack p_44642_) {
      return true;
   }

   @Override
   public float getDamageBonus(int p_44635_, MobType p_44636_) {
         return (float)-8.0F + (float)Math.max(0, p_44635_ - 1) * (float)-6.0F;
   }
}
