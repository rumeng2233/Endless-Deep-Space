package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.entity.Entity;

public class MadWitchDangShiTiGengXinKeShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("endless_deep_space:block_value", (entity.getPersistentData().getDouble("endless_deep_space:block_value") + 1));
		if (entity.getPersistentData().getDouble("endless_deep_space:block_value") >= 100) {
			entity.getPersistentData().putDouble("endless_deep_space:block_value", 0);
		}
	}
}
