package vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {

	public JavaUtility jUtil=new JavaUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver; //this

	@BeforeSuite(groups= {"Smoke suite","Regresstionsuite"})
	public void bsConfig() {
		System.out.println("=====Database Connection successful=====");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups={"Smoke suite","Regresstionsuite"})
	public void bcConfig(/*String BROWSER */) throws IOException {
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			sdriver=driver;
			System.out.println(BROWSER+"launched sucessfuly");
		}else if(BROWSER.equalsIgnoreCase("Fire fox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			sdriver=driver;
			System.out.println(BROWSER+"  "+"Launched sucessfuly");
		}else {
			System.out.println("invalid Browser");
		}
		
		wUtil.maximizeWindow(driver);
		System.out.println("====Window maximizied====");
		wUtil.waitForPageLoad(driver);
		driver.get(URL);	
		System.out.println("====Apllication opened sucessfully====");
	}
	@BeforeMethod(groups={"Smoke suite","Regresstionsuite"})
	public void bmConfig() throws IOException, InterruptedException {
		Thread.sleep(1000);
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		System.out.println("====Login is sucessfull====");
	}

	@AfterMethod(groups={"Smoke suite","Regresstionsuite"})
	public void amConfig() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		Thread.sleep(1000);
		hp.getSignOutLink();
		//hp.logOutOfApp(driver);
		System.out.println("====Log out sucessfully====");
	}
	@AfterClass(groups={"Smoke suite","Regresstionsuite"})
	public void acConfig() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
		System.out.println("===browser is closed");
	}
	@AfterSuite(groups={"Smoke suite","Regresstionsuite"})
	public void asConfig() throws InterruptedException {
		
		System.out.println("====Database Connection closed====");
	}
}
