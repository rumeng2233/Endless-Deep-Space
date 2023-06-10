package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class DeltaMovementLookAngleReduceProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "targets")) {
				entityiterator.setDeltaMovement(new Vec3((entityiterator.getLookAngle().x - DoubleArgumentType.getDouble(arguments, "vx")), (entityiterator.getLookAngle().y - DoubleArgumentType.getDouble(arguments, "vy")),
						(entityiterator.getLookAngle().z - DoubleArgumentType.getDouble(arguments, "vz"))));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
