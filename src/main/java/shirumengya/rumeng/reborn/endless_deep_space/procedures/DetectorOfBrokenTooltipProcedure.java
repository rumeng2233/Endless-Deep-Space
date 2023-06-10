package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModItems;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import javax.annotation.Nullable;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.CommonComponents;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.colorful.item.ColorfulItemOne;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.colorful.item.ColorfulItemGRAY;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.colorful.item.ColorfulItemGREEN;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.colorful.item.ColorfulItemRED;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.colorful.item.ColorfulItemBroken;
import net.minecraft.network.chat.Style;

@Mod.EventBusSubscriber
public class DetectorOfBrokenTooltipProcedure {
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
		if (itemstack.getItem() == EndlessDeepSpaceModItems.DETECTOR_OF_BROKEN.get()) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(ColorfulItemGRAY.makeColour2(Component.translatable("item.endless_deep_space.detector_of_broken.info.on").getString())));
			} else {
				tooltip.add(Component.literal(ColorfulItemGRAY.makeColour2(Component.translatable("item.endless_deep_space.detector_of_broken.info.off").getString())));
			}
			if ((itemstack.getOrCreateTag().getString("show_type")).equals("right_click")) {
				tooltip.add(
						Component.literal(ColorfulItemRED.makeColour2(Component.translatable("item.endless_deep_space.detector_of_broken.show_type.right_click").getString())));
			} else if ((itemstack.getOrCreateTag().getString("show_type")).equals("always")) {
				tooltip.add(Component.literal(ColorfulItemGREEN.makeColour2(Component.translatable("item.endless_deep_space.detector_of_broken.show_type.always").getString())));
			}
			if (itemstack.getOrCreateTag().getBoolean("whether_to_bind") == true) {
				tooltip.add(Component.literal(ColorfulItemGREEN.makeColour2
						(Component.translatable("item.endless_deep_space.detector_of_broken.message.bind_detector_of_broken.on").getString())));
				tooltip.add(Component.literal((Component.translatable("item.endless_deep_space.detector_of_broken.available_times").getString() + " "
				+ itemstack.getOrCreateTag().getDouble("available_times") + " " + "/" + " " + "200")));
			} else if (itemstack.getOrCreateTag().getBoolean("whether_to_bind") == false) {
				tooltip.add(Component.literal(ColorfulItemGRAY.makeColour2
						(Component.translatable("item.endless_deep_space.detector_of_broken.message.bind_detector_of_broken.off").getString())));
			}
		}
	}
}
