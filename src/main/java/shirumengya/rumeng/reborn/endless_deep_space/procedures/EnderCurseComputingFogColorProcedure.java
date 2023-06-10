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
public class EnderCurseComputingFogColorProcedure {
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
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.ENDER_CURSE.get()) : false) {
			fogcolor.setRed(255 / 255.0F);
			fogcolor.setGreen(28 / 255.0F);
			fogcolor.setBlue(43 / 255.0F);
		}
	}
}
