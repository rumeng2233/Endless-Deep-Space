
package shirumengya.rumeng.reborn.endless_deep_space.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class CanNotPickUpEnchantment extends Enchantment {
	public CanNotPickUpEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	public boolean isCurse() {
		return true;
	}

	public boolean canEnchant(ItemStack p_44642_) {
      return true;
   }

	public int getMinCost(int p_44633_) {
      return 0;
   }

   	public int getMaxCost(int p_44646_) {
      return 0;
   }
}
