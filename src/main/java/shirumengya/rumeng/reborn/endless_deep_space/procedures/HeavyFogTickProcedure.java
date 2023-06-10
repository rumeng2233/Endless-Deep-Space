package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HeavyFogTickProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (EndlessDeepSpaceModVariables.MapVariables.get(world).heavy_fog_time > 0) {
			EndlessDeepSpaceModVariables.MapVariables.get(world).heavy_fog_time = EndlessDeepSpaceModVariables.MapVariables.get(world).heavy_fog_time - 1;
			EndlessDeepSpaceModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
