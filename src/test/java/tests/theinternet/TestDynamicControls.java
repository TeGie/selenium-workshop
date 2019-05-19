package tests.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.theinterenet.DynamicControlsPage;

public class TestDynamicControls {

	WebDriver driver;
	WebDriverWait wait;
	DynamicControlsPage objDynamicControls;

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 20);
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void dynamicControls() {
		objDynamicControls = new DynamicControlsPage(driver, wait);
		objDynamicControls.writeIntoInput();
		Boolean isCheckbox = objDynamicControls.removeCheckbox();
		Boolean inputDisabled = objDynamicControls.disableInput();
		String checkboxMsg = objDynamicControls.addCheckbox();

		Assert.assertTrue(isCheckbox);
		Assert.assertTrue(inputDisabled);
		Assert.assertEquals(checkboxMsg, "It's back!");
	}
}
