package testNGs.Assertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {
	@Test
	public void login() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://demowebshop.tricentis.com");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(driver.getTitle(), "Demo Web Shp", "Welcome page not displayed");
		Reporter.log("Welcome page displayed");

		driver.findElement(By.linkText("Log in")).click();
		soft.assertEquals(driver.getTitle(), "Demo Web Shop Login", "Login page not displayed");
		Reporter.log("Login page displayed");

		driver.findElement(By.id("Email")).sendKeys("abhis1234@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("abhis@1234");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		soft.assertEquals(driver.getTitle(), "Demo Web Shop", "Home page not displayed");
		Reporter.log("Home page displayed");
		
		
		soft.assertAll();
		
		driver.close();
	}

}
