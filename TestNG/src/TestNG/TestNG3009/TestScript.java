package TestNG.TestNG3009;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestScript extends BaseClass{
	@Test
	public void clickOnBooks() {
		driver.findElement(By.partialLinkText("BOOKS")).click();
		Reporter.log("Books page is displayed", true);
	}

	@Test
	public void clickOnElectronics() {
		driver.findElement(By.partialLinkText("ELECTRONICS")).click();
		Reporter.log("Electronics page displayed", true);
	}
}
