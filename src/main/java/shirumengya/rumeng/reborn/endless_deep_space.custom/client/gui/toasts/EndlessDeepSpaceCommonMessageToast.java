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
import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;

@OnlyIn(Dist.CLIENT)
public class EndlessDeepSpaceCommonMessageToast implements Toast {
ResourceLocation TOAST_TEXTURE = new ResourceLocation("textures/gui/endless_deep_space_toasts/common_toast.png");
private final Component titles;
private final Component descriptions;
private final long timeleft;
private final int titlecolors;
private final int descriptioncolors;

	public EndlessDeepSpaceCommonMessageToast(@Nullable Component title, @Nullable Component description, long time, int titlecolor, int descriptioncolor) {
		this.titles = title;
		this.descriptions = description;
		this.timeleft = time;
		this.titlecolors = titlecolor;
		this.descriptioncolors = descriptioncolor;
	}

	public static void add(ToastComponent toastcomponent, @Nullable Component title, @Nullable Component description, long time, int titlecolor, int descriptioncolor) {
      	toastcomponent.addToast(new EndlessDeepSpaceCommonMessageToast(title, description, time, titlecolor, descriptioncolor));
   	}

	@Override
	public Toast.Visibility render(PoseStack p_94814_, ToastComponent p_94815_, long p_94816_) {
         RenderSystem.setShader(GameRenderer::getPositionTexShader);
         RenderSystem.setShaderTexture(0, TOAST_TEXTURE);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         p_94815_.blit(p_94814_, 0, 0, 0, 128, this.width(), this.height());
         p_94815_.getMinecraft().font.draw(p_94814_, this.titles, 5.0F, 7.0F, this.titlecolors);
         p_94815_.getMinecraft().font.draw(p_94814_, this.descriptions, 5.0F, 18.0F, this.descriptioncolors);
         return p_94816_ >= this.timeleft ? Visibility.HIDE : Visibility.SHOW;
   	}
}
