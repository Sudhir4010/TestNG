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
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 Test Case 17: Remove Products From Cart
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click 'X' button corresponding to particular product
8. Verify that product is removed from the cart
 * */
public class Q17TestCase {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse-Workbench\\TestNGGrooming\\testData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String cartUrl = prop.getProperty("cartUrl");

		// 1
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		new WebDriverWait(driver, Duration.ofSeconds(20));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// 2
		driver.get(url);

		// 3
		if (driver.getCurrentUrl().equals(url)) {
			System.out.println("Home Page Displayed...");
		} else {
			System.out.println("Home Page not displayed...");
		}

		// 4
		WebElement itmes = driver.findElement(By.xpath("(//p[text()='Blue Top'])[1]"));
		WebElement addToCartBTN = driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]"));

		js.executeScript(
				"var evt = new MouseEvent('mousedown', { bubbles: true, cancelable: true }); arguments[0].dispatchEvent(evt);",
				itmes);

		js.executeScript(
				"var evt = new MouseEvent('click', { bubbles: true, cancelable: true }); arguments[0].dispatchEvent(evt);",
				addToCartBTN);

		driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();

		// 5
		WebElement cart = driver.findElement(By.xpath("//a[contains(text(),'Cart')]"));
		cart.click();

		// 6
		if (driver.getCurrentUrl().equals(cartUrl)) {
			System.out.println("cart page is displayed");
		}
		
		// 7
		WebElement removeFromCart = driver.findElement(By.xpath("//i[contains(@class,'fa fa-times')]"));
		removeFromCart.click();
		
		Thread.sleep(5000);
		
		// 8
		WebElement text = driver.findElement(By.xpath("//b[text()='Cart is empty!']"));
		String originalText = text.getText();
		
		if(originalText.contentEquals("Cart is empty!")) {
			System.out.println("Cart is empty");
		}
		
		driver.close();
	}
}
