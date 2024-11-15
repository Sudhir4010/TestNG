package TestNG.Myntra;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;

	@BeforeClass
	public void openBrowwser() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		option.addArguments("--start-maximized");
		driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		

	}
	@BeforeMethod
	public void navigateToURL() {
		driver.get("https://www.myntra.com/");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
		
	}
}
