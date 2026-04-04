package rahulshettyacademy;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.Checkoutpage;
import rahulshettyacademy.pageobjects.Productcatalogue;

public class ErrorValidationsTest extends BaseTest {

	@Test
	public void submitOrder() throws IOException { 
		
		// Login
		
		//Landingpage l = launchApplication(); //as we gave before method no need of this
		l.logininApplication("arjunvkade@gmail.com", "Arjun12300");
		Assert.assertEquals("Incorrect email or password.", l.getErrorMessage());
		
	}
//***********************************************************************************************
	@Test
	public void productErrorValidation() throws IOException { 
		//************************************************************************************************		
				// Login
				
				//Landingpage l = launchApplication(); //as we gave before method no need of this
				Productcatalogue ca = l.logininApplication("arjunvkakade@gmail.com", "Arjun@123");
		//******************************************************************************************************
				// Get product List
				ca.getProductList();
				List<String> cartList = Arrays.asList("ADIDAS ORIGINAL", "ZARA COAT 3");
				ca.addProductToCart(cartList);
				Checkoutpage p = ca.goTocartPage();
		//******************************************************************************************************
				// Checkout page and country
				p.verifyCartElements1();
				boolean match = p.verifyCartElements(cartList);
				Assert.assertTrue(match); // should always be in test page
	
	
	
	
	
	
	
	
	
	
	}
	
}