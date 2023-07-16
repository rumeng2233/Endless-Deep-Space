package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
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

public class MinimalitySuperBombHongShiDianYuanKaiQiShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
	if (EndlessDeepSpaceModCommonConfig.DISABLE_SUPER_BOMB.get() == false) {
		world.destroyBlock(new BlockPos(x, y, z), false);
		if (world instanceof Level _level && !_level.isClientSide()) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")), SoundSource.BLOCKS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.tnt.primed")), SoundSource.BLOCKS, 1, 1, false);
			}
			_level.explode(null, x, y, z, 20, Explosion.BlockInteraction.DESTROY);
			LikeEnderDragonDeathAnimationEffect effect = new LikeEnderDragonDeathAnimationEffect(_level, x + 0.5D, y + 0.25D, z + 0.5D, 40.0F, 146, 252, 220, false, 432.0F, 0.5F);
			_level.addFreshEntity(effect);
		}
	}
	}
}
