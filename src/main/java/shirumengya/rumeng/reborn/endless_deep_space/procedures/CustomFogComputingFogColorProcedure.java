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

@Mod.EventBusSubscriber
public class CustomFogComputingFogColorProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onComputingFogColor(ViewportEvent.ComputeFogColor event) {
		execute(event, event.getCamera().getEntity().level, event.getCamera().getEntity(), event);
	}

	public static void execute(LevelAccessor world, Entity entity, ViewportEvent.ComputeFogColor fogcolor) {
		execute(null, world, entity, fogcolor);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, ViewportEvent.ComputeFogColor fogcolor) {
		if (entity == null || fogcolor == null)
			return;
		if ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).can_see_custom_fog == true) {
			if (EndlessDeepSpaceModVariables.MapVariables.get(world).custom_fog == true) {
				if (EndlessDeepSpaceModVariables.MapVariables.get(world).custom_fog_time > 0) {
					fogcolor.setRed((float) EndlessDeepSpaceModVariables.MapVariables.get(world).custom_fog_color_r / 255.0F);
					fogcolor.setGreen((float) EndlessDeepSpaceModVariables.MapVariables.get(world).custom_fog_color_g / 255.0F);
					fogcolor.setBlue((float) EndlessDeepSpaceModVariables.MapVariables.get(world).custom_fog_color_b / 255.0F);
				}
			}
		}
	}
}
