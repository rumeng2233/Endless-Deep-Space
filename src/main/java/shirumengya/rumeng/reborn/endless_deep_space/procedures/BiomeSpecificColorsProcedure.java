package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModMobEffects;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BiomeSpecificColorsProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onComputingFogColor(ViewportEvent.ComputeFogColor event) {
		execute(event, event.getCamera().getEntity().level, event.getCamera().getEntity().getX(), event.getCamera().getEntity().getY(), event.getCamera().getEntity().getZ(), event.getCamera().getEntity(), event);
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ViewportEvent.ComputeFogColor fogcolor) {
		execute(null, world, x, y, z, entity, fogcolor);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, ViewportEvent.ComputeFogColor fogcolor) {
		if (entity == null || fogcolor == null)
			return;
		if (true) {
			if (!entity.isInLava() && !(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.BLINDNESS) : false) && !(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.DARKNESS) : false)
					&& !(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.COLORFUL.get()) : false)
					&& !(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.ENDER_CURSE.get()) : false) && true) {
				if (world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("deep_dark"))) {
					fogcolor.setRed(0 / 255.0F);
					fogcolor.setGreen(0 / 255.0F);
					fogcolor.setBlue(0 / 255.0F);
				} else if (world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("lush_caves"))) {
					fogcolor.setRed(142 / 255.0F);
					fogcolor.setGreen(255 / 255.0F);
					fogcolor.setBlue(118 / 255.0F);
				} else if (world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("grove"))) {
					fogcolor.setRed(128 / 255.0F);
					fogcolor.setGreen(180 / 255.0F);
					fogcolor.setBlue(151 / 255.0F);
				} else if (world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("snowy_slopes"))) {
					fogcolor.setRed(128 / 255.0F);
					fogcolor.setGreen(180 / 255.0F);
					fogcolor.setBlue(151 / 255.0F);
				} else if (world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("jagged_peaks"))) {
					fogcolor.setRed(184 / 255.0F);
					fogcolor.setGreen(204 / 255.0F);
					fogcolor.setBlue(223 / 255.0F);
				} else if (world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("frozen_peaks"))) {
					fogcolor.setRed(184 / 255.0F);
					fogcolor.setGreen(230 / 255.0F);
					fogcolor.setBlue(255 / 255.0F);
				}
			}
		}
	}
}
