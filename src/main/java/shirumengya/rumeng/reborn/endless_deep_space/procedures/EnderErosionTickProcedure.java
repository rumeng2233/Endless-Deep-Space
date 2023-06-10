package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModMobEffects;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.EndlessDeepSpaceModCommonConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EnderErosionTickProcedure {
	public static final Logger LOGGER = LogManager.getLogger(EnderErosionTickProcedure.class);
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((entity.level.dimension()) == (Level.END)) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.ENDER_CURSE.get()) : false) == true) {
					if ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).ender_erosion_value < 10) {
						if (Math.random() < EndlessDeepSpaceModCommonConfig.ENDER_CURSE_INCREASES_CHANCE.get()) {
							{
								double _setval = (entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).ender_erosion_value + 1;
								entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ender_erosion_value = _setval;
									capability.syncPlayerVariables(entity);
									EnderErosionTickProcedure.LOGGER.info(("Increase the ender erosion value " + 1 + " for " + entity.getDisplayName().getString()));
								});
							}
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt
						? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.ENDER_EROSION_PROTECTION.get())
						: false) == true) {
					if ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).ender_erosion_value > 0) {
						if (Math.random() < EndlessDeepSpaceModCommonConfig.ENDER_EROSION_PROTECTION_REDUCES_CHANCE.get()) {
							{
								double _setval = (entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).ender_erosion_value - 1;
								entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ender_erosion_value = _setval;
									capability.syncPlayerVariables(entity);
									EnderErosionTickProcedure.LOGGER.info(("Reduce the ender erosion value " + 1 + " for " + entity.getDisplayName().getString()));
								});
							}
						}
					}
				}
				if ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).ender_erosion_value >= 10) {
					if ((entity instanceof LivingEntity _livEnt
							? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.ENDER_EROSION_PROTECTION.get())
							: false) == false) {
						{
							double _setval = 0;
							entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ender_erosion_value = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						EnderErosionDamageProcedure.execute(entity);
					}
				} else {
					if ((entity instanceof LivingEntity _livEnt
							? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.ENDER_EROSION_PROTECTION.get())
							: false) == false
							&& (entity instanceof LivingEntity _livEnt
									? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.ENDER_CURSE.get())
									: false) == false) {
						if (Math.random() < EndlessDeepSpaceModCommonConfig.ENDER_EROSION_GROWTH_RATE.get()) {
							{
								double _setval = (entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).ender_erosion_value + 1;
								entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ender_erosion_value = _setval;
									capability.syncPlayerVariables(entity);
									EnderErosionTickProcedure.LOGGER.info(("Increase the ender erosion value " + 1 + " for " + entity.getDisplayName().getString()));
								});
							}
						}
					}
				}
			}
		}
	}
}
