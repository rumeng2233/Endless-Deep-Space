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

import com.mojang.blaze3d.shaders.FogShape;

@Mod.EventBusSubscriber
public class ColorfulRenderingFogTickProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onRenderingFog(ViewportEvent.RenderFog event) {
		execute(event, event.getCamera().getEntity(), event);
	}

	public static void execute(Entity entity, ViewportEvent.RenderFog fog) {
		execute(null, entity, fog);
	}

	private static void execute(@Nullable Event event, Entity entity, ViewportEvent.RenderFog fog) {
		if (entity == null || fog == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.SHARP_EYES.get()) : false) == false) {
			if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.COLORFUL.get()) : false) {
				fog.setCanceled(true);
				fog.setNearPlaneDistance(0);
				fog.setFarPlaneDistance(8);
				fog.setFogShape(FogShape.SPHERE);
			}
		}
	}
}
