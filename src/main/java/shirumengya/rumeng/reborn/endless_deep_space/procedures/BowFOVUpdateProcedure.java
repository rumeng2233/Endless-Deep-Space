package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import shirumengya.rumeng.reborn.endless_deep_space.item.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.item.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.*;
import javax.annotation.Nullable;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BowItem;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber
public class BowFOVUpdateProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void FOVUpdate(ComputeFovModifierEvent event) {
		Player player = event.getPlayer();
		if (player.isUsingItem()) {
			Item useItem = player.getUseItem().getItem();
			if (useItem instanceof TrackingArrowItem || useItem instanceof EnderBowItem || useItem instanceof PenetratingBowItem || useItem instanceof BowItem) {
				float f = player.getTicksUsingItem() / 20.0F;
				f = f > 1.0F ? 1.0F : f * f;
				event.setNewFovModifier(event.getFovModifier() * (1.0F - f * 0.15F));
			}
		}
	}
}
