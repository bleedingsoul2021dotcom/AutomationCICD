package rahulshettyacademy.pageobjects;

//import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import rahulshettyacademy.Abstractcomponenets.Abstractcomponent;

public class Paymentpage extends Abstractcomponent {
	
	WebDriver driver;
	
	public Paymentpage(WebDriver driver){
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//****************************************************************************************************
//driver 1
@FindBy(css = ".field.small select:first-of-type")
WebElement paymentcard;

@FindBy(css = ".field.small select:last-of-type")
WebElement paymentcard1;

@FindBy(xpath = "(//input[@class='input txt'])[1]")        
WebElement cvvcode;

@FindBy(xpath = "(//input[@class='input txt'])[2]")
WebElement cardname;

@FindBy(xpath = "(//input[@name='coupon'])")
WebElement coupon;

@FindBy(xpath = "//button[text()='Apply Coupon']")
WebElement coupounclk;

@FindBy(xpath = "//p[text()='* Coupon Applied']")
WebElement gettextcopoun;

@FindBy(css = ".actions a")
WebElement placeorder;

@FindBy(css = "h1[class='hero-primary']")
WebElement ordermsg;


//*****************************************************************************************************	
//method 1
	public void payment() {
		
		Select s = new Select(paymentcard);
		s.selectByIndex(5);

		Select s1 = new Select(paymentcard1);
		s1.selectByIndex(10);
		
	}	
//****************************************************************************************************
//method 2
	public void cardcvvcode(String code,String name,String coupon1) {
		
      cvvcode.sendKeys(code);
      cardname.sendKeys(name);
      coupon.sendKeys(coupon1);
      coupounclk.click();
      System.out.println(gettextcopoun.getText());
      placeorder.click();
		}
//***************************************************************************************************
//method 3
     public String orderdetails() {
    	 System.out.println(ordermsg.getText());
    	String confirmmsg = ordermsg.getText();
    	return confirmmsg;
    	//Assert.assertTrue(confirmmsg.equalsIgnoreCase(expected));
     }
	}