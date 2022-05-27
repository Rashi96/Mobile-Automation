package com.MobileAutomationDemo.Utilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Utilities{
	
	AndroidDriver driver;

	public Utilities(AndroidDriver driver){
		
		this.driver= driver;
			
	}
	
	public void scrollToText(String text){

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + text + "\").instance(0))"));     

	}

}
