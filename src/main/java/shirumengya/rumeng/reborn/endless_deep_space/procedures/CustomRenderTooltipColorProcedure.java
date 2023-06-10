package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.RenderTooltipEvent;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.EndlessDeepSpaceModClientConfig;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CustomRenderTooltipColorProcedure {
	@SubscribeEvent
	public static void onItemTooltipRender(RenderTooltipEvent.Color event) {
		execute(event);
	}

	public static void execute(RenderTooltipEvent.Color tooltip) {
		execute(null, tooltip);
	}

	private static void execute(@Nullable Event event, RenderTooltipEvent.Color tooltip) {
		if (EndlessDeepSpaceModClientConfig.O_C_R_T_C.get() == true) {
			tooltip.setBorderStart(EndlessDeepSpaceModClientConfig.C_R_T_C_BO_S.get());
			tooltip.setBorderEnd(EndlessDeepSpaceModClientConfig.C_R_T_C_BO_E.get());
			if (EndlessDeepSpaceModClientConfig.O_C_R_T_C_B.get() == true) {
				tooltip.setBackground(EndlessDeepSpaceModClientConfig.C_R_T_C_B.get());
			} else {
				tooltip.setBackgroundStart(EndlessDeepSpaceModClientConfig.C_R_T_C_B_S.get());
				tooltip.setBackgroundEnd(EndlessDeepSpaceModClientConfig.C_R_T_C_B_E.get());
			}
		}
	}
}
