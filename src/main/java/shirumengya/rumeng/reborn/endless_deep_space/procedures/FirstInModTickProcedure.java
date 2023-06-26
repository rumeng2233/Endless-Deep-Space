package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.Minecraft;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.toasts.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModItems;
import net.minecraft.world.entity.Entity;
import javax.annotation.Nullable;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.packet.*;
import net.minecraft.server.level.ServerPlayer;

@Mod.EventBusSubscriber
public class FirstInModTickProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).first_in_mod == true) {
			{
				boolean _setval = false;
				entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.first_in_mod = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayer _serverPlayer)
			ModMessages.sendToPlayer(new SendEndlessDeepSpaceCommonToastS2CPacket((new ItemStack(EndlessDeepSpaceModItems.LOGO.get())), Component.translatable("advancements.endless_deep_space_all_root.title"), Component.translatable("advancements.endless_deep_space_all_root.descr"), 20000L, 16776960, -1), _serverPlayer);
		}
	}
}
