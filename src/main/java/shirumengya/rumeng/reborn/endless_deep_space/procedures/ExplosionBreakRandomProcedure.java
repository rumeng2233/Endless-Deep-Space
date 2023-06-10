package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class ExplosionBreakRandomProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "targets")) {
				if (BoolArgumentType.getBool(arguments, "fire") == true) {
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(entityiterator, (new Object() {
							public double getX() {
								try {
									return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getX();
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return 0;
								}
							}
						}.getX()), (new Object() {
							public double getY() {
								try {
									return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getY();
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return 0;
								}
							}
						}.getY()), (new Object() {
							public double getZ() {
								try {
									return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getZ();
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return 0;
								}
							}
						}.getZ()), (float) Mth.nextDouble(RandomSource.create(), DoubleArgumentType.getDouble(arguments, "min"),
								DoubleArgumentType.getDouble(arguments, "max")), true, Explosion.BlockInteraction.BREAK);
				} else {
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(entityiterator, (new Object() {
							public double getX() {
								try {
									return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getX();
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return 0;
								}
							}
						}.getX()), (new Object() {
							public double getY() {
								try {
									return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getY();
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return 0;
								}
							}
						}.getY()), (new Object() {
							public double getZ() {
								try {
									return BlockPosArgument.getLoadedBlockPos(arguments, "pos").getZ();
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return 0;
								}
							}
						}.getZ()), (float) Mth.nextDouble(RandomSource.create(), DoubleArgumentType.getDouble(arguments, "min"),
								DoubleArgumentType.getDouble(arguments, "max")), Explosion.BlockInteraction.BREAK);
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
