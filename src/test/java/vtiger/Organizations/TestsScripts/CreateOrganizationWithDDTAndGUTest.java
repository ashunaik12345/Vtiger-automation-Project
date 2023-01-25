package vtiger.Organizations.TestsScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ListenersImplementationClass;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
@Listeners(ListenersImplementationClass.class)
public class CreateOrganizationWithDDTAndGUTest extends BaseClass {
	@Test
	public void createOrganizationWithDDTAndGU() throws IOException, InterruptedException {

         HomePage hp=new HomePage(driver);
       //Step 1:Required data from excel
		String ORGNAME = eUtil.readDataFromExcel("Organisation", 1, 2)+jUtil.getRandomNumber();

		//Step 2:Click on organization link
		driver.findElement(By.linkText("Organizations")).click();

		//Step 3:Click on Create organization lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Step 4:Create organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		//Step 5:Save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//Step 6:Validation
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String ORGHEADER = oip.getOrganizatonHeader();
		Assert.assertTrue(ORGHEADER.contains(ORGNAME));
		System.out.println("===="+ORGHEADER+"==== PASS");
        
		//Step 7:Log out
		hp.getSignOutLink();
	}
}
