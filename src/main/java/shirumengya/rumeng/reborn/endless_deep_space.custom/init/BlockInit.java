
package shirumengya.rumeng.reborn.endless_deep_space.custom.init;

import shirumengya.rumeng.reborn.endless_deep_space.custom.block.NihilityBlock;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.PlaceholderAir;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.sign.EndlessDeepSpaceCustomStandingSignBlock;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.sign.EndlessDeepSpaceCustomWallSignBlock;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.wood_type.EndlessDeepSpaceCustomWoodTypes;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.conversion_table.ConversionTableBlock;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.guiding_stone.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.StarCubeEndPortalBlock;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.StarCubeEndGatewayBlock;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.*;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import net.minecraft.world.level.block.Block;
import java.util.concurrent.BrokenBarrierException;

public class BlockInit {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, "endless_deep_space.custom");
	public static final RegistryObject<Block> NIHILITY_BLOCK = REGISTRY.register("nihility_block", () -> new NihilityBlock());
	public static final RegistryObject<Block> PLACEHOLDER_AIR = REGISTRY.register("placeholder_air", () -> new PlaceholderAir());
    public static final RegistryObject<Block> PETRIFIED_OAK_WALL_SIGN = REGISTRY.register("petrified_oak_wall_sign",
            () -> new EndlessDeepSpaceCustomWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), EndlessDeepSpaceCustomWoodTypes.PETRIFIED_OAK));
    public static final RegistryObject<Block> PETRIFIED_OAK_SIGN = REGISTRY.register("petrified_oak_sign",
            () -> new EndlessDeepSpaceCustomStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), EndlessDeepSpaceCustomWoodTypes.PETRIFIED_OAK));
    public static final RegistryObject<Block> TRANSPARENT_WALL_SIGN = REGISTRY.register("transparent_wall_sign",
            () -> new EndlessDeepSpaceCustomWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), EndlessDeepSpaceCustomWoodTypes.TRANSPARENT));
    public static final RegistryObject<Block> TRANSPARENT_SIGN = REGISTRY.register("transparent_sign",
            () -> new EndlessDeepSpaceCustomStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), EndlessDeepSpaceCustomWoodTypes.TRANSPARENT));
	public static final RegistryObject<Block> CONVERSION_TABLE = REGISTRY.register("conversion_table", () -> new ConversionTableBlock());
	public static final RegistryObject<Block> STAR_CUBE_END_PORTAL = REGISTRY.register("star_cube_end_portal", () -> new StarCubeEndPortalBlock());
	public static final RegistryObject<Block> STAR_CUBE_END_GATEWAY = REGISTRY.register("star_cube_end_gateway", () -> new StarCubeEndGatewayBlock());
	public static final RegistryObject<Block> WHITE_GUIDING_STONE = REGISTRY.register("white_guiding_stone", () -> new WhiteGuidingStoneBlock());
	public static final RegistryObject<Block> YELLOW_GUIDING_STONE = REGISTRY.register("yellow_guiding_stone", () -> new YellowGuidingStoneBlock());
	public static final RegistryObject<Block> RED_GUIDING_STONE = REGISTRY.register("red_guiding_stone", () -> new RedGuidingStoneBlock());
	public static final RegistryObject<Block> PURPLE_GUIDING_STONE = REGISTRY.register("purple_guiding_stone", () -> new PurpleGuidingStoneBlock());
	public static final RegistryObject<Block> PINK_GUIDING_STONE = REGISTRY.register("pink_guiding_stone", () -> new PinkGuidingStoneBlock());
	public static final RegistryObject<Block> ORANGE_GUIDING_STONE = REGISTRY.register("orange_guiding_stone", () -> new OrangeGuidingStoneBlock());
	public static final RegistryObject<Block> MAGENTA_GUIDING_STONE = REGISTRY.register("magenta_guiding_stone", () -> new MagentaGuidingStoneBlock());
	public static final RegistryObject<Block> LIME_GUIDING_STONE = REGISTRY.register("lime_guiding_stone", () -> new LimeGuidingStoneBlock());
	public static final RegistryObject<Block> LIGHT_GRAY_GUIDING_STONE = REGISTRY.register("light_gray_guiding_stone", () -> new LightGrayGuidingStoneBlock());
	public static final RegistryObject<Block> LIGHT_BLUE_GUIDING_STONE = REGISTRY.register("light_blue_guiding_stone", () -> new LightBlueGuidingStoneBlock());
	public static final RegistryObject<Block> GREEN_GUIDING_STONE = REGISTRY.register("green_guiding_stone", () -> new GreenGuidingStoneBlock());
	public static final RegistryObject<Block> GRAY_GUIDING_STONE = REGISTRY.register("gray_guiding_stone", () -> new GrayGuidingStoneBlock());
	public static final RegistryObject<Block> CYAN_GUIDING_STONE = REGISTRY.register("cyan_guiding_stone", () -> new CyanGuidingStoneBlock());
	public static final RegistryObject<Block> BROWN_GUIDING_STONE = REGISTRY.register("brown_guiding_stone", () -> new BrownGuidingStoneBlock());
	public static final RegistryObject<Block> BLUE_GUIDING_STONE = REGISTRY.register("blue_guiding_stone", () -> new BlueGuidingStoneBlock());
	public static final RegistryObject<Block> BLACK_GUIDING_STONE = REGISTRY.register("black_guiding_stone", () -> new BlackGuidingStoneBlock());
	public static final RegistryObject<Block> BROKEN_BEACON = REGISTRY.register("broken_beacon", () -> new BrokenBeaconBlock());
	public static final RegistryObject<Block> BLUE_GREEN_GUIDING_STONE = REGISTRY.register("blue_green_guiding_stone", () -> new BlueGreenGuidingStoneBlock());
	public static final RegistryObject<Block> SKY_BLUE_GUIDING_STONE = REGISTRY.register("sky_blue_guiding_stone", () -> new SkyBlueGuidingStoneBlock());
	public static final RegistryObject<Block> AQUA_GUIDING_STONE = REGISTRY.register("aqua_guiding_stone", () -> new AquaGuidingStoneBlock());
	public static final RegistryObject<Block> PURE_BLACK_GUIDING_STONE = REGISTRY.register("pure_black_guiding_stone", () -> new PureBlackGuidingStoneBlock());
	public static final RegistryObject<Block> BROKEN_BOOK = REGISTRY.register("broken_book", () -> new BrokenBookBlock());
}
