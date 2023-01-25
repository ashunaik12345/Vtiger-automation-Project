package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganisation {
	public static void main(String[] args) throws InterruptedException {
		//step1 Launch the Browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");

		//step2 Login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//step 3 create organisation
		driver.findElement(By.linkText("Organizations")).click();

		//step 4 click on new oganaisation
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Enter the mandatory feild
		driver.findElement(By.className("detailedViewTextBox")).sendKeys("QSP1");
		
		//save the deatils
		driver.findElement(By.name("button")).click();
		
		//validation 
		String header = driver.findElement(By.className("dvHeaderText")).getText();
		if(header.contains(header)) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		 Thread.sleep(1000);
		//logout from applicatio
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		//to handle mouse over action
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}
}
