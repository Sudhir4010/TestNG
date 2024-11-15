package holidayHomework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 Test Case 9: Search Product
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8. Verify all the products related to search are visible*/

public class Q09TestCase {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse-Workbench\\TestNGGrooming\\testData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String allProductURL = prop.getProperty("allProductURL");
		String productName = prop.getProperty("productName");

		WebDriver driver = new ChromeDriver(); // 1
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url); // 2

		// 3
		if (driver.getCurrentUrl().equals(url)) {
			System.out.println("Home Page Displayed...");
		} else {
			System.out.println("Home Page not displayed...");
		}

		// 4
		driver.findElement(By.partialLinkText(" Products")).click();

		// 5
		if (driver.getCurrentUrl().contains(allProductURL)) {
			System.out.println("user is navigated to ALL PRODUCTS page successfully");
		}

		// 6
		WebElement productTF = driver.findElement(By.id("search_product"));
		productTF.sendKeys(productName);
		driver.findElement(By.id("submit_search")).click();
		
		// 7 
		WebElement searchProduct = driver.findElement(By.xpath("//h2[text()='Searched Products']"));
		System.out.println("'SEARCHED PRODUCTS' is visible : " + searchProduct.isDisplayed());
	}
}
