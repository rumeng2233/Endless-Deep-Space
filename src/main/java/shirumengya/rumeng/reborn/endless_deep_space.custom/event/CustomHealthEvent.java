package shirumengya.rumeng.reborn.endless_deep_space.custom.event;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Random;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.common.Mod;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.GameRenderer;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.*;
import shirumengya.rumeng.reborn.endless_deep_space.init.*;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber
public class CustomHealthEvent {
	private final Random random = new Random();
	private int lastHealth;
   	private int displayHealth;
   	private long lastHealthTime;
   	private long healthBlinkTime;

   	public CustomHealthEvent() {
   	}

   	public static CustomHealthEvent getInstance() {
   		return new CustomHealthEvent();
   	}

	@OnlyIn(Dist.CLIENT)
   	@SubscribeEvent
	public static void onRenderHeart(RenderGuiOverlayEvent.Pre event) {
		Player player = Minecraft.getInstance().player;
		Minecraft mc = Minecraft.getInstance();
		ForgeGui gui = (ForgeGui)mc.gui;
		if (player != null) {
			if (event.getOverlay() == VanillaGuiOverlay.PLAYER_HEALTH.type() && !mc.options.hideGui && gui.shouldDrawSurvivalElements()) {
				if (player.hasEffect(EndlessDeepSpaceModMobEffects.TOTEM_OF_UNDYING.get())) {
					CustomHealthEvent.getInstance().renderHearts(event, CustomHealthEvent.HeartsType.TOTEM_OF_UNDYING_EFFECT_HEART);
				} else if (player.hasEffect(ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation("witherstormmod:wither_sickness")))) {
					CustomHealthEvent.getInstance().renderHearts(event, CustomHealthEvent.HeartsType.WITHERSTORMMOD__WITHER_SICKNESS);
				} else if (player.hasEffect(ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation("cataclysm:abyssal_burn"))) || player.hasEffect(ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation("cataclysm:abyssal_curse")))) {
					CustomHealthEvent.getInstance().renderHearts(event, CustomHealthEvent.HeartsType.CATACLYSM__EFFECT_HEART);
				} else if (player.hasEffect(MobEffects.POISON)) {
					CustomHealthEvent.getInstance().renderHearts(event, CustomHealthEvent.HeartsType.POISIONED);
				} else if (player.hasEffect(MobEffects.WITHER)) {
					CustomHealthEvent.getInstance().renderHearts(event, CustomHealthEvent.HeartsType.WITHERED);
				} else if (player.isFullyFrozen()) {
					CustomHealthEvent.getInstance().renderHearts(event, CustomHealthEvent.HeartsType.FROZEN);
				} else if (player.hasEffect(MobEffects.FIRE_RESISTANCE)) {
					CustomHealthEvent.getInstance().renderHearts(event, CustomHealthEvent.HeartsType.FIRE_RESISTANCE_EFFECT_HEART);
				}
			}
		}
	}

	public static enum HeartsType {

		TOTEM_OF_UNDYING_EFFECT_HEART(new ResourceLocation("endless_deep_space:textures/gui/hearts/totem_of_undying_effect_heart.png")),
		NORMAL(new ResourceLocation("endless_deep_space:textures/gui/hearts/normal_heart.png")),
		POISIONED(new ResourceLocation("endless_deep_space:textures/gui/hearts/poisioned_heart.png")),
		WITHERED(new ResourceLocation("endless_deep_space:textures/gui/hearts/withered_heart.png")),
		FROZEN(new ResourceLocation("endless_deep_space:textures/gui/hearts/frozen_heart.png")),
		FIRE_RESISTANCE_EFFECT_HEART(new ResourceLocation("endless_deep_space:textures/gui/hearts/fire_resistance_effect_heart.png")),
		WITHERSTORMMOD__WITHER_SICKNESS(new ResourceLocation("witherstormmod:textures/gui/wither_sickness.png")),
		CATACLYSM__EFFECT_HEART(new ResourceLocation("cataclysm:textures/gui/effect_heart.png"));

		public final ResourceLocation HEART_LOCATION;

		private HeartsType(ResourceLocation location) {
			this.HEART_LOCATION = location;
		}

		public ResourceLocation getLocation() {
			return this.HEART_LOCATION;
		}
	}

	private void renderHearts(RenderGuiOverlayEvent.Pre event, CustomHealthEvent.HeartsType heartsType) {
		Player player = Minecraft.getInstance().player;
		Minecraft mc = Minecraft.getInstance();
		ForgeGui gui = (ForgeGui)mc.gui;
		PoseStack stack = event.getPoseStack();
		int screenWidth = mc.getWindow().getGuiScaledWidth();
      	int screenHeight = mc.getWindow().getGuiScaledHeight();
     	gui.setupOverlayRenderState(true, false);
     	event.setCanceled(true);
     	/*RenderSystem.setShader(GameRenderer::getPositionTexShader);
      	RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);*/
     	RenderSystem.setShaderTexture(0, heartsType.getLocation());
     	RenderSystem.enableBlend();
     	int health = Mth.ceil(player.getHealth());
     	int tickCount = gui.getGuiTicks();
     	if (health < this.lastHealth && player.invulnerableTime > 0) {
            this.lastHealthTime = Util.getMillis();
            this.healthBlinkTime = (long) (tickCount + 20);
        } else if (health > this.lastHealth && player.invulnerableTime > 0) {
            this.lastHealthTime = Util.getMillis();
            this.healthBlinkTime = (long) (tickCount + 10);
        }
        if (Util.getMillis() - this.lastHealthTime > 1000L) {
            this.lastHealth = health;
            this.displayHealth = health;
            this.lastHealthTime = Util.getMillis();
        }
        boolean highlight = this.healthBlinkTime > (long)tickCount && (this.healthBlinkTime - (long)tickCount) / 3L % 2L == 1L;
        this.lastHealth = health;
        int healthLast = this.displayHealth;
        AttributeInstance attrMaxHealth = player.getAttribute(Attributes.MAX_HEALTH);
        float healthMax = Math.max((float) attrMaxHealth.getValue(), Math.max(healthLast, health));
        int absorb = Mth.ceil(player.getAbsorptionAmount());
        int healthRows = Mth.ceil((healthMax + absorb) / 2.0F / 10.0F);
        int rowHeight = Math.max(10 - (healthRows - 2), 3);
        this.random.setSeed((long) (tickCount * 312871));
        int left = screenWidth / 2 - 91;
        int top = screenHeight - gui.leftHeight;
        gui.leftHeight += healthRows * rowHeight;
        if (rowHeight != 10) {
            gui.leftHeight += 10 - rowHeight;
        }
        int regen = -1;
        if (player.hasEffect(MobEffects.REGENERATION) || player.hasEffect(EndlessDeepSpaceModMobEffects.TOTEM_OF_UNDYING.get())) {
            regen = tickCount % Mth.ceil(healthMax + 5.0F);
        }
        int TOP = player.level.getLevelData().isHardcore() ? 9 : 0;
        int BACKGROUND = highlight ? 25 : 16;
        int margin = 34;
        float absorbRemaining = (float)absorb;
        for(int i = Mth.ceil((healthMax + (float)absorb) / 2.0F) - 1; i >= 0; --i) {
            int row = Mth.ceil((float)(i + 1) / 10.0F) - 1;
            int x = left + i % 10 * 8;
            int y = top - row * rowHeight;
            if (health <= 4) {
                y += this.random.nextInt(2);
            }

            if (i == regen) {
                y -= 2;
            }

            gui.blit(stack, x, y, BACKGROUND, TOP, 9, 9);
            if (highlight) {
                if (i * 2 + 1 < healthLast) {
                    gui.blit(stack, x, y, margin, TOP, 9, 9);
                } else if (i * 2 + 1 == healthLast) {
                    gui.blit(stack, x, y, margin + 9, TOP, 9, 9);
                }
            }

            if (absorbRemaining > 0.0F) {
                if (absorbRemaining == (float)absorb && (float)absorb % 2.0F == 1.0F) {
                    gui.blit(stack, x, y, margin + 9, TOP, 9, 9);
                    --absorbRemaining;
                } else {
                    gui.blit(stack, x, y, margin, TOP, 9, 9);
                    absorbRemaining -= 2.0F;
                }
            } else if (i * 2 + 1 < health) {
                gui.blit(stack, x, y, margin, TOP, 9, 9);
            } else if (i * 2 + 1 == health) {
                gui.blit(stack, x, y, margin + 9, TOP, 9, 9);
            }
        }
        RenderSystem.disableBlend();
        RenderSystem.setShaderTexture(0, GuiComponent.GUI_ICONS_LOCATION);
	}
}
