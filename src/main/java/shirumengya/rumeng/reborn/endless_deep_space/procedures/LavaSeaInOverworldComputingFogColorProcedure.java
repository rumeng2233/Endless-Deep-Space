package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModMobEffects;

import net.minecraftforge.client.event.ViewportEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

public class LavaSeaInOverworldComputingFogColorProcedure {
	public static void execute(Entity entity, ViewportEvent.ComputeFogColor fogcolor) {
		if (entity == null || fogcolor == null)
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
				fogcolor.setRed(153 / 255.0F);
				fogcolor.setGreen(25 / 255.0F);
				fogcolor.setBlue(0 / 255.0F);
			}
		}
	}
}
