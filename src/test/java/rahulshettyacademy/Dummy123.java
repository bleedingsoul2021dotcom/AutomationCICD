package rahulshettyacademy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dummy123 {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement table = driver.findElement(By.cssSelector("#product:nth-child(2)"));
		System.out.println(table.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).get(1).getText());

		WebElement table1 = driver.findElement(By.cssSelector(".tableFixHead"));
		System.out.println(table1.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).get(2).getText());
		
		
	}
	
	
}