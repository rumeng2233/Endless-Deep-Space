
package shirumengya.rumeng.reborn.endless_deep_space.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class DamageIncreaseEnchantment extends Enchantment {
	public DamageIncreaseEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.ARMOR, slots);
	}

	@Override
	public boolean isCurse() {
		return true;
	}

   	@Override
	public int getMaxLevel() {
		return 20;
	}
}
