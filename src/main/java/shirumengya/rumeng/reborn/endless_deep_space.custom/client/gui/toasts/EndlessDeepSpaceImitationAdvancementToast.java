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
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvents;

@OnlyIn(Dist.CLIENT)
public class EndlessDeepSpaceImitationAdvancementToast implements Toast {
private final ItemStack items;
private final Component descriptions;
private final boolean playSounds;
private boolean playedSound;

	public EndlessDeepSpaceImitationAdvancementToast(ItemStack item, @Nullable Component description, boolean playSound) {
		this.items = item;
		this.descriptions = description;
		this.playSounds = playSound;
	}

	public static void add(ToastComponent toastcomponent, ItemStack item, @Nullable Component description, boolean playSound) {
      	toastcomponent.addToast(new EndlessDeepSpaceImitationAdvancementToast(item, description, playSound));
   	}

	@Override
	public Toast.Visibility render(PoseStack p_94814_, ToastComponent p_94815_, long p_94816_) {
         RenderSystem.setShader(GameRenderer::getPositionTexShader);
         RenderSystem.setShaderTexture(0, TEXTURE);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
         p_94815_.blit(p_94814_, 0, 0, 0, 0, this.width(), this.height());
         int i = this.playSounds ? 16746751 : 16776960;
         Component j = this.playSounds ? Component.translatable("advancements.toast.challenge") : Component.translatable("advancements.toast.goal");
         p_94815_.getMinecraft().font.draw(p_94814_, j, 30.0F, 7.0F, i);
         p_94815_.getMinecraft().font.draw(p_94814_, this.descriptions, 30.0F, 18.0F, -1);
         PoseStack posestack = RenderSystem.getModelViewStack();
         posestack.pushPose();
         posestack.scale(0.6F, 0.6F, 1.0F);
         posestack.popPose();
         RenderSystem.applyModelViewMatrix();
         p_94815_.getMinecraft().getItemRenderer().renderAndDecorateFakeItem(this.items, 8, 8);
         if (!this.playedSound && p_94816_ > 0L) {
            this.playedSound = true;
            if (playSounds) {
               p_94815_.getMinecraft().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F));
            }
         }
         return p_94816_ >= 5000L ? Visibility.HIDE : Visibility.SHOW;
   	}
}
