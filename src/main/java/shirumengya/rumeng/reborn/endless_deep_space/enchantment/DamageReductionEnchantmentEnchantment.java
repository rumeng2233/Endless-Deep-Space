
package shirumengya.rumeng.reborn.endless_deep_space.enchantment;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModEnchantments;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.List;

public class DamageReductionEnchantmentEnchantment extends Enchantment {
	public DamageReductionEnchantmentEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR, slots);
	}

	@Override
	public int getMaxLevel() {
		return 10;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return !List.of(EndlessDeepSpaceModEnchantments.BETTER_PROTECTION.get()).contains(ench);
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}
}
