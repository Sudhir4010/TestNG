package holidayHomework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Test Case 4: Logout User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page
 * */
public class Q04TestCase {
	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse-Workbench\\TestNGGrooming\\testData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String email = prop.getProperty("email");
		String password = prop.getProperty("password");
		String loginUrl = prop.getProperty("loginUrl");

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

		// 4
		driver.findElement(By.xpath("//a[contains(@href,'/login')]")).click();

		// 5
		WebElement loginText = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
		System.out.println(loginText.isDisplayed());

		// 6
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);

		// 7
		driver.findElement(By.xpath("//button[text()='Login']")).click();

		// 8
		boolean usernameVisible = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed();
		System.out.println("Verify that 'Logged in as username' is visible : " + usernameVisible);
		
		// 9
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		
		// 10
		if (driver.getCurrentUrl().equals(loginUrl)) {
			System.out.println("User navigated to the login page.");
		}else {
			System.out.println("Not on the login page");
		}
		
		driver.quit();
	}
}
