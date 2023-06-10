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

@Mixin(OptionsScreen.class)
public class OptionsScreenMixin extends Screen {
	public OptionsScreenMixin() {
		super(Component.translatable("options.title"));
	}
	@Inject(method = {"init"}, at = {@At("HEAD")}, cancellable = true)
	protected void init(CallbackInfo info) {
		this.addRenderableWidget(new Button(this.width / 2 - 155, this.height / 2 - 67, 310, 20, Component.translatable("options.endless_deep_space.credits"), (p_96274_) -> {
         this.minecraft.setScreen(new EndlessDeepSpaceCredits("credits_and_postcredits", "poem", 0.75F, true, true, Runnables.doNothing()));
      }));
	}
}
