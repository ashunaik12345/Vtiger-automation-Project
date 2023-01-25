package vtiger.Organizations.TestsScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ListenersImplementationClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationPage;
@Listeners(ListenersImplementationClass.class)
public class CreateMultipleOrganizations extends BaseClass {
	
	@Test(dataProvider="OrgNames")
	public void createMultipleOrgTest(String ORG,String INDUSTRY) throws IOException {
		String ORGNAME = ORG+jUtil.getRandomNumber();
		
		//Step 1:Click on organization link
		HomePage hp=new HomePage(driver);
		hp.clickingOnOrganizationLink();
		
		//Step 2:Click on Create organization lookup image
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step 3:Create organization with mandatory fields with industry and save
		CreateNewOrganizationPage cp=new CreateNewOrganizationPage(driver);
		cp.createNewOrganization(ORGNAME, INDUSTRY);
	
		//Step 4:Validate
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		 String orgHeader = oip.getOrganizatonHeader();
		 Assert.assertTrue(orgHeader.contains(ORGNAME));
		 System.out.println("===="+orgHeader+"===PASS");
		
		 }
	

	@DataProvider(name="OrgNames")
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		Object[][] data = eUtil.readMultipleData("Multipleorganization");
		return data;
	}

}
