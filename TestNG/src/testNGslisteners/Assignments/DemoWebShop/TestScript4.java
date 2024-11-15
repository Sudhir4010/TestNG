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
public class TestScript4 extends BaseClass {
	@Test(description = "verify user is able to click on electronics link")
	public void clickOnElectronicsLink() {
		HomePage hp = new HomePage(driver);
		hp.getGiftCardsLink().click();

		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/gift-card", "Gift Cards page not displayed");
		Reporter.log("Gift Cards page displayed", true);
	}
}
