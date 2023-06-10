package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import shirumengya.rumeng.reborn.endless_deep_space.custom.world.damagesource.EndlessDeepSpaceDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import javax.annotation.Nullable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.projectile.*;

@Mod.EventBusSubscriber
public class NoDamageImmunityProcedure {
	@SubscribeEvent
	public static void onEntityHurt(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity(), event.getSource());
		}
	}

	public static void execute(Entity entity, Entity sourceentity, DamageSource source) {
		execute(null, entity, sourceentity, source);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity, DamageSource source) {
		if (entity == null)
			return;
		if (source == EndlessDeepSpaceDamageSource.BROKEN_VALUE
			|| source == EndlessDeepSpaceDamageSource.ENDER_EROSION
			|| source == DamageSource.OUT_OF_WORLD
			|| sourceentity instanceof Slime
			|| sourceentity instanceof EnderDragon) {
				entity.invulnerableTime = 0;
		}
	}
}
