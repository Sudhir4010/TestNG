package testNGslisteners;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerImplementationClass.class)
public class TestScript {
	@Test
	public void login() {
		Reporter.log("launch the browser", true);
		Reporter.log("navigate to url", true);
		Reporter.log("click on login link", true);
		Reporter.log("Enter the valid credentials", true);
		Reporter.log("Verify home page is displayed", true);
		Reporter.log("Logout", true);
		Reporter.log("Close the browser", true);
		
		Assert.assertEquals(true, true);
	}
}
