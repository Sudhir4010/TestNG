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
import org.openqa.selenium.interactions.Actions;

/**
 * Test Case 23: Verify address details in checkout page 
 * 1. Launch browser 
 * 2. Navigate to url 'http://automationexercise.com' 
 * 3. Verify that home page is visible successfully 
 * 4. Click 'Signup / Login' button 
 * 5. Fill all details in Signup and create account 
 * 6. Verify 'ACCOUNT CREATED!' and click 'Continue' button 
 * 7. Verify ' Logged in as username' at top 
 * 8. Add products to cart 
 * 9. Click 'Cart' button 
 * 10. Verify that cart page is displayed 
 * 11. Click Proceed To Checkout 
 * 12. Verify that the delivery address is same address filled at
 * the time registration of account 
 * 13. Verify that the billing address is same
 * address filled at the time registration of account 
 * 14. Click 'Delete Account' button 
 * 15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
 */
public class Q23TestCase {
	public static void main(String[] args) throws InterruptedException, IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse-Workbench\\TestNGGrooming\\testData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		prop.getProperty("name");
		String cartUrl = prop.getProperty("cartUrl");

		WebDriver driver = new ChromeDriver(); // 1
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url); // 2

		// 3
		if (driver.getCurrentUrl().equals(url)) {
			System.out.println("Home Page Displayed...");
		} else {
			System.out.println("Home Page not displayed...");
		}

		// 4
		driver.findElement(By.xpath("//a[contains(@href,'/login')]")).click();

		// 5
		String name = prop.getProperty("name");
		String email = prop.getProperty("email");
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		boolean accountInformation = driver.findElement(By.xpath("//b[text()='Enter Account Information']"))
				.isDisplayed();
		System.out.println("Verify that 'ENTER ACCOUNT INFORMATION' is visible : " + accountInformation);
		driver.findElement(By.id("id_gender1")).click();
		String password = prop.getProperty("password");
		driver.findElement(By.id("password")).sendKeys(password);
		WebElement day = driver.findElement(By.id("days"));
		WebElement months = driver.findElement(By.id("months"));
		WebElement year = driver.findElement(By.id("years"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='19'", day);
		js.executeScript("arguments[0].value='6'", months);
		js.executeScript("arguments[0].value='2002'", year);
		Thread.sleep(3000);
		WebElement newsletter = driver
				.findElement(By.xpath("//label[text()='Sign up for our newsletter!']/..//input[@value='1']"));
		Actions act = new Actions(driver);
		act.moveToElement(newsletter).click().perform();
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

		String originalAdress = Adress + Adress2;
		// 12

		System.out.println(originalAdress);

		String a2 = driver.findElement(By.xpath("(//li[@class='address_address1 address_address2'])[2]")).getText();
		String a3 = driver.findElement(By.xpath("(//li[@class='address_address1 address_address2'])[3]")).getText();

		String deliveryAdress = a2 + a3;
		System.out.println(deliveryAdress);

		if (originalAdress.equals(deliveryAdress)) {
			System.out.println("delivery address is same address filled at the time registration of account");
		}

		// 13
		String b2 = driver.findElement(By.xpath("(//li[@class='address_address1 address_address2'])[5]")).getText();
		String b3 = driver.findElement(By.xpath("(//li[@class='address_address1 address_address2'])[6]")).getText();

		String billingAdress = b2 + b3;
		System.out.println(billingAdress);
		if (originalAdress.equals(billingAdress)) {
			System.out.println("billing address is same address filled at the time registration of account");
		}

		// 14 
		driver.findElement(By.xpath("//a[contains(text(),' Delete Account')]")).click();

		// 15
		boolean accountDeleted = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed();
		System.out.println("Verify that 'ACCOUNT DELETED!' is visible : " + accountDeleted);

		driver.close();
	}

}
