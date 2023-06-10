package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.EndlessDeepSpaceModCommonConfig;
import net.minecraft.commands.CommandSourceStack;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class FileWriteFileRCommandProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		if (EndlessDeepSpaceModCommonConfig.ALLOWS_ENDLESS_DEEP_SPACE_MOD_TO_EXECUTE_JAVA_COMMANDS.get() == true) {
			FileWriter fw = null;
        	PrintWriter pw = null;
			File file = new File(StringArgumentType.getString(arguments, "file"));
				try {
				fw = new FileWriter(file, true);
            	pw = new PrintWriter(fw);
            	pw.append(StringArgumentType.getString(arguments, "text")+"\r");
            	pw.flush();
            	fw.flush();
         		} catch (IOException ioexception) {
         		} finally {
            	try {
                pw.close();
                fw.close();
            	} catch (IOException ioexception) {
            	}
        	}
		}
	}
}
