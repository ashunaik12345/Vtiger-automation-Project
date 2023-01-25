package vtiger.Organizations.TestsScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ListenersImplementationClass;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
@Listeners(ListenersImplementationClass.class)
public class CreateOrganizationWithIndustry extends BaseClass{

	@Test
	public void createOrganizationWithIndustry() throws IOException {
		HomePage hp=new HomePage(driver);

		String ORGNAME = eUtil.readDataFromExcel("Organisation", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.readDataFromExcel("Organisation", 4, 3);



		//Step 5:Click on organization link
		driver.findElement(By.linkText("Organizations")).click();

		//Step 6:Click on Create organization lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Step 7:Create organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		//Step 8: Select health care in industry drop down
		WebElement element = driver.findElement(By.name("industry"));
		wUtil.handleDropDown(element, INDUSTRY);

		//Step 9: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Step 10:Validate
		OrganizationInfoPage oip= new OrganizationInfoPage(driver);
		String ORGHEADER = oip.getOrganizatonHeader();
		Assert.assertTrue(ORGHEADER.contains(ORGNAME));
		System.out.println("==="+ORGHEADER+"===");
		//Step 11: Log out application
		hp.getSignOutLink();

	}














}
