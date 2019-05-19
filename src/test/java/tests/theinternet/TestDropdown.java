package tests.theinternet;

import org.testng.annotations.Test;

import pages.theinterenet.DropdownPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestDropdown {
	
	WebDriver driver;
	DropdownPage objDropdown;
	
	@BeforeTest
    public void beforeTest() {
    	driver = new ChromeDriver();
    	driver.get("https://the-internet.herokuapp.com/dropdown");
    }
	
	@AfterTest
    public void afterTest() {
    	driver.quit();
    }
	
	@Test
    public void selectFromDropdown() throws InterruptedException {
		objDropdown = new DropdownPage(driver);
		String option2 = objDropdown.selectOption("Option 2");		
		synchronized (driver) {
    		driver.wait(2000);
    	}
		String option1 = objDropdown.selectOption("Option 1");
		
		Assert.assertEquals(option2, "Option 2");
		Assert.assertEquals(option1, "Option 1");
	}
}