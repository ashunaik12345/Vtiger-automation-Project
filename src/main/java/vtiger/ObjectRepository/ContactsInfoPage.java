package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {

	//Decleration
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactHeaderTxt;
	
	//initialization
	public ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getContactHeaderTxt() {
		return ContactHeaderTxt;
	}
	
	//Business libray
	/**
	 * This method will capture the contact header and return value
	 * @return
	 */
	public String getContactHeader() {
		return ContactHeaderTxt.getText();
	}
	
	
	
	
	
	
	
	
}
