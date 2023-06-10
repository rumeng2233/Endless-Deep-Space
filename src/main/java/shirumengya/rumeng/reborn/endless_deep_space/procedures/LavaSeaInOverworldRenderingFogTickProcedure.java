package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModMobEffects;

import net.minecraftforge.client.event.ViewportEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import com.mojang.blaze3d.shaders.FogShape;

public class LavaSeaInOverworldRenderingFogTickProcedure {
	public static void execute(Entity entity, ViewportEvent.RenderFog fog) {
		if (entity == null || fog == null)
			return;
		if ((entity.level.dimension()) == (Level.OVERWORLD)) {
			if (entity.getY() <= -64) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(EndlessDeepSpaceModMobEffects.SHARP_EYES.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(EndlessDeepSpaceModMobEffects.VISUAL_IMPAIRMENT.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(EndlessDeepSpaceModMobEffects.COLORFUL.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(EndlessDeepSpaceModMobEffects.ENDER_CURSE.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(EndlessDeepSpaceModMobEffects.ENDER_EROSION_PROTECTION.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.BLINDNESS);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.DARKNESS);
				fog.setCanceled(true);
				fog.setNearPlaneDistance((float) 0.25);
				fog.setFarPlaneDistance(1);
				fog.setFogShape(FogShape.SPHERE);
			}
		}
	}
}
