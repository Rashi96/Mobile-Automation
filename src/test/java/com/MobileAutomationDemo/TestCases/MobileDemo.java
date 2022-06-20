package com.MobileAutomationDemo.TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.MobileAutomationDemo.PageObjects.GeneralStorePage;
import com.MobileAutomationDemo.PageObjects.ProductsPage;
import com.MobileAutomationDemo.Utilities.Utilities;

public class MobileDemo extends BaseClass_Cloud{
	
	public static String expectedMessage = "Please enter your name";
	public static String country = "Australia";
	public static String name = "John Doe";
	
	@Test(priority = 1)
	public void validateToastMessage() throws InterruptedException{
		
		GeneralStorePage gsp = new GeneralStorePage(driver);
		
		gsp.btnLetsShop.click();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		String toastMessage = gsp.lblToastMsg.getAttribute("name");
		Assert.assertEquals(expectedMessage, toastMessage);
		System.out.println("Validation success. Expected toast message displayed");
		
	}
	
	@Test(priority = 2)
	public void productsPageNavigation() throws InterruptedException{
		
		GeneralStorePage gsp = new GeneralStorePage(driver);
		
		gsp.ddCountry.click();
		
		Utilities u=new Utilities(driver);
	    u.scrollToCountry(country);
	
		gsp.lblCountry.click();
		
		gsp.txtName.sendKeys(name);
		driver.hideKeyboard();
		
		gsp.radioGender.click();
		gsp.btnLetsShop.click();
		
		ProductsPage pp = new ProductsPage(driver);
		Thread.sleep(1000);
		
		Assert.assertTrue(pp.lblProducts.isDisplayed());
		System.out.println("Successfully navigated to products page");
		
	}

	
	    
	    
		
}