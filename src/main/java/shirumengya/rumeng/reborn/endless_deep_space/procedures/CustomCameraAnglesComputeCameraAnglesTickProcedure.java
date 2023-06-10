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
public class CustomCameraAnglesComputeCameraAnglesTickProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onComputeCameraAngles(ViewportEvent.ComputeCameraAngles event) {
		execute(event, event.getCamera().getEntity(), event);
	}

	public static void execute(Entity entity, ViewportEvent.ComputeCameraAngles camera) {
		execute(null, entity, camera);
	}

	private static void execute(@Nullable Event event, Entity entity, ViewportEvent.ComputeCameraAngles camera) {
		if (entity == null || camera == null)
			return;
		if ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).custom_camera_angles == true) {
			camera.setYaw((float) (entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).custom_camera_angles_yaw);
			camera.setPitch((float) (entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).custom_camera_angles_pitch);
			camera.setRoll((float) (entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).custom_camera_angles_roll);
		}
	}
}
