package rahulshettyacademy.pageobjects;

//import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponenets.Abstractcomponent;

public class Landingpage extends Abstractcomponent {

	WebDriver driver;

	// constructor is first thing to execute
	public Landingpage(WebDriver driver) { // create object of this class in standAloneTest
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // so that findby know about driver
	}

	// WebElement username = driver.findElement(By.id("userEmail")); use findby
	// shortcut and avoid driver line
	// pageFactory

//driver call	
	@FindBy(id = "userEmail") // no semicolon here
	WebElement useremail;

	@FindBy(id = "userPassword")
	WebElement password1;

	@FindBy(id = "login")
	WebElement submit;
				
	@FindBy(css ="[class*='flyInOut']")
	WebElement errorlogin;
	//div[@class='ng-tns-c4-10 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error']
//***************************************************************************************************
	
	
//method 1

	public Productcatalogue logininApplication(String email, String password) {
		useremail.sendKeys(email);
		password1.sendKeys(password);
		submit.click();
		Productcatalogue ca = new Productcatalogue(driver);
		return ca;
		
	}
	
	public String getErrorMessage() {
		waitForWebElementToappear(errorlogin);
		return errorlogin.getText();
		
	}
//*******************************************************************************************************
//method 2	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}

}
