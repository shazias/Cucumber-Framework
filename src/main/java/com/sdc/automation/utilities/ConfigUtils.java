package com.sdc.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by imran on 28/01/17.
 */
public class ConfigUtils {

	static Properties config;

	private static Logger Log = Logger.getLogger(ConfigUtils.class.getName());


	public static String getConfigValue(String key) {

		return config.getProperty(key);
	}


	public static void loadConfig() {


		try {
			final FileInputStream fileInputStream = new FileInputStream(new File("src/test/resources/config.properties"));
			config = new Properties();
			config.load(fileInputStream);
			fileInputStream.close();

		} catch (final IOException ex) {
			Log.info("Exception reading config " + ex);
		}
	}

}
