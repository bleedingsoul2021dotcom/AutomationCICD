package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber",glue = "rahulshettyacademy.stepDefinitions",
monochrome = true,tags = "@Regression",plugin= {"html:target/cucumber.html"})  //report in html 
public class TestNGTestRunner extends AbstractTestNGCucumberTests {  //only by extends it understands testNg
	

}
