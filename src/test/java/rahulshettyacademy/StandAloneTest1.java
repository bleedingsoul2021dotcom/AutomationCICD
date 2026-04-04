package rahulshettyacademy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest1 {

	public static void main(String[] args) {
		
	 //String[] cart = {"ADIDAS ORIGINAL","ZARA COAT 3"};

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
		// Add to cart

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("document.scrollingElement.scrollBy(0,300)");
		
		//List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));
	
		
		
	//WebElement prod = 	items.stream().filter(s->
	          //  s.findElement(By.tagName("b")).getText().contains("AUTOMATION 8","ZARA COAT 3")).findFirst().orElse(null);

		
	
			//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
int j = 0;
		String []cart = {"ADIDAS ORIGINAL","ZARA COAT 3"};
			
		List<WebElement> items = driver.findElements(By.cssSelector(".mb-3 b"));
		
		
		for(int i =0 ; i<items.size(); i++) {
		
			String name = items.get(i).getText();
			
			for(String expected : cart) {
				 
			if(name.equalsIgnoreCase(expected)) {
		driver.findElements(By.cssSelector("button[class='btn w-10 rounded']")).get(i).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-tns-c31-0.ng-star-inserted")));
		j++;
		break;		
					}
		}
			if(j==cart.length)	{
				break;
			}	
		}
		
		


	

				
				
			
		
			
			
				
			}

		


}

