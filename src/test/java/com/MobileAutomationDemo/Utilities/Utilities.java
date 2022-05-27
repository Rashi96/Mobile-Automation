package com.MobileAutomationDemo.Utilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Utilities{
	
	AndroidDriver driver;

	public Utilities(AndroidDriver driver){
		
		this.driver= driver;
			
	}
	
	public void scrollToCountry(String text){

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + text + "\").instance(0))"));     

	}
	
	
	public void scrollToProduct(String text){

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"" + text + "\").instance(0))"));

	}
	
	public void tapTheCheckbox(){

		driver.findElement(AppiumBy.androidUIAutomator("text(\"Send me e-mails on discounts related to selected products in future\")"));
	}
	
	
	  
}
