package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPracties {
	@Test
	public void assertTest1() {
		System.out.println("STEP 1");
		System.out.println("STEP 2");
		System.out.println("STEP 3");
		System.out.println("STEP 4");
		//Assert.assertEquals(true, true);//pass
		//Assert.assertEquals(false, true);//failed
		Assert.assertTrue(true);
		System.out.println("STEP 5");
		System.out.println("STEP 6");
		System.out.println("STEP 7");
		System.out.println("STEP 8");
	}
	@Test
	public void assertTest2() {
		SoftAssert sa=new SoftAssert();
		System.out.println("STEP 1");
		System.out.println("STEP 2");
		sa.assertEquals(true, true);//pass soft
		System.out.println("STEP 3");
		System.out.println("STEP 4");
		sa.assertTrue(false);//fail softA
		System.out.println("STEP 5");
		sa.assertEquals("A", "Z");//fail soft
		Assert.assertTrue(false);//hard
		System.out.println("STEP 6");
		System.out.println("STEP 7");
		System.out.println("STEP 8");
		sa.assertAll();//not executed
		
		
	}
}
