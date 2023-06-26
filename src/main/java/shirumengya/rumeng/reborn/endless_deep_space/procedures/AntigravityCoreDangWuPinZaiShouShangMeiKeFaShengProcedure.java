package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModItems;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.entity.*;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class AntigravityCoreDangWuPinZaiShouShangMeiKeFaShengProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			TrackingUtil.forceEffect(entity, Entity.class, 20.0D, -8.0D, 8.0D);
		}
	}
}
