package base;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.testrailmanager.TestRailManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver webdriver;
	protected String testCaseId;

	@Parameters("borwserName")
	@BeforeClass
	public void setup(String borwserName) {
		/*
		 * String driverExecutablePath =
		 * "C:\\Users\\aiman\\chromedriver-win64\\chromedriver.exe"; //
		 * System.setProperty("webdriver.chrome.driver", driverExecutablePath);
		 * 
		 * ChromeOptions option = new ChromeOptions();
		 * option.addArguments("--remote-allow-origins=*");
		 * 
		 * System.setProperty("webdriver.chrome.driver", driverExecutablePath);
		 * webdriver = new ChromeDriver(option);
		 */

		switch (borwserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			webdriver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			webdriver = new FirefoxDriver();
			break;

		default:
			System.out.println("Invalid browser");

		}

	}

	@AfterClass
	public void tearDown() {
		System.out.println("Closing the browser");
		webdriver.quit();
	}

	@AfterMethod
	public void addTestResultsToTestRail(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS)
			TestRailManager.addResultForTestCase(testCaseId, TestRailManager.TEST_CASE_PASS_STATUS, "");
		if (result.getStatus() == ITestResult.FAILURE)
			TestRailManager.addResultForTestCase(testCaseId, TestRailManager.TEST_CASE_FAIL_STATUS,
					"test got failed.... " + result.getTestName() + ": FAILED");
	}

	public void failed() {
		File srcFile = ((TakesScreenshot) this.webdriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("/SeleniumMavenAutomationUsingJava/screenshots/testfailure.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
