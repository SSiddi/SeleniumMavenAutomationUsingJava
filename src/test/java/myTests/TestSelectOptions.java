package myTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;

public class TestSelectOptions extends BaseTest {

	@Test
	public void select_multi_dropdon() {
		webdriver.get("https://demoqa.com/select-menu");

		Select oSelect = new Select(webdriver.findElement(By.name("cars")));

		if (oSelect.isMultiple()) {
			oSelect.selectByIndex(0);
			oSelect.selectByIndex(1);

		}

		System.out.println("List of options are ");
		List<WebElement> listOfOptions = oSelect.getOptions();

		System.out.println("No of opions are: " + listOfOptions.size());
		for (WebElement selectedOption : listOfOptions)
			System.out.println(selectedOption.getText());

		oSelect.deselectByIndex(3);
	}

}
