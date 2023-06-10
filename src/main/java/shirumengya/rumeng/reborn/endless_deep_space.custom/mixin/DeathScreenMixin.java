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

@Mixin(DeathScreen.class)
public class DeathScreenMixin {
	@Inject(method = {"isPauseScreen"}, at = {@At("HEAD")}, cancellable = true)
	public boolean isPauseScreen(CallbackInfoReturnable<Boolean> info) {
		info.setReturnValue(true);
   		return true;
	}
}
