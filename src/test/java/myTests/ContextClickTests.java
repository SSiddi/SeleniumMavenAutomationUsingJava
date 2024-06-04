package myTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import base.CustomListener;

@Listeners(CustomListener.class)
public class ContextClickTests extends BaseTest {

	// Action class comes into play simulate user actions.
	// And one of the most commonly used methods of the class is
	// contextClick(WebElement), which is used to perform the Right-Click action.
	// Action class is present in package: org.openqa.selenium.interactions package

	protected Actions action;

	@Test(priority = 1)
	public void rightClickTest() {
		testCaseId = "3";
		webdriver.get("https://demo.guru99.com/test/simple_context_menu.html");
		webdriver.manage().window().maximize();

		action = new Actions(webdriver);
		WebElement link = webdriver.findElement(By.cssSelector(".context-menu-one"));
		action.contextClick(link).perform();
		System.out.println("Right click Context Menu displayed");

		WebElement editButton = webdriver.findElement(By.xpath("//span[text()='Edit']"));
		editButton.click();

		webdriver.switchTo().alert().accept();
		System.out.println("Right click Alert Accepted");
	}

	@Test(priority = 2)
	public void doubleClickTest() {
		testCaseId = "4";
		webdriver.get("https://demoqa.com/buttons");
		System.out.println("Demoqa Web Page Displayed");
		action = new Actions(webdriver);

		// Maximize browser window
		webdriver.manage().window().maximize();
		WebElement button = webdriver.findElement(By.id("doubleClickBtn"));

		action.doubleClick(button).perform();
		System.out.println("Button is double clicked");

		webdriver.switchTo().alert().accept();
		System.out.println("Double click Alert Accepted");
	}

	@Test(priority = 3)
	public void dragAndDropTest() {
		testCaseId = "5";
		webdriver.get("https://demoqa.com/droppable/");
		System.out.println("Demoqa Web Page Displayed");

		action = new Actions(webdriver);

		webdriver.manage().window().maximize();
		WebElement fromTab = webdriver.findElement(By.id("draggable"));
		WebElement toTab = webdriver.findElement(By.id("droppable"));

		action.dragAndDrop(fromTab, toTab).perform();
		String textTo = toTab.getText();

		if (textTo.equals("Dropped!")) {
			System.out.println("PASS: Source is dropped to target as expected");
		} else {
			System.out.println("FAIL: Source couldn't be dropped to target as expected");
		}

	}
	
	@Test(priority = 4)
	public void clickHoldReleaseTest() {
		testCaseId = "9";
		webdriver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		action = new Actions(webdriver);

		webdriver.manage().window().maximize();
		WebElement ele = webdriver.findElement(By.xpath("//li[text()= 'C']"));
		
		action.moveToElement(ele).clickAndHold().perform();

	}
}
