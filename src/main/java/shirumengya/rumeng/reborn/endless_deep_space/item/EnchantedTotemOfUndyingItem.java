
package shirumengya.rumeng.reborn.endless_deep_space.item;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModTabs;
import java.util.List;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import org.jetbrains.annotations.Nullable;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;

public class EnchantedTotemOfUndyingItem extends Item {

	public boolean canSetTag = true;

	public EnchantedTotemOfUndyingItem() {
		super(new Item.Properties().tab(EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP).durability(9).fireResistant().rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public int getBarColor(ItemStack p_150901_) {
      	return 16755200;
   	}

   	@Override
   	public boolean canBeHurtBy(DamageSource p_41387_) {
      	return false;
   	}

	@Override
   	public Component getName(ItemStack p_41458_) {
      	return Component.translatable(this.getDescriptionId(p_41458_)).withStyle(ChatFormatting.GOLD);
   	}

   	public static int getRestoreHealth(ItemStack itemstack) {
   		return itemstack.getOrCreateTag().getInt("RestoreHealth");
   	}

   	public static void setRestoreHealth(ItemStack itemstack, int RestoreHealth) {
   		itemstack.getOrCreateTag().putInt("RestoreHealth", RestoreHealth);
   	}

   	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
		super.appendHoverText(stack, level, tooltip, flag);
		tooltip.add(Component.translatable("item.endless_deep_space.enchanted_totem_of_undying.info").withStyle(ChatFormatting.BLUE));
		tooltip.add(Component.translatable("item.endless_deep_space.enchanted_totem_of_undying.restore_health", getRestoreHealth(stack)).withStyle(ChatFormatting.RED));
		tooltip.add(Component.literal(Component.translatable("item.endless_deep_space.detector_of_broken.available_times").getString() + (stack.getMaxDamage() - stack.getDamageValue())).withStyle(ChatFormatting.GRAY));
	}
}
