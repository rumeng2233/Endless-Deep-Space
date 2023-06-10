package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.client.Camera;
import net.minecraft.client.CameraType;

public class LoseYourselfCameraProcedure {
	public static void execute() {
	Minecraft.getInstance().options.setCameraType(Minecraft.getInstance().options.getCameraType().cycle());
	}
}
