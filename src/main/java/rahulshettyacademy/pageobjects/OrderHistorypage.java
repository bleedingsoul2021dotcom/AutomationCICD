package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponenets.Abstractcomponent;

public class OrderHistorypage extends Abstractcomponent {
	WebDriver driver;
	public OrderHistorypage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//****************************************************************************************************
@FindBy (xpath = "//td[2]")            //(css = "tr td:nth-child(3)")
List<WebElement> ordernames;
//***************************************************************************************************
     public List<WebElement> ordersList() {
    	return ordernames;
	}
//*************************************************************************************************	
	public boolean verifyOrdername(List<String> cartList) {
	boolean match1 = ordernames.stream().anyMatch(orderitem -> cartList.contains(orderitem.getText()));
	return match1;
	}
}
