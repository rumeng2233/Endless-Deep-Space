package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.entity.Entity;
import shirumengya.rumeng.reborn.endless_deep_space.custom.world.damagesource.EndlessDeepSpaceDamageSource;

public class EnderErosionDamageProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.hurt(EndlessDeepSpaceDamageSource.ENDER_EROSION, Float.MAX_VALUE);
	}
}
