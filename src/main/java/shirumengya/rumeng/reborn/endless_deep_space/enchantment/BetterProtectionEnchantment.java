
package shirumengya.rumeng.reborn.endless_deep_space.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.damagesource.DamageSource;

public class BetterProtectionEnchantment extends Enchantment {
	public BetterProtectionEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.ARMOR, slots);
	}

	@Override
	public int getMaxLevel() {
		return 4;
	}

	@Override
	public int getDamageProtection(int level, DamageSource source) {
		return level * 4;
	}
}
