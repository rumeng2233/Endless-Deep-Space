package shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.toasts;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import com.google.common.collect.Queues;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Deque;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;

@OnlyIn(Dist.CLIENT)
public class EndlessDeepSpaceCommonHasBarToast implements Toast {
ResourceLocation TOAST_TEXTURE = new ResourceLocation("textures/gui/endless_deep_space_toasts/common_toast.png");
private final ItemStack items;
private final Component titles;
private final Component descriptions;
private final int titlecolors;
private final int descriptioncolors;
private long lastProgressTime;
private float lastProgress;
private static float progress;
public static final int PROGRESS_BAR_WIDTH = 154;
public static final int PROGRESS_BAR_HEIGHT = 1;
public static final int PROGRESS_BAR_X = 3;
public static final int PROGRESS_BAR_Y = 28;

	public EndlessDeepSpaceCommonHasBarToast(ItemStack item, @Nullable Component title, @Nullable Component description, int titlecolor, int descriptioncolor) {
		this.items = item;
		this.titles = title;
		this.descriptions = description;
		this.titlecolors = titlecolor;
		this.descriptioncolors = descriptioncolor;
	}

	public static void add(ToastComponent toastcomponent, ItemStack item, @Nullable Component title, @Nullable Component description, int titlecolor, int descriptioncolor) {
      	toastcomponent.addToast(new EndlessDeepSpaceCommonHasBarToast(item, title, description, titlecolor, descriptioncolor));
   	}

   	public static void updateProgress(float p_94963_) {
      	EndlessDeepSpaceCommonHasBarToast.progress = p_94963_;
   	}

	@Override
	public Toast.Visibility render(PoseStack p_94814_, ToastComponent p_94815_, long p_94967_) {
         RenderSystem.setShader(GameRenderer::getPositionTexShader);
         RenderSystem.setShaderTexture(0, TOAST_TEXTURE);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         p_94815_.blit(p_94814_, 0, 0, 0, 128, this.width(), this.height());
         p_94815_.getMinecraft().font.draw(p_94814_, this.titles, 30.0F, 7.0F, this.titlecolors);
         p_94815_.getMinecraft().font.draw(p_94814_, this.descriptions, 30.0F, 18.0F, this.descriptioncolors);
         PoseStack posestack = RenderSystem.getModelViewStack();
         posestack.pushPose();
         posestack.scale(0.6F, 0.6F, 1.0F);
         posestack.popPose();
         RenderSystem.applyModelViewMatrix();
         p_94815_.getMinecraft().getItemRenderer().renderAndDecorateFakeItem(this.items, 8, 8);
         GuiComponent.fill(p_94814_, 3, 28, 157, 29, -1);
         float f = Mth.clampedLerp(this.lastProgress, EndlessDeepSpaceCommonHasBarToast.progress, (float)(p_94967_ - this.lastProgressTime) / 100.0F);
         int i;
         if (EndlessDeepSpaceCommonHasBarToast.progress >= this.lastProgress) {
            i = -16711681;
         } else {
            i = -11206656;
         }

         GuiComponent.fill(p_94814_, 3, 28, (int)(3.0F + 154.0F * f), 29, i);
         this.lastProgress = f;
         this.lastProgressTime = p_94967_;
         return EndlessDeepSpaceCommonHasBarToast.progress >= 1.0F ? Visibility.HIDE : Visibility.SHOW;
   	}
}
