
package shirumengya.rumeng.reborn.endless_deep_space.enchantment;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.EndlessDeepSpaceModCommonConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.colorful.item.ColorfulItem;

public class BestSharpnessEnchantment extends Enchantment {
   public static final int ALL = 0;
   public static final int UNDEAD = 1;
   public static final int ARTHROPODS = 2;
   private static final String[] NAMES = new String[]{"all", "undead", "arthropods"};
   private static final int[] MIN_COST = new int[]{1, 5, 5};
   private static final int[] LEVEL_COST = new int[]{11, 8, 8};
   private static final int[] LEVEL_COST_SPAN = new int[]{20, 20, 20};
   public final int type;
   int p_44629_;
   
	public BestSharpnessEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, slots);
		this.type = p_44629_;
	}

	  public int getMinCost(int p_44633_) {
      return MIN_COST[this.type] + (p_44633_ - 1) * LEVEL_COST[this.type];
   }

   public int getMaxCost(int p_44646_) {
      return this.getMinCost(p_44646_) + LEVEL_COST_SPAN[this.type];
   }

	@Override
	public int getMaxLevel() {
		return 255;
	}

	@Override
	public boolean isAllowedOnBooks() {
		return true;
	}

	@Override
	public boolean isDiscoverable() {
		return false;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}

	public float getDamageBonus(int p_44635_, MobType p_44636_) {
         double w = (double)EndlessDeepSpaceModCommonConfig.BEST_SHARPNESS_BASE_DAMAGE_INCREASED.get();
         double x = (double)EndlessDeepSpaceModCommonConfig.BEST_SHARPNESS_BONUS_DAMAGE_INCREASED.get();
         float y = (float)w;
         float z = (float)x;
         return (float)y + (float)Math.max(0, p_44635_ - 1) * (float)z;
   }

	public boolean canEnchant(ItemStack p_44642_) {
      return true;
   }

   public boolean checkCompatibility(Enchantment p_44644_) {
      return true;
   }

   public boolean canApplyAtEnchantingTable(ItemStack stack) {
      return false;
   }

   public Component getFullname(int p_44701_) {
      MutableComponent mutablecomponent = Component.literal(ColorfulItem.makeColour2(Component.translatable(this.getDescriptionId()).getString()));
      mutablecomponent.append(" ").append(Component.literal(ColorfulItem.makeColour2(Component.translatable("enchantment.level." + p_44701_).getString())));
      return mutablecomponent;
   }
}
