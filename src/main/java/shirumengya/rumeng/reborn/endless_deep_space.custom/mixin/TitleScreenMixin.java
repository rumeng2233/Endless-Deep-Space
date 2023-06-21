package shirumengya.rumeng.reborn.endless_deep_space.custom.mixin;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.components.*;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.screens.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.OutOfMemoryScreen;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.screens.*;
import com.google.common.util.concurrent.Runnables;
import java.util.Calendar;
import net.minecraft.Util;
import com.google.common.util.concurrent.Runnables;
import com.mojang.authlib.minecraft.BanDetails;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.LogUtils;
import com.mojang.math.Vector3f;
import com.mojang.realmsclient.RealmsMainScreen;
import com.mojang.realmsclient.gui.screens.RealmsNotificationsScreen;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.MultiLineLabel;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.gui.screens.multiplayer.SafetyScreen;
import net.minecraft.client.gui.screens.worldselection.SelectWorldScreen;
import net.minecraft.client.renderer.CubeMap;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.PanoramaRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.presets.WorldPresets;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.storage.LevelSummary;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.slf4j.Logger;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.sounds.SoundEvents;
import shirumengya.rumeng.reborn.endless_deep_space.init.*;
import net.minecraft.sounds.SoundEvent;
@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
	private static final Component EDS_COPYRIGHT_TEXT = Component.literal("Copyright 是如梦呀rumeng2233");
	private static final Component MENU_MUSIC_FROM_TEXT = Component.literal("Music from Genshin Impact");
	
	public TitleScreenMixin() {
		super(Component.translatable("narrator.screen.title"));
	}
	
	@Inject(method = {"init"}, at = {@At("HEAD")}, cancellable = true)
	protected void init(CallbackInfo info) {
		int i = this.font.width(EDS_COPYRIGHT_TEXT);
      	int j = this.width - i - 2;
      	int k = this.font.width(MENU_MUSIC_FROM_TEXT);
      	int l = this.width - k - 2;
		this.addRenderableWidget(new PlainTextButton(j, this.height - 30, i, 10, EDS_COPYRIGHT_TEXT, (p_211790_) -> {
			if (Calendar.getInstance().get(Calendar.MONTH) == 8 && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 28) {
				this.minecraft.setScreen(new EndlessDeepSpaceCredits("credits_and_postcredits", "textures/gui/endless_deep_space_credits_background/poem.png", EndlessDeepSpaceModSounds.GENSHIN_IMPACT_MAIN_THEME.get(), 0.75F, true, true, () -> {
					this.minecraft.setScreen(this);
				}));
			} else {
        		this.minecraft.setScreen(new EndlessDeepSpaceCredits("credits_and_postcredits", "textures/gui/endless_deep_space_credits_background/poem.png", SoundEvents.MUSIC_CREDITS, 0.75F, true, true, () -> {
					this.minecraft.setScreen(this);
				}));
			}
//        	this.minecraft.setScreen(new OutOfMemoryScreen());
      	 	}, this.font));
      	if (Calendar.getInstance().get(Calendar.MONTH) == 8 && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 28) {
      	this.addRenderableWidget(new PlainTextButton(l, this.height - 40, k, 10, MENU_MUSIC_FROM_TEXT, (p_211790_) -> {
        	 Util.getPlatform().openUri("https://ys.mihoyo.com/main/");
      	 	}, this.font));
      	}
	}

	@Inject(method = {"shouldCloseOnEsc"}, at = {@At("HEAD")}, cancellable = true)
	public boolean shouldCloseOnEsc(CallbackInfoReturnable<Boolean> info) {
		info.setReturnValue(true);
   		return true;
	}

	@Inject(method = {"isPauseScreen"}, at = {@At("HEAD")}, cancellable = true)
	public boolean isPauseScreen(CallbackInfoReturnable<Boolean> info) {
		info.setReturnValue(true);
   		return true;
	}
}
