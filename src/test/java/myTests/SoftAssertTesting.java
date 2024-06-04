package myTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTesting {

	
	@Test
	public void testcaseOne()
	{
		
		System.out.println("*** test case one started ***");
		Assert.assertEquals(5, 5, "First hard assert failed");
		System.out.println("hard assert success....");
		Assert.assertTrue("Hello".equals("hello"), "Second hard assert failed");
		System.out.println("*** test case one executed successfully ***"); //this will not executed becz of hard assert above
	}
	
	@Test
	public void testcaseTwo()
	{
		SoftAssert softAssert = new SoftAssert();
		System.out.println("*** test case two started ***");
		softAssert.assertEquals("Hello", "Hello", "First soft assert failed");
		softAssert.assertTrue("Hello".equals("hello"), "Second soft assert failed");
		softAssert.assertTrue("Welcome".equals("welcomeeee"), "Third soft assert failed");
		System.out.println("*** test case two executed successfully ***");
		softAssert.assertAll();
		
	}
	
	//This will ignore the exception and will mark the test as pass
	// invocationCount will tell how many times the same test case should execute
	@Test(expectedExceptions=ArithmeticException.class,invocationCount = 5)
	public void dividedByZeroExample1(){
		int e = 1/0;
		System.out.println(e);
	}
	
	//This test will fail with exception java.lang.ArithmeticException: / by zero
	@Test
	public void dividedByZeroExample2(){
		int e = 1/0;
		System.out.println(e);
	}
}
