package testNGslisteners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplementationClass implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("Test Script failed", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test Script passed ", true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test Script passed ", true);
	}
	
}
