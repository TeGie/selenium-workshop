package tests.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.theinterenet.StatusCodesPage;

public class TestStatusCodes {

	WebDriver driver;
	StatusCodesPage objStatusCodes;

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/status_codes");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void checkStatusCodes() {
		objStatusCodes = new StatusCodesPage(driver);

		int code200 = objStatusCodes.getCode("200");
		// int code301 = objStatusCodes.getCode("301");
		int code404 = objStatusCodes.getCode("404");
		int code500 = objStatusCodes.getCode("500");

		Assert.assertEquals(code200, 200);
		// Assert.assertEquals(code301, 301);
		Assert.assertEquals(code404, 404);
		Assert.assertEquals(code500, 500);
	}
}
