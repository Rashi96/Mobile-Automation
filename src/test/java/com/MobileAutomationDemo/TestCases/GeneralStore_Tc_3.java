package com.MobileAutomationDemo.TestCases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.MobileAutomationDemo.PageObjects.GeneralStorePage;
import com.MobileAutomationDemo.PageObjects.ProductsPage;
import com.MobileAutomationDemo.Utilities.Utilities;
import io.appium.java_client.MobileBy;

public class GeneralStore_Tc_3 extends BaseClass{
	
	public static String expectedMessage = "Please enter your name";
	public static String country = "Australia";
	public static String name = "John Doe";
	public static String productName="Jordan 6 Rings";
	public static String totalProductsValue=": Total value of products";
	public static String sumOfProducts=": sum of products";
	
	@Test
public void validateTotalAmount() throws InterruptedException, MalformedURLException{
		
		GeneralStorePage gsp = new GeneralStorePage(driver);
        ProductsPage pp = new ProductsPage(driver);

        gsp.ddCountry.click();

        Utilities u=new Utilities(driver);
	    u.scrollToCountry(country);
	
		gsp.lblCountry.click();
		
		gsp.txtName.sendKeys(name);
		driver.hideKeyboard();
		
		gsp.radioGender.click();
		gsp.btnLetsShop.click();
        
        pp.btnproduct1.get(0).click();
        pp.btnproduct2.get(0).click();
	    
        pp.btnAddToCart.click();
	    Thread.sleep(4000);
	    
	    
       int count = pp.lblListOfProducts.size();
       System.out.println(count+"count of products");

	    double sum=0;

	    for(int i=0;i<count;i++){
	    	
	    	String amount1= ((WebElement)pp.lblproductprice.get(i)).getText();
             
	    	double amount=getAmount(amount1);
            sum=sum+amount;
	    	
	    }
	    
	    System.out.println(sum+sumOfProducts);

	    String total= pp.lbltotalAmount.getText();

	    total= total.substring(1);
        double totalValue=Double.parseDouble(total);
        System.out.println(totalValue + totalProductsValue);

	    Assert.assertEquals(sum, totalValue); 
	    System.out.println("Verification success Expectedamount and Actualamount are same");
	    
	}
	    	
	   public static double getAmount(String value){

	    value= value.substring(1);

	    double amount2value=Double.parseDouble(value);

	    return amount2value;
	    
	    }
		

}
