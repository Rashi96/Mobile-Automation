package com.MobileAutomationDemo.TestCases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.MobileAutomationDemo.PageObjects.ProductsPage;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class GeneralStore_Tc_2 extends BaseClass {
	
	public static String productName = "Jordan 6 Rings";
	
	@Test
	public void validateAddToCartOption() throws InterruptedException, MalformedURLException{
		
		ProductsPage pp = new ProductsPage(driver);
		
		GeneralStore_Tc_1 tc1 = new GeneralStore_Tc_1();
	    tc1.productsPageNavigation();
	    
	    driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"" + productName + "\").instance(0))"));
		
	    int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
	     	     
	    for(int i=0; i<count; i++){
	    	
	    	String text=pp.listOfProducts.get(i).getText();

	    	if(text.equalsIgnoreCase(productName)){

	    		pp.addToCartList.get(i).click();
	    		break;
             }

	     }
	            
	     pp.btnAddToCart.click();
	     Thread.sleep(1000);
	     	    
	     String productInCart = pp.lblProduct.getText();

	     Assert.assertEquals(productInCart, productName);
	     System.out.println("Validation success. Expected product is added to cart");
		
	}

}
