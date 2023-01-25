package vtiger.Contacts.TestScripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;

import vtiger.GenericUtilities.BaseClass;
@Listeners(vtiger.GenericUtilities.ListenersImplementationClass.class)
public class DemoTest extends BaseClass{
	@Test
	public void demoTest() throws InterruptedException {
		System.out.println("Hello");
		Thread.sleep(1000);
		
	}
	@Test
	public void sampleTest() throws InterruptedException {
		System.out.println("Sample");
		Thread.sleep(1000);
		//Assert.fail();
		
	}
}
