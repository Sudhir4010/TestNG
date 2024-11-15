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
import org.openqa.selenium.interactions.Actions;

///*
// Test Case 18: View Category Products
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that categories are visible on left side bar
//4. Click on 'Women' category
//5. Click on any category link under 'Women' category, for example: Dress
//6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
//7. On left side bar, click on any sub-category link of 'Men' category
//8. Verify that user is navigated to that category page
// * */
//
public class Q18TestCase {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse-Workbench\\TestNGGrooming\\testData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String mensCategory = prop.getProperty("mensCategory");

		// 1
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// 2
		driver.get(url);

		// 3
		List<WebElement> categories = driver.findElements(By.xpath("//div[@class='left-sidebar']//ul//li"));
		if (categories.size() > 0) {
			System.out.println("Categories are visible on the left sidebar.");

		// 4
		WebElement women = driver.findElement(By.xpath("//a[contains(@data-toggle,'collapse')]"));
		Actions act = new Actions(driver);			act.moveToElement(women).perform();
		js.executeScript("arguments[0].click();", women);
		// 5
		WebElement tops = driver.findElement(By.partialLinkText("TOPS"));
		js.executeScript("arguments[0].click();", tops);

		// 6
		WebElement title = driver.findElement(By.xpath("//h2[contains(@class,'title')]"));
		String titles = title.getText();
		if (titles.equalsIgnoreCase("WOMEN -  TOPS PRODUCTS")) {
			System.out.println("WOMEN -  TOPS PRODUCTS : It is displayed...");
			}
		}

		// 7
		WebElement tshirts = driver.findElement(By.xpath("//a[contains(.,'Tshirts ')]"));
		js.executeScript("arguments[0].click();", tshirts);

		// 8
		if (driver.getCurrentUrl().equals(mensCategory)) {
			System.out.println("MEN -  TSHIRTS PRODUCTS : It is displayed...");
		}

		driver.close();
	}
}
