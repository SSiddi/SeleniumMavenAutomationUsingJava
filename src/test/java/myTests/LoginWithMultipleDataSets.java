package myTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithMultipleDataSets {

	@Test(dataProvider ="loginData")
	public void testLogin(String id, String email, String password) {
		System.out.println("input id is  : " + id);
		System.out.println("input email is  : " + email);
		System.out.println("input password is  : " + password);
	}
	
	@DataProvider(name= "loginData")
	public Object [][] getData()
	{
		return new Object[][]
				{		
		{"id1", "test1.gmail" ,"pwd1"},
		{"id2", "test2.gmail" ,"pwd2" },
		{"id3", "test3.gmail" ,"pwd3"}
				}	;
	}
		
	}

