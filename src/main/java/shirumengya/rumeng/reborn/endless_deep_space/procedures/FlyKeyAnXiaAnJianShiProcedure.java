package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.packet.*;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.Minecraft;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.toasts.*;

public class FlyKeyAnXiaAnJianShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance()
							.getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity) || new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
				} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance()
							.getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			if ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).fly == false) {
				{
					boolean _setval = true;
					entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.fly = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
					ToastComponent toastcomponent = Minecraft.getInstance().getToasts();
					if (entity instanceof ServerPlayer _serverPlayer)
					ModMessages.sendToPlayer(new SendEndlessDeepSpaceCommonMessageToastS2CPacket(Component.translatable("message.fly.endless_deep_space.on"), Component.translatable(""), 3000L, -11534256, -16777216), _serverPlayer);
			} else {
				{
					boolean _setval = false;
					entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.fly = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
					ToastComponent toastcomponent = Minecraft.getInstance().getToasts();
					if (entity instanceof ServerPlayer _serverPlayer)
					ModMessages.sendToPlayer(new SendEndlessDeepSpaceCommonMessageToastS2CPacket(Component.translatable("message.fly.endless_deep_space.off"), Component.translatable(""), 3000L, -11534256, -16777216), _serverPlayer);
			}
		} else {
				ToastComponent toastcomponent = Minecraft.getInstance().getToasts();
				if (entity instanceof ServerPlayer _serverPlayer)
				ModMessages.sendToPlayer(new SendEndlessDeepSpaceCommonMessageToastS2CPacket(Component.translatable("message.fly.endless_deep_space.error"), Component.translatable(""), 3000L, -65536, -16777216), _serverPlayer);
		}
	}
}
