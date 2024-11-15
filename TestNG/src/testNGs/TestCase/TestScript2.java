package testNGs.TestCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestScript2 extends BaseClass{
	@Test
	public void check() {
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed());
		Reporter.log("logged in as username visble",true);		
	}
}
