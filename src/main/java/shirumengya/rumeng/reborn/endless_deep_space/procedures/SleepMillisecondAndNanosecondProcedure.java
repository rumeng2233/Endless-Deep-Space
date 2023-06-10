package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SleepMillisecondAndNanosecondProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		try {
            Thread.currentThread().sleep((long) DoubleArgumentType.getDouble(arguments, "millisecond"), (int) DoubleArgumentType.getDouble(arguments, "nanosecond"));
         } catch (InterruptedException interruptedexception) {
         }
	}
}
