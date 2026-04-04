package rahulshettyacademy.stepDefinitions;

import java.io.IOException;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.Checkoutpage;
import rahulshettyacademy.pageobjects.Landingpage;
import rahulshettyacademy.pageobjects.Paymentpage;
import rahulshettyacademy.pageobjects.Productcatalogue;

public class StepDefinitionimpl extends BaseTest {

	public Landingpage l;
	public Productcatalogue ca;
	public Checkoutpage p;
	public Paymentpage pay;
	List<String> products;

	@Given("I landed on ecommerce page")
	public void I_landed_on_ecommerce_page() throws IOException {
		l = launchApplication();
}

	@Given("^Loggedin with username (.+) and password (.+)$") // the .+ is any characters is a regular expression for
																// name and password
	public void Loggedin_with_username_and_password(String username, String password) { // when you have regular
																						// expression give cap in
																						// beginning and dollar at end
		ca = l.logininApplication(username, password);
}

	@When("^I add the product (.+) to cart$")
	public void I_add_the_product_to_cart( String cartList) {
		products = Arrays.asList(cartList.split(","));
		ca.getProductList();
		ca.addProductToCart(products);
}

	@And("^checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String cartList) {
		p = ca.goTocartPage();
		p.verifyCartElements1();
		boolean match = p.verifyCartElements(products);
		Assert.assertTrue(match);
		p.getpaymentpage();
		p.selectCountry("i");
}		
	@And("^payment done via credit card with details of (.+),(.+),(.+)$")
	public void payment_done_via_credit_card_with_details(String cvv, String name1 ,String coupoun1) {
	      
		  pay = p.addcountry();
		  pay.payment();
		  pay.cardcvvcode(cvv, name1, coupoun1);
}
	
	@Then("verify the confirmation {string} is dispayed") //write string or int as per requirement to catch directly in method and s in string need to be small letter 
	public void verify_the_confirmation_is_dispayed(String msg) {
		String confirmmsg = pay.orderdetails();
		Assert.assertTrue(confirmmsg.equalsIgnoreCase(msg));
		driver.close();
}
	
	@Then("{string} is displayed")
	public void error_popup__is_displayed(String msg1) {
		Assert.assertEquals(msg1, l.getErrorMessage());
		driver.close();
	}
	
}