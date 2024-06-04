package myTests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadExcelDataProvider {

	
	public WebDriver driver;
	public WebDriverWait wait;
	String appURL = "https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin";
	
	//Locators
	private By byEmail = By.id("username");
	private By byPassword = By.id("password");
	private By bySubmit = By.id("signin");
	private By byError = By.id("global-alert-queue");
	
	@BeforeClass
	public void testSetup() {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "empLogin")
	public void loginIntoLinkedIn(String username,String password)
	{
		driver.navigate().to(appURL);
		driver.findElement(byEmail).sendKeys(username);
		driver.findElement(byPassword).sendKeys(password);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(bySubmit));
		driver.findElement(bySubmit).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(byError));
		String actualErrorMessage = driver.findElement(byError).getText();
		String expErrorMessage = "Please correct the marked field(s) below.";
		Assert.assertEquals(actualErrorMessage, expErrorMessage);
		
	}
	
	@DataProvider(name="empLogin")
	public Object[][] loginData() {
		Object[][] arrayObj = getExcelData("D:\\Shabnam Project\\SeleniumMavenAutomationUsingJava\\src\\test\\resources\\DataSets\\linkedindataset.xlsx","loginData");
		return arrayObj;
		
	}
	
	public String[][] getExcelData(String filename, String sheetname)
	{
		String[][] arrayExcelData = null;
		try {
		FileInputStream file = new FileInputStream(filename);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet("loginData");
		
		 int rowCount = sh.getLastRowNum() + 1;
		 
		  Row firstRow = sh.getRow(0);
		  int colCount = firstRow.getLastCellNum();
		  
		
		arrayExcelData = new String[rowCount][colCount];
		
		for(int i =1; i< rowCount; i++)
		
		{
			for(int j= 0; j < colCount ; j++)
			{
			Cell cell =  sh.getRow(i).getCell(j);
			arrayExcelData[i-1][j]  =cell.getStringCellValue();
			}
			
		}
		wb.close();
		file.close();
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return arrayExcelData;
		
	}
	
	@Test
	public void tearDown() {
		driver.quit();
	}
	
}
