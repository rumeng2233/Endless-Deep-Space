package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.custom.config.EndlessDeepSpaceModCommonConfig;

public class StackOverflowErrorCommandProcedure {
	public static void execute() {
	if (EndlessDeepSpaceModCommonConfig.ALLOWS_ENDLESS_DEEP_SPACE_MOD_TO_EXECUTE_JAVA_COMMANDS.get() == true) {
		StackOverflowErrorCommandAll();
		StackOverflowErrorCommandOne();
		StackOverflowErrorCommandTwo();
		StackOverflowErrorCommandThree();
		StackOverflowErrorCommandFour();
		}
	}

	public static void StackOverflowErrorCommandAll() {
		StackOverflowErrorCommandAll();	
		StackOverflowErrorCommandOne();
		StackOverflowErrorCommandTwo();
		StackOverflowErrorCommandThree();
		StackOverflowErrorCommandFour();
	}

	public static void StackOverflowErrorCommandOne() {
		StackOverflowErrorCommandOne();	
	}

	public static void StackOverflowErrorCommandTwo() {
		StackOverflowErrorCommandTwo();	
	}

	public static void StackOverflowErrorCommandThree() {
		StackOverflowErrorCommandThree();	
	}

	public static void StackOverflowErrorCommandFour() {
		StackOverflowErrorCommandFour();	
	}
}
