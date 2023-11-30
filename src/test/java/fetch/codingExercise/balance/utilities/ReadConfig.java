package fetch.codingExercise.balance.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	private static Properties properties;
	
	static {
		String propertyFilePath = "./configs/config.properties";
		try {
			FileInputStream fstream = new FileInputStream(propertyFilePath);
			properties = new Properties();
			try {
				properties.load(fstream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getApplicationUrl() {
		return properties.getProperty("baseURL");
	}
	
	
	public static String getChromeDriverPath() {
		return properties.getProperty("chromepath");
	}
	
	
	public static String getFirefoxDriverPath() {
		return properties.getProperty("firefoxpath");
	}


	public static String getSuccessAlertMessage() {
		return properties.getProperty("alertSuccessMessage");
	}
}
