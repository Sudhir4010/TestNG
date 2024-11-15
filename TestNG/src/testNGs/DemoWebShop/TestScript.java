package testNGs.DemoWebShop;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestScript extends BaseClass {
	@Test
	public void clickOnBooks() {
		driver.findElement(By.partialLinkText("BOOKS")).click();

		String expectedTitle = workbook.getSheet("Sheet2").getRow(1).getCell(0).getStringCellValue();

		String actualTitle = driver.getTitle();

		if (actualTitle.equals(expectedTitle)) {
			Reporter.log("Books page displayed", true);
		} else {
			Reporter.log("Books page not displayed", true);
		}
	}
}
