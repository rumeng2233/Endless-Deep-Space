package shirumengya.rumeng.reborn.endless_deep_space.custom.init.entity.projectile;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.projectile.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.renderer.entity.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ProjectileRendererInit {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ProjectileInit.ENDER_DRAGON_WIND_BOMB.get(), EnderDragonWindBombRenderer::new);
		event.registerEntityRenderer(ProjectileInit.PENETRATING_BOW_ARROW.get(), PenetratingBowArrowRenderer::new);
	}
}
