package testNGs.DemoWebShop;

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

	@BeforeTest
	public void fetchData() throws IOException {
		// Properties File
		FileInputStream fis = new FileInputStream("./testData/testdata.properties");
		prop = new Properties();
		prop.load(fis);

		FileInputStream efis = new FileInputStream("./testData/TestScriptData.xlsx");
		workbook = WorkbookFactory.create(efis);
	}

	@Parameters("Browser")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName) { // in case if we want to run the test script
																		// instead of suite file.
//		public void launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get(prop.getProperty("url"));
	}
//	public void launchBrowser() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//
//	}

	@BeforeMethod
	public void login() {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.id("Password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}

	@AfterTest
	public void closeObject() throws IOException {
		workbook.close();
	}

	@AfterMethod
	public void logout() {
		driver.findElement(By.linkText("Log out")).click();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
