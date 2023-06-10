package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import com.google.common.util.concurrent.Runnables;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.screens.EndlessDeepSpaceCredits;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import shirumengya.rumeng.reborn.endless_deep_space.init.*;

@OnlyIn(Dist.CLIENT)
public class BrokenBookBlockRCProcedure {
	public static void execute() {
	if (Math.random() < 0.1) {
	Minecraft.getInstance().setScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_one", "broken", 0.5F, false, true, Runnables.doNothing()));
	} else if (Math.random() < 0.1) {
	Minecraft.getInstance().setScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_two", "broken", 0.5F, false, true, Runnables.doNothing()));
	} else if (Math.random() < 0.1) {
	Minecraft.getInstance().setScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_three", "broken", 0.5F, false, true, Runnables.doNothing()));
	} else if (Math.random() < 0.1) {
	Minecraft.getInstance().setScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_four", "broken", 0.5F, false, true, Runnables.doNothing()));
	} else if (Math.random() < 0.1) {
	Minecraft.getInstance().setScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_five", "broken", 0.5F, false, true, Runnables.doNothing()));
	} else if (Math.random() < 0.1) {
	Minecraft.getInstance().setScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_six", "broken", 0.5F, false, true, Runnables.doNothing()));
	} else if (Math.random() < 0.1) {
	Minecraft.getInstance().setScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_seven", "broken", 0.5F, false, true, Runnables.doNothing()));
	} else if (Math.random() < 0.1) {
	Minecraft.getInstance().setScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_eight", "broken", 0.5F, false, true, Runnables.doNothing()));
	} else if (Math.random() < 0.1) {
	Minecraft.getInstance().setScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_nine", "broken", 0.5F, false, true, Runnables.doNothing()));
	} else if (Math.random() < 0.1) {
	Minecraft.getInstance().setScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_ten", "broken", 0.5F, false, true, Runnables.doNothing()));
	}
	}
}
