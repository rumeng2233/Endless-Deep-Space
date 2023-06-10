package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModEnchantments;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CanNotPickUpTickProcedure {
	@SubscribeEvent
	public static void onPickup(EntityItemPickupEvent event) {
		execute(event, event.getItem().getItem());
	}

	public static void execute(ItemStack itemstack) {
		execute(null, itemstack);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack) {
		if (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.CAN_NOT_PICK_UP.get(), itemstack) != 0) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
		}
	}
}
