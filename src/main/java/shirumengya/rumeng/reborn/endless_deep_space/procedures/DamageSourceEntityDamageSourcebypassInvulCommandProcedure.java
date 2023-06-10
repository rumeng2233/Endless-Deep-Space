package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.*;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class DamageSourceEntityDamageSourcebypassInvulCommandProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		try {
			for (Entity eentity : EntityArgument.getEntities(arguments, "entity")) {
		try {
			for (Entity sourceentity : EntityArgument.getEntities(arguments, "sourceentity")) {
					eentity.hurt(new EntityDamageSource(StringArgumentType.getString(arguments, "damage_source"), sourceentity).bypassInvul(),(float) DoubleArgumentType.getDouble(arguments, "damage"));
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
