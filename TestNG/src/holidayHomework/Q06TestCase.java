package holidayHomework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 Test Case 6: Contact Us Form
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
*/

public class Q06TestCase {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse-Workbench\\TestNGGrooming\\testData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String name = prop.getProperty("name");
		String email = prop.getProperty("email");
		String subject = prop.getProperty("subject");
		String message = prop.getProperty("message");
		
		WebDriver driver = new ChromeDriver(); // 1
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url); // 2

		// 3
		if (driver.getCurrentUrl().equals(url)) {
			System.out.println("home page is visible successfully");
		} else {
			System.out.println("Home Page not displayed...");
		}
		
		// 4
		driver.findElement(By.xpath("//a[contains(@href,'us')]")).click();
		
		// 5
		WebElement getinTouchText = driver.findElement(By.xpath("//h2[text()='Get In Touch']"));
		System.out.println("GET IN TOUCH :" + getinTouchText.isDisplayed());
		
		// 6
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("subject")).sendKeys(subject);
		driver.findElement(By.id("message")).sendKeys(message);	
		
		// 7
		WebElement uploadFile = driver.findElement(By.name("upload_file"));
		uploadFile.sendKeys("C:\\Users\\kisha\\OneDrive\\Desktop\\Current test set report.pdf");
		
		Thread.sleep(3000);
		// 8
		Actions act = new Actions(driver);
		act.moveToElement(uploadFile).perform();
		driver.findElement(By.name("submit")).click();
		
		// 9 
		driver.switchTo().alert().accept();
		
		// 10
		WebElement successMSG = driver.findElement(By.xpath("//div[contains(@class,'status alert')]"));
		if(successMSG.getText().equals("Success! Your details have been submitted successfully.")) {
			System.out.println("Success! Your details have been submitted successfully. " + successMSG.isDisplayed());
		}
		
		// 11
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		
		if(driver.getCurrentUrl().equals(url)) {
			System.out.println("Landed to home page successfully...");
		}
	}

}
