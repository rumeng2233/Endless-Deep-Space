package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.client.Camera;
import net.minecraft.client.CameraType;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.FogRenderer.FogMode;

public class GfgDangYouJianDianJiKongQiShiShiTiDeWeiZhiProcedure {
	public static void execute() {
	Minecraft.getInstance().options.setCameraType(Minecraft.getInstance().options.getCameraType().cycle());
//	FogRenderer.setupNoFog();
//	FogRenderer.setupFog(null, FogMode.FOG_SKY, 0.5F, false, 0.5F);
	}
}
