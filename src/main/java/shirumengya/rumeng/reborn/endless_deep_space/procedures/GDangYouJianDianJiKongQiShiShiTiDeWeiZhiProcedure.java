package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

public class GDangYouJianDianJiKongQiShiShiTiDeWeiZhiProcedure {
	public static void execute() {
	Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("shaders/post/invert.json"));
	}
}
