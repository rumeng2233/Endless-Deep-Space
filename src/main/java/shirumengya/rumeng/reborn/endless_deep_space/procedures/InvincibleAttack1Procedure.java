package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModMobEffects;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class InvincibleAttack1Procedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).invincible == true
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.INVINCIBLE.get()) : false)) {
			entity.clearFire();
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) + 20));
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)));
		}
	}
}
