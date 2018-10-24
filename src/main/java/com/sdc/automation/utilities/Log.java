package com.sdc.automation.utilities;

import org.apache.log4j.Logger;

public class Log {

	//Initialize Log4j logs
	private static Logger Log = Logger.getLogger(Log.class.getName());//

	public static void debug(String message) {
		Log.debug(message);
	}

	//This is to print log for the ending of the test case
	public static void endScenario(String sScenario){
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
		Log.info("X");
		Log.info("X");
		Log.info("X");
		Log.info("X");

	}

	public static void error(String message) {
		Log.error(message);
	}

	public static void fatal(String message) {
		Log.fatal(message);
	}

	// Need to create these methods, so that they can be called
	public static void info(String message) {
		Log.info(message);
	}

	// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
	public static void startScenario(String sScenario){

		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
		Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sScenario+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");

	}

	public static void warn(String message) {
		Log.warn(message);
	}

}