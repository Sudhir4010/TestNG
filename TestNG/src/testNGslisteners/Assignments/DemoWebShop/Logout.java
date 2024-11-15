package testNGslisteners.Assignments.DemoWebShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
	@FindBy(linkText = "Log out")
	private WebElement logoutLink;
	
	public Logout(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return the logoutLink
	 */
	public WebElement getLogoutLink() {
		return logoutLink;
	}

	
}
