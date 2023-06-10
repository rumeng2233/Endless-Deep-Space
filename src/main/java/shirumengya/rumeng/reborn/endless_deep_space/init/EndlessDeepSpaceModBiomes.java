
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package shirumengya.rumeng.reborn.endless_deep_space.init;

import shirumengya.rumeng.reborn.endless_deep_space.world.biome.NihilityBiomeBiome;
import shirumengya.rumeng.reborn.endless_deep_space.world.biome.GeocentricWastelandBiome;
import shirumengya.rumeng.reborn.endless_deep_space.world.biome.GeocentricMountainBiome;
import shirumengya.rumeng.reborn.endless_deep_space.world.biome.BossFightBiomeBiome;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.biome.Biome;

public class EndlessDeepSpaceModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, EndlessDeepSpaceMod.MODID);
	public static final RegistryObject<Biome> NIHILITY_BIOME = REGISTRY.register("nihility_biome", NihilityBiomeBiome::createBiome);
	public static final RegistryObject<Biome> GEOCENTRIC_WASTELAND = REGISTRY.register("geocentric_wasteland", GeocentricWastelandBiome::createBiome);
	public static final RegistryObject<Biome> BOSS_FIGHT_BIOME = REGISTRY.register("boss_fight_biome", BossFightBiomeBiome::createBiome);
	public static final RegistryObject<Biome> GEOCENTRIC_MOUNTAIN = REGISTRY.register("geocentric_mountain", GeocentricMountainBiome::createBiome);
}
