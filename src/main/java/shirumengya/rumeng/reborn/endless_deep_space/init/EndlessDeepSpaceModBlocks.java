
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package shirumengya.rumeng.reborn.endless_deep_space.init;

import shirumengya.rumeng.reborn.endless_deep_space.block.WitherWrathAltarBlock;
import shirumengya.rumeng.reborn.endless_deep_space.block.WaterAbsorberBlock;
<<<<<<< Updated upstream
=======
import shirumengya.rumeng.reborn.endless_deep_space.block.SuperBombBlock;
import shirumengya.rumeng.reborn.endless_deep_space.block.ScreamAltarBlock;
>>>>>>> Stashed changes
import shirumengya.rumeng.reborn.endless_deep_space.block.RagingFireOreBlock;
import shirumengya.rumeng.reborn.endless_deep_space.block.RagingFireBlockBlock;
import shirumengya.rumeng.reborn.endless_deep_space.block.MinimalitySuperBombBlock;
import shirumengya.rumeng.reborn.endless_deep_space.block.MiniSuperBombBlock;
import shirumengya.rumeng.reborn.endless_deep_space.block.LavaAbsorberBlock;
import shirumengya.rumeng.reborn.endless_deep_space.block.GeocentricStoneBlock;
import shirumengya.rumeng.reborn.endless_deep_space.block.GeocentricPortalBlock;
import shirumengya.rumeng.reborn.endless_deep_space.block.GeocentricGrassBlockBlock;
import shirumengya.rumeng.reborn.endless_deep_space.block.GeocentricDirtBlock;
import shirumengya.rumeng.reborn.endless_deep_space.block.FrozenOreBlock;
import shirumengya.rumeng.reborn.endless_deep_space.block.FrozenBlockBlock;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

public class EndlessDeepSpaceModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, EndlessDeepSpaceMod.MODID);
	public static final RegistryObject<Block> GEOCENTRIC_GRASS_BLOCK = REGISTRY.register("geocentric_grass_block", () -> new GeocentricGrassBlockBlock());
	public static final RegistryObject<Block> GEOCENTRIC_DIRT = REGISTRY.register("geocentric_dirt", () -> new GeocentricDirtBlock());
	public static final RegistryObject<Block> GEOCENTRIC_STONE = REGISTRY.register("geocentric_stone", () -> new GeocentricStoneBlock());
	public static final RegistryObject<Block> GEOCENTRIC_PORTAL = REGISTRY.register("geocentric_portal", () -> new GeocentricPortalBlock());
	public static final RegistryObject<Block> RAGING_FIRE_ORE = REGISTRY.register("raging_fire_ore", () -> new RagingFireOreBlock());
	public static final RegistryObject<Block> RAGING_FIRE_BLOCK = REGISTRY.register("raging_fire_block", () -> new RagingFireBlockBlock());
	public static final RegistryObject<Block> FROZEN_ORE = REGISTRY.register("frozen_ore", () -> new FrozenOreBlock());
	public static final RegistryObject<Block> FROZEN_BLOCK = REGISTRY.register("frozen_block", () -> new FrozenBlockBlock());
	public static final RegistryObject<Block> LAVA_ABSORBER = REGISTRY.register("lava_absorber", () -> new LavaAbsorberBlock());
	public static final RegistryObject<Block> WATER_ABSORBER = REGISTRY.register("water_absorber", () -> new WaterAbsorberBlock());
<<<<<<< Updated upstream
=======
	public static final RegistryObject<Block> SCREAM_ALTAR = REGISTRY.register("scream_altar", () -> new ScreamAltarBlock());
	public static final RegistryObject<Block> WITHER_WRATH_ALTAR = REGISTRY.register("wither_wrath_altar", () -> new WitherWrathAltarBlock());
	public static final RegistryObject<Block> SUPER_BOMB = REGISTRY.register("super_bomb", () -> new SuperBombBlock());
	public static final RegistryObject<Block> MINI_SUPER_BOMB = REGISTRY.register("mini_super_bomb", () -> new MiniSuperBombBlock());
	public static final RegistryObject<Block> MINIMALITY_SUPER_BOMB = REGISTRY.register("minimality_super_bomb", () -> new MinimalitySuperBombBlock());
>>>>>>> Stashed changes

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
			GeocentricGrassBlockBlock.blockColorLoad(event);
		}

		@SubscribeEvent
		public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
			GeocentricGrassBlockBlock.itemColorLoad(event);
		}
	}
}
