
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package shirumengya.rumeng.reborn.endless_deep_space.init;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

public class EndlessDeepSpaceModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, EndlessDeepSpaceMod.MODID);
	public static final RegistryObject<SimpleParticleType> DYNAMIC_BROKEN_PARTICLES_FAST = REGISTRY.register("dynamic_broken_particles_fast", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DYNAMIC_BROKEN_PARTICLES_MIDDLE = REGISTRY.register("dynamic_broken_particles_middle", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> DYNAMIC_BROKEN_PARTICLES_SLOW = REGISTRY.register("dynamic_broken_particles_slow", () -> new SimpleParticleType(false));
}
