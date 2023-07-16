package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraft.world.BossEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.server.level.ServerBossEvent;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

@Mod.EventBusSubscriber
public class WardenBossBarProcedure {
private static final ServerBossEvent wardenEvent = (ServerBossEvent)(new ServerBossEvent(Component.translatable("entity.minecraft.warden"), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true).setCreateWorldFog(true);

	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (!world.getEntitiesOfClass(Warden.class, AABB.ofSize(new Vec3(x, y, z), 49, 51, 49), e -> true).isEmpty()) {
			if (entity instanceof ServerPlayer _serverPlayer)
			WardenBossBarProcedure.wardenEvent.addPlayer(_serverPlayer);
			WardenBossBarProcedure.wardenEvent.setVisible(true);
		} else if (world.getEntitiesOfClass(Warden.class, AABB.ofSize(new Vec3(x, y, z), 49, 51, 49), e -> true).isEmpty()) {
			if (entity instanceof ServerPlayer _serverPlayer)
			WardenBossBarProcedure.wardenEvent.removePlayer(_serverPlayer);
			WardenBossBarProcedure.wardenEvent.setVisible(false);
		}
	}

	public static void updateWarden(Warden p_64097_) {
		WardenBossBarProcedure.wardenEvent.setProgress(p_64097_.getHealth() / p_64097_.getMaxHealth());
	}
}
