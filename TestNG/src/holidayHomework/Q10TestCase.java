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
 Test Case 10: Verify Subscription in home page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down to footer
5. Verify text 'SUBSCRIPTION'
6. Enter email address in input and click arrow button
7. Verify success message 'You have been successfully subscribed!' is visible
 * */

public class Q10TestCase {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse-Workbench\\TestNGGrooming\\testData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String compareChar = prop.getProperty("compareChar");
		String email = prop.getProperty("email");
		
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		
		// 5
		WebElement subcription = driver.findElement(By.xpath("//h2[text()='Subscription']"));
		System.out.println(subcription.getText().equals(compareChar));
		
		// 6
		driver.findElement(By.id("susbscribe_email")).sendKeys(email);
		driver.findElement(By.id("subscribe")).click();
		
		// 7
		WebElement subscriptionSuccess = driver.findElement(By.id("success-subscribe"));
		String text = subscriptionSuccess.getText();
		if(text.equals("You have been successfully subscribed!")) {
			System.out.println(subscriptionSuccess.isDisplayed());
		}
		
		driver.quit();
	}

}
