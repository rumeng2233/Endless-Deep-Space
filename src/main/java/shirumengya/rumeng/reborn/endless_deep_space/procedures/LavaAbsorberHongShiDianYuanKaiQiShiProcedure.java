package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class LavaAbsorberHongShiDianYuanKaiQiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		int horizontalRadiusSphere = (int) 30 - 1;
		int verticalRadiusSphere = (int) 30 - 1;
		int yIterationsSphere = verticalRadiusSphere;
		for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
			for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
				for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
							+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
					if (distanceSq <= 1.0) {
						if ((world.getFluidState(new BlockPos(x + xi, y + i, z + zi)).createLegacyBlock()).getBlock() == Blocks.LAVA || (world.getFluidState(new BlockPos(x + xi, y + i, z + zi)).createLegacyBlock()).getBlock() == Blocks.LAVA) {
							world.setBlock(new BlockPos(x + xi, y + i, z + zi), Blocks.AIR.defaultBlockState(), 3);
						}
					}
				}
			}
		}
	}
}
