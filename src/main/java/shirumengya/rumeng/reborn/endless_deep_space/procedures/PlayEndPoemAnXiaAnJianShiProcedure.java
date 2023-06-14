package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.packet.*;

public class PlayEndPoemAnXiaAnJianShiProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _serverPlayer)
			ModMessages.sendToPlayer(new CommonOpenScreenS2CPacket(0), _serverPlayer);
	}
}
