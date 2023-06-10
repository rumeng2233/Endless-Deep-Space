package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;
import net.minecraft.world.damagesource.DamageSource;
import javax.annotation.Nullable;
import shirumengya.rumeng.reborn.endless_deep_space.custom.world.damagesource.*;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.toasts.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.alchemy.PotionUtils;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModPotions;

@Mod.EventBusSubscriber
public class DieOfEnderErosionTickProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource());
		}
	}

	public static void execute(Entity entity, DamageSource source) {
		execute(null, entity, source);
	}

	private static void execute(@Nullable Event event, Entity entity, DamageSource source) {
		if (entity == null)
			return;
		if (source == EndlessDeepSpaceDamageSource.ENDER_EROSION) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("endless_deep_space:die_of_ender_erosion"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				ToastComponent toastcomponent = Minecraft.getInstance().getToasts();
				EndlessDeepSpaceCommonRecipeTipToast.add(toastcomponent, (new ItemStack(Items.BREWING_STAND)), PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER), Component.translatable("recipe.toast.title"), Component.translatable("recipe.toast.description"), 5000L, -11534256, -16777216);
    			EndlessDeepSpaceCommonRecipeTipToast.add(toastcomponent, (new ItemStack(Items.BREWING_STAND)), (new ItemStack(Items.POPPED_CHORUS_FRUIT)), Component.translatable("recipe.toast.title"), Component.translatable("recipe.toast.description"), 5000L, -11534256, -16777216);
    			EndlessDeepSpaceCommonRecipeTipToast.add(toastcomponent, (new ItemStack(Items.POPPED_CHORUS_FRUIT)), PotionUtils.setPotion(new ItemStack(Items.POTION), EndlessDeepSpaceModPotions.ENDER_EROSION_PROTECTION_POTIOM_SHORT.get()), Component.translatable("recipe.toast.title"), Component.translatable("recipe.toast.description"), 5000L, -11534256, -16777216);
    			EndlessDeepSpaceCommonRecipeTipToast.add(toastcomponent, (new ItemStack(Items.ENDER_EYE)), PotionUtils.setPotion(new ItemStack(Items.POTION), EndlessDeepSpaceModPotions.ENDER_EROSION_PROTECTION_POTIOM_MEDIUM.get()), Component.translatable("recipe.toast.title"), Component.translatable("recipe.toast.description"), 5000L, -11534256, -16777216);
    			EndlessDeepSpaceCommonRecipeTipToast.add(toastcomponent, (new ItemStack(Items.GHAST_TEAR)), PotionUtils.setPotion(new ItemStack(Items.POTION), EndlessDeepSpaceModPotions.ENDER_EROSION_PROTECTION_POTIOM_LONG.get()), Component.translatable("recipe.toast.title"), Component.translatable("recipe.toast.description"), 5000L, -11534256, -16777216);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemainingCriteria().iterator();
					while (_iterator.hasNext())
						_player.getAdvancements().award(_adv, (String) _iterator.next());
				}
			}
		}
	}
}
