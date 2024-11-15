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
 * Test Case 16: Place Order: Login before Checkout
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill email, password and click 'Login' button
6. Verify 'Logged in as username' at top
7. Add products to cart
8. Click 'Cart' button
9. Verify that cart page is displayed
10. Click Proceed To Checkout
11. Verify Address Details and Review Your Order
12. Enter description in comment text area and click 'Place Order'
13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
14. Click 'Pay and Confirm Order' button
15. Verify success message 'Your order has been placed successfully!'
16. Click 'Delete Account' button
17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
 * */
public class Q16TestCase {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse-Workbench\\TestNGGrooming\\testData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String cartUrl = prop.getProperty("cartUrl");
		String email = prop.getProperty("email");
		String password = prop.getProperty("password");

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
		driver.findElement(By.xpath("//a[contains(@href,'/login')]")).click();
		WebElement loginText = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
		System.out.println(loginText.isDisplayed());

		// 5
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();

		// 6
		boolean usernameVisible = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed();
		System.out.println("Verify that 'Logged in as username' is visible : " + usernameVisible);

		// 7
		WebElement itmes = driver.findElement(By.xpath("(//p[text()='Blue Top'])[1]"));
		WebElement addToCartBTN = driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]"));

		js.executeScript(
				"var evt = new MouseEvent('mousedown', { bubbles: true, cancelable: true }); arguments[0].dispatchEvent(evt);",
				itmes);

		js.executeScript(
				"var evt = new MouseEvent('click', { bubbles: true, cancelable: true }); arguments[0].dispatchEvent(evt);",
				addToCartBTN);

		driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();

		// 8
		WebElement cart = driver.findElement(By.xpath("//a[contains(text(),'Cart')]"));
		cart.click();

		// 9
		if (driver.getCurrentUrl().equals(cartUrl)) {
			System.out.println("cart page is displayed");
		}

		// 10
		WebElement checkOut = driver.findElement(By.linkText("Proceed To Checkout"));
		checkOut.click();

		// 11
		driver.findElement(By.name("message")).sendKeys(prop.getProperty("message"));

		// 12
		driver.findElement(By.linkText("Place Order")).click();

		// 13
		driver.findElement(By.name("name_on_card")).sendKeys(prop.getProperty("name"));
		driver.findElement(By.name("card_number")).sendKeys(prop.getProperty("cardNumber"));
		driver.findElement(By.name("cvc")).sendKeys(prop.getProperty("cvc"));
		driver.findElement(By.name("expiry_month")).sendKeys(prop.getProperty("month"));
		driver.findElement(By.name("expiry_year")).sendKeys(prop.getProperty("year"));
		
		// 14
		WebElement confirmOrder = driver.findElement(By.xpath("//button[text()='Pay and Confirm Order']"));
		js.executeScript("arguments[0].click();", confirmOrder);

		/// 15
		System.out.println(driver.findElement(By.xpath("(//div[contains(@class,'alert')])[1]")).getText());

		// 16
		driver.findElement(By.xpath("//a[contains(text(),' Delete Account')]")).click();

		// 17
		boolean accountDeleted = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed();
		System.out.println("Verify that 'ACCOUNT DELETED!' is visible : " + accountDeleted);

		driver.close();

	}
}
