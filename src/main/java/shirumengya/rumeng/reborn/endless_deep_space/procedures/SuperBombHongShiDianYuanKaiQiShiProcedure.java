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

public class SuperBombHongShiDianYuanKaiQiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (EndlessDeepSpaceModCommonConfig.DISABLE_SUPER_BOMB.get() == false) {
			if (world instanceof ServerLevel _level) {
				SuperBomb bomb = new SuperBomb(_level);
				bomb.setPos(x + 0.5D, y + 0.25D, z + 0.5D);
				world.addFreshEntity(bomb);
			}
		}
		/*world.destroyBlock(new BlockPos(x, y, z), false);
		if (world instanceof ServerLevel _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")), SoundSource.BLOCKS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")), SoundSource.BLOCKS, 1, 1, false);
			}
			LikeEnderDragonDeathAnimationEffect effect = new LikeEnderDragonDeathAnimationEffect(_level, x + 0.5D, y + 0.25D, z + 0.5D, 200.0F, 255, 102, 0, false, 432.0F, 2F);
			world.addFreshEntity(effect);
		}
		EndlessDeepSpaceMod.queueServerWork(200, () -> {
			if (world instanceof Level _level && !_level.isClientSide()) {
				_level.explode(null, x, y, z, 30, Explosion.BlockInteraction.DESTROY);
				LikeEnderDragonDeathAnimationEffect effect1 = new LikeEnderDragonDeathAnimationEffect(_level, x, y, z, 80.0F, 236, 225, 159, false, 432.0F, 0.2F);
				_level.addFreshEntity(effect1);
				_level.explode(null, x, y + 10.0D, z, 30, Explosion.BlockInteraction.DESTROY);
				LikeEnderDragonDeathAnimationEffect effect2 = new LikeEnderDragonDeathAnimationEffect(_level, x, y + 10.0D, z, 80.0F, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), false, 432.0F, 0.2F);
				_level.addFreshEntity(effect2);
				_level.explode(null, x, y - 10.0D, z, 30, Explosion.BlockInteraction.DESTROY);
				LikeEnderDragonDeathAnimationEffect effect3 = new LikeEnderDragonDeathAnimationEffect(_level, x, y - 10.0D, z, 80.0F, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), false, 432.0F, 0.2F);
				_level.addFreshEntity(effect3);
				_level.explode(null, x + 10.0D, y, z, 30, Explosion.BlockInteraction.DESTROY);
				LikeEnderDragonDeathAnimationEffect effect4 = new LikeEnderDragonDeathAnimationEffect(_level, x + 10.0D, y, z, 80.0F, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), false, 432.0F, 0.2F);
				_level.addFreshEntity(effect4);
				_level.explode(null, x - 10.0D, y, z, 30, Explosion.BlockInteraction.DESTROY);
				LikeEnderDragonDeathAnimationEffect effect5 = new LikeEnderDragonDeathAnimationEffect(_level, x - 10.0D, y, z, 80.0F, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), false, 432.0F, 0.2F);
				_level.addFreshEntity(effect5);
				_level.explode(null, x, y, z + 10.0D, 30, Explosion.BlockInteraction.DESTROY);
				LikeEnderDragonDeathAnimationEffect effect6 = new LikeEnderDragonDeathAnimationEffect(_level, x, y, z + 10.0D, 80.0F, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), false, 432.0F, 0.2F);
				_level.addFreshEntity(effect6);
				_level.explode(null, x, y, z - 10.0D, 30, Explosion.BlockInteraction.DESTROY);
				LikeEnderDragonDeathAnimationEffect effect7 = new LikeEnderDragonDeathAnimationEffect(_level, x, y, z - 10.0D, 80.0F, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), false, 432.0F, 0.2F);
				_level.addFreshEntity(effect7);
			}
			EndlessDeepSpaceMod.queueServerWork(80, () -> {
				if (world instanceof ServerLevel _level) {
					LikeEnderDragonDeathAnimationEffect effect8 = new LikeEnderDragonDeathAnimationEffect(_level, x, y, z, 400.0F, 153, 255, 102, false, 432.0F, 4F);
					_level.addFreshEntity(effect8);
				}
				int horizontalRadiusSphere = (int) 80 - 1;
				int verticalRadiusSphere = (int) 80 - 1;
				int yIterationsSphere = verticalRadiusSphere;
				for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
					for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
						for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
							double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
									+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
							if (distanceSq <= 1.0) {
								//world.destroyBlock(new BlockPos(x + xi, y + i, z + zi), false);
								world.setBlock(new BlockPos(x + xi, y + i, z + zi), Blocks.AIR.defaultBlockState(), 3);
							}
						}
					}
				}
			});
		});
	}*/
	}
}
