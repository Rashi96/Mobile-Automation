package com.MobileAutomationDemo.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckOutPage {
	
	public CheckOutPage(AppiumDriver driver){
		
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	public WebElement btnTermsOfCondition;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	public WebElement btnWebsite;
	
	@AndroidFindBy(xpath="//*[@text='CLOSE']")
	public WebElement btnClose;
	
	
	

}



