package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class EnderBowDangTouZhiWuJiZhongShiTiShiProcedure {
	public static void execute(Entity immediatesourceentity, Entity sourceentity) {
		if (immediatesourceentity == null || sourceentity == null)
			return;
		{
			Entity _ent = sourceentity;
			_ent.teleportTo((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), _ent.getYRot(), _ent.getXRot());
		}
		if (!immediatesourceentity.level.isClientSide())
			immediatesourceentity.discard();
	}
}
