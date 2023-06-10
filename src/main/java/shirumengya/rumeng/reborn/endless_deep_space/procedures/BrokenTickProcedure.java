package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.EndlessDeepSpaceModCommonConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BrokenTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
				new EndlessDeepSpaceModVariables.PlayerVariables())).broken_value >= EndlessDeepSpaceModCommonConfig.BROKEN_VALUE_MAX
						.get()) {
			{
				double _setval = 0;
				entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.broken_value = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
			BrokenTickDamageProcedure.execute(entity);
			entity.clearFire();
			entity.setAirSupply(0);
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
			BrokenTickDamageProcedure.execute(entity);
			entity.clearFire();
			entity.setAirSupply(0);
		}
	}
}
