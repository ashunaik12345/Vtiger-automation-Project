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
public class CreateOrganizationWithDDT extends BaseClass{
	 
	@Test
	public void createOrgWithDDTTest() throws IOException
	{	
		HomePage hp=new HomePage(driver);
		
		//Step1:Read all the data
		String ORGNAME =eUtil.readDataFromExcel("Organisation", 4, 2)+jUtil.getRandomNumber();


		//Step4:Click on organization link
		driver.findElement(By.linkText("Organizations")).click();

		//Step5:Click on Create organization lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Step6:Create organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		//Step7:Save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();


		//Step8:Validate
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);

		String orgHeader =oip.getOrganizatonHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println("===="+orgHeader+"====PASS");
		//Step9:LogoutApp
		hp.getSignOutLink();





	}
}
