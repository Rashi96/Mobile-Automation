package com.MobileAutomationDemo.TestCases;

import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.MobileAutomationDemo.PageObjects.CheckOutPage;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

@Test
public class GeneralStore_Tc_5 extends BaseClass{
	
	public void navigateToTheWebview() throws InterruptedException, MalformedURLException{
		
		CheckOutPage cop = new CheckOutPage(driver);
		
		GeneralStore_Tc_4 tc4 = new GeneralStore_Tc_4();
	    tc4.checkingTheLongPressFunction();
	    
	    cop.btnClose.click();
	    
	    cop.btnWebsite.click();
	    
	    Thread.sleep(7000);
	    
	    Set<String> context = driver.getContextHandles();
        for(String contextName:context )
      	  
        {
        System.out.println(contextName);
        }
        
        driver.context("WEBVIEW_com.androidsample.generalstore");
        Thread.sleep(3000);
        driver.findElement(By.name("q")).sendKeys("Mobile Automation");
        
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        
        driver.context("NATIVE_APP");
        	
	
	}

}
