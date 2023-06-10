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
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ColorfulComputingFogColorProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onComputingFogColor(ViewportEvent.ComputeFogColor event) {
		execute(event, event.getCamera().getEntity(), event);
	}

	public static void execute(Entity entity, ViewportEvent.ComputeFogColor fogcolor) {
		execute(null, entity, fogcolor);
	}

	private static void execute(@Nullable Event event, Entity entity, ViewportEvent.ComputeFogColor fogcolor) {
		if (entity == null || fogcolor == null)
			return;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.COLORFUL.get()) : false) {
			fogcolor.setRed((float) Mth.nextDouble(RandomSource.create(), 0, 255) / 255.0F);
			fogcolor.setGreen((float) Mth.nextDouble(RandomSource.create(), 0, 255) / 255.0F);
			fogcolor.setBlue((float) Mth.nextDouble(RandomSource.create(), 0, 255) / 255.0F);
		}
	}
}
