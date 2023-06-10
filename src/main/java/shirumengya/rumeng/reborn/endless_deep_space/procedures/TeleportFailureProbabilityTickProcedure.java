package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.custom.init.EndlessDeepSpaceModAttributes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityTeleportEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TeleportFailureProbabilityTickProcedure {
	@SubscribeEvent
	public static void onEntityHealed(EntityTeleportEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity) {
		if (((LivingEntity) entity).getAttribute(EndlessDeepSpaceModAttributes.TELEPORT_FAILURE_PROBABILITY.get()) != null) {
			if (Math.random() < ((LivingEntity) entity).getAttribute(EndlessDeepSpaceModAttributes.TELEPORT_FAILURE_PROBABILITY.get()).getValue()
					/ 10) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		}
	}
	}
}
