package rahulshettyacademy.pageobjects;

//import java.util.Arrays;


import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponenets.Abstractcomponent;


public class Productcatalogue extends Abstractcomponent  {
	
	WebDriver driver;
	                                           
	public Productcatalogue(WebDriver driver) { 
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
//*************************************************************************************************
	//Page factory(only call from drivers not Locater)
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css = ".mb-3")  
	List<WebElement> products;
	
	                                                    //@FindBy(css = ".btn.w-10.rounded")
	                                                    //WebElement cartItem;  this will take driver to search 
	
	@FindBy(css = "div[aria-label='Product Added To Cart']")
	WebElement printmsg;
	

	
	
	
//************************************************************************************	
	//By Locater
By productsby = By.cssSelector(".mb-3");	  //or else right locator directly
By addToCart = By.cssSelector(".btn.w-10.rounded");      //this will take product to search
By toastmsg = By.cssSelector("div[aria-label='Product Added To Cart']");
By spinner = By.cssSelector(".ng-tns-c31-0.ng-star-inserted");



//********************************************************************************************
//method 1	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsby);
		return products;
		
	}
//*****************************************************************************************************************
//method 2
	public List<WebElement> getProductByName(List<String> cartList) {
		
		//List<String> cartList = Arrays.asList("ADIDAS ORIGINAL", "ZARA COAT 3");
		
		List<WebElement> matchedProducts = products.stream()
				.filter(product -> cartList.contains(product.findElement(By.cssSelector("b")).getText()))
				.collect(Collectors.toList());
		 return matchedProducts;
	}
//****************************************************************************************************************	
//method 3		
	public void addProductToCart(List<String> cartList) {
		
		 List<WebElement> matchedProducts = getProductByName(cartList);
		 for (WebElement product : matchedProducts) {
				product.findElement(addToCart).click();
				waitForElementToAppear(toastmsg);
				printmsg.getText();
				waitForElementToDisappear(spinner);
		}
}

}
