package vtiger.Organizations.TestsScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ListenersImplementationClass;
@Listeners(ListenersImplementationClass.class)
public class CreateOrganisationWithType extends BaseClass {

	@Test
	public void createOrganisationWithType() throws IOException {
		
		//Step 2: Read all the required data
		String ORGNAME = eUtil.readDataFromExcel("Organisation", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.readDataFromExcel("Organisation", 4, 3);
		String TYPE = eUtil.readDataFromExcel("Organisation", 7, 3);
		
		//Step 5:Click on organization link
		driver.findElement(By.linkText("Organizations")).click();

		//Step 6:Click on Create organization lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Step 7:Create organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		//Step 8: Select health care in industry drop down
		WebElement element = driver.findElement(By.name("industry"));
		wUtil.handleDropDown(element, INDUSTRY);
		
		//Step 9: Select the Type of customer
		WebElement type= driver.findElement(By.name("accounttype"));
		wUtil.handleDropDown(type, TYPE);
		
		//Step 10:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
