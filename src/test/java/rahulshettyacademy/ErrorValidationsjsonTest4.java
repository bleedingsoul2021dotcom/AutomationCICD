package rahulshettyacademy;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.Checkoutpage;
import rahulshettyacademy.pageobjects.Productcatalogue;

public class ErrorValidationsjsonTest4 extends BaseTest {

	@Test(dataProvider = "getData",groups = {"ErrorHandling"})
	public void submitOrder(HashMap<String,String> input) throws IOException { 
		
		// Login
		
		//Landingpage l = launchApplication(); //as we gave before method no need of this
		l.logininApplication(input.get("email"), input.get("password"));
		Assert.assertEquals("Incorrect email or password.", l.getErrorMessage());
		
	}
//***********************************************************************************************
	@Test
	public void productErrorValidation(HashMap<String,String> input) throws IOException { 
		//************************************************************************************************		
				// Login
				
				//Landingpage l = launchApplication(); //as we gave before method no need of this
				Productcatalogue ca = l.logininApplication(input.get("email1"), input.get("password1"));
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
	
	
	@DataProvider
	
	public Object[][] getData() throws IOException {
   List<HashMap<String,String>> data =   getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\purchaseorder.json");
		         return new Object[] []  {{data.get(0)},{data.get(1)}};
	
	}
	
	
	
	}
	
