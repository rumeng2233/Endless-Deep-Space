package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.entity.*;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Blocks;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.*;

public class MiniSuperBombHongShiDianYuanKaiQiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
	if (EndlessDeepSpaceModCommonConfig.DISABLE_SUPER_BOMB.get() == false) {
		world.destroyBlock(new BlockPos(x, y, z), false);
		if (world instanceof ServerLevel _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")), SoundSource.BLOCKS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")), SoundSource.BLOCKS, 1, 1, false);
			}
			LikeEnderDragonDeathAnimationEffect effect = new LikeEnderDragonDeathAnimationEffect(_level, x + 0.5D, y + 0.25D, z + 0.5D, 200.0F, 138, 104, 216, false, 432.0F, 2F);
			_level.addFreshEntity(effect);
		}
		int horizontalRadiusSphere = (int) 40 - 1;
		int verticalRadiusSphere = (int) 40 - 1;
		int yIterationsSphere = verticalRadiusSphere;
		for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
			for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
				for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
							+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
					if (distanceSq <= 1.0) {
						world.setBlock(new BlockPos(x + xi, y + i, z + zi), Blocks.AIR.defaultBlockState(), 3);
					}
				}
			}
		}
	}
	}
}
