package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.RenderTooltipEvent;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.EndlessDeepSpaceModClientConfig;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CustomRenderTooltipPreProcedure {
	@SubscribeEvent
	public static void onItemTooltipRender(RenderTooltipEvent.Pre event) {
		execute(event);
	}

	public static void execute(RenderTooltipEvent.Pre tooltip) {
		execute(null, tooltip);
	}

	private static void execute(@Nullable Event event, RenderTooltipEvent.Pre tooltip) {
		if (EndlessDeepSpaceModClientConfig.O_C_R_T_P.get() == true) {
			tooltip.setX(EndlessDeepSpaceModClientConfig.C_R_T_P_X.get());
			tooltip.setY(EndlessDeepSpaceModClientConfig.C_R_T_P_Y.get());
		}
	}
}
