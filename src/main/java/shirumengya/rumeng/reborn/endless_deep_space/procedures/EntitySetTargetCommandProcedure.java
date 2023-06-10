package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModMobEffects;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.world.entity.Mob;

public class EntitySetTargetCommandProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity eentity) {
		try {
			for (Entity sourceentity : EntityArgument.getEntities(arguments, "sourceentity")) {
		try {
			for (Entity entity : EntityArgument.getEntities(arguments, "entity")) {
				if (entity instanceof Mob _entity && sourceentity instanceof Mob _sourceentity)
				_entity.setTarget(_sourceentity);
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