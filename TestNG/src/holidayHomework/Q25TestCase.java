package holidayHomework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down page to bottom
5. Verify 'SUBSCRIPTION' is visible
6. Click on arrow at bottom right side to move upward
7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
*/

public class Q25TestCase {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;
        try {
            // 1. Launch browser
        	driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
            JavascriptExecutor js = (JavascriptExecutor) driver; 

            // 2. Navigate to url
            driver.get("http://automationexercise.com");

            // 3. Verify that home page is visible successfully
            if (driver.getTitle().contains("Automation Exercise")) {
                System.out.println("Home Page is displayed successfully.");
            } else {
                System.out.println("Home Page is not displayed.");
            }

            // 4. Scroll down page to bottom
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            
            Thread.sleep(5000); 
            
            // 5. Verify 'SUBSCRIPTION' is visible
            boolean isSubscriptionVisible = driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed();
            System.out.println("Verify 'SUBSCRIPTION' is visible: " + isSubscriptionVisible);
            
            // 6. Click on arrow at bottom right side to move upward
            WebElement scrollUpButton = driver.findElement(By.id("scrollUp")); // Adjust the selector if needed
            js.executeScript("arguments[0].click();", scrollUpButton);
            
            Thread.sleep(5000); 
            
            // 7. 
            boolean isTextVisible = driver.findElement(By.xpath("//*[contains(text(),'Full-Fledged practice website for Automation Engineers')]")).isDisplayed();
            System.out.println("Verify that 'Full-Fledged practice website for Automation Engineers' is visible: " + isTextVisible);

        } 
        finally {
			driver.quit();
		}
    }
}

