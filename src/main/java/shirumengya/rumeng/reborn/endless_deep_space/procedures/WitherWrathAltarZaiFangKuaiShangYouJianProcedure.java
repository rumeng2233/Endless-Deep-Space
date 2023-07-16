package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModEntities;
import shirumengya.rumeng.reborn.endless_deep_space.entity.WitherestEntity;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.packet.*;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class WitherWrathAltarZaiFangKuaiShangYouJianProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.destroyBlock(new BlockPos(x, y, z), false);
		if (world instanceof ServerLevel _level) {
			WitherestEntity entityToSpawn = new WitherestEntity(EndlessDeepSpaceModEntities.WITHEREST.get(), _level);
			entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
			entityToSpawn.makeInvulnerable();
			world.addFreshEntity(entityToSpawn);
		}
	}
}
