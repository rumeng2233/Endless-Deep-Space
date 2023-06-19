
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package shirumengya.rumeng.reborn.endless_deep_space.init;

import shirumengya.rumeng.reborn.endless_deep_space.client.renderer.WitherestRenderer;
import shirumengya.rumeng.reborn.endless_deep_space.client.renderer.StoneRenderer;
import shirumengya.rumeng.reborn.endless_deep_space.client.renderer.ScreamingGhastRenderer;
import shirumengya.rumeng.reborn.endless_deep_space.client.renderer.MadWitchRenderer;
import shirumengya.rumeng.reborn.endless_deep_space.client.renderer.IRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EndlessDeepSpaceModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EndlessDeepSpaceModEntities.WITHEREST.get(), WitherestRenderer::new);
		event.registerEntityRenderer(EndlessDeepSpaceModEntities.STONE.get(), StoneRenderer::new);
		event.registerEntityRenderer(EndlessDeepSpaceModEntities.I.get(), IRenderer::new);
		event.registerEntityRenderer(EndlessDeepSpaceModEntities.MAD_WITCH.get(), MadWitchRenderer::new);
		event.registerEntityRenderer(EndlessDeepSpaceModEntities.ENDER_BOW.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(EndlessDeepSpaceModEntities.SCREAMING_GHAST.get(), ScreamingGhastRenderer::new);
	}
}
