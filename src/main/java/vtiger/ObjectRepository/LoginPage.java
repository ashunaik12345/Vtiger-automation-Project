package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
//rule 1:create a pom class for every web page
//rule 2: class name should be the title of page and ending with page
{
	//rule 3:Identify webelements using @FindBy,@FindAll,@FindBys annotation

	@FindBy(name="user_name")
	private WebElement UserNameEdt;  

	@FindBy(name="user_password")
	private WebElement PasswordEdt;

	@FindBy(id="submitButton")
	private WebElement SubmitBtn;

	//rule 4:create a constructor initialzie the variables/web elements
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	//rule 5:Provide getters to access the web elements
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	/**
	 * This method will login to application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	//Business Library -Generic methods -for this application
	public void loginToApp(String USERNAME,String PASSWORD) {
		UserNameEdt.sendKeys(USERNAME);
		PasswordEdt.sendKeys(PASSWORD);
		SubmitBtn.click();
	}





}
