package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class HealthReducePOSITIVEINFINITYProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "targets")) {
				if (entityiterator instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - Double.POSITIVE_INFINITY));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
