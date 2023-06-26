
package shirumengya.rumeng.reborn.endless_deep_space.item;

import shirumengya.rumeng.reborn.endless_deep_space.procedures.PenetratingBowDangYouJianDianJiKongQiShiShiTiDeWeiZhiProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModTabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;

public class PenetratingBowItem extends Item {
	public PenetratingBowItem() {
		super(new Item.Properties().tab(EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP).durability(768).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.BOW;
	}

	@Override
	public int getEnchantmentValue() {
		return 10;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 72000;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		entity.startUsingItem(hand);
		return new InteractionResultHolder(InteractionResult.SUCCESS, entity.getItemInHand(hand));
	}

	@Override
	public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entityLiving, int timeLeft) {
		if (!world.isClientSide() && entityLiving instanceof ServerPlayer entity) {
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			PenetratingBowDangYouJianDianJiKongQiShiShiTiDeWeiZhiProcedure.execute(entity, itemstack);
			world.playSound(null, x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.PLAYERS, 1, 1);
		}
	}
}
