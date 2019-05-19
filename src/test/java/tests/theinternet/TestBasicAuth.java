package tests.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.theinterenet.BasicAuthPage;

public class TestBasicAuth {
	
	WebDriver driver;
	BasicAuthPage objBasicAuth;
	
    @BeforeTest
    public void beforeTest() {
    	driver = new ChromeDriver();
    	driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    @AfterTest
    public void afterTest() {
    	driver.quit();
    }
	
    @Test
    public void basicAuth() {
    	objBasicAuth = new BasicAuthPage(driver);
    	String basicAuthMessage = objBasicAuth.getBasicAuthMessage();
    	
    	Assert.assertEquals(basicAuthMessage, "Congratulations! You must have the proper credentials.");
    }
}


