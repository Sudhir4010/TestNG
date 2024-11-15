package testNGs.DemoAppSkillRaryCrossBrowser;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestScript extends BaseClass {
	@Test
	public void SalesLink() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(.,'Sales')]")).click();
		
		Thread.sleep(5000);
		
		String expectedURL = workbook.getSheet("Sheet3").getRow(1).getCell(0).getStringCellValue();
		
		Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Sales link not displayed");
	}

}
