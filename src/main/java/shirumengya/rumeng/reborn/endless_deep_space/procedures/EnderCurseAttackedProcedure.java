package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModMobEffects;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.EndlessDeepSpaceModCommonConfig;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EnderCurseAttackedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof Player) {
				if ((entity.level.dimension()) == (Level.END)) {
					if (sourceentity.isAlive()) {
						if ((entity instanceof LivingEntity _livEnt
								? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.ENDER_CURSE.get())
								: false) == true) {
							if (entity instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(EndlessDeepSpaceModMobEffects.ENDER_CURSE.get(),
										(int) ((entity instanceof LivingEntity _livEnt
												&& _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.ENDER_CURSE.get())
														? _livEnt.getEffect(EndlessDeepSpaceModMobEffects.ENDER_CURSE.get()).getDuration()
														: 0)
												+ EndlessDeepSpaceModCommonConfig.GAIN_ENDER_CURSE_SECONDS_WHEN_ATTACKED_IN_THE_END.get()
														* 20),
										(int) ((entity instanceof LivingEntity _livEnt
												&& _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.ENDER_CURSE.get())
														? _livEnt.getEffect(EndlessDeepSpaceModMobEffects.ENDER_CURSE.get()).getAmplifier()
														: 0)
												+ 1),
										(true), (true)));
						} else if ((entity instanceof LivingEntity _livEnt
								? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.ENDER_CURSE.get())
								: false) == false) {
							if (Math.random() < EndlessDeepSpaceModCommonConfig.GAIN_ENDER_CURSE_WHEN_ATTACKED_IN_THE_END.get()) {
								if (entity instanceof LivingEntity _entity)
									_entity.addEffect(
											new MobEffectInstance(EndlessDeepSpaceModMobEffects.ENDER_CURSE.get(), 1200, 0, (true), (true)));
							}
						}
					}
				}
			}
		}
	}
}
