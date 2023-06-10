package shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.overlay;

import com.mojang.blaze3d.systems.RenderSystem;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

public class SpecialBarOverlay {
    private static final ResourceLocation FILLED_HOT_BAR = new ResourceLocation(EndlessDeepSpaceMod.MODID,
            "textures/overlay/hot_bar_filled.png");
    private static final ResourceLocation EMPTY_HOT_BAR = new ResourceLocation(EndlessDeepSpaceMod.MODID,
            "textures/overlay/hot_bar_empty.png");

    public static final IGuiOverlay HOT_BAR = ((gui, poseStack, partialTick, width, height) -> {
        int x = width / 2 - 91;
        int y = height - 32 + 3;

        Player entity = Minecraft.getInstance().player;

	if (entity.level.getBiome(new BlockPos(entity.getX(), entity.getY(), entity.getZ())).value().getBaseTemperature() > 0.5) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, FILLED_HOT_BAR);
        GuiComponent.blit(poseStack, x, y, 0, 0, 182, 5, 182, 5);
	}
    });
}
