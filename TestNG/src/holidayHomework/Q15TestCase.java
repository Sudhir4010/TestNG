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
 * Test Case 15: Place Order: Register before Checkout
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill all details in Signup and create account
6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
7. Verify ' Logged in as username' at top
8. Add products to cart
9. Click 'Cart' button
10. Verify that cart page is displayed
11. Click Proceed To Checkout
12. Verify Address Details and Review Your Order
13. Enter description in comment text area and click 'Place Order'
14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
15. Click 'Pay and Confirm Order' button
16. Verify success message 'Your order has been placed successfully!'
17. Click 'Delete Account' button
18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
 * */
public class Q15TestCase {
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// 2
		driver.get(url);

		// 3
		if (driver.getCurrentUrl().equals(url)) {
			System.out.println("Home Page Displayed...");
		} else {
			System.out.println("Home Page not displayed...");
		}

		driver.findElement(By.xpath("//a[contains(@href,'/login')]")).click();

		String name = prop.getProperty("name");
		String email = prop.getProperty("email");
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);

		// 4
		driver.findElement(By.xpath("//button[text()='Signup']")).click();

		boolean accountInformation = driver.findElement(By.xpath("//b[text()='Enter Account Information']"))
				.isDisplayed();
		System.out.println("Verify that 'ENTER ACCOUNT INFORMATION' is visible : " + accountInformation);
		
		// 5
		driver.findElement(By.id("id_gender1")).click();
		String password = prop.getProperty("password");
		driver.findElement(By.id("password")).sendKeys(password);
		WebElement day = driver.findElement(By.id("days"));
		WebElement months = driver.findElement(By.id("months"));
		WebElement year = driver.findElement(By.id("years"));

		js.executeScript("arguments[0].value='19'", day);
		js.executeScript("arguments[0].value='6'", months);
		js.executeScript("arguments[0].value='2002'", year);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Sign up for our newsletter!']/..//input[@value='1']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Receive special offers from our partners!']")).click();
		String firstName = prop.getProperty("firstName");
		String lastName = prop.getProperty("lastName");
		String company = prop.getProperty("company");
		String Adress = prop.getProperty("Adress");
		String Adress2 = prop.getProperty("Adress2");
		String State = prop.getProperty("State");
		String City = prop.getProperty("City");
		String zipcode = prop.getProperty("zipcode");
		String mobileNumber = prop.getProperty("mobileNumber");

		driver.findElement(By.id("first_name")).sendKeys(firstName);
		driver.findElement(By.id("last_name")).sendKeys(lastName);
		driver.findElement(By.id("company")).sendKeys(company);
		driver.findElement(By.id("address1")).sendKeys(Adress);
		driver.findElement(By.id("address2")).sendKeys(Adress2);
		driver.findElement(By.id("state")).sendKeys(State);
		driver.findElement(By.id("city")).sendKeys(City);
		driver.findElement(By.id("zipcode")).sendKeys(zipcode);
		driver.findElement(By.id("mobile_number")).sendKeys(mobileNumber);
		driver.findElement(By.xpath("//button[text()='Create Account']")).click();

		// 6
		boolean accountCreated = driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed();
		System.out.println("Verify that 'ACCOUNT CREATED!' is visible : " + accountCreated);
		driver.findElement(By.linkText("Continue")).click();

		// 7
		boolean usernameVisible = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed();
		System.out.println("Verify that 'Logged in as username' is visible : " + usernameVisible);

		// 8
		WebElement itmes = driver.findElement(By.xpath("(//p[text()='Blue Top'])[1]"));
		WebElement addToCartBTN = driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]"));

		js.executeScript(
				"var evt = new MouseEvent('mousedown', { bubbles: true, cancelable: true }); arguments[0].dispatchEvent(evt);",
				itmes);

		js.executeScript(
				"var evt = new MouseEvent('click', { bubbles: true, cancelable: true }); arguments[0].dispatchEvent(evt);",
				addToCartBTN);

		driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();

		// 9
		WebElement cart = driver.findElement(By.xpath("//a[contains(text(),'Cart')]"));
		cart.click();

		// 10
		if (driver.getCurrentUrl().equals(cartUrl)) {
			System.out.println("cart page is displayed");
		}

		// 11
		WebElement checkOut = driver.findElement(By.linkText("Proceed To Checkout"));
		checkOut.click();

		// 12
		driver.findElement(By.name("message")).sendKeys(prop.getProperty("message"));

		// 13 
		driver.findElement(By.linkText("Place Order")).click();

		// 14
		driver.findElement(By.name("name_on_card")).sendKeys(prop.getProperty("name"));
		driver.findElement(By.name("card_number")).sendKeys(prop.getProperty("cardNumber"));
		driver.findElement(By.name("cvc")).sendKeys(prop.getProperty("cvc"));
		driver.findElement(By.name("expiry_month")).sendKeys(prop.getProperty("month"));
		driver.findElement(By.name("expiry_year")).sendKeys(prop.getProperty("year"));
		
		// 15
		WebElement confirmOrder = driver.findElement(By.xpath("//button[text()='Pay and Confirm Order']"));
		js.executeScript("arguments[0].click();", confirmOrder);

		// 16
		System.out.println(driver.findElement(By.xpath("(//div[contains(@class,'alert')])[1]")).getText());

		// 17
		driver.findElement(By.xpath("//a[contains(text(),' Delete Account')]")).click();

		// 18
		boolean accountDeleted = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed();
		System.out.println("Verify that 'ACCOUNT DELETED!' is visible : " + accountDeleted);

		driver.quit();
	}

}
