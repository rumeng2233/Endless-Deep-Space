package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModItems;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.client.gui.screens.Screen;

import javax.annotation.Nullable;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.CommonComponents;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.colorful.item.ColorfulItemOne;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.colorful.item.ColorfulItemGRAY;
import net.minecraft.network.chat.Style;

@Mod.EventBusSubscriber
public class FpsHelpProcedure {
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
		if (itemstack.getItem() == EndlessDeepSpaceModItems.FPS.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(ColorfulItemOne.makeColour2(Component.translatable("item.endless_deep_space.fps.help.on").getString())));
			} else {
				tooltip.add(Component.literal(ColorfulItemGRAY.makeColour2(Component.translatable("item.endless_deep_space.fps.help.off").getString())));
			}
		}
	}
}
