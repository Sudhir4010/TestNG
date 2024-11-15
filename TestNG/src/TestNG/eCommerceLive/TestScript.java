package TestNG.eCommerceLive;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestScript extends BaseClass {

//	@Test(priority = 1)
//	public void verify() {
//		if (driver.getTitle().equalsIgnoreCase("Home page")) {
//			System.out.println("Home Page Title Verified");
//		} else {
//			System.out.println("Landed on a different page, please try again");
//		}
//	}
//
//	@Test(priority = 2)
//	public void mobile() {
//		driver.findElement(By.partialLinkText("MOBILE")).click();
//		String Title = driver.getTitle();
//		if (driver.getTitle().equals(Title)) {
//			System.out.println("Mobile page Title Verified");
//		} else {
//			System.out.println("Not verified...");
//		}
//	}
//
//	@Test(priority = 3)
//	public void sortByName() {
//		driver.findElement(By.partialLinkText("MOBILE")).click();
//		WebElement sortby = driver.findElement(By.xpath("(//select[@title='Sort By'])[1]"));
//
//		List<WebElement> beforeSorting = driver.findElements(By.xpath("//span[text()='Add to Cart']/../../../..//h2"));
//		List<String> initialNames = new ArrayList<String>();
//		for (WebElement ele : beforeSorting) {
//			initialNames.add(ele.getText());
//		}
//
//		Collections.sort(initialNames);
//		
//		Select ref = new Select(sortby);
//
//		ref.selectByVisibleText("Name");
//		List<WebElement> allProducts = driver.findElements(By.xpath("//h2[@class='product-name']"));
//
////		ArrayList<String> arrList = new ArrayList<String>();
////		for (WebElement ele : allProducts) {
////			arrList.add(ele.getText());
////		}
////		
////		char firstChar = arrList.toString().charAt(0);
////		System.out.println(firstChar);
//		
//		List<WebElement> elements = driver.findElements(By.xpath("//span[text()='Add to Cart']/../../../..//h2"));
//
//		List<String> capturedName = new ArrayList<String>();
//		for (WebElement ele : elements) {
//			capturedName.add(ele.getText());
//		}
//		
////		System.out.println(initialNames);
////		System.out.println(capturedName);
//
//		if (initialNames.equals(capturedName)) {
//			System.out.println("sorted");
//		} else {
//			System.out.println("not sorted");
//		}
//	}
//
//	@Test(priority = 4)
//	public void comparePrice() throws InterruptedException {
//		driver.findElement(By.partialLinkText("MOBILE")).click();
//
//		WebElement price = driver.findElement(By.xpath("(//div[@class='price-box'])"));
//
//		String homePagePrice = price.getText();
//
//		driver.findElement(By.partialLinkText("SONY XPERIA")).click();
//		Thread.sleep(3000);
//
//		WebElement detailsPrice = driver.findElement(By.xpath("//span[@class='price']"));
//
//		String detailsPagePrice = detailsPrice.getText();
//		
//		if (homePagePrice.equals(detailsPagePrice)) {
//			System.out.println("Both are equal");
//		} else {
//			System.out.println("Not Equal");
//		}
//	}
//	
//	@Test(priority = 5)
//	public void verificationMsg() throws InterruptedException {
//		driver.findElement(By.partialLinkText("MOBILE")).click();
//		WebElement addToCartBTN = driver
//				.findElement(By.xpath("//a[@title='Sony Xperia']/../..//button[@title='Add to Cart']"));
//		addToCartBTN.click();
//		WebElement textfield = driver.findElement(By.xpath("//input[@title='Qty']"));
//		textfield.clear();
//		textfield.sendKeys ("1000");
//		driver.findElement(By.xpath("//button[@title='Update']")).click();
//		String expectedErrorMsg = "* The maximum quantity allowed for purchase is 500.";
//		WebElement errorMSG = driver.findElement(By.xpath("//p[@class='item-msg error']"));
//		String actualMsg = errorMSG.getText();
//		if (actualMsg.equalsIgnoreCase(expectedErrorMsg)) {
//			System.out.println("Verified");
//		}
//		else {
//			System.out.println("Not Verified");
//		}
//		
//		driver.findElement(By.id("empty_cart_button")).click();
//		WebElement emptyCart = driver.findElement(By.tagName("h1"));
//		String expectedCartMsg = "SHOPPING CART IS EMPTY";
//		String actualcartMsg = emptyCart.getText();
//		if (actualcartMsg.equals(expectedCartMsg)) {
//			System.out.println("Verified");
//		}
//		else {
//			System.out.println("Not Verified");
//		}
//	}

//	@Test(priority = 6)
//	public void popup() {
//		driver.findElement(By.partialLinkText("MOBILE")).click();
//		driver.findElement(By.xpath("//a[@title='Xperia']/..//a[text()='Add to Compare']")).click();
//		driver.findElement(By.xpath("//a[@title='IPhone']/..//a[text()='Add to Compare']")).click();
//
//		driver.findElement(By.xpath("//span[text()='Compare']/../..")).click();
//
//		Set<String> handles = driver.getWindowHandles();
//
//		for (String handle : handles) {
//			driver.switchTo().window(handle);
//
//			if (driver.getCurrentUrl().contains("http://live.techpanda.org/index.php/catalog/product_compare/index/")) {
//				break;
//			}
//		}
//		System.out.println("Popup window displayed");
//		WebElement element1 = driver.findElement(By.xpath("//a[text()='Sony Xperia']"));
//		WebElement element2 = driver.findElement(By.xpath("(//a[@title='IPhone'])[2]"));
//		System.out.println(element1.isDisplayed());
//		System.out.println(element2.isDisplayed());
//		driver.close();
//	}

	@Test(priority = 7)
	public void register() {
		driver.findElement(By.xpath("(//a[text()='My Account'])[2]")).click();

		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();

		driver.findElement(By.id("firstname")).sendKeys("KISHAN");
		driver.findElement(By.id("lastname")).sendKeys("KUMAR");
		driver.findElement(By.id("email_address")).sendKeys("abpoerhsbs@gmail.com");
		driver.findElement(By.id("password")).sendKeys("abc@1234");
		driver.findElement(By.id("confirmation")).sendKeys("abc@1234");
		driver.findElement(By.xpath("//span[text()='Register']")).click();

		if (driver.getCurrentUrl().equals("http://live.techpanda.org/index.php/customer/account/index/")) {
			System.out.println("Registration sucessful");
		} else {
			System.out.println("Not registered");
		}
		driver.findElement(By.xpath("//a[text()='TV']")).click();
		driver.findElement(By.xpath("//a[text()='LG LCD']/../..//a[text()='Add to Wishlist']")).click();
		driver.findElement(By.xpath("//span[text()='Share Wishlist']")).click();

		driver.findElement(By.id("email_address")).sendKeys("kishan12345@gmail.com");
		driver.findElement(By.id("message")).sendKeys("Hi ");
		driver.findElement(By.xpath("//span[text()='Share Wishlist']")).click();

		WebElement myWishlist = driver.findElement(By.xpath("//span[text()='Your Wishlist has been shared.']"));
		if (myWishlist.isDisplayed()) {
			System.out.println("Wishlist shared successfully");
		}
	}
	
//	@Test
//	public void placeOrder() throws InterruptedException {
//		driver.findElement(By.xpath("(//a[text()='My Account'])[2]")).click();
//		WebElement emailAdress = driver.findElement(By.id("email"));
//		emailAdress.sendKeys("abpoerhsbsc@gmail.com");
//		WebElement password = driver.findElement(By.id("pass"));
//		password.sendKeys("abc@1234");
//		WebElement loginBtn = driver.findElement(By.xpath("//button[@title='Login']"));
//		loginBtn.click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//div[@class='block-content']/../..//a[text()='My Wishlist']")).click();
//		WebElement addToCart = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
//		addToCart.click();
//		WebElement address = driver.findElement(By.xpath("(//input[@title='First Name'])[1]"));
//		address.sendKeys("ABC");
//		WebElement city = driver.findElement(By.id("billing:city"));
//		city.sendKeys("New York");
//		WebElement zip = driver.findElement(By.id("billing:postcode"));
//		zip.sendKeys("542896");
//		WebElement telephone = driver.findElement(By.id("billing:telephone"));
//		telephone.sendKeys("12345678");
//		WebElement state = driver.findElement(By.id("billing:region_id"));
//		Select ref = new Select(state);
//		ref.selectByValue("43");
//		WebElement county = driver.findElement(By.id("billing:country_id"));
//		Select sel = new Select(county);
//		sel.selectByVisibleText("United States");	
//	}
	
	@Test(priority = 8)
	public void placeOrder() throws InterruptedException {
		
	    // 2. Click on my account link                                             
	    driver.findElement(By.linkText("MY ACCOUNT")).click();
	    
	    Thread.sleep(3000);  
	    
	    // switching to new window                                                    
	    for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
	    
	    // 3. Login in application using previously created credential                  
//	    driver.findElement(By.id("email")).clear();	   
	    driver.findElement(By.id("email")).sendKeys("abpoerhsbs@gmail.com"); 
//	    driver.findElement(By.id("pass")).clear();	    
	    driver.findElement(By.id("pass")).sendKeys("abc@1234");
	    driver.findElement(By.id("send2")).click();	 // this is the Login button   
	   
	    Thread.sleep(3000);  
	    
	 // switching to new window                                                                               
	    for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
	    
	    // 4. Click on MY WISHLIST link                                                                              
	    driver.findElement(By.linkText("MY WISHLIST")).click();
	
	    Thread.sleep(3000);    
	    
	    // switching to new window                                                                             
	    for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
	    
	    // 5. In next page, Click ADD TO CART link                                                                     
	    driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
	 
	    Thread.sleep(3000);   
	    
	    // switching to new window                                                                                  
	    for (String handle : driver.getWindowHandles()) {                                             
	    	driver.switchTo().window(handle);
	    	} 
	    
	    // 6. Enter general shipping country, state/province and zip for the shipping cost estimate                
	    new Select(driver.findElement(By.xpath("//select[@id='country']"))).selectByIndex(14);
	    driver.findElement(By.id("region")).sendKeys("New South Wales");
	    driver.findElement(By.id("postcode")).sendKeys("2000");
	    
	    // 7. Click Estimate                                                                                                       
	    driver.findElement(By.xpath(".//*[@id='shipping-zip-form']/div/button")).click(); // this is the ESTIMATE link
	    
	    
	    // 8. Verify Shipping cost generated                                                                               
	    String sFlatRate = "Flat Rate";
	    String flatRate = driver.findElement(By.xpath(".//*[@id='co-shipping-method-form']/dl/dt")).getText();	
	    try {
	    	System.out.println("sFlatRate = "+sFlatRate);
	    	System.out.println("flatRate = "+flatRate);
	    	assertEquals(sFlatRate, flatRate);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    	    
	    String sFlatRatePrice = "Fixed - $5.00";
	    String flatRatePrice = driver.findElement(By.xpath(".//*[@id='co-shipping-method-form']/dl/dd/ul/li/label")).getText();
	    try {	 
	    	System.out.println("sFlatRatePrice = "+sFlatRatePrice);
	    	System.out.println("flatRatePrice = "+flatRatePrice);
	    	assertEquals(sFlatRatePrice, flatRatePrice);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    
	    
	    // 9. Select Shipping Cost (already selected as default), Update Total                                              
	    driver.findElement(By.id("s_method_flatrate_flatrate")).click();	 // RADIO button  -  Fixed - $5.00
	    driver.findElement(By.xpath("//button[@title='Update Total']")).click();
	    
	    
	    
	    // 10. Verify shipping cost is added to total                                                           
	    String vFlatRatePrice = "$5.00";
	    String shippingCostIncluded = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span")).getText();
	    
	    try {
	    	System.out.println("vFlatRatePrice = "+vFlatRatePrice);
	    	System.out.println("shippingCostIncluded = "+shippingCostIncluded);
	    	assertEquals(vFlatRatePrice, shippingCostIncluded);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }
	   
	    
	    // 11. Click PROCEED TO CHECKOUT                                                                       
	    driver.findElement(By.xpath("//button[@title='Proceed to Checkout']")).click();
	   
	    Thread.sleep(3000);    
	    
	    
	    // switching to new window                                                                                
	    for (String handle : driver.getWindowHandles()) { 
	    	driver.switchTo().window(handle);
	    	}  
	    Thread.sleep(2000); 
	    
	    //********************************************************************************************************
	    //*
	    //*  BILLING ADDRESS
	    //*
	    //********************************************************************************************************
	    // Check if Select element is present. If not present, it is the first time a customer has logged back in, to process what is in his/her wishlist
	    
	    try {
	    	Select bAddr = new Select(driver.findElement(By.name("billing_address_id")));
	    	int bAddrSize = bAddr.getOptions().size();
	    	bAddr.selectByIndex(bAddrSize-1); 
		    } catch (Exception e) {
		    	//e.printStackTrace();
		    	System.out.println("No dropdown element present");
		    }
	  
	    driver.findElement(By.id("billing:firstname")).clear();
	    driver.findElement(By.id("billing:firstname")).clear();
	    driver.findElement(By.id("billing:firstname")).sendKeys("ABC"); 
	    driver.findElement(By.id("billing:lastname")).clear();
	    driver.findElement(By.id("billing:lastname")).sendKeys("CDF"); 
	    driver.findElement(By.id("billing:company")).clear(); 
	    
	    driver.findElement(By.id("billing:street1")).clear();
	    driver.findElement(By.id("billing:street1")).sendKeys("148 Crown Street"); 
	    new Select(driver.findElement(By.xpath("//select[@id='billing:country_id']"))).selectByIndex(14);
	    Thread.sleep(5000);	    
	    driver.findElement(By.id("billing:city")).clear();	
	    driver.findElement(By.id("billing:city")).sendKeys("Sydney"); 
	    driver.findElement(By.id("billing:region")).clear();
	    driver.findElement(By.id("billing:region")).sendKeys("New South Wales");
	    driver.findElement(By.id("billing:postcode")).clear();
	    driver.findElement(By.id("billing:postcode")).sendKeys("2000");
	    driver.findElement(By.id("billing:telephone")).clear();
	    driver.findElement(By.id("billing:telephone")).sendKeys("8850 6789"); 
	    
	    // check radio button to "Ship to different address" 
        driver.findElement(By.id("billing:use_for_shipping_no")).click();
	    
        // click the CONTINUE button 
	   
	    // after the click above, it is still on same web page: live.guru99.com/index.php/checkout/onepage/
	    driver.findElement(By.xpath(".//*[@id='billing-buttons-container']/button")).click();
	    
	    // switching to new window                                                                                
	    for (String handle : driver.getWindowHandles()) {  
	    	driver.switchTo().window(handle);
	    	}  
	    Thread.sleep(2000); 
	    
	    //********************************************************************************************************
	    //*
	    //*  SHIPPING ADDRESS
	    //*
	    //********************************************************************************************************
	    // Check if Select element is present or not.  If not present, it is first time user has logged back in to process his/her order
	    
	    try {
	    	Select sAddr = new Select(driver.findElement(By.name("shipping_address_id")));
	    	int sAddrSize = sAddr.getOptions().size();
	    	sAddr.selectByIndex(sAddrSize-1); 
		    } catch (Exception e) {
		    	//e.printStackTrace();
		    	System.out.println("No dropdown element present");
		    }
	    
	  
	    Thread.sleep(3000);   
	   
	    driver.findElement(By.id("shipping:firstname")).clear();
	    driver.findElement(By.id("shipping:firstname")).clear();
	    driver.findElement(By.id("shipping:firstname")).sendKeys("ABC"); 
	    driver.findElement(By.id("shipping:lastname")).clear();
	    driver.findElement(By.id("shipping:lastname")).sendKeys("ABC"); 
	    driver.findElement(By.id("shipping:company")).clear(); 
	    
	    driver.findElement(By.id("shipping:street1")).clear();
	    driver.findElement(By.id("shipping:street1")).sendKeys("50 Berry Street"); 
	    driver.findElement(By.id("shipping:street2")).clear();
	    // shipping country must be selected first from dropdown
	    new Select(driver.findElement(By.xpath("//select[@id='shipping:country_id']"))).selectByIndex(14); 
	    // once Australia is selected, then the region and city becomes simply a text input, instead of dropdown
	    driver.findElement(By.id("shipping:region")).clear();
	    driver.findElement(By.id("shipping:region")).sendKeys("New Sounth Wales"); 
	    driver.findElement(By.id("shipping:city")).clear();
	    driver.findElement(By.id("shipping:city")).sendKeys("Sydney"); 
	    driver.findElement(By.id("shipping:postcode")).clear();
	    driver.findElement(By.id("shipping:postcode")).sendKeys("2000"); 
	    driver.findElement(By.id("shipping:telephone")).clear();
	    driver.findElement(By.id("shipping:telephone")).sendKeys("8034 1234");
	        
	    Thread.sleep(3000);	    
	    
	    driver.findElement(By.xpath(".//*[@id='shipping-buttons-container']/button")).click(); 
	    
	    // switching to new window                                                                                
	    for (String handle : driver.getWindowHandles()) {  
	    	driver.switchTo().window(handle);
	    	}  
	    Thread.sleep(2000); 
	    
	    
	    // 13. In Shipping Method, Click Continue   
	    driver.findElement(By.xpath(".//*[@id='shipping-method-buttons-container']/button")).click(); 	
	   	 
	    Thread.sleep(2000);
	    
	    // 14. In Payment Information select 'Check/Money Order' radio button. Click Continue
	    driver.findElement(By.xpath("//input[@title='Check / Money order']")).click();
	    
	    Thread.sleep(3000);	    
	    
	    driver.findElement(By.xpath(".//*[@id='payment-buttons-container']/button")).click(); 
	     
	    Thread.sleep(3000);
	    
	    // 15. Click 'PLACE ORDER' button  
	    driver.findElement(By.xpath(".//*[@id='review-buttons-container']/button")).click(); 
	    
	    Thread.sleep(3000);
	    
	    // 16. Verify Oder is generated. Note the order number 
	    String orderNum = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/p[1]/a")).getText();	
	    System.out.println("*** Your order number for your record = " + orderNum);
	}
}
