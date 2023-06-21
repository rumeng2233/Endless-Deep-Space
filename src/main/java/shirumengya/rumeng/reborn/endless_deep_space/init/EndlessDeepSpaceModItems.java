
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package shirumengya.rumeng.reborn.endless_deep_space.init;

import shirumengya.rumeng.reborn.endless_deep_space.item.WoodenPocketKnifeItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.TrackingArrowItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.TotemSwordItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.TheLostItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.StonePocketKnifeItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.RagingFireSwordItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.RagingFireShovelItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.RagingFirePocketKnifeItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.RagingFirePickaxeItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.RagingFireHoeItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.RagingFireDustItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.RagingFireAxeItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.RagingFireArmorItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.PenetratingBowItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.NullItemItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.NetheritePocketKnifeItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.LogoItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.IronPocketKnifeItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.IntertwinedItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.GoldenPocketKnifeItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.GeocentricItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.FrozenSwordItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.FrozenShovelItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.FrozenPocketKnifeItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.FrozenPickaxeItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.FrozenHoeItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.FrozenDustItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.FrozenAxeItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.FrozenArmorItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.FpsItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.EyeballItemItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.EnderBowItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.DiamondPocketKnifeItem;
import shirumengya.rumeng.reborn.endless_deep_space.item.DetectorOfBrokenItem;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

public class EndlessDeepSpaceModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EndlessDeepSpaceMod.MODID);
	public static final RegistryObject<Item> WITHEREST_SPAWN_EGG = REGISTRY.register("witherest_spawn_egg",
			() -> new ForgeSpawnEggItem(EndlessDeepSpaceModEntities.WITHEREST, -13395457, -10040065, new Item.Properties().tab(EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP)));
	public static final RegistryObject<Item> STONE_SPAWN_EGG = REGISTRY.register("stone_spawn_egg",
			() -> new ForgeSpawnEggItem(EndlessDeepSpaceModEntities.STONE, -6710887, -10066330, new Item.Properties().tab(EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP)));
	public static final RegistryObject<Item> FPS = REGISTRY.register("fps", () -> new FpsItem());
	public static final RegistryObject<Item> I_SPAWN_EGG = REGISTRY.register("i_spawn_egg", () -> new ForgeSpawnEggItem(EndlessDeepSpaceModEntities.I, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> MAD_WITCH_SPAWN_EGG = REGISTRY.register("mad_witch_spawn_egg",
			() -> new ForgeSpawnEggItem(EndlessDeepSpaceModEntities.MAD_WITCH, -3407617, -6750055, new Item.Properties().tab(EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP)));
	public static final RegistryObject<Item> DETECTOR_OF_BROKEN = REGISTRY.register("detector_of_broken", () -> new DetectorOfBrokenItem());
	public static final RegistryObject<Item> ENDER_BOW = REGISTRY.register("ender_bow", () -> new EnderBowItem());
	public static final RegistryObject<Item> LOGO = REGISTRY.register("logo", () -> new LogoItem());
	public static final RegistryObject<Item> MUSIC_DISC_THE_LOST = REGISTRY.register("music_disc_the_lost", () -> new TheLostItem());
	public static final RegistryObject<Item> MUSIC_DISC_INTERTWINED = REGISTRY.register("music_disc_intertwined", () -> new IntertwinedItem());
	public static final RegistryObject<Item> EYEBALL_ITEM = REGISTRY.register("eyeball_item", () -> new EyeballItemItem());
	public static final RegistryObject<Item> NULL_ITEM = REGISTRY.register("null_item", () -> new NullItemItem());
	public static final RegistryObject<Item> GEOCENTRIC_GRASS_BLOCK = block(EndlessDeepSpaceModBlocks.GEOCENTRIC_GRASS_BLOCK, EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP);
	public static final RegistryObject<Item> GEOCENTRIC_DIRT = block(EndlessDeepSpaceModBlocks.GEOCENTRIC_DIRT, EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP);
	public static final RegistryObject<Item> GEOCENTRIC_STONE = block(EndlessDeepSpaceModBlocks.GEOCENTRIC_STONE, EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP);
	public static final RegistryObject<Item> GEOCENTRIC = REGISTRY.register("geocentric", () -> new GeocentricItem());
	public static final RegistryObject<Item> WOODEN_POCKET_KNIFE = REGISTRY.register("wooden_pocket_knife", () -> new WoodenPocketKnifeItem());
	public static final RegistryObject<Item> STONE_POCKET_KNIFE = REGISTRY.register("stone_pocket_knife", () -> new StonePocketKnifeItem());
	public static final RegistryObject<Item> IRON_POCKET_KNIFE = REGISTRY.register("iron_pocket_knife", () -> new IronPocketKnifeItem());
	public static final RegistryObject<Item> GOLDEN_POCKET_KNIFE = REGISTRY.register("golden_pocket_knife", () -> new GoldenPocketKnifeItem());
	public static final RegistryObject<Item> DIAMOND_POCKET_KNIFE = REGISTRY.register("diamond_pocket_knife", () -> new DiamondPocketKnifeItem());
	public static final RegistryObject<Item> NETHERITE_POCKET_KNIFE = REGISTRY.register("netherite_pocket_knife", () -> new NetheritePocketKnifeItem());
	public static final RegistryObject<Item> RAGING_FIRE_DUST = REGISTRY.register("raging_fire_dust", () -> new RagingFireDustItem());
	public static final RegistryObject<Item> RAGING_FIRE_ORE = block(EndlessDeepSpaceModBlocks.RAGING_FIRE_ORE, EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP);
	public static final RegistryObject<Item> RAGING_FIRE_BLOCK = block(EndlessDeepSpaceModBlocks.RAGING_FIRE_BLOCK, EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP);
	public static final RegistryObject<Item> RAGING_FIRE_PICKAXE = REGISTRY.register("raging_fire_pickaxe", () -> new RagingFirePickaxeItem());
	public static final RegistryObject<Item> RAGING_FIRE_AXE = REGISTRY.register("raging_fire_axe", () -> new RagingFireAxeItem());
	public static final RegistryObject<Item> RAGING_FIRE_SWORD = REGISTRY.register("raging_fire_sword", () -> new RagingFireSwordItem());
	public static final RegistryObject<Item> RAGING_FIRE_SHOVEL = REGISTRY.register("raging_fire_shovel", () -> new RagingFireShovelItem());
	public static final RegistryObject<Item> RAGING_FIRE_HOE = REGISTRY.register("raging_fire_hoe", () -> new RagingFireHoeItem());
	public static final RegistryObject<Item> RAGING_FIRE_ARMOR_HELMET = REGISTRY.register("raging_fire_armor_helmet", () -> new RagingFireArmorItem.Helmet());
	public static final RegistryObject<Item> RAGING_FIRE_ARMOR_CHESTPLATE = REGISTRY.register("raging_fire_armor_chestplate", () -> new RagingFireArmorItem.Chestplate());
	public static final RegistryObject<Item> RAGING_FIRE_ARMOR_LEGGINGS = REGISTRY.register("raging_fire_armor_leggings", () -> new RagingFireArmorItem.Leggings());
	public static final RegistryObject<Item> RAGING_FIRE_ARMOR_BOOTS = REGISTRY.register("raging_fire_armor_boots", () -> new RagingFireArmorItem.Boots());
	public static final RegistryObject<Item> RAGING_FIRE_POCKET_KNIFE = REGISTRY.register("raging_fire_pocket_knife", () -> new RagingFirePocketKnifeItem());
	public static final RegistryObject<Item> FROZEN_DUST = REGISTRY.register("frozen_dust", () -> new FrozenDustItem());
	public static final RegistryObject<Item> FROZEN_ORE = block(EndlessDeepSpaceModBlocks.FROZEN_ORE, EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP);
	public static final RegistryObject<Item> FROZEN_BLOCK = block(EndlessDeepSpaceModBlocks.FROZEN_BLOCK, EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP);
	public static final RegistryObject<Item> FROZEN_PICKAXE = REGISTRY.register("frozen_pickaxe", () -> new FrozenPickaxeItem());
	public static final RegistryObject<Item> FROZEN_AXE = REGISTRY.register("frozen_axe", () -> new FrozenAxeItem());
	public static final RegistryObject<Item> FROZEN_SWORD = REGISTRY.register("frozen_sword", () -> new FrozenSwordItem());
	public static final RegistryObject<Item> FROZEN_SHOVEL = REGISTRY.register("frozen_shovel", () -> new FrozenShovelItem());
	public static final RegistryObject<Item> FROZEN_HOE = REGISTRY.register("frozen_hoe", () -> new FrozenHoeItem());
	public static final RegistryObject<Item> FROZEN_ARMOR_HELMET = REGISTRY.register("frozen_armor_helmet", () -> new FrozenArmorItem.Helmet());
	public static final RegistryObject<Item> FROZEN_ARMOR_CHESTPLATE = REGISTRY.register("frozen_armor_chestplate", () -> new FrozenArmorItem.Chestplate());
	public static final RegistryObject<Item> FROZEN_ARMOR_LEGGINGS = REGISTRY.register("frozen_armor_leggings", () -> new FrozenArmorItem.Leggings());
	public static final RegistryObject<Item> FROZEN_ARMOR_BOOTS = REGISTRY.register("frozen_armor_boots", () -> new FrozenArmorItem.Boots());
	public static final RegistryObject<Item> FROZEN_POCKET_KNIFE = REGISTRY.register("frozen_pocket_knife", () -> new FrozenPocketKnifeItem());
	public static final RegistryObject<Item> PENETRATING_BOW = REGISTRY.register("penetrating_bow", () -> new PenetratingBowItem());
	public static final RegistryObject<Item> TOTEM_SWORD = REGISTRY.register("totem_sword", () -> new TotemSwordItem());
	public static final RegistryObject<Item> LAVA_ABSORBER = block(EndlessDeepSpaceModBlocks.LAVA_ABSORBER, EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP);
	public static final RegistryObject<Item> WATER_ABSORBER = block(EndlessDeepSpaceModBlocks.WATER_ABSORBER, EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP);
<<<<<<< Updated upstream
	public static final RegistryObject<Item> GHASTLIER_SPAWN_EGG = REGISTRY.register("ghastlier_spawn_egg",
			() -> new ForgeSpawnEggItem(EndlessDeepSpaceModEntities.GHASTLIER, -1, -1, new Item.Properties().tab(EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP)));
=======
	public static final RegistryObject<Item> ENCHANTED_TOTEM_OF_UNDYING = REGISTRY.register("enchanted_totem_of_undying", () -> new EnchantedTotemOfUndyingItem());
	public static final RegistryObject<Item> SCREAMING_GHAST_SPAWN_EGG = REGISTRY.register("screaming_ghast_spawn_egg",
			() -> new ForgeSpawnEggItem(EndlessDeepSpaceModEntities.SCREAMING_GHAST, -1, -1, new Item.Properties().tab(EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP)));
	public static final RegistryObject<Item> TRACKING_ARROW = REGISTRY.register("tracking_arrow", () -> new TrackingArrowItem());
>>>>>>> Stashed changes

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
