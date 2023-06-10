
package shirumengya.rumeng.reborn.endless_deep_space.item;

import shirumengya.rumeng.reborn.endless_deep_space.procedures.DetectorOfBrokenDangYouJianDianJiKongQiShiShiTiDeWeiZhiProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DetectorOfBrokenDangWuPinZaiShouShangMeiKeFaShengProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModTabs;
import net.minecraft.world.level.block.state.*;
import net.minecraft.core.*;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DetectorOfBrokenItem extends Item {
	public DetectorOfBrokenItem() {
		super(new Item.Properties().tab(EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP).stacksTo(1).fireResistant().rarity(Rarity.RARE));
	}

	@Override
	public boolean hasCraftingRemainingItem() {
		return true;
	}

//	@Override
//	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
//		return new ItemStack(this);
//	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		DetectorOfBrokenDangYouJianDianJiKongQiShiShiTiDeWeiZhiProcedure.execute(entity, itemstack);
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			DetectorOfBrokenDangWuPinZaiShouShangMeiKeFaShengProcedure.execute(entity, itemstack);
	}

	@Override
	public int getBarColor(ItemStack p_150901_) {
      	return 16253176;
   	}

	@Override
   	public int getBarWidth(ItemStack p_150900_) {
//      	return Math.round(13.0F - (float)p_150900_.getOrCreateTag().getDouble("available_times") * 13.0F / 200.0F);
      	return Math.round(13.0F - (float)(200.0F - p_150900_.getOrCreateTag().getDouble("available_times")) * 13.0F / 200.0F);
   	}

	@Override
   	public boolean isBarVisible(ItemStack p_150899_) {
      return true;
   }

	@Override
   	public boolean canBeHurtBy(DamageSource p_41387_) {
      	return false;
   	}

	@Override
   	public boolean canAttackBlock(BlockState p_41441_, Level p_41442_, BlockPos p_41443_, Player p_41444_) {
      	return false;
   	}
}
