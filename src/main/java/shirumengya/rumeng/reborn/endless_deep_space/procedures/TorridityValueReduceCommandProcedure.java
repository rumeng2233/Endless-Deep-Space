package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class TorridityValueReduceCommandProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "player")) {
				{
					double _setval = (entityiterator.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).torridity_value
							- DoubleArgumentType.getDouble(arguments, "torridity_value");
					entityiterator.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.torridity_value = _setval;
						capability.syncPlayerVariables(entityiterator);
					});
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
