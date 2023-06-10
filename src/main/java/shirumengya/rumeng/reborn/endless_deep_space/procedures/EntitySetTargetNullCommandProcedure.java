package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.world.entity.Mob;

public class EntitySetTargetNullCommandProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "entity")) {
			if (entityiterator instanceof Mob _entity)
					_entity.setTarget(null);
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
