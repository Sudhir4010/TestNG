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
public class TestScript3 extends BaseClass {
	@Test(description = "verify user is able to click on electronics link")
	public void clickOnElectronicsLink() {
		HomePage hp = new HomePage(driver);
		hp.getElectronicsLink().click();

		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/electronics", "Electronics page not displayed");
		Reporter.log("Electronics page displayed", true);
	}
}
