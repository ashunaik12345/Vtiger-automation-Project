package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	//Declaration
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateOrgLookUpImg;
	
	//initiallization(construtor)
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}
	/**
	 * This method will click create organization
	 * @param driver
	 */
	//Business library
	public void clickOnCreateOrgLookUpImg() {
		CreateOrgLookUpImg.click();
	}
	
	
}
