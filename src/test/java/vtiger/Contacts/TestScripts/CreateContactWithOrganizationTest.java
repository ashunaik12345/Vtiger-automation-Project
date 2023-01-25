package vtiger.Contacts.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ListenersImplementationClass;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactsPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;
@Listeners(ListenersImplementationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass{
	@Test(groups="Regresstionsuite")
	public void createContactWithOrganizations() throws IOException, InterruptedException {

		//Step 1:read the data 
		String ORGNAME = eUtil.readDataFromExcel("Organisation", 4, 2)+jUtil.getRandomNumber();
		String LastNAME = eUtil.readDataFromExcel("Contacts", 4, 2)+jUtil.getRandomNumber();


		//Step 2:Click on organization link
		HomePage hp=new HomePage(driver);
		hp.clickingOnOrganizationLink();
		Reporter.log("Orgaanization created"+ORGNAME);

		//Step 3:Click on Create organization lookup image
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpImg();
		Reporter.log("organization lookup image is clicked");

		//Step 4:Create organization with mandatory fields and save
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.crateNewOrganization(ORGNAME);
		Reporter.log("organization craeted"+ORGNAME);

		//Step 5:Validate for organization
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrganizatonHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));


		//Step 6: Navigate to the contact link
		hp.clickingOnContactLink();
		Reporter.log("contact is clicked");

		//Step 7: Click on crate contact look up image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		Reporter.log("contact look up image is clicked");

		//Step 8:Create new contact
		CreateNewContactsPage cnp=new CreateNewContactsPage(driver);
		cnp.createNewContact(driver, LastNAME, ORGNAME);
		//Assert.fail();
		Reporter.log("organization created"+ORGNAME);
		

		//Step 9: Validate
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String ContactHeader = cip.getContactHeader();
		Assert.assertTrue(ContactHeader.contains(LastNAME));
		System.out.println("====="+ContactHeader+"====PAS");


	}
}



