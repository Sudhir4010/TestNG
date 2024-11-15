package testNGslisteners;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class DemoWebShopListenerClass extends DemoWebShopBaseClass implements ITestListener {

	
	@Override
	public void onTestFailure(ITestResult result) {
		String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		String methodName = result.getName();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/" + methodName +  timeStamp + ".png"  );
		
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Reporter.log("Test Script failed", true);
	}

//	@Override
//	public void onTestSuccess(ITestResult result) {
//		Reporter.log("Test Script passed ", true);
//	}
//
//	@Override
//	public void onTestSkipped(ITestResult result) {
//		Reporter.log("Test Script passed ", true);
//	}
	
}
