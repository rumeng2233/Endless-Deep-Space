package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;

public class TotemSwordDangYouJianDianJiFangKuaiShiFangKuaiDeWeiZhiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 16);
		if (world instanceof ServerLevel _level) {
			ColorfulLightningBolt entityToSpawn = new ColorfulLightningBolt(_level, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255));
			entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
			entityToSpawn.setVisualOnly(true);
			entityToSpawn.setDamage(Float.MAX_VALUE);
			_level.addFreshEntity(entityToSpawn);
		}
	}
}
