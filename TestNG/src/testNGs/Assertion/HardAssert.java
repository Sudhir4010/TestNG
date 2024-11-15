package testNGs.Assertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HardAssert {
	@Test
	public void demo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com");
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop", "Welcome page not displayed");
		Reporter.log("Welcome page displayed");
		
		driver.findElement(By.linkText("Log in")).click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login", "Login page not displayed");
		Reporter.log("Login page displayed");
		
		
		driver.findElement(By.id("Email")).sendKeys("abhis1234@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("abhis@1234");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop", "Home page not displayed");
		Reporter.log("Home page displayed");
		
		
		driver.close();
	}

}
