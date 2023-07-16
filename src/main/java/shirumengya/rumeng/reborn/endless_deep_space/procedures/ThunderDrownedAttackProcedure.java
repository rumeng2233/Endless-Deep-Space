package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.entity.ThunderDrownedEntity;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.*;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

@Mod.EventBusSubscriber
public class ThunderDrownedAttackProcedure {
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
		if (sourceentity instanceof ThunderDrownedEntity) {
			if (world instanceof ServerLevel _level) {
				ColorfulLightningBolt entityToSpawn = new ColorfulLightningBolt(_level, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255));
				entityToSpawn.setPos(entity.getX(), entity.getY(), entity.getZ());
				entityToSpawn.setVisualOnly(false);
				entityToSpawn.setDamage(6.0F);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
