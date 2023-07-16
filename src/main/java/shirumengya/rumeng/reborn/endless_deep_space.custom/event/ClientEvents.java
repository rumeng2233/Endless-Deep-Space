package shirumengya.rumeng.reborn.endless_deep_space.custom.event;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.overlay.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.renderer.blockentity.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.renderer.blockentity.guiding_stone.*;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.EndlessDeepSpaceCustomBlockEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import shirumengya.rumeng.reborn.endless_deep_space.init.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.client.DimensionSpecialEffectsManager;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraft.client.renderer.DimensionSpecialEffects;
<<<<<<< Updated upstream
=======
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import shirumengya.rumeng.reborn.endless_deep_space.item.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.item.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.*;
import net.minecraft.world.item.BowItem;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.screens.*;
import net.minecraft.resources.ResourceLocation;
import com.google.common.util.concurrent.Runnables;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.Random;
import net.minecraft.Util;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.util.Mth;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.world.effect.MobEffects;
import com.mojang.blaze3d.vertex.PoseStack;
>>>>>>> Stashed changes

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = EndlessDeepSpaceMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
            event.registerBelowAll("torridity", TorridityValueOverlay.TORRIDITY_VALUE);
            event.registerBelowAll("ender_erosion", EnderErosionValueOverlay.ENDER_EROSION_VALUE);
//            event.registerAboveAll("hot_bar", SpecialBarOverlay.HOT_BAR);
        }

        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.STAR_CUBE_END_PORTAL.get(),
                    StarCubeEndPortalRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.STAR_CUBE_END_GATEWAY.get(),
                    StarCubeEndGatewayRenderer::new);
            event.registerBlockEntityRenderer(BlockEntityType.BARREL,
                    ChestCultRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.WHITE_GUIDING_STONE.get(),
                    WhiteGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.BLACK_GUIDING_STONE.get(),
                    BlackGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.BLUE_GUIDING_STONE.get(),
                    BlueGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.BROWN_GUIDING_STONE.get(),
                    BrownGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.CYAN_GUIDING_STONE.get(),
                    CyanGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.GRAY_GUIDING_STONE.get(),
                    GrayGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.GREEN_GUIDING_STONE.get(),
                    GreenGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.LIGHT_BLUE_GUIDING_STONE.get(),
                    LightBlueGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.LIGHT_GRAY_GUIDING_STONE.get(),
                    LightGrayGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.LIME_GUIDING_STONE.get(),
                    LimeGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.MAGENTA_GUIDING_STONE.get(),
                    MagentaGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.ORANGE_GUIDING_STONE.get(),
                    OrangeGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.PINK_GUIDING_STONE.get(),
                    PinkGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.PURPLE_GUIDING_STONE.get(),
                    PurpleGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.RED_GUIDING_STONE.get(),
                    RedGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.YELLOW_GUIDING_STONE.get(),
                    YellowGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.BROKEN_BEACON.get(),
                    BrokenBeaconRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.BLUE_GREEN_GUIDING_STONE.get(),
                    BlueGreenGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.SKY_BLUE_GUIDING_STONE.get(),
                    SkyBlueGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.AQUA_GUIDING_STONE.get(),
                    AquaGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.PURE_BLACK_GUIDING_STONE.get(),
                    PureBlackGuidingStoneRenderer::new);
            event.registerBlockEntityRenderer(BlockEntityType.ENCHANTING_TABLE,
                    EnchantTableRendererOverride::new);
            event.registerBlockEntityRenderer(EndlessDeepSpaceCustomBlockEntity.BROKEN_BOOK.get(),
                    BrokenBookRenderer::new);
        }
    }

	@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE, modid = EndlessDeepSpaceMod.MODID)
	public static class ForgeEvents {
	}
}