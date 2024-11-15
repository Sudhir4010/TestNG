package testNGs.TestCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public WebDriver driver;
	public Properties prop;

	@BeforeTest
	public void fetchData() throws IOException {
		FileInputStream fis = new FileInputStream("./testData/commonData.properties");
		prop = new Properties();
		prop.load(fis);
	}

	@BeforeClass
	public void launchBrowser() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get(prop.getProperty("url"));
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/", "Homepage not displayed");
		Reporter.log("Navigated to the homepage", true);
	}
	
	@BeforeMethod
	public void login() {
		driver.findElement(By.xpath("//a[contains(@href,'/login')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed());
		Reporter.log("Login to your account is visible. ");
		
		
		driver.findElement(By.name("email")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}
	
	@AfterMethod
	public void deleteAccount() {
		driver.findElement(By.xpath("//a[contains(text(),' Delete Account')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed());
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
	@AfterTest
	public void closeObject() {
		prop.clear();
	}
}
