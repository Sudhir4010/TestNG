package testNGs.dataProviders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ToLearnDataProviders {
	public WebDriver driver;
//	@Test(dataProviderClass = DataStorage.class, dataProvider = "loginData")
//	public void login(String[] cred) {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		
//		driver.get("https://demoapp.skillrary.com/login.php?type=login");
//		driver.findElement(By.id("email")).sendKeys(cred[0]);
//		driver.findElement(By.id("password")).sendKeys(cred[1]);
//		driver.findElement(By.id("last")).click();
//		
//		Assert.assertEquals(driver.getTitle(), "SkillRary Ecommerce", "User Failed to login");
//		Reporter.log("User logged in succdessfuly", true);	
//	}
	
	
	@Test(dataProviderClass = DataStorage.class, dataProvider = "registerData")
	public void registration(String[] data) {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		driver.get("https://demoapp.skillrary.com/login.php?type=register");
		driver.findElement(By.name("firstname")).sendKeys(data[0]);
		driver.findElement(By.name("lastname")).sendKeys(data[1]);
		driver.findElement(By.xpath("(//*[@placeholder='Email'])[2]")).sendKeys(data[2]);
		driver.findElement(By.xpath("(//*[@placeholder='Password'])[2]")).sendKeys(data[3]);
		driver.findElement(By.name("repassword")).sendKeys(data[4]);
		driver.findElement(By.xpath("//*[@value='Register']")).click();
		
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demoapp.skillrary.com/register.php", "Registraton unsuccesful");
	}
	
}
