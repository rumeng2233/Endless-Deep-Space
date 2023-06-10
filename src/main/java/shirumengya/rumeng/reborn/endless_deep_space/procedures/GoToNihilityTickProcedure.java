package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.Minecraft;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.toasts.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GoToNihilityTickProcedure {
	@SubscribeEvent
	public static void onEntityTravelToDimension(EntityTravelToDimensionEvent event) {
		execute(event, event.getDimension());
	}

	public static void execute(ResourceKey<Level> dimension) {
		execute(null, dimension);
	}

	private static void execute(@Nullable Event event, ResourceKey<Level> dimension) {
		if (dimension == null)
			return;
		if ((dimension) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("endless_deep_space:nihility")))) {
			ToastComponent toastcomponent = Minecraft.getInstance().getToasts();
			EndlessDeepSpaceCommonToast.add(toastcomponent, (new ItemStack(Items.AIR)), Component.translatable("go_to_nihility_toast_title"), Component.translatable("go_to_nihility_toast_descr"), 20000L, -11534256, -16777216);
		}
	}
}
