package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.custom.init.EndlessDeepSpaceModAttributes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RandomRegenerationTickProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(LivingEntity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, LivingEntity entity) {
		if (entity == null)
			return;
		if (((LivingEntity) entity).getAttribute(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_PROBABILITY.get()) != null && ((LivingEntity) entity).getAttribute(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_HEALTH.get()) != null) {
			if (Math.random() < ((LivingEntity) entity).getAttribute(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_PROBABILITY.get())
					.getValue()) {
				entity.heal((float) ((LivingEntity) entity).getAttribute(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_HEALTH.get()).getValue());
			}
		}
	}
}
