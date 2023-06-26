package shirumengya.rumeng.reborn.endless_deep_space.custom.mixin;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.logging.LogUtils;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.GameNarrator;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.RandomSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.slf4j.Logger;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.screens.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screens.Screen;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.screens.EndlessDeepSpaceCredits;
import net.minecraft.sounds.SoundEvents;

@Mixin(WinScreen.class)
public class WinScreenMixin {

//@Final
@Shadow
boolean poem;
Runnable onFinished;

	@Inject(method = {"tick"}, at = {@At("HEAD")}, cancellable = true)
	public void tick(CallbackInfo info) {
		if (this.poem == true) {
			Minecraft.getInstance().setScreen(new EndlessDeepSpaceCredits("vanilla_poem_and_endless_deep_space_credits_and_credits", "textures/gui/options_background.png", SoundEvents.MUSIC_CREDITS, 0.5F, true, true, this.onFinished));
		} else {
			Minecraft.getInstance().setScreen(new EndlessDeepSpaceCredits("vanilla_credits", "textures/gui/options_background.png", SoundEvents.MUSIC_CREDITS, 0.75F, true, true, this.onFinished));
		}
	}
}
