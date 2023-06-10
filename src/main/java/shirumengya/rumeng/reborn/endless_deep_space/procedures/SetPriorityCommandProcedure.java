package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetPriorityCommandProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		Thread.currentThread().setPriority((int) DoubleArgumentType.getDouble(arguments, "priority"));
	}
}
