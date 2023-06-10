package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModEnchantments;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.colorful.item.ColorfulItem;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.colorful.item.ColorfulItemWarning;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class BestSharpnessInfoProcedure {
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.BEST_SHARPNESS.get(), itemstack) != 0) {
			tooltip.add(Component.literal(ColorfulItem.makeColour2(Component.translatable("enchantment.endless_deep_space.best_sharpness.info").getString())));
			if (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.BEST_SHARPNESS.get(), itemstack) < 2) {
				tooltip.add(Component.literal(ColorfulItemWarning.makeColour2(Component.translatable("enchantment.endless_deep_space.best_sharpness.warning_info").getString())));
			}
		}
	}
}
