package rahulshettyacademy.pageobjects;

//import java.util.Arrays;

import java.util.List;

//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

public class Checkoutpage {
	WebDriver driver;

public Checkoutpage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
//***************************************************************************************************

//driver
@FindBy(css = ".cartSection h3")
List<WebElement> cart;

@FindBy(css = ".totalRow button")
WebElement paymentclk;

@FindBy(css = ".form-group input")
WebElement countryadd;

@FindBy(css = ".ta-item.list-group-item.ng-star-inserted")
List<WebElement> countriesList;

@FindBy(css = ".ta-item.list-group-item.ng-star-inserted")
List<WebElement> countiesdropdown; 

@FindBy(css = ".form-group input")
WebElement countryletter;

//*****************************************************************************************************
//method1
public List<WebElement> verifyCartElements1() {
	return cart;
}
//*****************************************************************************************************
//method2
public boolean verifyCartElements(List<String> cartList) {
    boolean match =  cart.stream()
            .anyMatch(cartname -> cartList.contains(cartname.getText()));
    return match;
}
//********************************************************************************************************
//method 3
public void getpaymentpage() {
//	JavascriptExecutor js = ((JavascriptExecutor) driver);
	Actions a = new Actions(driver);
	a.moveToElement(paymentclk).click().build().perform();
}
//*********************************************************************************************************
//method 4

public List<WebElement> selectCountry(String letter) {
	countryletter.sendKeys(letter);
return countriesList;
}
//***********************************************************************************************************
//method 5
public Paymentpage addcountry() {

	WebElement india = countriesList.stream().filter(c -> c.getText().equals("India")).findFirst().orElse(null);
	Actions a = new Actions(driver);
	a.moveToElement(india).click().build().perform();
	Paymentpage pay = new Paymentpage(driver);
	return pay;
	
}
//***********************************************************************************************************
}