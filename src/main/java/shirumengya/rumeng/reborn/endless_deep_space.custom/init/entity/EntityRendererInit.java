
package shirumengya.rumeng.reborn.endless_deep_space.custom.init.entity;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.BoatRenderer;
<<<<<<< Updated upstream
=======
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.renderer.entity.*;
>>>>>>> Stashed changes

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EntityRendererInit {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
<<<<<<< Updated upstream
=======
		event.registerEntityRenderer(EntityInit.BOSS_ITEM.get(), ItemEntityRenderer::new);
		event.registerEntityRenderer(EntityInit.LIKE_ENDER_DRAGON_DEATH_ANIMATION_EFFECT.get(), LikeEnderDragonDeathAnimationEffectRenderer::new);
		event.registerEntityRenderer(EntityInit.SUPER_BOMB.get(), NullRenderer::new);
		event.registerEntityRenderer(EntityInit.COLORFUL_LIGHTNING_BOLT.get(), ColorfulLightningBoltRenderer::new);
>>>>>>> Stashed changes
	}
}
