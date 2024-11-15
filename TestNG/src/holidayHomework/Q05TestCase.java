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
Test Case 5: Register User with existing email
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
 * */


public class Q05TestCase {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse-Workbench\\TestNGGrooming\\testData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String name = prop.getProperty("name");
		String email = prop.getProperty("email");

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
		boolean newUserSignUP = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
		System.out.println("Verify 'New User Signup!' is visible : " + newUserSignUP);
		
		// 6 
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);
		
		// 7
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		
		// 8
		WebElement alreadyRegistered = driver.findElement(By.xpath("//p[text()='Email Address already exist!']"));
		System.out.println(alreadyRegistered.isDisplayed());

		driver.quit();
	}
}
