package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import com.mojang.blaze3d.shaders.FogShape;

@Mod.EventBusSubscriber
public class CustomFogRenderingFogTickProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onRenderingFog(ViewportEvent.RenderFog event) {
		execute(event, event.getCamera().getEntity().level, event.getCamera().getEntity(), event);
	}

	public static void execute(LevelAccessor world, Entity entity, ViewportEvent.RenderFog fog) {
		execute(null, world, entity, fog);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, ViewportEvent.RenderFog fog) {
		if (entity == null || fog == null)
			return;
		if ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).can_see_custom_fog == true) {
			if (EndlessDeepSpaceModVariables.MapVariables.get(world).custom_fog == true) {
				if (EndlessDeepSpaceModVariables.MapVariables.get(world).custom_fog_time > 0) {
					fog.setCanceled(true);
					fog.setNearPlaneDistance((float) EndlessDeepSpaceModVariables.MapVariables.get(world).custom_fog_start_distance);
					fog.setFarPlaneDistance((float) EndlessDeepSpaceModVariables.MapVariables.get(world).custom_fog_end_distance);
					if (EndlessDeepSpaceModVariables.MapVariables.get(world).custom_fog_shape_is_sphere == true) {
						fog.setFogShape(FogShape.SPHERE);
					} else if (EndlessDeepSpaceModVariables.MapVariables.get(world).custom_fog_shape_is_sphere == false) {
						fog.setFogShape(FogShape.CYLINDER);
					}
				}
			}
		}
	}
}
