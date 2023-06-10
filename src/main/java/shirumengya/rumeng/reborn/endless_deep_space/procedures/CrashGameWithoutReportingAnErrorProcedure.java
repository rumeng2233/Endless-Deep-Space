package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CrashGameWithoutReportingAnErrorProcedure {
	public static final Logger LOGGER = LogManager.getLogger(CrashGameWithoutReportingAnErrorProcedure.class);
	public static void execute() {
		CrashGameWithoutReportingAnErrorProcedure.LOGGER.fatal("The Java Virtual Machine is about to be forced to stop!");
		Runtime.getRuntime().halt(0);
	}
}
