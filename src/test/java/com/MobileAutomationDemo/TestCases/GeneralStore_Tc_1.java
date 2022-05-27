package com.MobileAutomationDemo.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.MobileAutomationDemo.PageObjects.GeneralStorePage;
import com.MobileAutomationDemo.PageObjects.ProductsPage;
import com.MobileAutomationDemo.Utilities.Utilities;

public class GeneralStore_Tc_1 extends BaseClass{
	
	public static String expectedMessage = "Please enter your name";
	public static String country = "Australia";
	public static String name = "John Doe";
	
	@Test(priority = 1)
	public void validateToastMessage(){
		
		GeneralStorePage gsp = new GeneralStorePage(driver);
		
		gsp.btnLetsShop.click();
		
		String toastMessage = gsp.labelToastMsg.getAttribute("name");
		Assert.assertEquals(expectedMessage, toastMessage);
		System.out.println("Validation success. Expected toast message displayed");
		
	}
	
	@Test(priority = 2)
	public void productsPageNavigation() throws InterruptedException{
		
		GeneralStorePage gsp = new GeneralStorePage(driver);
		
		gsp.dropdownCountry.click();
		
		Utilities u=new Utilities(driver);
	    u.scrollToText(country);
	
		gsp.labelCountry.click();
		
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
