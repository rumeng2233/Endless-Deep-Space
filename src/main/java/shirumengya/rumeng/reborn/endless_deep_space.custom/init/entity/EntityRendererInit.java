
package shirumengya.rumeng.reborn.endless_deep_space.custom.init.entity;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EntityRendererInit {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EntityInit.BOSS_ITEM.get(), ItemEntityRenderer::new);
	}
}
