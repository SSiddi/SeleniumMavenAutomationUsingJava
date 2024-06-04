package myTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTests {

	protected WebDriver webdriver;
	
	@Test(dataProvider = "BroserOptions")
	public void test1(String browser) {
		if(browser.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			webdriver = new ChromeDriver();
			System.out.println("Open chrome browser");
		}
		else if(browser.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			webdriver = new FirefoxDriver();
			System.out.println("Open firefox browser");
		}
		webdriver.get("http://www.google.com");
	}

	@DataProvider(name = "BroserOptions", parallel=true)
	public String[] getData() {
		String[] browsers = { "Firefox", "Chrome"};
		return browsers;
	}
}


// Using data provider, we can run same method multiple times for different input
// To run them in parallel, use parallel = true, it will parallel run test for all the different data provided