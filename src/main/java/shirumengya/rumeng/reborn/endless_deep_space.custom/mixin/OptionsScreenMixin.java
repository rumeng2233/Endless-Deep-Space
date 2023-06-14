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
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.screens.EndlessDeepSpaceCredits;
import com.google.common.util.concurrent.Runnables;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.Minecraft;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.toasts.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;
import java.util.Iterator;
import net.minecraft.world.entity.player.Player;

@Mixin(OptionsScreen.class)
public class OptionsScreenMixin extends Screen {
	public OptionsScreenMixin() {
		super(Component.translatable("options.title"));
	}
	@Inject(method = {"init"}, at = {@At("HEAD")}, cancellable = true)
	protected void init(CallbackInfo info) {
		this.addRenderableWidget(new Button(this.width / 2 - 155, this.height / 6 + 15, 310, 20, Component.translatable("options.endless_deep_space.credits"), (p_96274_) -> {
			if (net.minecraftforge.fml.ModList.get().isLoaded("blue_skies")) {
				ToastComponent toastcomponent = Minecraft.getInstance().getToasts();
				EndlessDeepSpaceCommonToast.add(toastcomponent, (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("blue_skies:defying_starlight")))), Component.literal("Music from Blue Skies"), Component.literal("Defying Starlight"), 40000L, -11534256, -12808848);
				this.minecraft.setScreen(new EndlessDeepSpaceCredits("credits_and_postcredits", "blue_skies:textures/block/dirt_grass/turquoise_dirt.png", ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("blue_skies:records.defying_starlight")), 0.75F, true, true, () -> {
					this.minecraft.setScreen(this);
		 		}));
			} else {
				this.minecraft.setScreen(new EndlessDeepSpaceCredits("credits_and_postcredits", "textures/gui/endless_deep_space_credits_background/poem.png", SoundEvents.MUSIC_DISC_OTHERSIDE, 0.75F, true, true, () -> {
					this.minecraft.setScreen(this);
		 		}));
			}
      }));
	}
}
