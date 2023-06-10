package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CustomFogColorGProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		EndlessDeepSpaceModVariables.MapVariables.get(world).custom_fog_color_g = DoubleArgumentType.getDouble(arguments, "g");
		EndlessDeepSpaceModVariables.MapVariables.get(world).syncData(world);
	}
}
