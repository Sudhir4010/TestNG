package testNGslisteners.Assignments.DemoWebShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//a[text()='Log in']")
	private WebElement loginLink;
	
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return the registerLink
	 */
	public WebElement getRegisterLink() {
		return registerLink;
	}

	/**
	 * @return the loginLink
	 */
	public WebElement getLoginLink() {
		return loginLink;
	}
	
	
}
