package com.MobileAutomationDemo.PageObjects;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage {
	
	public ProductsPage(AppiumDriver driver){
		
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	public WebElement lblProducts;

	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	public List<WebElement> listOfProducts;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	public List<WebElement> addToCartList;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement btnAddToCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	public WebElement lblProduct;
	
	@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
	public List<WebElement> product1;
	
	@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
	public List<WebElement> product2;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productprice;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalamount;
	
	
	
}
