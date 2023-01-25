package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SelectTheCustomerDrop {
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

		//step 3 create Organizations
		driver.findElement(By.linkText("Organizations")).click();

		//step 4 click on new Organizations
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		//Enter the mandatory feild
		driver.findElement(By.className("detailedViewTextBox")).sendKeys("xa12");

		//step 5 select chemical industry dropdown
		WebElement dropdown = driver.findElement(By.name("accounttype"));

		Select sele=new Select(dropdown);
		sele.selectByVisibleText("Customer");
		System.out.println("selected");
		driver.findElement(By.name("button")).click();
		System.out.println("clicked");

		//logout from application
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		element.click();

		//to handle mouse over action
		Actions action=new Actions(driver);
		System.out.println("mouse over");
		action.moveByOffset(1269, 17).perform();

		Thread.sleep(1000);
		System.out.println("logged out");
		driver.findElement(By.linkText("Sign Out")).clear();;


	}
}