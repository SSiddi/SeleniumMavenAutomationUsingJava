package myTests;

import org.junit.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnoTest {

	
	@BeforeSuite
	public void m1()
	{
		System.out.println("Inside Before Suite");
	}

	
	@BeforeTest
	public void m3()
	{
		System.out.println("Inside Before Test");
	}
	
	
	@BeforeClass
	public void m2()
	{
		System.out.println("Inside Before Class");
	}
	
	@BeforeMethod
	public void m4()
	{
		System.out.println("Inside Before Method");
	}
	
	@Test
	public void m5()
	{
		System.out.println("Inside Method m5");
	}
	
	@Test
	public void m6()
	{
		System.out.println("Inside Method m6");
	}
	
	@Test
	public void m7()
	{
		System.out.println("Inside Method m7");
	}
	
	
	
}
