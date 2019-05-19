package tests.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.theinterenet.NotificationMessagePage;

public class TestNotificationMessage {
	
	WebDriver driver;
	NotificationMessagePage objNotificationMessage;
	
	@BeforeTest
    public void beforeTest() {
    	driver = new ChromeDriver();
    	driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
    }
	
	@AfterTest
    public void afterTest() {
    	driver.quit();
    }
	
	@Test
    public void getNotificationMessage() {
		objNotificationMessage = new NotificationMessagePage(driver);
		String flashMessage = objNotificationMessage.clickUntilMessage();
		
		Assert.assertTrue(flashMessage.contains("Action unsuccesful, please try again"));
		
	}
}
