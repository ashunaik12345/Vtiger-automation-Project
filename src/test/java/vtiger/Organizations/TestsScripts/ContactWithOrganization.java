package vtiger.Organizations.TestsScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ListenersImplementationClass;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactsPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationPage;
@Listeners(ListenersImplementationClass.class)
public class ContactWithOrganization  extends BaseClass{

	@Test
	public void createContactWithOrganization() throws EncryptedDocumentException, IOException, InterruptedException {
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2);
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 7, 3)+jUtil.getRandomNumber();

		//Step Navigate to Organization link
		HomePage hp=new HomePage(driver);
		hp.clickingOnOrganizationLink();

		//Step Click on Organization look up image
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpImg();
		//Step  create new Organization and save
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.crateNewOrganization(ORGNAME);
		Thread.sleep(1000);
		hp.clickingOnContactLink();
		//create contact
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		Assert.fail();
		
		CreateNewContactsPage ca=new CreateNewContactsPage(driver);
		ca.createNewContact(driver,LASTNAME, ORGNAME);
		















	}

}
