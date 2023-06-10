
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package shirumengya.rumeng.reborn.endless_deep_space.init;

import shirumengya.rumeng.reborn.endless_deep_space.client.particle.DynamicBrokenParticlesSlowParticle;
import shirumengya.rumeng.reborn.endless_deep_space.client.particle.DynamicBrokenParticlesMiddleParticle;
import shirumengya.rumeng.reborn.endless_deep_space.client.particle.DynamicBrokenParticlesFastParticle;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EndlessDeepSpaceModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.register(EndlessDeepSpaceModParticleTypes.DYNAMIC_BROKEN_PARTICLES_FAST.get(), DynamicBrokenParticlesFastParticle::provider);
		event.register(EndlessDeepSpaceModParticleTypes.DYNAMIC_BROKEN_PARTICLES_MIDDLE.get(), DynamicBrokenParticlesMiddleParticle::provider);
		event.register(EndlessDeepSpaceModParticleTypes.DYNAMIC_BROKEN_PARTICLES_SLOW.get(), DynamicBrokenParticlesSlowParticle::provider);
	}
}
