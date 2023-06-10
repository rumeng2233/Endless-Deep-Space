package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.EndlessDeepSpaceModCommonConfig;
import net.minecraft.commands.CommandSourceStack;
import java.io.File;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class FileDeleteFileCommandProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		if (EndlessDeepSpaceModCommonConfig.ALLOWS_ENDLESS_DEEP_SPACE_MOD_TO_EXECUTE_JAVA_COMMANDS.get() == true) {
			File file = new File(StringArgumentType.getString(arguments, "file"));
			if(file.isDirectory() == false) {
				file.delete();
        	} else {
        		File[] listFiles = file.listFiles();
        			for(File dirfile : listFiles){
            		dirfile.delete();
            		file.delete();
        		}
        	}
		}
	}
}
