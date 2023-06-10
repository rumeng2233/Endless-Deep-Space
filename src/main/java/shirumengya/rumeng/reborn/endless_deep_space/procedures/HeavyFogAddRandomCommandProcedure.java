package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class HeavyFogAddRandomCommandProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		EndlessDeepSpaceModVariables.MapVariables.get(world).heavy_fog_time = EndlessDeepSpaceModVariables.MapVariables.get(world).heavy_fog_time
				+ Mth.nextInt(RandomSource.create(), (int) DoubleArgumentType.getDouble(arguments, "min"), (int) DoubleArgumentType.getDouble(arguments, "max"));
		EndlessDeepSpaceModVariables.MapVariables.get(world).syncData(world);
	}
}
