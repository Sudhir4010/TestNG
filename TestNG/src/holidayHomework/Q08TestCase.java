package holidayHomework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 Test Case 8: Verify All Products and product detail page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. The products list is visible
7. Click on 'View Product' of first product
8. User is landed to product detail page
9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
*/

public class Q08TestCase {
	public static void main(String[] args) throws IOException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse-Workbench\\TestNGGrooming\\testData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String url = prop.getProperty("url");
		String allProductURL = prop.getProperty("allProductURL");
		String productDetailPage = prop.getProperty("productDetailPage");

		// 1
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// 2
		driver.get(url);

		// 3
		if (driver.getCurrentUrl().equals(url)) {
			System.out.println("Home Page Displayed...");
		} else {
			System.out.println("Home Page not displayed...");
		}
		
		// 4
		driver.findElement(By.partialLinkText(" Products")).click();
		
		if (driver.getCurrentUrl().contains(allProductURL)) {
			System.out.println("user is navigated to ALL PRODUCTS page successfully");
		}
		
		// 6
		WebElement productList = driver.findElement(By.xpath("//h2[text()='All Products']"));
		System.out.println("Product list is displayed : " + productList.isDisplayed());
		
		// 7
		try {
			
			WebElement viewProduct = driver.findElement(By.xpath("(//a[text()='View Product'])[1]"));
			viewProduct.click();
			
		}catch (ElementClickInterceptedException e) {
			e.printStackTrace();
		}
		
		// 8
		if (driver.getCurrentUrl().equals(productDetailPage)) {
			System.out.println("User is landed to product detail page");
		}
		
		// 9
		WebElement productName = driver.findElement(By.xpath("//h2[text()='Blue Top']"));
		System.out.println(productName.getText());
		System.out.println(productName.isDisplayed());
		
		WebElement category = driver.findElement(By.xpath("//p[text()='Category: Women > Tops']"));
		System.out.println(category.isDisplayed());
		
		WebElement price = driver.findElement(By.xpath("//span[contains(text(),'Rs.')]"));
		System.out.println(price.getText());
		System.out.println("price" + price.isDisplayed());
		
		WebElement availabilty = driver.findElement(By.xpath("//b[text()='Availability:']"));
		System.out.println(availabilty.getText());
		System.out.println(availabilty.isDisplayed());
		
		WebElement condition = driver.findElement(By.xpath("//b[text()='Condition:']"));
		System.out.println(condition.getText());
		System.out.println(condition.isDisplayed());
		
		WebElement brand = driver.findElement(By.xpath("//b[text()='Brand:']"));
		System.out.println(brand.getText());
		System.out.println(brand.isDisplayed());
		
		driver.close();
		
	}
}
