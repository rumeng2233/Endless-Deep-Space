package shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity;

import shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.sign.EndlessDeepSpaceCustomSignBlockEntity;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.conversion_table.ConversionTableBlockEntity;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.guiding_stone.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.BlockInit;

public class EndlessDeepSpaceCustomBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> REGISTRY =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "endless_deep_space.custom");
            

    public static final RegistryObject<BlockEntityType<EndlessDeepSpaceCustomSignBlockEntity>> SIGN_BLOCK_ENTITY =
            REGISTRY.register("sign", () ->
                    BlockEntityType.Builder.of(EndlessDeepSpaceCustomSignBlockEntity::new,
//                            BlockInit.PETRIFIED_OAK_WALL_SIGN.get(),
//                            BlockInit.PETRIFIED_OAK_SIGN.get()).build(null));
                            BlockInit.PETRIFIED_OAK_WALL_SIGN.get(),
                            BlockInit.PETRIFIED_OAK_SIGN.get(),
                            BlockInit.TRANSPARENT_WALL_SIGN.get(),
                            BlockInit.TRANSPARENT_SIGN.get()).build(null));
                            
	public static final RegistryObject<BlockEntityType<ConversionTableBlockEntity>> CONVERSION_TABLE =
            REGISTRY.register("conversion_table", () ->
                    BlockEntityType.Builder.of(ConversionTableBlockEntity::new,
                            BlockInit.CONVERSION_TABLE.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<StarCubeEndPortalBlockEntity>> STAR_CUBE_END_PORTAL =
            REGISTRY.register("star_cube_end_portal", () ->
                    BlockEntityType.Builder.of(StarCubeEndPortalBlockEntity::new,
                            BlockInit.STAR_CUBE_END_PORTAL.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<StarCubeEndGatewayBlockEntity>> STAR_CUBE_END_GATEWAY =
            REGISTRY.register("star_cube_end_gateway", () ->
                    BlockEntityType.Builder.of(StarCubeEndGatewayBlockEntity::new,
                            BlockInit.STAR_CUBE_END_GATEWAY.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<WhiteGuidingStoneBlockEntity>> WHITE_GUIDING_STONE =
            REGISTRY.register("white_guiding_stone", () ->
                    BlockEntityType.Builder.of(WhiteGuidingStoneBlockEntity::new,
                            BlockInit.WHITE_GUIDING_STONE.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<BlackGuidingStoneBlockEntity>> BLACK_GUIDING_STONE =
            REGISTRY.register("black_guiding_stone", () ->
                    BlockEntityType.Builder.of(BlackGuidingStoneBlockEntity::new,
                            BlockInit.BLACK_GUIDING_STONE.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<BlueGuidingStoneBlockEntity>> BLUE_GUIDING_STONE =
            REGISTRY.register("blue_guiding_stone", () ->
                    BlockEntityType.Builder.of(BlueGuidingStoneBlockEntity::new,
                            BlockInit.BLUE_GUIDING_STONE.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<BrownGuidingStoneBlockEntity>> BROWN_GUIDING_STONE =
            REGISTRY.register("brown_guiding_stone", () ->
                    BlockEntityType.Builder.of(BrownGuidingStoneBlockEntity::new,
                            BlockInit.BROWN_GUIDING_STONE.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<CyanGuidingStoneBlockEntity>> CYAN_GUIDING_STONE =
            REGISTRY.register("cyan_guiding_stone", () ->
                    BlockEntityType.Builder.of(CyanGuidingStoneBlockEntity::new,
                            BlockInit.CYAN_GUIDING_STONE.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<GrayGuidingStoneBlockEntity>> GRAY_GUIDING_STONE =
            REGISTRY.register("gray_guiding_stone", () ->
                    BlockEntityType.Builder.of(GrayGuidingStoneBlockEntity::new,
                            BlockInit.GRAY_GUIDING_STONE.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<GreenGuidingStoneBlockEntity>> GREEN_GUIDING_STONE =
            REGISTRY.register("green_guiding_stone", () ->
                    BlockEntityType.Builder.of(GreenGuidingStoneBlockEntity::new,
                            BlockInit.GREEN_GUIDING_STONE.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<LightBlueGuidingStoneBlockEntity>> LIGHT_BLUE_GUIDING_STONE =
            REGISTRY.register("light_blue_guiding_stone", () ->
                    BlockEntityType.Builder.of(LightBlueGuidingStoneBlockEntity::new,
                            BlockInit.LIGHT_BLUE_GUIDING_STONE.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<LightGrayGuidingStoneBlockEntity>> LIGHT_GRAY_GUIDING_STONE =
            REGISTRY.register("light_gray_guiding_stone", () ->
                    BlockEntityType.Builder.of(LightGrayGuidingStoneBlockEntity::new,
                            BlockInit.LIGHT_GRAY_GUIDING_STONE.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<LimeGuidingStoneBlockEntity>> LIME_GUIDING_STONE =
            REGISTRY.register("lime_guiding_stone", () ->
                    BlockEntityType.Builder.of(LimeGuidingStoneBlockEntity::new,
                            BlockInit.LIME_GUIDING_STONE.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<MagentaGuidingStoneBlockEntity>> MAGENTA_GUIDING_STONE =
            REGISTRY.register("magenta_guiding_stone", () ->
                    BlockEntityType.Builder.of(MagentaGuidingStoneBlockEntity::new,
                            BlockInit.MAGENTA_GUIDING_STONE.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<OrangeGuidingStoneBlockEntity>> ORANGE_GUIDING_STONE =
            REGISTRY.register("orange_guiding_stone", () ->
                    BlockEntityType.Builder.of(OrangeGuidingStoneBlockEntity::new,
                            BlockInit.ORANGE_GUIDING_STONE.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<PinkGuidingStoneBlockEntity>> PINK_GUIDING_STONE =
            REGISTRY.register("pink_guiding_stone", () ->
                    BlockEntityType.Builder.of(PinkGuidingStoneBlockEntity::new,
                            BlockInit.PINK_GUIDING_STONE.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<PurpleGuidingStoneBlockEntity>> PURPLE_GUIDING_STONE =
            REGISTRY.register("purple_guiding_stone", () ->
                    BlockEntityType.Builder.of(PurpleGuidingStoneBlockEntity::new,
                            BlockInit.PURPLE_GUIDING_STONE.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<RedGuidingStoneBlockEntity>> RED_GUIDING_STONE =
            REGISTRY.register("red_guiding_stone", () ->
                    BlockEntityType.Builder.of(RedGuidingStoneBlockEntity::new,
                            BlockInit.RED_GUIDING_STONE.get()).build(null));
                            
    public static final RegistryObject<BlockEntityType<YellowGuidingStoneBlockEntity>> YELLOW_GUIDING_STONE =
            REGISTRY.register("yellow_guiding_stone", () ->
                    BlockEntityType.Builder.of(YellowGuidingStoneBlockEntity::new,
                            BlockInit.YELLOW_GUIDING_STONE.get()).build(null));

    public static final RegistryObject<BlockEntityType<BrokenBeaconBlockEntity>> BROKEN_BEACON =
            REGISTRY.register("broken_beacon", () ->
                    BlockEntityType.Builder.of(BrokenBeaconBlockEntity::new,
                            BlockInit.BROKEN_BEACON.get()).build(null));

    public static final RegistryObject<BlockEntityType<BlueGreenGuidingStoneBlockEntity>> BLUE_GREEN_GUIDING_STONE =
            REGISTRY.register("blue_green_guiding_stone", () ->
                    BlockEntityType.Builder.of(BlueGreenGuidingStoneBlockEntity::new,
                            BlockInit.BLUE_GREEN_GUIDING_STONE.get()).build(null));

    public static final RegistryObject<BlockEntityType<SkyBlueGuidingStoneBlockEntity>> SKY_BLUE_GUIDING_STONE =
            REGISTRY.register("sky_blue_guiding_stone", () ->
                    BlockEntityType.Builder.of(SkyBlueGuidingStoneBlockEntity::new,
                            BlockInit.SKY_BLUE_GUIDING_STONE.get()).build(null));

    public static final RegistryObject<BlockEntityType<AquaGuidingStoneBlockEntity>> AQUA_GUIDING_STONE =
            REGISTRY.register("aqua_guiding_stone", () ->
                    BlockEntityType.Builder.of(AquaGuidingStoneBlockEntity::new,
                            BlockInit.AQUA_GUIDING_STONE.get()).build(null));

    public static final RegistryObject<BlockEntityType<PureBlackGuidingStoneBlockEntity>> PURE_BLACK_GUIDING_STONE =
            REGISTRY.register("pure_black_guiding_stone", () ->
                    BlockEntityType.Builder.of(PureBlackGuidingStoneBlockEntity::new,
                            BlockInit.PURE_BLACK_GUIDING_STONE.get()).build(null));

    public static final RegistryObject<BlockEntityType<BrokenBookBlockEntity>> BROKEN_BOOK =
            REGISTRY.register("broken_book", () ->
                    BlockEntityType.Builder.of(BrokenBookBlockEntity::new,
                            BlockInit.BROKEN_BOOK.get()).build(null));
                            

    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
