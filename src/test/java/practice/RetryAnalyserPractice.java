package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	@Test(retryAnalyzer=vtiger.GenericUtilities.RetryAnalyserImpemenatation.class)
	public void retryTest() {
		System.out.println("EXCEUTED");
		Assert.fail();
	}

	@Test
	public void retryTest1() {
		System.out.println("EXECUTED 1");
	}
}
