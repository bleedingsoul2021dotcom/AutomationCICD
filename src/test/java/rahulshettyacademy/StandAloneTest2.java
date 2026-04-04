package rahulshettyacademy;

import java.io.IOException;


//import java.awt.Desktop.Action;

import java.time.Duration;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.stream.Collectors;

//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.Abstractcomponenets.Abstractcomponent;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.Checkoutpage;
import rahulshettyacademy.pageobjects.Landingpage;
import rahulshettyacademy.pageobjects.OrderHistorypage;
import rahulshettyacademy.pageobjects.Paymentpage;
import rahulshettyacademy.pageobjects.Productcatalogue;

public class StandAloneTest2 extends BaseTest {
	List<String> cartList = Arrays.asList("ADIDAS ORIGINAL", "ZARA COAT 3");
	@Test
	public  void submitOrder() throws IOException { 
//************************************************************************************************		
		// Login
		
		//Landingpage l = launchApplication(); //as we gave before method no need of this
		Productcatalogue ca = l.logininApplication("arjunvkakade@gmail.com", "Arjun@123");
//******************************************************************************************************
		// Get product List
		ca.getProductList();
		
		ca.addProductToCart(cartList);
		Checkoutpage p = ca.goTocartPage();
//******************************************************************************************************
		// Checkout page and country
		p.verifyCartElements1();
		boolean match = p.verifyCartElements(cartList);
		Assert.assertTrue(match); // should always be in test page
		p.getpaymentpage();
		p.selectCountry("i");
		Paymentpage pay = p.addcountry();
//******************************************************************************************************
		// payment page and order details
		pay.payment();
		pay.cardcvvcode("366", "Arjun v kakade", "rahulshettyacademy");
	String confirmmsg = pay.orderdetails();
	Assert.assertTrue(confirmmsg.equalsIgnoreCase("Thankyou for the order."));
//*******************************************************************************************************			
	}
	
//*****************************************************************************************************	
	@Test(dependsOnMethods = {"submitOrder"})
	public  void orderHistoryTest() {
		Productcatalogue ca =	l.logininApplication("arjunvkakade@gmail.com", "Arjun@123");
		OrderHistorypage O  = ca.goToOrderHistory();
		//boolean match1 =  O.verifyOrdername(cartList);
		//Assert.assertTrue(match1); //or method
		Assert.assertTrue(O.verifyOrdername(cartList));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	 
	
	
	
	
	
	
	
}