package myTests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import base.CustomListener;
import dev.failsafe.TimeoutExceededException;

@Listeners(CustomListener.class)
public class ListOfTestCases extends BaseTest {

	protected String url = "https://www.google.com/";

	@Test(priority = 1)
	public void titleVerifyTest() {
		webdriver.get(url);
		testCaseId = "1";
		String title = webdriver.getTitle();
		System.out.println("Page title is :  " + title);
		Assert.assertEquals(title, "Google");
	}

	@Test(priority = 2)
	public void isSearchExist() {
		testCaseId = "2";
		webdriver.get(url);
		boolean flag = webdriver.findElement(By.name("q")).isDisplayed();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void openExistingNotepadAndReadData() {
		testCaseId = "6";
		String testFile = "D:\\Shabnam Project\\SeleniumMavenAutomationUsingJava\\testData.txt";
		FileReader FR = null;
		try {
			FR = new FileReader(testFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader BR = new BufferedReader(FR);

		String content = "";
		try {
			while ((content = BR.readLine()) != null) {
				System.out.println("Content of file is : " + content);
				webdriver.get(content);
				String title = webdriver.getTitle();
				System.out.println("Page title is :  " + title);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 4)
	@SuppressWarnings("deprecation")
	public void openNotepadApp() {
		testCaseId = "7";
		Runtime rt = Runtime.getRuntime();

		try {
			rt.exec("notepad");
		} catch (IOException ex) {

			System.out.println(ex);

		}
	}

	@Test(priority = 5)
	public void fileDownloadTest() {
		testCaseId = "8";
		webdriver.get("https://get.jenkins.io/windows-stable/2.426.1/jenkins.msi");
		String downloadPath = "/Users/aiman/Downloads";
		String fileName = "jenkins.msi";

		File file = new File(downloadPath, fileName);

		FluentWait<File> wait = new FluentWait<File>(file).withTimeout(Duration.ofMinutes(5))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class).withMessage("File is not downloaded");

		try {
			boolean isDownloaded = wait.until(filedownloaded -> filedownloaded.exists() && filedownloaded.canRead());

			if (isDownloaded) {
				System.out.println("File is downloaded 100%");
			}
		} catch (Exception e) {
			System.out.println("File is not completely downloaded");
		}

	}

}
