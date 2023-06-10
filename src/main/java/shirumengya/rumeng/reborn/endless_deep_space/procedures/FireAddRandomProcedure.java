package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class FireAddRandomProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "targets")) {
				entityiterator.setSecondsOnFire((int) (entityiterator.getRemainingFireTicks() + Mth.nextDouble(RandomSource.create(), DoubleArgumentType.getDouble(arguments, "min"), DoubleArgumentType.getDouble(arguments, "max"))));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
