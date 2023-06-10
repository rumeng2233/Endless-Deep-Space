package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class StoneZiRanShiTiShengChengTiaoJianProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.STONE) {
			return true;
		}
		return false;
	}
}
