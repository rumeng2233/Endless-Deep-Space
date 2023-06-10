package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HeavyFogStepProcedure {
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
		if (EndlessDeepSpaceModVariables.MapVariables.get(world).heavy_fog_time < 6000) {
			if (Math.random() < 0.00002) {
				EndlessDeepSpaceModVariables.MapVariables.get(world).heavy_fog_time = EndlessDeepSpaceModVariables.MapVariables.get(world).heavy_fog_time + Mth.nextInt(RandomSource.create(), 3600, 6000);
				EndlessDeepSpaceModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
