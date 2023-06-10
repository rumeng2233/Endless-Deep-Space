package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModItems;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.colorful.item.ColorfulItemGRAY;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.*;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class StarCubeTipProcedure {
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
		if (itemstack.getItem() == ItemInit.STAR_CUBE_END_PORTAL.get()) {
			tooltip.add(Component.literal(ColorfulItemGRAY.makeColour2(Component.translatable("block.endless_deep_space.custom.star_cube_end_portal.tip").getString())));
		} else if (itemstack.getItem() == ItemInit.STAR_CUBE_END_GATEWAY.get()) {
			tooltip.add(Component.literal(ColorfulItemGRAY.makeColour2(Component.translatable("block.endless_deep_space.custom.star_cube_end_gateway.tip").getString())));
		}
	}
}
