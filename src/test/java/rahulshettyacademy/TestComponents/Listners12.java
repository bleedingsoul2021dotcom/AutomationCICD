package rahulshettyacademy.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulshettyacademy.resources.ExtentreporterNG;


public class Listners12 extends BaseTest implements ITestListener  {
	ExtentTest test;
	
	
	ExtentReports  extent = ExtentreporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //to avoid Over riding in parallel tests
	
	  public void onTestStart(ITestResult result) {
		     test =   extent.createTest(result.getMethod().getMethodName());
		     extentTest.set(test); //it has a unique test id(Error validation test)
	  }

	
	 public void onTestSuccess(ITestResult result) {
		 extentTest.get().log(Status.PASS, "test passed");
	  }

	 
	 public void onTestFailure(ITestResult result) {
		 //test.get().fail(result.getThrowable()); without thread safety
		 extentTest.get().fail(result.getThrowable());
	          //screenshot and attach it to failure
	          
	          try {
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        		  
	     String Filepath = null;
		try {
			Filepath = getScreenshot(result.getMethod().getMethodName()+System.currentTimeMillis(),driver); //System.currentTimeMillis(); makes its unique and give both screeenshots
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(Filepath, result.getMethod().getMethodName());      
	  }

	 
	 public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	  
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	
	 public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	  
	 public void onStart(ITestContext context) {
	    // not implemented
	  }

	  
	 public void onFinish(ITestContext context) {
	    extent.flush();
	  }
	}

	
	
	
	
	
	


