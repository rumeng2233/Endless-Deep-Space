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
public class ManMachineSeparationTickProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onComputeCameraAngles(ViewportEvent.ComputeCameraAngles event) {
		execute(event, event.getCamera().getEntity(), event);
	}

	public static void execute(Entity entity, ViewportEvent.ComputeCameraAngles camera) {
		execute(null, entity, camera);
	}

	private static void execute(@Nullable Event event, Entity entity, ViewportEvent.ComputeCameraAngles camera) {
		if (entity == null || camera == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.NAUSEA.get()) : false)
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.MAN_MACHINE_SEPARATION.get()) : false)) {
			camera.setYaw(0);
			camera.setPitch(0);
			camera.setRoll(-180);
		} else if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.MAN_MACHINE_SEPARATION.get()) : false) {
			camera.setYaw(0);
			camera.setPitch(0);
			camera.setRoll(0);
		}
	}
}
