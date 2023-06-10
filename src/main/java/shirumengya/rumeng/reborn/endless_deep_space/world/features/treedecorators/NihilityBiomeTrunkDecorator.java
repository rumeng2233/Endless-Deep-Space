package shirumengya.rumeng.reborn.endless_deep_space.world.features.treedecorators;

import shirumengya.rumeng.reborn.endless_deep_space.custom.init.BlockInit;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.core.BlockPos;

public class NihilityBiomeTrunkDecorator extends TrunkVineDecorator {
	public static final NihilityBiomeTrunkDecorator INSTANCE = new NihilityBiomeTrunkDecorator();
	public static com.mojang.serialization.Codec<NihilityBiomeTrunkDecorator> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		ForgeRegistries.TREE_DECORATOR_TYPES.register("nihility_biome_tree_trunk_decorator", tdt);
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(TreeDecorator.Context context) {
		context.logs().forEach(blockpos -> {
			if (context.random().nextInt(3) > 0) {
				BlockPos pos = blockpos.west();
				if (context.isAir(pos)) {
					context.setBlock(pos, BlockInit.NIHILITY_BLOCK.get().defaultBlockState());
				}
			}
			if (context.random().nextInt(3) > 0) {
				BlockPos pos = blockpos.east();
				if (context.isAir(pos)) {
					context.setBlock(pos, BlockInit.NIHILITY_BLOCK.get().defaultBlockState());
				}
			}
			if (context.random().nextInt(3) > 0) {
				BlockPos pos = blockpos.north();
				if (context.isAir(pos)) {
					context.setBlock(pos, BlockInit.NIHILITY_BLOCK.get().defaultBlockState());
				}
			}
			if (context.random().nextInt(3) > 0) {
				BlockPos pos = blockpos.south();
				if (context.isAir(pos)) {
					context.setBlock(pos, BlockInit.NIHILITY_BLOCK.get().defaultBlockState());
				}
			}
		});
	}
}
