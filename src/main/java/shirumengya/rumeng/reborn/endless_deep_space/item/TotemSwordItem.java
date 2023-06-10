
package shirumengya.rumeng.reborn.endless_deep_space.item;

import shirumengya.rumeng.reborn.endless_deep_space.procedures.TotemSwordDangYouJianDianJiKongQiShiShiTiDeWeiZhiProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.TotemSwordDangYouJianDianJiFangKuaiShiFangKuaiDeWeiZhiProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.TotemSwordDangShiTiBeiGongJuJiZhongShiProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModTabs;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;

public class TotemSwordItem extends SwordItem {
	public TotemSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return Float.MAX_VALUE;
			}

			public float getAttackDamageBonus() {
				return Float.MAX_VALUE;
			}

			public int getLevel() {
				return Integer.MAX_VALUE;
			}

			public int getEnchantmentValue() {
				return Integer.MAX_VALUE;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 3, Float.MAX_VALUE, new Item.Properties().tab(EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		TotemSwordDangShiTiBeiGongJuJiZhongShiProcedure.execute(entity, sourceentity);
		return retval;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		TotemSwordDangYouJianDianJiKongQiShiShiTiDeWeiZhiProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		TotemSwordDangYouJianDianJiFangKuaiShiFangKuaiDeWeiZhiProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ());
		return InteractionResult.SUCCESS;
	}

	@Override
   	public boolean canBeHurtBy(DamageSource p_41387_) {
      	return false;
   	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}
