package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	//declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminstrateImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;
	
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utiliazation

	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getAdminstrateImg() {
		return AdminstrateImg;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	
   //Business library
	/**
	 * This method will click on the organizationLink
	 */
	public void clickingOnOrganizationLink() {
		OrganizationsLink.click();
	}
	public void clickingOnContactLink() {
		ContactsLink.click();
	}
	/**
	 * This method will click on the oppertuinity
	 */
	public void clickingOnOpertunity() {
		OpportunitiesLink.click();
	}
	/**
	 * This method will logout of application
	 * @param driver
	 */
	public void logOutOfApp(WebDriver driver) {
		actionToMovetoElement(driver, AdminstrateImg);
		SignOutLink.click();
	}
	
	
	
	
	
	
	
	
	
	
}
