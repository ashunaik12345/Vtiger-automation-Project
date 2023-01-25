package vtiger.Organizations.TestsScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ListenersImplementationClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationPage;
@Listeners(ListenersImplementationClass.class)
public class CreateNewOrganizationWithIndustryPom extends BaseClass {

	@Test(groups="Smoke suite")
	public void createNewOrganizationWithIndustry() throws IOException {

		//Step 1:Read all the neseccary
		String ORGNAME = eUtil.readDataFromExcel("Organisation", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.readDataFromExcel("Organisation", 4, 3);

		//Step 2:Click on organization link
		HomePage hp=new HomePage(driver);
		hp.clickingOnOrganizationLink();

		//Step 3:Click on Create organization lookup image
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpImg();

		//Step 4:Create organization with mandatory fields with industry and save
		CreateNewOrganizationPage cp=new CreateNewOrganizationPage(driver);
		cp.createNewOrganization(ORGNAME, INDUSTRY);

		//Step 10:Save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				


	}

}


