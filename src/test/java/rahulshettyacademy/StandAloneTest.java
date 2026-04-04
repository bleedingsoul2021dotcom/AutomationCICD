package rahulshettyacademy;

import java.awt.Desktop.Action;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.Landingpage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {

		List<String> cartList = Arrays.asList("ADIDAS ORIGINAL", "ZARA COAT 3");
		
		

		// Login
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();
		
		
		
		
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.findElement(By.id("userEmail")).sendKeys("arjunvkakade@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Arjun@123");
		driver.findElement(By.id("login")).click();

	
//******************************************************************************************************
//            List<WebElement> products = driver.findElements(By.cssSelector(".mb-3 "));
//		
//WebElement prod =	products.stream().filter(s-> 
//		s.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
//		
//		driver.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		List<WebElement> matchedProducts = products.stream()
				.filter(product -> cartList.contains(product.findElement(By.cssSelector("b")).getText()))
				.collect(Collectors.toList());

		for (WebElement product : matchedProducts) {
			product.findElement(By.cssSelector(".btn.w-10.rounded")).click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("div[aria-label='Product Added To Cart']")));
			System.out.println(driver.findElement(By.cssSelector("div[aria-label='Product Added To Cart']")).getText());
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-tns-c31-0.ng-star-inserted")));

		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();

		List<WebElement> cart = driver.findElements(By.cssSelector(".cartSection h3"));

		// boolean match = cart.stream().anyMatch(cartname->
		// cartname.getText().equalsIgnoreCase(cartList)); for one cart element
		boolean match = cart.stream().anyMatch(cartname -> cartList.contains(cartname.getText()));
		Assert.assertTrue(match);
		// Thread.sleep(5000);

		JavascriptExecutor js = ((JavascriptExecutor) driver);

		// js.executeScript("document.scrollingElement.scrollBy(0,800)");
		// driver.findElement(By.cssSelector(".totalRow button")).click(); //use any
		// method

		Actions a = new Actions(driver);
		//a.sendKeys(webelement, "india") you can use
		a.moveToElement(driver.findElement(By.cssSelector(".totalRow button"))).click().build().perform();

		driver.findElement(By.cssSelector(".form-group input")).sendKeys("i");
		List<WebElement> con = driver.findElements(By.cssSelector(".ta-item.list-group-item.ng-star-inserted"));

		WebElement india = con.stream().filter(c -> c.getText().equals("India")).findFirst().orElse(null);

		a.moveToElement(india).click().build().perform();

		Select s = new Select(driver.findElement(By.cssSelector(".field.small select:first-of-type")));

		s.selectByIndex(5);

		Select s1 = new Select(driver.findElement(By.cssSelector(".field.small select:last-of-type")));

		s1.selectByIndex(10);

		driver.findElement(By.xpath("(//input[@class='input txt'])[1]")).sendKeys("366");
		driver.findElement(By.xpath("(//input[@class='input txt'])[2]")).sendKeys("Arjun v kakade");
		driver.findElement(By.xpath("(//input[@name='coupon'])")).sendKeys("rahulshettyacademy");

		driver.findElement(By.xpath("//button[text()='Apply Coupon']")).click();

		System.out.println(driver.findElement(By.xpath("//p[text()='* Coupon Applied']")).getText());

		driver.findElement(By.cssSelector(".actions a")).click();

		System.out.println(driver.findElement(By.cssSelector("h1[class='hero-primary']")).getText());
		String confirmmsg =  driver.findElement(By.cssSelector("h1[class='hero-primary']")).getText();
	  // Assert.assertEquals(driver.findElement(By.cssSelector("h1[class='hero-primary']"))
			//   .getText(), "THANKYOU FOR THE ORDER.");
     //or
	   Assert.assertTrue(confirmmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

}
