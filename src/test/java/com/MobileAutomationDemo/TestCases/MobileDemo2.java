package com.MobileAutomationDemo.TestCases;

import javax.swing.JOptionPane;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.MobileAutomationDemo.PageObjects.GeneralStorePage;
import com.MobileAutomationDemo.PageObjects.ProductsPage;
import com.MobileAutomationDemo.Utilities.Utilities;

public class MobileDemo2 extends BaseClass{
	
	public static String expectedMessage = "Please enter your name";
	public static String country = "Australia";
	public static String name = "John Doe";
	public static String nameCharcter="R";
	public static String expectedMessageForLessCharcter = "Name should include more than 3 charcters";
	
	@Test(priority = 1)
	public void validateCharctersofName() throws InterruptedException{
		
		GeneralStorePage gsp = new GeneralStorePage(driver);
		
		gsp.ddCountry.click();
		
		Utilities u=new Utilities(driver);
	    u.scrollToCountry(country);
	
		gsp.lblCountry.click();
		
		gsp.txtName.sendKeys(nameCharcter);
		driver.hideKeyboard();
		
		gsp.radioGender.click();
		gsp.btnLetsShop.click();
		
//	    int count = nameCharcter.length();
//	    System.out.println(count);
//	    
//	    if (count < 3){
//	    	
//	    	String toastMessage = gsp.lblToastMsg.getAttribute("name");
//            JOptionPane.showInternalMessageDialog(null,toastMessage);
//	    	
//    		
//        }else {
//        	
//            gsp.radioGender.click();
//    		gsp.btnLetsShop.click();
//    		
//    		ProductsPage pp = new ProductsPage(driver);
//    		Thread.sleep(1000);
//    		
//    		Assert.assertTrue(pp.lblProducts.isDisplayed());
//    		System.out.println("Successfully navigated to products page");
//        }
		
	}

	
	    
	    
		
}