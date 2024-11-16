package TestNG.Myntra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestScript extends BaseClass {
	// This will execute the testcase 3 times
	@Test(invocationCount = 3)
	public void hoverOnKids() {
		WebElement kids = driver.findElement(By.partialLinkText("KIDS"));

		Actions act = new Actions(driver);
		act.moveToElement(kids).perform();

		driver.findElement(By.partialLinkText("Ethnic Wear")).click();
	}

	@Test
	public void hoverOnMens() {
		WebElement links = driver.findElement(By.partialLinkText("MEN"));
	

		Actions act = new Actions(driver);
		act.moveToElement(links).perform();

		driver.findElement(By.partialLinkText("Jeans")).click();
	}
}
