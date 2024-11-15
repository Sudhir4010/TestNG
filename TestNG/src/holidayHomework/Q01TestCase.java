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
 * Test Case 1: Register User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
 * */

public class Q01TestCase {
	public static void main(String[] args) throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse-Workbench\\TestNGGrooming\\testData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		prop.getProperty("name");

		// 1 Launch browser
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// 2 Navigate to url 'http://automationexercise.com'
		driver.get(url); 

		// 3 Verify that home page is visible successfully
		if (driver.getCurrentUrl().equals(url)) {
			System.out.println("Home Page Displayed...");
		} else {
			System.out.println("Home Page not displayed...");
		}

		// 4 Click on 'Signup / Login' button
		driver.findElement(By.xpath("//a[contains(@href,'/login')]")).click();

		// 5 Verify 'New User Signup!' is visible
		boolean newUserSignUP = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
		System.out.println("Verify 'New User Signup!' is visible : " + newUserSignUP);

		// 6 Enter name and email address
		String name = prop.getProperty("name");
		String email = prop.getProperty("email");
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);

		// 7 Click 'Signup' button
		driver.findElement(By.xpath("//button[text()='Signup']")).click();

		// 8
		boolean accountInformation = driver.findElement(By.xpath("//b[text()='Enter Account Information']"))
				.isDisplayed();
		System.out.println("Verify that 'ENTER ACCOUNT INFORMATION' is visible : " + accountInformation);

		// 9
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
		// 10
		driver.findElement(By.xpath("//label[text()='Sign up for our newsletter!']/..//input[@value='1']")).click();

		// 11
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Receive special offers from our partners!']")).click();
		
		// 12
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
		
		
		//13
		driver.findElement(By.xpath("//button[text()='Create Account']")).click();
		
		//14
		boolean accountCreated = driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed();
		System.out.println("Verify that 'ACCOUNT CREATED!' is visible : " + accountCreated);
		
		//15
		driver.findElement(By.linkText("Continue")).click();
		
		//16
		boolean usernameVisible = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed();
		System.out.println("Verify that 'Logged in as username' is visible : " + usernameVisible);
		
		//17
//		driver.findElement(By.xpath("//a[contains(text(),' Delete Account')]")).click();
		
		//18
//		boolean accountDeleted = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed();
//		System.out.println("Verify that 'ACCOUNT DELETED!' is visible : " + accountDeleted);
//		driver.findElement(By.xpath("//a[text()='Continue']")).click();

		driver.quit();
	}
}
