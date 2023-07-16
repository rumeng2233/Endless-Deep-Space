package shirumengya.rumeng.reborn.endless_deep_space.custom.event;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.event.CustomizeGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import java.util.Iterator;
import java.util.Objects;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import net.minecraft.world.BossEvent;
import net.minecraft.client.gui.GuiComponent;
import shirumengya.rumeng.reborn.endless_deep_space.entity.*;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;

@Mod.EventBusSubscriber
public class CustomBossBarEvent {
	private static Minecraft minecraft;
  	public static final Set<Entity> BOSSES = Collections.newSetFromMap(new WeakHashMap<>());
  	private static final ResourceLocation GUI_BARS_LOCATION = new ResourceLocation("textures/gui/bars.png");
  	private static final ResourceLocation BOSSBAR_LOCATION = new ResourceLocation("endless_deep_space:textures/gui/endless_deep_space_common_bossbar.png");
  	private static int lastProgress = 182;

  	@SubscribeEvent
    public static void renderBossBar(CustomizeGuiOverlayEvent.BossEventProgress event) {
    	minecraft = Minecraft.getInstance();
    	if (!BOSSES.isEmpty()) {
        	int i = minecraft.getWindow().getGuiScaledWidth();
        	Iterator var3 = BOSSES.iterator();
        	while(var3.hasNext()) {
        		Entity boss = (Entity)var3.next();
        		if (boss != null) {
        			if (event.getBossEvent().getId().equals(boss.getUUID())) {
        				event.setCanceled(true);
       					int k = i / 2 - 91;
         				RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        				drawBar(event.getPoseStack(), k, event.getY(), event.getPartialTick(), boss, event.getBossEvent());
       					Component component = event.getBossEvent().getName();
                      	int l = minecraft.font.width(component);
                    	int i1 = i / 2 - l / 2;
                    	minecraft.font.drawShadow(event.getPoseStack(), component, (float) i1, (float) event.getY() - 10, 16777215);
                    	Component Description = Component.translatable(ForgeRegistries.ENTITY_TYPES.getKey(boss.getType()).toString() + ".description");
                    	int l1 = minecraft.font.width(Description);
                    	int i2 = i / 2 - l1 / 2;
                    	minecraft.font.drawShadow(event.getPoseStack(), Description, (float) i2, (float) event.getY() + 5, 11184810);
                   		if (event.getY() >= minecraft.getWindow().getGuiScaledHeight() / 3) {
                    		break;
                   		}
                   		Objects.requireNonNull(minecraft.font);
             			event.setIncrement(12 + 9);
                 	}
             	}
        	}
		}
    }

    private static void drawBar(PoseStack pPoseStack, int pX, int pY, float partialTicks, Entity pEntity, BossEvent event) {
    	float percent = event.getProgress();
    	int i = (int)(percent * 182.0F);
    	if (pEntity instanceof TheVoidCubeEntity) {
    		TheVoidCubeEntity voidCube = (TheVoidCubeEntity)pEntity;
    		int j = (int)(percent * 174.0F);
    		int f = (voidCube.getIntegerData(voidCube.BossProgress) >= 3) ? (int)(percent * 182.0F) : 182;
    		if (voidCube.getIntegerData(voidCube.BossProgress) == 2) {
    			RenderSystem.setShaderTexture(0, GUI_BARS_LOCATION);
    			GuiComponent.blit(pPoseStack, pX, pY, 0, event.getColor().ordinal() * 5 * 2 + 0, 182, 5, 256, 256);
    			if (i > 0) {
    				GuiComponent.blit(pPoseStack, pX, pY, 0, event.getColor().ordinal() * 5 * 2 + 5, i, 5, 256, 256);
    			}
    		} else {
    			RenderSystem.setShaderTexture(0, BOSSBAR_LOCATION);
    			GuiComponent.blit(pPoseStack, pX, pY - ((voidCube.getIntegerData(voidCube.BossProgress) < 3) ? 2 : 0), 0, 0, 182, 5, 256, 256);
    			if (f > 0) {
    				GuiComponent.blit(pPoseStack, pX, pY - ((voidCube.getIntegerData(voidCube.BossProgress) < 3) ? 2 : 0), 0, 5, voidCube.getIntegerData(voidCube.BossProgress) == -1 ? 0 : f, 5, 256, 256);
    			}
    			if (voidCube.getIntegerData(voidCube.BossProgress) < 3) {
    				GuiComponent.blit(pPoseStack, pX + 4, pY + 3, 0, 10, 174, 3, 256, 256);
    				if (j > 0) {
    					GuiComponent.blit(pPoseStack, pX + 4, pY + 3, 0, 13, voidCube.getIntegerData(voidCube.BossProgress) == -1 ? 0 : j, 3, 256, 256);
    				}
    			}
    		}
    	} else if (pEntity instanceof ThunderDrownedEntity) {
    		ThunderDrownedEntity drowned = (ThunderDrownedEntity)pEntity;
    		int j = (int)((drowned.getShield() / drowned.getMaxShield()) * 154.0F);
    		int f = (int)(percent * 162.0F);
    		RenderSystem.setShaderTexture(0, BOSSBAR_LOCATION);
    		GuiComponent.blit(pPoseStack, pX + 10, pY - (drowned.hasShield() ? 2 : 0), 0, 37, 162, 5, 256, 256);
    		if (f > 0) {
    			GuiComponent.blit(pPoseStack, pX + 10, pY - (drowned.hasShield() ? 2 : 0), 0, 42, f, 5, 256, 256);
    		}
    		if (drowned.hasShield()) {
    			GuiComponent.blit(pPoseStack, pX + 14, pY + 3, 0, 47, 154, 3, 256, 256);
    			if (j > 0) {
    				GuiComponent.blit(pPoseStack, pX + 14, pY + 3, 0, 56, j, 3, 256, 256);
    			}
    		}
    	} else {
    		RenderSystem.setShaderTexture(0, BOSSBAR_LOCATION);
    		GuiComponent.blit(pPoseStack, pX, pY, 0, 0, 182, 5, 256, 256);
    		if (i > 0) {
    			GuiComponent.blit(pPoseStack, pX, pY, 0, 5, i, 5, 256, 256);
    		}
    	}
    }

    public static void addBoss(Entity entity){
        BOSSES.add(entity);
    }

    public static void removeBoss(Entity entity){
        BOSSES.remove(entity);
    }

    public static Set<Entity> getBosses(){
        return BOSSES;
    }
}
