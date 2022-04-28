package com.saumya.chatapp.utils;

import java.util.ResourceBundle;

public class configReader {
	// Don't let anybody instantiate this class.
	private configReader() {
		
	}
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
	public static String getValue(String key) {
		return resourceBundle.getString(key);
	}
}
