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
		objStatusCodes.clickPage("200");
		String status200 = objStatusCodes.getStatusCode();
		driver.get("https://the-internet.herokuapp.com/status_codes");
		objStatusCodes.clickPage("301");
		String status301 = objStatusCodes.getStatusCode();
		driver.get("https://the-internet.herokuapp.com/status_codes");
		objStatusCodes.clickPage("404");
		String status404 = objStatusCodes.getStatusCode();
		driver.get("https://the-internet.herokuapp.com/status_codes");
		objStatusCodes.clickPage("500");
		String status500 = objStatusCodes.getStatusCode();
		
		Assert.assertTrue(status200.contains("200"));
		Assert.assertTrue(status301.contains("301"));
		Assert.assertTrue(status404.contains("404"));
		Assert.assertTrue(status500.contains("500"));
	}
}
