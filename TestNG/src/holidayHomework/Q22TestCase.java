package holidayHomework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 Test Case 22: Add to cart from Recommended items
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Scroll to bottom of page
4. Verify 'RECOMMENDED ITEMS' are visible
5. Click on 'Add To Cart' on Recommended product
6. Click on 'View Cart' button
7. Verify that product is displayed in cart page
 * */

public class Q22TestCase {
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
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// 2
		driver.get(url);
		
		// 3
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		// 4
		 WebElement recommendedItems = driver.findElement(By.xpath("//h2[text()='recommended items']"));
		if (recommendedItems.isDisplayed() == true) {
			System.out.println("'RECOMMENDED ITEMS' are visible");
		}
		
		String chosenDress = driver.findElement(By.xpath("(//h2[text()='Rs. 1000'])[7]")).getText();
		// 5
		driver.findElement(By.xpath("(//a[text()='Add to cart'])[71]")).click();
		
		// 6
		driver.findElement(By.xpath("//u[text()='View Cart']")).click();		
		String addedDress = driver.findElement(By.xpath("(//p[text()='Rs. 1000'])[1]")).getText();
		
		// 7
		if (chosenDress.equals(addedDress)) {
			System.out.println("Product is displayed in the cart.");
		}
		
		driver.close();
	}
}
