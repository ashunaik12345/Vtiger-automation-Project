package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vtiger.ObjectRepository.LoginPage;

public class PomClassPractices {


	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("http://localhost:8888");
		
		LoginPage lp=new LoginPage(driver);
		/*lp.getUserNameEdt().sendKeys("admin");
		lp.getPasswordEdt().sendKeys("admin");
		lp.getSubmitBtn().click();*/
		
		lp.loginToApp("admin", "admin"); //optimized code

	}
}
