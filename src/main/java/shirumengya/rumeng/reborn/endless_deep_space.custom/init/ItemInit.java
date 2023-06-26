package shirumengya.rumeng.reborn.endless_deep_space.custom.init;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import shirumengya.rumeng.reborn.endless_deep_space.init.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.item.*;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraft.world.item.*;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.level.block.CommandBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EntityType;

public class ItemInit {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, "endless_deep_space.custom");
	
    public static final RegistryObject<Item> DURABLE_BOW = REGISTRY.register("durable_bow", () -> new BowItem(new Item.Properties().tab(CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM).durability(768)));
    public static final RegistryObject<Item> PETRIFIED_OAK_SIGN = REGISTRY.register("petrified_oak_sign", () -> new SignItem(new Item.Properties().tab(CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM).stacksTo(16), BlockInit.PETRIFIED_OAK_SIGN.get(), BlockInit.PETRIFIED_OAK_WALL_SIGN.get()));
    public static final RegistryObject<Item> TRANSPARENT_SIGN = REGISTRY.register("transparent_sign", () -> new SignItem(new Item.Properties().tab(CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM).stacksTo(16), BlockInit.TRANSPARENT_SIGN.get(), BlockInit.TRANSPARENT_WALL_SIGN.get()));
    public static final RegistryObject<Item> CONVERSION_TABLE = block(BlockInit.CONVERSION_TABLE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> STAR_CUBE_END_PORTAL = block(BlockInit.STAR_CUBE_END_PORTAL, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> STAR_CUBE_END_GATEWAY = block(BlockInit.STAR_CUBE_END_GATEWAY, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> WHITE_GUIDING_STONE = block(BlockInit.WHITE_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> BLACK_GUIDING_STONE = block(BlockInit.BLACK_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> BLUE_GUIDING_STONE = block(BlockInit.BLUE_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> BROWN_GUIDING_STONE = block(BlockInit.BROWN_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> CYAN_GUIDING_STONE = block(BlockInit.CYAN_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> GRAY_GUIDING_STONE = block(BlockInit.GRAY_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> GREEN_GUIDING_STONE = block(BlockInit.GREEN_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> LIGHT_BLUE_GUIDING_STONE = block(BlockInit.LIGHT_BLUE_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> LIGHT_GRAY_GUIDING_STONE = block(BlockInit.LIGHT_GRAY_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> LIME_GUIDING_STONE = block(BlockInit.LIME_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> MAGENTA_GUIDING_STONE = block(BlockInit.MAGENTA_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> ORANGE_GUIDING_STONE = block(BlockInit.ORANGE_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> PINK_GUIDING_STONE = block(BlockInit.PINK_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> PURPLE_GUIDING_STONE = block(BlockInit.PURPLE_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> RED_GUIDING_STONE = block(BlockInit.RED_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> YELLOW_GUIDING_STONE = block(BlockInit.YELLOW_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> BROKEN_BEACON = block(BlockInit.BROKEN_BEACON, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> BLUE_GREEN_GUIDING_STONE = block(BlockInit.BLUE_GREEN_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> SKY_BLUE_GUIDING_STONE = block(BlockInit.SKY_BLUE_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> AQUA_GUIDING_STONE = block(BlockInit.AQUA_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> PURE_BLACK_GUIDING_STONE = block(BlockInit.PURE_BLACK_GUIDING_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
    public static final RegistryObject<Item> GEOCENTRIC_GRASS_BLOCK = edsblock(EndlessDeepSpaceModBlocks.GEOCENTRIC_GRASS_BLOCK, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
	public static final RegistryObject<Item> GEOCENTRIC_DIRT = edsblock(EndlessDeepSpaceModBlocks.GEOCENTRIC_DIRT, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
	public static final RegistryObject<Item> GEOCENTRIC_STONE = edsblock(EndlessDeepSpaceModBlocks.GEOCENTRIC_STONE, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
	public static final RegistryObject<Item> BROKEN_BOOK = block(BlockInit.BROKEN_BOOK, CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM);
	public static final RegistryObject<Item> DURABLE_FISHING_ROD = REGISTRY.register("durable_fishing_rod", () -> new FishingRodItem(new Item.Properties().tab(CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM).durability(384)));
	public static final RegistryObject<Item> DURABLE_CROSSBOW = REGISTRY.register("durable_crossbow", () -> new CrossbowItem(new Item.Properties().tab(CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM).durability(930)));
	public static final RegistryObject<Item> CREATIVE_ENCHANTED_BOOK = REGISTRY.register("creative_enchanted_book", () -> new CreativeEnchantedBookItem());
	public static final RegistryObject<Item> DURABLE_SHIELD = REGISTRY.register("durable_shield", () -> new ShieldItem(new Item.Properties().tab(CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM).durability(674)));
	public static final RegistryObject<Item> RAGING_FIRE_ORE = edsblock(EndlessDeepSpaceModBlocks.RAGING_FIRE_ORE, EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP);
	public static final RegistryObject<Item> RAGING_FIRE_BLOCK = edsblock(EndlessDeepSpaceModBlocks.RAGING_FIRE_BLOCK, EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP);
	public static final RegistryObject<Item> FROZEN_ORE = edsblock(EndlessDeepSpaceModBlocks.FROZEN_ORE, EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP);
	public static final RegistryObject<Item> FROZEN_BLOCK = edsblock(EndlessDeepSpaceModBlocks.FROZEN_BLOCK, EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP);
	public static final RegistryObject<Item> ENDER_DRAGON_SPAWN_EGG = REGISTRY.register("ender_dragon_spawn_egg", () -> new SpawnEggItem(EntityType.ENDER_DRAGON, -16777216, -3407668, new Item.Properties().tab(CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM)));
	public static final RegistryObject<Item> WITHER_SPAWN_EGG = REGISTRY.register("wither_spawn_egg", () -> new SpawnEggItem(EntityType.WITHER, -13421773, -16777216, new Item.Properties().tab(CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM)));
	public static final RegistryObject<Item> IRON_GOLEM_SPAWN_EGG = REGISTRY.register("iron_golem_spawn_egg", () -> new SpawnEggItem(EntityType.IRON_GOLEM, -3355444, -1, new Item.Properties().tab(CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM)));
	public static final RegistryObject<Item> SNOW_GOLEM_SPAWN_EGG = REGISTRY.register("snow_golem_spawn_egg", () -> new SpawnEggItem(EntityType.SNOW_GOLEM, -1, -13210, new Item.Properties().tab(CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM)));
	public static final RegistryObject<Item> GIANT_SPAWN_EGG = REGISTRY.register("giant_spawn_egg", () -> new SpawnEggItem(EntityType.GIANT, 44975, 7969893, new Item.Properties().tab(CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM)));
	public static final RegistryObject<Item> ILLUSIONER_SPAWN_EGG = REGISTRY.register("illusioner_spawn_egg", () -> new SpawnEggItem(EntityType.ILLUSIONER, -13395457, -3355444, new Item.Properties().tab(CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM)));
	public static final RegistryObject<Item> LAVA_ABSORBER = edsblock(EndlessDeepSpaceModBlocks.LAVA_ABSORBER, EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP);
	public static final RegistryObject<Item> WATER_ABSORBER = edsblock(EndlessDeepSpaceModBlocks.WATER_ABSORBER, EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP);
	public static final RegistryObject<Item> SCREAM_ALTAR = edsblock(EndlessDeepSpaceModBlocks.SCREAM_ALTAR, EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP);
	public static final RegistryObject<Item> WITHER_WRATH_ALTAR = edsblock(EndlessDeepSpaceModBlocks.WITHER_WRATH_ALTAR, EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP);

	public static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(CreativeModeTabInit.ENDLESS_DEEP_SPACE_CUSTOM)));
	}

	public static RegistryObject<Item> edsblock(RegistryObject<Block> edsblock, CreativeModeTab tab) {
		return REGISTRY.register(edsblock.getId().getPath(), () -> new BlockItem(edsblock.get(), new Item.Properties().tab(EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP)));
	}
}
