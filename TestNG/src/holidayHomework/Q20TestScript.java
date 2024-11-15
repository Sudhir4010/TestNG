package holidayHomework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 Test Case 20: Search Products and Verify Cart After Login
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Enter product name in search input and click search button
6. Verify 'SEARCHED PRODUCTS' is visible
7. Verify all the products related to search are visible
8. Add those products to cart
9. Click 'Cart' button and verify that products are visible in cart
10. Click 'Signup / Login' button and submit login details
11. Again, go to Cart page
12. Verify that those products are visible in cart after login as well
 */
public class Q20TestScript {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse-Workbench\\TestNGGrooming\\testData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String productName = prop.getProperty("productName");
		String email = prop.getProperty("email");
		String password = prop.getProperty("password");

		// 1
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// 2
		driver.get(url);

		// 3
		driver.findElement(By.partialLinkText(" Products")).click();

		// 4
		String text = driver.findElement(By.xpath("//h2[text()='All Products']")).getText();
		if (text.equals("ALL PRODUCTS")) {
			System.out.println("User navigated to the page successfully.");
		}

		// 5
		WebElement productTF = driver.findElement(By.id("search_product"));
		productTF.sendKeys(productName);
		driver.findElement(By.id("submit_search")).click();

		// 6
		WebElement searchProduct = driver.findElement(By.xpath("//h2[text()='Searched Products']"));
		System.out.println("'SEARCHED PRODUCTS' is visible : " + searchProduct.isDisplayed());

		// 8
		List<WebElement> productList = driver.findElements(By.xpath("//div[@class='product-image-wrapper']"));

		for (int i = 0; i < productList.size(); i++) {
			if ((i + 1) % 2 != 0) { 
				WebElement product = productList.get(i);
				WebElement addToCartButton = product
						.findElement(By.xpath(".//a[@class='btn btn-default add-to-cart']"));

				
				js.executeScript("arguments[0].click();", addToCartButton);
				WebElement continueShopping = product
						.findElement(By.xpath("//button[text()='Continue Shopping']"));
				js.executeScript("arguments[0].click();", continueShopping);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/view_cart']")));
			}
		}
		// 9
		WebElement viewCart = driver
				.findElement(By.xpath("//u[text()='View Cart']"));
		js.executeScript("arguments[0].click();", viewCart);
		
		List<WebElement> cartsize = driver.findElements(By.tagName("tr"));
		System.out.println(cartsize.size());
		
		// 10
		driver.findElement(By.xpath("//a[contains(@href,'/login')]")).click();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();

		// 11
		WebElement cartBTN = driver.findElement(By.xpath("//a[contains(text(),'Cart')]"));
		cartBTN.click();
		
		List<WebElement> cartsize2 = driver.findElements(By.tagName("tr"));
		System.out.println(cartsize2.size());
		
		// 12
		if (cartsize == cartsize2) {
			System.out.println("Items are present after login as well..");
		}
		else {
			System.out.println("All items are not present..");
		}
		
		driver.close();
	}
}
