package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	//initialization
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	
	//Business libray
	/**
	 * This method will capture header text and return it to caller
	 * @param driver
	 * @return 
	 */
	
	public String getOrganizatonHeader() {
		return OrgHeaderText.getText();
	}
	

}
