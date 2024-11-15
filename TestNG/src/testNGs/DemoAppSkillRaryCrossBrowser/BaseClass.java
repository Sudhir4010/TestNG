package testNGs.DemoAppSkillRaryCrossBrowser;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	public Workbook workbook;
	
	@BeforeTest(description = "Importing data from the external file.")
	public void fetchData() throws IOException  {
		// Properties File
		FileInputStream fis = new FileInputStream("./testData/skillRary.properties");
		prop = new Properties();
		prop.load(fis);
		
		FileInputStream efis = new FileInputStream("./testData/TestScriptData.xlsx");
		workbook = WorkbookFactory.create(efis);
	}
	
	@Parameters("Browser")
	
	@BeforeClass
	public void launchNavigate(@Optional("chrome") String browserName) throws InterruptedException{
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get(prop.getProperty("url"));
		Thread.sleep(3000);
	}

	@BeforeMethod
	public void login() throws InterruptedException {
		driver.findElement(By.linkText("LOGIN")).click();
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("last")).click();
		
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='SkillRary Admin']")).click();
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
	@AfterTest
	public void closeObject() throws IOException {
		workbook.close();
	}
}
