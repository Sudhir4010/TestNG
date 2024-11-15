package testNGslisteners.Assignments.DemoWebShop;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(ListenerImplementationClass.class)
public class TestScript1 extends BaseClass{
	@Test(description = "verify user is able to click on books link")
	public void clickOnBooks() {
		HomePage hp = new HomePage(driver);
		
		hp.getBooksLink().click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/books", "Books Page not displayed");
		Reporter.log("Books page displayed");
	}
}
