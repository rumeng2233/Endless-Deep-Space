
package shirumengya.rumeng.reborn.endless_deep_space.client.gui;

import shirumengya.rumeng.reborn.endless_deep_space.world.inventory.PlayerModelViewerMenu;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.gui.*;
import java.util.HashMap;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.EndlessDeepSpaceModClientConfig;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.world.entity.LivingEntity;

public class PlayerModelViewerScreen extends AbstractContainerScreen<PlayerModelViewerMenu> {
	private final static HashMap<String, Object> guistate = PlayerModelViewerMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private float xMouse;
   	private float yMouse;
   	private final LivingEntity living_entity;

	public PlayerModelViewerScreen(PlayerModelViewerMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 200;
		this.living_entity = new Allay(EntityType.ALLAY, this.world);
	}

	private static final ResourceLocation texture = new ResourceLocation("endless_deep_space:textures/screens/player_model_viewer.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		this.xMouse = (int)mouseX;
      	this.yMouse = (int)mouseY;
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		if (EndlessDeepSpaceModClientConfig.P_M_V_R_B.get() == true) {
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		}
		RenderSystem.disableBlend();
		int i = this.width / 2;
       	int j = this.height / 2;
       	if ((this.entity.getStringUUID()).equals("6a2917ad-6544-40ad-b0cf-784fe590296d") || (this.entity.getStringUUID()).equals("daff9ddf-0c9b-4a9d-9ab6-cc91bb11daa1")) {
      	if (this.entity instanceof Player) {
      		EntityRenderDispatcherInGUI.renderEntityInInventory(i + EndlessDeepSpaceModClientConfig.P_M_V_R_M_P_X.get() + 30, j + EndlessDeepSpaceModClientConfig.P_M_V_R_M_P_Y.get() - 50, 30, (float)(i + 51) - this.xMouse, (float)(j + 75 - 50) - this.yMouse, this.living_entity);
       	if (EndlessDeepSpaceModClientConfig.P_M_V_E_R_M_S.get() == true) {
		EntityRenderDispatcherInGUI.renderEntityInInventory(i + EndlessDeepSpaceModClientConfig.P_M_V_R_M_P_X.get(), j + EndlessDeepSpaceModClientConfig.P_M_V_R_M_P_Y.get(), i / EndlessDeepSpaceModClientConfig.P_M_V_R_M_S.get(), (float)(i + 51) - this.xMouse, (float)(j + 75 - 50) - this.yMouse, this.entity);
       	} else if (EndlessDeepSpaceModClientConfig.P_M_V_E_R_M_S.get() == false) {
		EntityRenderDispatcherInGUI.renderEntityInInventory(i + EndlessDeepSpaceModClientConfig.P_M_V_R_M_P_X.get(), j + EndlessDeepSpaceModClientConfig.P_M_V_R_M_P_Y.get(), EndlessDeepSpaceModClientConfig.P_M_V_M_S.get(), (float)(i + 51) - this.xMouse, (float)(j + 75 - 50) - this.yMouse, this.entity);
       	}
      }
   } else {
      	if (EndlessDeepSpaceModClientConfig.P_M_V_E_R_M_S.get() == true) {
		EntityRenderDispatcherInGUI.renderEntityInInventory(i + EndlessDeepSpaceModClientConfig.P_M_V_R_M_P_X.get(), j + EndlessDeepSpaceModClientConfig.P_M_V_R_M_P_Y.get(), i / EndlessDeepSpaceModClientConfig.P_M_V_R_M_S.get(), (float)(i + 51) - this.xMouse, (float)(j + 75 - 50) - this.yMouse, this.entity);
       	} else if (EndlessDeepSpaceModClientConfig.P_M_V_E_R_M_S.get() == false) {
		EntityRenderDispatcherInGUI.renderEntityInInventory(i + EndlessDeepSpaceModClientConfig.P_M_V_R_M_P_X.get(), j + EndlessDeepSpaceModClientConfig.P_M_V_R_M_P_Y.get(), EndlessDeepSpaceModClientConfig.P_M_V_M_S.get(), (float)(i + 51) - this.xMouse, (float)(j + 75 - 50) - this.yMouse, this.entity);
       	}
      }
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
	}
}
