package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.EntityDamageSource;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.*;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

public class TotemSwordDangShiTiBeiGongJuJiZhongShiProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		entity.hurt(new EntityDamageSource("player", sourceentity).bypassMagic().bypassEnchantments().bypassInvul().bypassArmor(), Float.MAX_VALUE);
		if (entity.level instanceof ServerLevel _level) {
			ColorfulLightningBolt entityToSpawn = new ColorfulLightningBolt(_level, entity.getX(), entity.getY(), entity.getZ(), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255));
			entityToSpawn.setVisualOnly(true);
			entityToSpawn.setDamage(Float.MAX_VALUE);
			_level.addFreshEntity(entityToSpawn);
		}
	}
}
