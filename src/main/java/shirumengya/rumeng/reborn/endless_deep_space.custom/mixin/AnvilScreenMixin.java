package shirumengya.rumeng.reborn.endless_deep_space.custom.mixin;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ServerboundRenameItemPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.gui.screens.inventory.AnvilScreen;
import net.minecraft.client.gui.screens.inventory.ItemCombinerScreen;

@Mixin(AnvilScreen.class)
public class AnvilScreenMixin extends ItemCombinerScreen<AnvilMenu> {

//@Final
@Shadow
Player player;
private static final ResourceLocation ANVIL_LOCATION = new ResourceLocation("textures/gui/container/anvil.png");

	public AnvilScreenMixin(AnvilMenu p_97874_, Inventory p_97875_, Component p_97876_) {
      super(p_97874_, p_97875_, p_97876_, ANVIL_LOCATION);
      this.player = p_97875_.player;
      this.titleLabelX = 60;
   	}

	@Overwrite
	protected void renderLabels(PoseStack p_97890_, int p_97891_, int p_97892_) {
      RenderSystem.disableBlend();
      super.renderLabels(p_97890_, p_97891_, p_97892_);
      int i = this.menu.getCost();
      if (i > 0) {
         int j = 8453920;
         Component component;
         if (!this.menu.getSlot(2).hasItem()) {
            component = null;
         } else {
            component = Component.translatable("container.repair.cost", i);
            if (!this.menu.getSlot(2).mayPickup(this.player)) {
               j = 16736352;
            }
         }

         if (component != null) {
            int k = this.imageWidth - 8 - this.font.width(component) - 2;
            int l = 69;
            fill(p_97890_, k - 2, 67, this.imageWidth - 8, 79, 1325400064);
            this.font.drawShadow(p_97890_, component, (float)k, 69.0F, j);
         }
      }

   }
}
