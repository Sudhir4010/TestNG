package ConfigurationAnnotation;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeSuiteExample {
	
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("BS executed", true);
	}
	
	@BeforeTest
	public void beforeTest() {
		Reporter.log("BT executed", true);
	}
	
	@Test
	public void demo(){
		Reporter.log("Test executed", true);
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("AT executed", true);
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("AS executed", true);
	}
}
