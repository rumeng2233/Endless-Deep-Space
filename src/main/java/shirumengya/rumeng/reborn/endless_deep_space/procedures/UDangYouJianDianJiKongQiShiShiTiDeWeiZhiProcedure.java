package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.gui.components.toasts.TutorialToast;
import net.minecraft.client.Minecraft;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.toasts.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

public class UDangYouJianDianJiKongQiShiShiTiDeWeiZhiProcedure {
	public static void execute() {
	ToastComponent toastcomponent = Minecraft.getInstance().getToasts();
    SystemToast.addOrUpdate(toastcomponent, SystemToast.SystemToastIds.PACK_LOAD_FAILURE, Component.translatable("傻逼一个！"), Component.translatable("message.prohibit_ntertainment.endless_deep_space"));
    EndlessDeepSpaceCommonToast.add(toastcomponent, (new ItemStack(Items.ACACIA_CHEST_BOAT)), Component.translatable("888888888888888888888888888888888888888888888888888888888888888888888888888888888"), Component.empty(), 5000L, -1, -1);
	}
}
