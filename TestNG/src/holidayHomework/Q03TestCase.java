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
 Test Case 3: Login User with incorrect email and password
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter incorrect email address and password
7. Click 'login' button
8. Verify error 'Your email or password is incorrect!' is visible
 * */
public class Q03TestCase{
	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse-Workbench\\TestNGGrooming\\testData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String email = prop.getProperty("email");
		String password = prop.getProperty("password");

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
		System.out.println("Login to your account : " + loginText.isDisplayed());
		
		// 6 
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		
		// 7
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		// 8
		WebElement incorrectText = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));
		System.out.println(incorrectText.isDisplayed());
		
		driver.quit();
	}
}
