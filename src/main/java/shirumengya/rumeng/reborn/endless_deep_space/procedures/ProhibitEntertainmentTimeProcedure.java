package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.gui.components.toasts.TutorialToast;
import net.minecraft.client.Minecraft;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import javax.annotation.Nullable;

import java.util.Calendar;

@Mod.EventBusSubscriber
public class ProhibitEntertainmentTimeProcedure {
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
		if (Calendar.getInstance().get(Calendar.MONTH) == 11 && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 13) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.disconnect(Component.translatable("message.prohibit_ntertainment.endless_deep_space"));
				ToastComponent toastcomponent = Minecraft.getInstance().getToasts();
				SystemToast.addOrUpdate(toastcomponent, SystemToast.SystemToastIds.WORLD_ACCESS_FAILURE, Component.translatable("message.prohibit_ntertainment.endless_deep_space"), Component.translatable("message.prohibit_ntertainment.endless_deep_space"));
		}
	}
}
