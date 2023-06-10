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
import net.minecraft.world.level.Level;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModMobEffects;
import net.minecraft.world.entity.LivingEntity;

public class EnderErosionValueOverlay {
    private static final ResourceLocation FILLED_EYE = new ResourceLocation(EndlessDeepSpaceMod.MODID,
            "textures/overlay/ender_erosion_value_filled.png");
    private static final ResourceLocation EMPTY_EYE = new ResourceLocation(EndlessDeepSpaceMod.MODID,
            "textures/overlay/ender_erosion_value_empty.png");
    private static final ResourceLocation PROTECTION_FILLED_EYE = new ResourceLocation(EndlessDeepSpaceMod.MODID,
            "textures/overlay/ender_erosion_value_protection_filled.png");
	private static final ResourceLocation CURSE_FILLED_EYE = new ResourceLocation(EndlessDeepSpaceMod.MODID,
            "textures/overlay/ender_erosion_value_curse_filled.png");
    private static final ResourceLocation CURSE_AND_PROTECTION_FILLED_EYE = new ResourceLocation(EndlessDeepSpaceMod.MODID,
            "textures/overlay/ender_erosion_value_curse_and_protection_filled.png");

    public static final IGuiOverlay ENDER_EROSION_VALUE = ((gui, poseStack, partialTick, width, height) -> {
        int x = width / 2;
        int y = height;

        Player entity = Minecraft.getInstance().player;

	if ((entity.level.dimension()) == (Level.END)) {
	if (Minecraft.getInstance().gameMode.canHurtPlayer()) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, EMPTY_EYE);
        for(int i = 0; i < 10; i++) {
            GuiComponent.blit(poseStack,x + 10 + (i * 8), y - 58,0,0,8,8,
                    8,8);
        }

		if (entity.hasEffect(EndlessDeepSpaceModMobEffects.ENDER_EROSION_PROTECTION.get()) && entity.hasEffect(EndlessDeepSpaceModMobEffects.ENDER_CURSE.get())) {
			RenderSystem.setShaderTexture(0, CURSE_AND_PROTECTION_FILLED_EYE);
        	for(int i = 0; i < 10; i++) {
            	if((int) ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).ender_erosion_value) > i) {
                	GuiComponent.blit(poseStack,x + 10 + (i * 8),y - 58,0,0,8,8,
                        	8,8);
            	} else {
                	break;
            	}
        	}
		} else if (entity.hasEffect(EndlessDeepSpaceModMobEffects.ENDER_EROSION_PROTECTION.get())) {
			RenderSystem.setShaderTexture(0, PROTECTION_FILLED_EYE);
        	for(int i = 0; i < 10; i++) {
            	if((int) ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).ender_erosion_value) > i) {
                	GuiComponent.blit(poseStack,x + 10 + (i * 8),y - 58,0,0,8,8,
                        	8,8);
            	} else {
                	break;
            	}
        	}
		} else if (entity.hasEffect(EndlessDeepSpaceModMobEffects.ENDER_CURSE.get())) {
			RenderSystem.setShaderTexture(0, CURSE_FILLED_EYE);
        	for(int i = 0; i < 10; i++) {
            	if((int) ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).ender_erosion_value) > i) {
                	GuiComponent.blit(poseStack,x + 10 + (i * 8),y - 58,0,0,8,8,
                        	8,8);
            	} else {
                	break;
            	}
        	}
		} else {
        	RenderSystem.setShaderTexture(0, FILLED_EYE);
        	for(int i = 0; i < 10; i++) {
            	if((int) ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).ender_erosion_value) > i) {
                	GuiComponent.blit(poseStack,x + 10 + (i * 8),y - 58,0,0,8,8,
                        	8,8);
            	} else {
                	break;
            	}
        	}
		}
    }
	}
    });
}
