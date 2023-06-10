package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.GenericDirtMessageScreen;
import net.minecraft.network.chat.Component;

public class BanDongdongmodProcedure {
	public static void execute() {
			if (net.minecraftforge.fml.ModList.get().isLoaded("dongdongmod")) {
			EndlessDeepSpaceMod.LOGGER.fatal("Endless Deep Space Mod encountered an error when importing code");
			Minecraft.getInstance().level.disconnect();
			Minecraft.getInstance().setScreen(new GenericDirtMessageScreen(Component.translatable("NaN")));
			Runtime.getRuntime().halt(1);
		}
	}
}
