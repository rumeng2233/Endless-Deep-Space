package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModMobEffects;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ShortSightedComputeFovProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onComputeFov(ViewportEvent.ComputeFov event) {
		execute(event, event.getCamera().getEntity(), event);
	}

	public static void execute(Entity entity, ViewportEvent.ComputeFov fov) {
		execute(null, entity, fov);
	}

	private static void execute(@Nullable Event event, Entity entity, ViewportEvent.ComputeFov fov) {
		if (entity == null || fov == null)
			return;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.SHORT_SIGHTED.get()) : false) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.SHORT_SIGHTED.get())
					? _livEnt.getEffect(EndlessDeepSpaceModMobEffects.SHORT_SIGHTED.get()).getAmplifier()
					: 0) <= 0) {
				fov.setFOV(35);
			} else {
				fov.setFOV((float) (70 / 2
						- (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.SHORT_SIGHTED.get())
								? _livEnt.getEffect(EndlessDeepSpaceModMobEffects.SHORT_SIGHTED.get()).getAmplifier()
								: 0) * 2));
			}
		}
	}
}
