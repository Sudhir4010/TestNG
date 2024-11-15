package holidayHomework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 Test Case 13: Verify Product quantity in Cart
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'View Product' for any product on home page
5. Verify product detail is opened
6. Increase quantity to 4
7. Click 'Add to cart' button
8. Click 'View Cart' button
9. Verify that product is displayed in cart page with exact quantity
 * */

public class Q13TestCase {
	public static void main(String[] args) throws IOException, InterruptedException, ElementClickInterceptedException {
		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse-Workbench\\TestNGGrooming\\testData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String productDetailPage = prop.getProperty("productDetailPage");
		String itemsToAdd = prop.getProperty("itemsToAdd");

		// 1
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// 2
		driver.get(url);

		// 3
		if (driver.getCurrentUrl().equals(url)) {
			System.out.println("Home Page Displayed...");
		} else {
			System.out.println("Home Page not displayed...");
		}

		Thread.sleep(9000);
		// 4

		WebElement viewProduct = driver.findElement(By.xpath("(//a[text()='View Product'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", viewProduct);

		// 5
		if (driver.getCurrentUrl().equals(productDetailPage)) {
			System.out.println("product detail is opened ");
		}

		// 6
		WebElement quantity = driver.findElement(By.id("quantity"));
		quantity.clear();
		quantity.sendKeys(itemsToAdd);

		// 7
		WebElement addTocartBTN = driver.findElement(By.xpath("//button[contains(@type,'button')]"));
		js.executeScript("arguments[0].click();", addTocartBTN);

		// 8
		WebElement viewCart = driver.findElement(By.xpath("//u[text()='View Cart']"));
		viewCart.click();

		// 9
		WebElement totalQuantity = driver.findElement(By.xpath("//td[@class='cart_product']/following-sibling::td[3]"));
		String originalCount = totalQuantity.getText();

		if (originalCount.contentEquals(itemsToAdd)) {
			System.out.println("product is displayed in cart page with exact quantity.");
		}
		driver.quit();
	}
}
