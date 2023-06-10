package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CustomFovComputeFovProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onComputeFov(ViewportEvent.ComputeFov event) {
		execute(event, event.getCamera().getEntity(), event);
	}

	public static void execute(Entity entity, ViewportEvent.ComputeFov fov) {
		execute(null, entity, fov);
	}

	private static void execute(@Nullable Event event, Entity entity, ViewportEvent.ComputeFov fov) {
		if (entity == null || fov == null)
			return;
		if ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).custom_fov == true) {
			fov.setFOV((double) (entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).custom_fov_fov);
		}
	}
}
