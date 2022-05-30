package com.MobileAutomationDemo.TestCases;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import java.net.MalformedURLException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.MobileAutomationDemo.PageObjects.CheckOutPage;
import com.MobileAutomationDemo.PageObjects.ProductsPage;
import com.MobileAutomationDemo.Utilities.Utilities;
//import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidTouchAction;

public class GeneralStore_Tc_4 extends BaseClass {
		
@Test	
public void checkingTheLongPressFunction() throws InterruptedException, MalformedURLException{
	
	    CheckOutPage cop = new CheckOutPage(driver);
		
		GeneralStore_Tc_2 tc2 = new GeneralStore_Tc_2();
	    tc2.validateAddToCartOption();
	    
		 AndroidTouchAction touch = new AndroidTouchAction(driver);
		 
		 Utilities u=new Utilities(driver);
	//	 WebElement checkbox = u.tapTheCheckbox();
		 //WebElement checkbox = driver.findElement(AppiumBy.androidUIAutomator("text(\"Send me e-mails on discounts related to selected products in future\")"));
		 //new AndroidTouchAction(driver).tap(tapOptions().withElement(element(checkbox))).perform();
		 
		
		 WebElement termsofcondition = cop.btnTermsOfCondition;
		 touch.longPress(longPressOptions().withElement(element(termsofcondition)).withDuration(ofSeconds(2))).release().perform();
		  
		 
	    
	    
	    
}

}
