package tests.theinternet;

import org.testng.annotations.Test;

import pages.theinternet.AddRemoveElementsPage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAddRemoveElements {

	WebDriver driver;
	AddRemoveElementsPage objAddRemoveElements;

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void addRemoveElements() throws InterruptedException {
		objAddRemoveElements = new AddRemoveElementsPage(driver);
		objAddRemoveElements.clickAddButton();
		objAddRemoveElements.clickAddButton();
		int addedButtonsCount = objAddRemoveElements.countButtons();
		synchronized (driver) {
			driver.wait(2000);
		}
		objAddRemoveElements.clickDeleteButton();
		objAddRemoveElements.clickDeleteButton();
		int deletedButtonsCount = objAddRemoveElements.countButtons();

		Assert.assertEquals(addedButtonsCount, 2);
		Assert.assertEquals(deletedButtonsCount, 0);
	}
}
