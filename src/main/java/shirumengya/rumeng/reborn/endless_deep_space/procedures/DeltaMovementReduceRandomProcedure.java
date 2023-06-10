package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class DeltaMovementReduceRandomProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "targets")) {
				entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x() - Mth.nextDouble(RandomSource.create(), DoubleArgumentType.getDouble(arguments, "vxMin"), DoubleArgumentType.getDouble(arguments, "vxMax"))),
						(entityiterator.getDeltaMovement().y() - Mth.nextDouble(RandomSource.create(), DoubleArgumentType.getDouble(arguments, "vyMin"), DoubleArgumentType.getDouble(arguments, "vyMax"))),
						(entityiterator.getDeltaMovement().z() - Mth.nextDouble(RandomSource.create(), DoubleArgumentType.getDouble(arguments, "vzMin"), DoubleArgumentType.getDouble(arguments, "vzMax")))));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
