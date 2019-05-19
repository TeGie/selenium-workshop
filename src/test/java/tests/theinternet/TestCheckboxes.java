package tests.theinternet;

import org.testng.annotations.Test;

import pages.theinterenet.CheckboxesPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestCheckboxes {
	
	WebDriver driver;
	CheckboxesPage objCheckboxes;
	
	@BeforeTest
    public void beforeTest() {
    	driver = new ChromeDriver();
    	driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
	
	@AfterTest
    public void afterTest() {
    	driver.quit();
    }
	
	@Test
    public void selectCheckboxes() {
    	objCheckboxes = new CheckboxesPage(driver);
    	objCheckboxes.clickCheckbox(0);
    	objCheckboxes.clickCheckbox(1);
    	String checkedFirst = objCheckboxes.getChecked(0);   	
    	String checkedSecond = objCheckboxes.getChecked(1);
    	
    	Assert.assertEquals(checkedFirst, "true");
    	Assert.assertEquals(checkedSecond, null);
	}
}
