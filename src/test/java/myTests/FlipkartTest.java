package myTests;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class FlipkartTest extends BaseTest{

	WebElement ele ;
	@Test
	public void validateTitle() {
		webdriver.get("https://flipkart.com/");
		
		webdriver.manage().window().maximize();
		ele = webdriver.findElement(By.name("q"));
		ele.sendKeys("mobiles");
		
		// ele = webdriver.findElement(By.xpath("//button[@class='MJG8Up']"));
		ele.sendKeys(Keys.ENTER);
		String pageTitle= webdriver.getTitle();
		System.out.println("Page title is : " + pageTitle );
		
		
		ele = webdriver.findElement(By.xpath("(//div[@class='tUxRFH']//a[@class='CGtC98'])[1]"));
		ele.click();
		
		String currentHandle = webdriver.getWindowHandle();
		String childPgeTitle = null;
		Set<String> handles = new HashSet<String>();
		handles = webdriver.getWindowHandles();
		for(String handle : handles)
		{
		if(currentHandle!=handle)
		{
			webdriver.switchTo().window(handle);
			 childPgeTitle= webdriver.getTitle();
			
		}
		}
		
		System.out.println("Chile page title is : " + childPgeTitle );
		
		Assert.assertEquals(pageTitle, childPgeTitle);
		
		
		
		
	}
}
