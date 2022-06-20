package com.MobileAutomationDemo.TestCases;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import com.MobileAutomationDemo.Utilities.ReadConfig;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass_Cloud {
	

	public static AppiumDriverLocalService service;
	static ReadConfig readconfig = new ReadConfig();
	public static String appName = readconfig.getAppName();
	public static String deviceName = readconfig.getDeviceName();
	public static AndroidDriver driver;
	
	@BeforeClass
	public void setCapabilities() throws IOException, InterruptedException{
	
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("browserstack.idleTimeout", "300");
		cap.setCapability("browserstack.user", "rashiwarna1");
	    cap.setCapability("browserstack.key", "3cLXtKJtSrQhL12ESTjp");
		cap.setCapability("app", "bs://2e8813b35660546969319e5922378f5a98f8f56b");
		cap.setCapability("device", "Google Pixel 3");
        cap.setCapability("os_version", "9.0");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), cap);
		
		
	}

}
