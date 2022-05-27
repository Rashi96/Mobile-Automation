package com.MobileAutomationDemo.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/global.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}

	}
	
	public String getAppName() {
		String app = pro.getProperty("AppName");
		return app;
	}

	public String getDeviceName() {
		String device = pro.getProperty("DeviceName");
		return device;
	}

}
