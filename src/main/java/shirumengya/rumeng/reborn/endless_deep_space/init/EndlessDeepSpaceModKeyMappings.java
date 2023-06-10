
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package shirumengya.rumeng.reborn.endless_deep_space.init;

import shirumengya.rumeng.reborn.endless_deep_space.network.ThroughTheWallMessage;
import shirumengya.rumeng.reborn.endless_deep_space.network.QuicklyForceStopTheJavaVirtualMachineWithoutReportingAnErrorMessage;
import shirumengya.rumeng.reborn.endless_deep_space.network.QuicklyForceStopTheJavaVirtualMachineMessage;
import shirumengya.rumeng.reborn.endless_deep_space.network.PlayEndPoemMessage;
import shirumengya.rumeng.reborn.endless_deep_space.network.OpenPlayerModelViewerMessage;
import shirumengya.rumeng.reborn.endless_deep_space.network.InvincibleMessage;
import shirumengya.rumeng.reborn.endless_deep_space.network.FlyKeyMessage;
import shirumengya.rumeng.reborn.endless_deep_space.network.ExitServerMessage;
import shirumengya.rumeng.reborn.endless_deep_space.network.ColorPickerMessage;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class EndlessDeepSpaceModKeyMappings {
	public static final KeyMapping QUICKLY_FORCE_STOP_THE_JAVA_VIRTUAL_MACHINE = new KeyMapping("key.endless_deep_space.quickly_force_stop_the_java_virtual_machine", GLFW.GLFW_KEY_J, "key.categories.endless_deep_space") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				EndlessDeepSpaceMod.PACKET_HANDLER.sendToServer(new QuicklyForceStopTheJavaVirtualMachineMessage(0, 0));
				QuicklyForceStopTheJavaVirtualMachineMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping QUICKLY_FORCE_STOP_THE_JAVA_VIRTUAL_MACHINE_WITHOUT_REPORTING_AN_ERROR = new KeyMapping("key.endless_deep_space.quickly_force_stop_the_java_virtual_machine_without_reporting_an_error", GLFW.GLFW_KEY_K,
			"key.categories.endless_deep_space") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				EndlessDeepSpaceMod.PACKET_HANDLER.sendToServer(new QuicklyForceStopTheJavaVirtualMachineWithoutReportingAnErrorMessage(0, 0));
				QuicklyForceStopTheJavaVirtualMachineWithoutReportingAnErrorMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping INVINCIBLE = new KeyMapping("key.endless_deep_space.invincible", GLFW.GLFW_KEY_I, "key.categories.endless_deep_space") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				EndlessDeepSpaceMod.PACKET_HANDLER.sendToServer(new InvincibleMessage(0, 0));
				InvincibleMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FLY_KEY = new KeyMapping("key.endless_deep_space.fly_key", GLFW.GLFW_KEY_Y, "key.categories.endless_deep_space") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				EndlessDeepSpaceMod.PACKET_HANDLER.sendToServer(new FlyKeyMessage(0, 0));
				FlyKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping PLAY_END_POEM = new KeyMapping("key.endless_deep_space.play_end_poem", GLFW.GLFW_KEY_END, "key.categories.endless_deep_space") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				EndlessDeepSpaceMod.PACKET_HANDLER.sendToServer(new PlayEndPoemMessage(0, 0));
				PlayEndPoemMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping EXIT_SERVER = new KeyMapping("key.endless_deep_space.exit_server", GLFW.GLFW_KEY_R, "key.categories.endless_deep_space") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				EndlessDeepSpaceMod.PACKET_HANDLER.sendToServer(new ExitServerMessage(0, 0));
				ExitServerMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping COLOR_PICKER = new KeyMapping("key.endless_deep_space.color_picker", GLFW.GLFW_KEY_O, "key.categories.endless_deep_space") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				EndlessDeepSpaceMod.PACKET_HANDLER.sendToServer(new ColorPickerMessage(0, 0));
				ColorPickerMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPEN_PLAYER_MODEL_VIEWER = new KeyMapping("key.endless_deep_space.open_player_model_viewer", GLFW.GLFW_KEY_M, "key.categories.endless_deep_space") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				EndlessDeepSpaceMod.PACKET_HANDLER.sendToServer(new OpenPlayerModelViewerMessage(0, 0));
				OpenPlayerModelViewerMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping THROUGH_THE_WALL = new KeyMapping("key.endless_deep_space.through_the_wall", GLFW.GLFW_KEY_H, "key.categories.endless_deep_space") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				EndlessDeepSpaceMod.PACKET_HANDLER.sendToServer(new ThroughTheWallMessage(0, 0));
				ThroughTheWallMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(QUICKLY_FORCE_STOP_THE_JAVA_VIRTUAL_MACHINE);
		event.register(QUICKLY_FORCE_STOP_THE_JAVA_VIRTUAL_MACHINE_WITHOUT_REPORTING_AN_ERROR);
		event.register(INVINCIBLE);
		event.register(FLY_KEY);
		event.register(PLAY_END_POEM);
		event.register(EXIT_SERVER);
		event.register(COLOR_PICKER);
		event.register(OPEN_PLAYER_MODEL_VIEWER);
		event.register(THROUGH_THE_WALL);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				QUICKLY_FORCE_STOP_THE_JAVA_VIRTUAL_MACHINE.consumeClick();
				QUICKLY_FORCE_STOP_THE_JAVA_VIRTUAL_MACHINE_WITHOUT_REPORTING_AN_ERROR.consumeClick();
				INVINCIBLE.consumeClick();
				FLY_KEY.consumeClick();
				PLAY_END_POEM.consumeClick();
				EXIT_SERVER.consumeClick();
				COLOR_PICKER.consumeClick();
				OPEN_PLAYER_MODEL_VIEWER.consumeClick();
				THROUGH_THE_WALL.consumeClick();
			}
		}
	}
}
