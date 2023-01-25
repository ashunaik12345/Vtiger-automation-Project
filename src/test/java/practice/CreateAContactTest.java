package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAContactTest {
	public static void main(String[] args) {
		//step1 Launch the Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");

		//step2 Login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		//step3 click on contact link
		driver.findElement(By.linkText("Contacts")).click();

		//step4 click on create contact look up icon
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// step5 create a mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("xyz");

		//step6 save the details
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step 7 validate
		String Header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(Header.contains("xyz")) {
			System.out.println(Header);
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
	
		//step 8 logout from application
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		//to handle dropdown
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
}
