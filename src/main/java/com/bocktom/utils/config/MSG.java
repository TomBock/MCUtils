package com.bocktom.utils.config;

import org.bukkit.configuration.file.FileConfiguration;

/**
 * A class to manage messages of the plugin
 * Make sure to call setup() before using any of the methods
 */
public class MSG {

	private static FileConfiguration config;

	public static void setup(FileConfiguration cfg) {
		config = cfg;
	}

	public static String get(String path) {
		if(config == null) {
			throw new IllegalStateException("MSG.setup() must be called before using any of the methods");
		}

		return config.getString(path);
	}

	public static String get(String path, String... replaceVariables) {
		if(replaceVariables.length % 2 != 0) {
			throw new IllegalArgumentException("replaceVariables must be a multiple of 2");
		}
		String message = get(path);
		for(int i = 0; i < replaceVariables.length; i += 2) {
			message = message.replace(replaceVariables[i], replaceVariables[i + 1]);
		}
		return message;
	}

}
