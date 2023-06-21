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
<<<<<<< Updated upstream
=======
		event.registerEntityRenderer(ProjectileInit.SCREAMING_GHAST_FIRBALL.get(), (p_174082_) -> {
         							return new ThrownItemRenderer<>(p_174082_, 3.0F, true);});
        event.registerEntityRenderer(ProjectileInit.SCREAMING_GHAST_MAGIC_BULLET.get(), ScreamingGhastMagicBulletRenderer::new);
        event.registerEntityRenderer(ProjectileInit.TRACKING_ARROW.get(), DefaultArrowRenderer::new);
        event.registerEntityRenderer(ProjectileInit.SCREAMING_GHAST_GRAVITY_BOMB.get(), ScreamingGhastGravityBombRenderer::new);
>>>>>>> Stashed changes
	}
}
