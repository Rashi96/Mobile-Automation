package com.MobileAutomationDemo.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneralStorePage {
	
	public GeneralStorePage(AppiumDriver driver){
		
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement btnLetsShop;
	
	@AndroidFindBy(xpath="//android.widget.Toast[1]")
	public WebElement labelToastMsg;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	public WebElement dropdownCountry;
	
	@AndroidFindBy(xpath="//*[@text='Australia']")
	public WebElement labelCountry;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement txtName;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement radioGender;

}
