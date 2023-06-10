package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.EndlessDeepSpaceModCommonConfig;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import java.io.IOException;

public class RuntimeGetRuntimeExecStringCmdArrayCommandProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
	if (EndlessDeepSpaceModCommonConfig.ALLOWS_ENDLESS_DEEP_SPACE_MOD_TO_EXECUTE_JAVA_COMMANDS.get() == true) {
		try {
            Runtime.getRuntime().exec(new String[]{StringArgumentType.getString(arguments, "exe"), StringArgumentType.getString(arguments, "dir"), StringArgumentType.getString(arguments, "command")});
         } catch (IOException ioexception) {
         }
		}
	}
}
