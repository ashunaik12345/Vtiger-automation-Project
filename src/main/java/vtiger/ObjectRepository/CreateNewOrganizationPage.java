package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {

	//Declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;

	@FindBy(name="industry")
	private WebElement industryDropDown;

	@FindBy(name="assigntype")
	private WebElement assigntypeRadioBtn;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//initialization
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getAssigntypeRadioBtn() {
		return assigntypeRadioBtn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business library
	/**
	 * This metho will craete new organization and save
	 * @param OrgName
	 */
	public void crateNewOrganization(String OrgName) {
		OrgNameEdt.sendKeys(OrgName);
		SaveBtn.click();
	}
	/**
	 * This method will crate new organization with industry
	 * @param OrgName
	 * @param industry
	 */
	public void createNewOrganization(String OrgName,String industry) {
		OrgNameEdt.sendKeys(OrgName);
		handleDropDown(industryDropDown, industry);
		SaveBtn.click();
	}
	
	
	
	



}
