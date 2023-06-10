package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class DeltaMovementLookAngleSetProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "targets")) {
				entityiterator.setDeltaMovement(new Vec3((DoubleArgumentType.getDouble(arguments, "vx")), (DoubleArgumentType.getDouble(arguments, "vy")), (DoubleArgumentType.getDouble(arguments, "vz"))));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
