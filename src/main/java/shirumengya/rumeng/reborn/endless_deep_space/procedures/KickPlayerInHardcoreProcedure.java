package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.EndlessDeepSpaceModCommonConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.Difficulty;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class KickPlayerInHardcoreProcedure {
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
		if (world.getLevelData().isHardcore() == true) {
			if (EndlessDeepSpaceModCommonConfig.KICK_PLAYER_IN_HARDCORE.get() == true) {
				if (entity instanceof ServerPlayer) {
					if ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).player_kick_in_hardcore == true) {
						if (Math.random() < 0.1) {
						if (entity instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.disconnect(Component.translatable("multiplayer.disconnect.die_in_hardcore_1"));
						} else if (Math.random() < 0.1) {
						if (entity instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.disconnect(Component.translatable("multiplayer.disconnect.die_in_hardcore_2"));
						} else if (Math.random() < 0.1) {
						if (entity instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.disconnect(Component.translatable("multiplayer.disconnect.die_in_hardcore_3"));
						} else if (Math.random() < 0.1) {
						if (entity instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.disconnect(Component.translatable("multiplayer.disconnect.die_in_hardcore_4"));
						} else if (Math.random() < 0.1) {
						if (entity instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.disconnect(Component.translatable("multiplayer.disconnect.die_in_hardcore_5"));
						} else if (Math.random() < 0.1) {
						if (entity instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.disconnect(Component.translatable("multiplayer.disconnect.die_in_hardcore_6"));
						} else if (Math.random() < 0.1) {
						if (entity instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.disconnect(Component.translatable("multiplayer.disconnect.die_in_hardcore_7"));
						} else if (Math.random() < 0.1) {
						if (entity instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.disconnect(Component.translatable("multiplayer.disconnect.die_in_hardcore_8"));
						} else if (Math.random() < 0.1) {
						if (entity instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.disconnect(Component.translatable("multiplayer.disconnect.die_in_hardcore_9"));
						} else if (Math.random() < 0.1) {
						if (entity instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.disconnect(Component.translatable("multiplayer.disconnect.die_in_hardcore_10"));
						}

					}
				}
			}
		}
	}
}
