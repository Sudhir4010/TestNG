package TestNG;


import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo {
	
	@BeforeSuite
	public void bs() {
		Reporter.log("@BeforeSuite", true);
	}
	
	@BeforeTest
	public void bt() {
		Reporter.log("@BeforeTest", true);
	}
	
	@BeforeClass
	public void bc() {
		Reporter.log("@BeforeClass", true);
	}
	
	@BeforeMethod
	public void bm() {
		Reporter.log("@BeforeMethod", true);
	}
	
	@Test
	public void test1() 
	{
		Reporter.log("@Test", true);
	}
	
	@Test
	public void  test2() {
		Reporter.log("@test2", true);
	}
	
	@AfterMethod
	public void am() {
		Reporter.log("@AfterMethod", true);
	}
	
	@AfterClass
	public void ac() {
		Reporter.log("@AfterClass", true);
	}
	
	@AfterTest
	public void at() {
		Reporter.log("@AfterTest", true);
	}
	
	@AfterSuite
	public void as() {
		Reporter.log("@AfterSuite", true);
	}
}
