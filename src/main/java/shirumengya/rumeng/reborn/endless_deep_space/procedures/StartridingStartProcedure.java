package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class StartridingStartProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity sourceentity : EntityArgument.getEntities(arguments, "sourceentity")) {
		try {
			for (Entity entity : EntityArgument.getEntities(arguments, "entity")) {
				if (BoolArgumentType.getBool(arguments, "boolean") == true) {
					sourceentity.startRiding(entity, true);
				} else {
					sourceentity.startRiding(entity, false);
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
