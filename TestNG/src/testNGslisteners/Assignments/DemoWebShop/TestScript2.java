package testNGslisteners.Assignments.DemoWebShop;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

//@Listeners(ListenerImplementationClass.class)
public class TestScript2 extends BaseClass{
	@Test(description = "verify user is able to click on computers link")
	public void clickOnComputersLink() {
		HomePage hp = new HomePage(driver);
		hp.getComputerLink().click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/computer", "Computers page not displayed");
		Reporter.log("Computers page displayed", true);
	}
}
