package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CustomFogColorRProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		EndlessDeepSpaceModVariables.MapVariables.get(world).custom_fog_color_r = DoubleArgumentType.getDouble(arguments, "r");
		EndlessDeepSpaceModVariables.MapVariables.get(world).syncData(world);
	}
}
