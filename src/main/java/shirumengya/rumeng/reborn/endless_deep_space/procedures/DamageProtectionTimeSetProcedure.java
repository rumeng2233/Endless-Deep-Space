package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.custom.init.EndlessDeepSpaceModAttributes;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DamageProtectionTimeSetProcedure {
	@SubscribeEvent
	public static void onEntityHurt(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (((LivingEntity) entity).getAttribute(EndlessDeepSpaceModAttributes.DAMAGE_PROTECTION_TIME.get()) != null) {
			entity.invulnerableTime = (int)((LivingEntity) entity).getAttribute(EndlessDeepSpaceModAttributes.DAMAGE_PROTECTION_TIME.get()).getValue();
		}
	}
}
