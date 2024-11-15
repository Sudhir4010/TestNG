package testNGs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ToLearnMultipleDOM {

	@Test
	public void register() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		Assert.fail();
		driver.get("https://demowebshop.tricentis.com/login");
		Reporter.log("register", true);

		driver.quit();
	}

	@Test(dependsOnMethods = "register")
	public void login() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		driver.get("https://demowebshop.tricentis.com/register");
		Reporter.log("login", true);

		driver.close();
	}
	
	@Test (dependsOnMethods = {"register", "login"})
	public void addToCart() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://demowebshop.tricentis.com/cart");
		Reporter.log("product added", true);

		driver.close();
	}

}
