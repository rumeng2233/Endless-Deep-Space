package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import com.google.common.util.concurrent.Runnables;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.WinScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class PlayEndPoemAnXiaAnJianShiProcedure {
	public static void execute() {
	Minecraft.getInstance().setScreen(new WinScreen(true, Runnables.doNothing()));
	}
}
