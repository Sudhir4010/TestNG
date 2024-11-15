package testNGslisteners.Assignments.DemoWebShop;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static Properties prop;
	public static Workbook workbook;
	public static WebDriver driver;

	@BeforeTest
	public void fetchData() throws IOException {
		FileInputStream fis = new FileInputStream("./testData/testdata.properties");
		prop = new Properties();
		prop.load(fis);

		FileInputStream efis = new FileInputStream("./testData/TestScriptData.xlsx");
		workbook = WorkbookFactory.create(efis);
	}

	@Parameters ("Browser")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			Reporter.log("Browser not available", true);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get(prop.getProperty("url"));
	}

	@BeforeMethod
	public void login() {
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();

		LoginPage lp = new LoginPage(driver);
		lp.getEmailTF().sendKeys(prop.getProperty("email"));
		lp.getPasswordTF().sendKeys(prop.getProperty("password"));
		lp.getLoginBTN().click();
	}

	@AfterMethod
	public void logout() {
		Logout lout = new Logout(driver);
		lout.getLogoutLink().click();
	}

	@AfterClass
	public void closeDriver() {
		driver.close();
	}

	@AfterTest
	public void closeObject() throws IOException {
		workbook.close();
	}
}
