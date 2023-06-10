package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class WitherestAssaultValueReduceProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "targets")) {
				entityiterator.getPersistentData().putDouble("endless_deep_space:assault_value", (entityiterator.getPersistentData().getDouble("endless_deep_space:assault_value") - DoubleArgumentType.getDouble(arguments, "assault_value")));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
