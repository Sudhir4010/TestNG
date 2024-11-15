package testNGslisteners.Assignments.DemoWebShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy (partialLinkText  = "BOOKS")
	private WebElement booksLink;
	
	@FindBy (partialLinkText  = "COMPUTERS")
	private WebElement computerLink;
	
	@FindBy (partialLinkText  = "ELECTRONICS")
	private WebElement electronicsLink;
	
	@FindBy (partialLinkText  = "APPAREL & SHOES")
	private WebElement apparelLink;
	
	@FindBy (partialLinkText  = "DIGITAL DOWNLOADS")
	private WebElement digitalDownloadLink;
	
	@FindBy (partialLinkText  = "JEWELRY")
	private WebElement jewelryLink;
	
	@FindBy (partialLinkText  = "GIFT CARDS")
	private WebElement giftCardsLink;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	/**
	 * @return the booksLink
	 */
	public WebElement getBooksLink() {
		return booksLink;
	}


	/**
	 * @return the computerLink
	 */
	public WebElement getComputerLink() {
		return computerLink;
	}


	/**
	 * @return the electronicsLink
	 */
	public WebElement getElectronicsLink() {
		return electronicsLink;
	}


	/**
	 * @return the apparelLink
	 */
	public WebElement getApparelLink() {
		return apparelLink;
	}


	/**
	 * @return the digitalDownloadLink
	 */
	public WebElement getDigitalDownloadLink() {
		return digitalDownloadLink;
	}


	/**
	 * @return the jewelryLink
	 */
	public WebElement getJewelryLink() {
		return jewelryLink;
	}


	/**
	 * @return the giftCardsLink
	 */
	public WebElement getGiftCardsLink() {
		return giftCardsLink;
	}
	
	

}
