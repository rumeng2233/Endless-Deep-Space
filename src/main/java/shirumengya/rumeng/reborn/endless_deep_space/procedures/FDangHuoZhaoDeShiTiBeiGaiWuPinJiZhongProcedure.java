package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class FDangHuoZhaoDeShiTiBeiGaiWuPinJiZhongProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.die(DamageSource.OUT_OF_WORLD);
	}
}
