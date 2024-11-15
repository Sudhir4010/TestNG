package testNGslisteners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(DemoWebShopListenerClass.class)
public class DemoWebShopTestScript extends DemoWebShopBaseClass{
	@Test
	public void login() {
		Reporter.log("Click on login link", true);
		driver.findElement(By.linkText("Log in")).click();
		
		Reporter.log("Enter the valid credentials", true);
		driver.findElement(By.id("Email")).sendKeys("abhis1234@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("abhis@1234");
		
		Reporter.log("click on login button");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		Reporter.log("verifying the title", true);
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop ", "Home page not displlayed");
		Reporter.log("Home page is displayed", true);
	}
}
