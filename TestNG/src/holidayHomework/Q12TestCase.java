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

/*
 Test Case 12: Add Products in Cart
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Products' button
5. Hover over first product and click 'Add to cart'
6. Click 'Continue Shopping' button
7. Hover over second product and click 'Add to cart'
8. Click 'View Cart' button
9. Verify both products are added to Cart
10. Verify their prices, quantity and total price 
 * */

public class Q12TestCase {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse-Workbench\\TestNGGrooming\\testData\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		
		// 1
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
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

		// 5
		WebElement itmes = driver.findElement(By.xpath("(//p[text()='Blue Top'])[1]"));
		WebElement addToCartBTN = driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]"));
		
		js.executeScript(
				"var evt = new MouseEvent('mousedown', { bubbles: true, cancelable: true }); arguments[0].dispatchEvent(evt);",
				itmes);
		
		js.executeScript(
				"var evt = new MouseEvent('click', { bubbles: true, cancelable: true }); arguments[0].dispatchEvent(evt);",
				addToCartBTN);

		// 6
		driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
		
		// 7
		WebElement itmes2 = driver.findElement(By.xpath("//p[text()='Men Tshirt']"));
		WebElement addToCartBTN2 = driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]"));
		
		js.executeScript(
				"var evt = new MouseEvent('mousedown', { bubbles: true, cancelable: true }); arguments[0].dispatchEvent(evt);",
				itmes2);
		
		js.executeScript(
				"var evt = new MouseEvent('click', { bubbles: true, cancelable: true }); arguments[0].dispatchEvent(evt);",
				addToCartBTN2);
		// 8
		driver.findElement(By.xpath("//u[text()='View Cart']")).click();	
		
		// 9	
		List<WebElement> noOfProducts = driver.findElements(By.xpath("//tr[contains(@id,'product')]"));
		int quantityText = noOfProducts.size();
		if(quantityText == 2) {
			System.out.println("both Products are added to the cart...");
		}
		
		
		// 10
		double totalPrice = 0.0;

		for (WebElement product : noOfProducts) {
		    String priceString = product.findElement(By.className("cart_price")).getText();
		    String quantityString = product.findElement(By.className("cart_quantity")).getText();
		    
		    String newPrice = priceString.replaceAll("Rs. ", "");
		    int price = Integer.parseInt(newPrice);
		    int quantity = Integer.parseInt(quantityString);
		    double productTotal = price * quantity;
		    totalPrice += productTotal;
		}
		System.out.println("Grand Total: " + totalPrice);
		
		if (totalPrice == 900) {
			System.out.println("The added product are the same.");
		}
        
		driver.quit();
	}
}
