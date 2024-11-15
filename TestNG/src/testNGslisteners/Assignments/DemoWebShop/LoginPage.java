package testNGslisteners.Assignments.DemoWebShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id = "Email")
	private WebElement emailTF;

	@FindBy(id = "Password")
	private WebElement passwordTF;

	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginBTN;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return the emailTF
	 */
	public WebElement getEmailTF() {
		return emailTF;
	}

	/**
	 * @return the passwordTF
	 */
	public WebElement getPasswordTF() {
		return passwordTF;
	}

	/**
	 * @return the loginBTN
	 */
	public WebElement getLoginBTN() {
		return loginBTN;
	}

	
}
