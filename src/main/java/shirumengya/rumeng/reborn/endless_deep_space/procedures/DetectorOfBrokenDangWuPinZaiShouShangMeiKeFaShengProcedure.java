package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class DetectorOfBrokenDangWuPinZaiShouShangMeiKeFaShengProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("available_times") > 0) {
			if ((itemstack.getOrCreateTag().getString("show_type")).equals("always")) {
				if (Math.random() < 0.008) {
					itemstack.getOrCreateTag().putDouble("available_times", (itemstack.getOrCreateTag().getDouble("available_times") - 1));
				}
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("item.endless_deep_space.detector_of_broken.broken_value").getString() + ""
							+ (entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).broken_value)), (true));
			}
		}
	}
}
