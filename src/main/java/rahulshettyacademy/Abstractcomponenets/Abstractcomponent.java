package rahulshettyacademy.Abstractcomponenets;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.Checkoutpage;
import rahulshettyacademy.pageobjects.OrderHistorypage;

public class Abstractcomponent {
	WebDriver driver;
	
	
	public Abstractcomponent(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
//***************************************************************************************************
	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cartdash;
	
	@FindBy(css = "button[routerlink='/dashboard/myorders']")
	WebElement orderdash;
//******************************************************************************************************

//method 1
public void waitForElementToAppear(By FindBy) {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
     wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
}
//************************************************************************************
//method 2
public void waitForElementToDisappear(By FindBy) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
	wait.until(ExpectedConditions.invisibilityOfElementLocated(FindBy));
}
//**************************************************************************************
//method 3
public void waitForWebElementToappear(WebElement FindBy) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
	wait.until(ExpectedConditions.visibilityOf(FindBy));
	}

//***************************************************************************************

public Checkoutpage goTocartPage() {
	cartdash.click();
  Checkoutpage p = new Checkoutpage(driver);
   	 return p;
	
}
public OrderHistorypage goToOrderHistory() {
	orderdash.click();
  OrderHistorypage O = new OrderHistorypage(driver);
   	 return O;









}

}