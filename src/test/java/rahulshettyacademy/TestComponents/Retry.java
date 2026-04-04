package rahulshettyacademy.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Retry implements IRetryAnalyzer {
	//to run failed tests n number of times to confirm
    //call inside methods (retryanalyser = path of this class)
	
	int count = 0;
	int maxTry = 1;
	@Override
	public boolean retry(ITestResult result) {
		if(count < maxTry) {
			count++;
			return true;
		}
		return false;
	}  
}

       