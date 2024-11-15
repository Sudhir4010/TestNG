package holidayHomework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 Test Case 19: View & Cart Brand Products
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify that Brands are visible on left side bar
5. Click on any brand name
6. Verify that user is navigated to brand page and brand products are displayed
7. On left side bar, click on any other brand link
8. Verify that user is navigated to that brand page and can see products
 * */

public class Q19TestCase {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse-Workbench\\TestNGGrooming\\testData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		// 1
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// 2
		driver.get(url);
		
		// 3
		driver.findElement(By.partialLinkText(" Products")).click();
		
		// 4
		List<WebElement> brands = driver.findElements(By.xpath("//h2[text()='Brands']"));
		if(brands.size() > 0) {
			System.out.println("Brands is visible on the left side.");
		}
		
		//5
		WebElement brand = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("POLO")));
		js.executeScript("arguments[0].click();", brand);
		
		// 6
		WebElement brandAfterClick = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("POLO")));
		if (brandAfterClick.isDisplayed()) {
		    System.out.println("User is navigated to the brand page...");
		} else {
		    System.out.println("Brand is not displayed.");
		}
		
		// 7
		WebElement brand2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("H&M")));
		js.executeScript("arguments[0].click();", brand2);
		
		// 8
		WebElement brandAfterClick2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("H&M")));
		if (brandAfterClick2.isDisplayed()) {
			System.out.println("User is navigated to the brand page...");
		} else {
			System.out.println("Brand is not displayed.");
		}
		
		driver.close();
	}

}
