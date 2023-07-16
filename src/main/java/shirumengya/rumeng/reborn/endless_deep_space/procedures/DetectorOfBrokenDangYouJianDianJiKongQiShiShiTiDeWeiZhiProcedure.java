package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.packet.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.*;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.Minecraft;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.toasts.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModItems;
import net.minecraft.server.level.ServerPlayer;

public class DetectorOfBrokenDangYouJianDianJiKongQiShiShiTiDeWeiZhiProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (Screen.hasControlDown()) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			itemstack.getOrCreateTag().putBoolean("whether_to_bind", (true));
			if (!(itemstack.getOrCreateTag().getString("show_type")).equals("right_click")
					&& !(itemstack.getOrCreateTag().getString("show_type")).equals("always")) {
				itemstack.getOrCreateTag().putString("show_type", "always");
				itemstack.getOrCreateTag().putDouble("available_times", 200);
			}
			if (EndlessDeepSpaceModClientConfig.SEND_TO_TOP_OF_THE_HOTBAR.get() == true) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal(
							(Component.translatable("item.endless_deep_space.detector_of_broken.message.bind_detector_of_broken").getString())),
							(true));
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal(
							(Component.translatable("item.endless_deep_space.detector_of_broken.message.bind_detector_of_broken").getString())),
							(false));
			}
			ToastComponent toastcomponent = Minecraft.getInstance().getToasts();
			if (entity instanceof ServerPlayer _serverPlayer)
			ModMessages.sendToPlayer(new SendEndlessDeepSpaceCommonToastS2CPacket(itemstack, Component.translatable("item.endless_deep_space.detector_of_broken"), Component.translatable("item.endless_deep_space.detector_of_broken.message.bind_detector_of_broken"), 3000L, -11534256, -16777216), _serverPlayer);
		}
		if (itemstack.getOrCreateTag().getBoolean("whether_to_bind") == true && itemstack.getOrCreateTag().getDouble("available_times") > 0) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (Screen.hasShiftDown()) {
				if ((itemstack.getOrCreateTag().getString("show_type")).equals("right_click")) {
					itemstack.getOrCreateTag().putString("show_type", "always");
					if (EndlessDeepSpaceModClientConfig.SEND_TO_TOP_OF_THE_HOTBAR.get() == true) {
						if (entity instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(
									Component.literal(
											(Component.translatable("item.endless_deep_space.detector_of_broken.show_type.always").getString())),
									(true));
					} else {
						if (entity instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(
									Component.literal(
											(Component.translatable("item.endless_deep_space.detector_of_broken.show_type.always").getString())),
									(false));
					}
					ToastComponent toastcomponent = Minecraft.getInstance().getToasts();
					if (entity instanceof ServerPlayer _serverPlayer)
					ModMessages.sendToPlayer(new SendEndlessDeepSpaceCommonToastS2CPacket(itemstack, Component.translatable("item.endless_deep_space.detector_of_broken"), Component.translatable("item.endless_deep_space.detector_of_broken.show_type.always"), 3000L, -11534256, -16777216), _serverPlayer);
				} else if ((itemstack.getOrCreateTag().getString("show_type")).equals("always")) {
					itemstack.getOrCreateTag().putString("show_type", "right_click");
					if (EndlessDeepSpaceModClientConfig.SEND_TO_TOP_OF_THE_HOTBAR.get() == true) {
						if (entity instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(
									Component.literal(
											(Component.translatable("item.endless_deep_space.detector_of_broken.show_type.right_click").getString())),
									(true));
					} else {
						if (entity instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(
									Component.literal(
											(Component.translatable("item.endless_deep_space.detector_of_broken.show_type.right_click").getString())),
									(false));
					}
					ToastComponent toastcomponent = Minecraft.getInstance().getToasts();
					if (entity instanceof ServerPlayer _serverPlayer)
					ModMessages.sendToPlayer(new SendEndlessDeepSpaceCommonToastS2CPacket(itemstack, Component.translatable("item.endless_deep_space.detector_of_broken"), Component.translatable("item.endless_deep_space.detector_of_broken.show_type.right_click"), 3000L, -11534256, -16777216), _serverPlayer);
				}
			}
			if ((itemstack.getOrCreateTag().getString("show_type")).equals("right_click")) {
				itemstack.getOrCreateTag().putDouble("available_times", (itemstack.getOrCreateTag().getDouble("available_times") - 1));
				if (EndlessDeepSpaceModClientConfig.SEND_TO_TOP_OF_THE_HOTBAR.get() == true) {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(
								Component.literal((Component.translatable("item.endless_deep_space.detector_of_broken.broken_value").getString() + ""
										+ (entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).broken_value)),
								(true));
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(
								Component.literal((Component.translatable("item.endless_deep_space.detector_of_broken.broken_value").getString() + ""
										+ (entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).broken_value)),
								(false));
				}
				ToastComponent toastcomponent = Minecraft.getInstance().getToasts();
				if (entity instanceof ServerPlayer _serverPlayer)
				ModMessages.sendToPlayer(new SendEndlessDeepSpaceCommonToastS2CPacket(itemstack, Component.translatable("item.endless_deep_space.detector_of_broken"), Component.literal((Component.translatable("item.endless_deep_space.detector_of_broken.broken_value").getString() + "" + (entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).broken_value)), 2000L, -11534256, -16777216), _serverPlayer);
			}
		}
	}
}
