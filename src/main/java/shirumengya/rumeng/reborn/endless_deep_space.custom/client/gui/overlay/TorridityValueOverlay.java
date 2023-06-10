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

public class TorridityValueOverlay {
    private static final ResourceLocation FILLED_TORRIDITY = new ResourceLocation(EndlessDeepSpaceMod.MODID,
            "textures/overlay/torridity_value_filled.png");
    private static final ResourceLocation EMPTY_TORRIDITY = new ResourceLocation(EndlessDeepSpaceMod.MODID,
            "textures/overlay/torridity_value_empty.png");

    public static final IGuiOverlay TORRIDITY_VALUE = ((gui, poseStack, partialTick, width, height) -> {
        int x = width / 2;
        int y = height;

        Player entity = Minecraft.getInstance().player;

	if ((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("endless_deep_space:geocentric")))) {
	if (Minecraft.getInstance().gameMode.canHurtPlayer()) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, EMPTY_TORRIDITY);
        for(int i = 0; i < 10; i++) {
            GuiComponent.blit(poseStack,x + 8 + (i * 8), y - 58,0,0,8,8,
                    8,8);
        }

        RenderSystem.setShaderTexture(0, FILLED_TORRIDITY);
        for(int i = 0; i < 10; i++) {
            if((int) ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).torridity_value) > i) {
                GuiComponent.blit(poseStack,x + 8 + (i * 8),y - 58,0,0,8,8,
                        8,8);
            } else {
                break;
            }
        }
    }
	}
    });
}
