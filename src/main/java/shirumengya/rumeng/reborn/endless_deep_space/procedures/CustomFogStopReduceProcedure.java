package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class CustomFogStopReduceProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		EndlessDeepSpaceModVariables.MapVariables.get(world).custom_fog_stop_reduce = BoolArgumentType.getBool(arguments, "on_or_off");
		EndlessDeepSpaceModVariables.MapVariables.get(world).syncData(world);
	}
}
