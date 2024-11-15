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
 Test Case 21: Add review on product
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Click on 'View Product' button
6. Verify 'Write Your Review' is visible
7. Enter name, email and review
8. Click 'Submit' button
9. Verify success message 'Thank you for your review.'
 * */

public class Q21TestCase {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse-Workbench\\TestNGGrooming\\testData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String email = prop.getProperty("email");
		String name = prop.getProperty("name");
		String review = prop.getProperty("review");

		// 1
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// 2
		driver.get(url);

		// 3
		driver.findElement(By.partialLinkText(" Products")).click();

		// 4
		String text = driver.findElement(By.xpath("//h2[text()='All Products']")).getText();
		if (text.equals("ALL PRODUCTS")) {
			System.out.println("User navigated to the page successfully.");
		}
		
		// 5
		WebElement viewProduct = driver.findElement(By.xpath("(//a[text()='View Product'])[1]"));
		js.executeScript("arguments[0].click();", viewProduct);
		
		// 6
		WebElement reviewBTN = driver.findElement(By.xpath("//a[text()='Write Your Review']"));
		if (reviewBTN.isDisplayed() == true) {
			System.out.println("Write Your Review : is visible");
		}
		
		// 7
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("review")).sendKeys(review);
		
		// 8
		driver.findElement(By.id("button-review")).click();
		
		// 9
		WebElement successReview = driver.findElement(By.xpath("//span[text()='Thank you for your review.']"));
		if(successReview.isDisplayed() == true) {
			System.out.println("Verified");
		}
		
		driver.close();
	}
}
