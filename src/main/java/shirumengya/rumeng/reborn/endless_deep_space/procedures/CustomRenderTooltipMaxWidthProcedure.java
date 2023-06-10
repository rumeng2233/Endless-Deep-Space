package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.client.event.RenderTooltipEvent;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.EndlessDeepSpaceModClientConfig;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CustomRenderTooltipMaxWidthProcedure {
	@SubscribeEvent
	public static void onItemTooltip(RenderTooltipEvent.GatherComponents event) {
		execute(event);
	}

	public static void execute(RenderTooltipEvent.GatherComponents tooltip) {
		execute(null, tooltip);
	}

	private static void execute(@Nullable Event event, RenderTooltipEvent.GatherComponents tooltip) {
		if (EndlessDeepSpaceModClientConfig.O_C_R_T_M_W.get() == true) {
				tooltip.setMaxWidth(EndlessDeepSpaceModClientConfig.C_R_T_M_W.get());
		}
	}
}
