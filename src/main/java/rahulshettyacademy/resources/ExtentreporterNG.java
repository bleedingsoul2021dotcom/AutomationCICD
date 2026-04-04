package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreporterNG {

	public static ExtentReports getReportObject() {

		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results"); // report name
		reporter.config().setDocumentTitle("Test Results"); // document title

		ExtentReports extent = new ExtentReports(); // main class
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rahul shetty");
		extent.createTest(path);
		return extent;

	}

}
