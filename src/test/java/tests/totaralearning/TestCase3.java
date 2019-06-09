package tests.totaralearning;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.totaralearning.*;

public class TestCase3 {

	WebDriver driver;
	LandingPage objLandPage;
	DashboardPage objDashPage;
	CalendarViewPage objCalViewPage;
	ModFacetofaceSignupPage objMFSignupPage;
	ModFacetofaceEventsAddPage objMFEventsAddPage;

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.get("https://demo.totaralearning.com");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void testCase3() throws InterruptedException {
		objLandPage = new LandingPage(driver);
		objDashPage = new DashboardPage(driver);
		objCalViewPage = new CalendarViewPage(driver);
		objMFSignupPage = new ModFacetofaceSignupPage(driver);
		objMFEventsAddPage = new ModFacetofaceEventsAddPage(driver);
		String[] sDateTime = Helpers.getDateTime("d MMMM yyyy HH mm", "Europe/Warsaw").split(" ");
		String[] eDateTime = { "29", "June", "2019", "14", "00", "Europe/Warsaw" };
		String[] eventData = { "9", "2", "200zł", "150zł", "This is a simple test to add new events." };

		objLandPage.logAsCourseCreator();
		objDashPage.clickResuscitationEventLink();
		String eventDate = objCalViewPage.getEventDateTime();
		String eventDuration = objCalViewPage.getEventDuration();
		String eventLocation = objCalViewPage.getEventRoom();
		objCalViewPage.clickSignUp();
		String alertMsg = objMFSignupPage.getAlertMessage();
		objMFSignupPage.clickResusTrainingLink();
		List<String> eventDetails = objMFSignupPage.getEventDetails();
		objMFSignupPage.clickAddNewEvent();
		objMFEventsAddPage.clickRemoveSession();
		objMFEventsAddPage.setStartDate(sDateTime);
		objMFEventsAddPage.setEndDate(eDateTime);
		objMFEventsAddPage.createEvent(eventData);
		Thread.sleep(10000);
		objDashPage.clickLogOut();

		Assert.assertEquals(alertMsg, "The signup user has conflicting signups");

		String message = String.format("The event will be on %s at %s in %s", eventDetails.get(0), eventDetails.get(1),
				eventDetails.get(2));

		System.out.println("### Resuscitation training ###");
		System.out.println("Event date/time: " + eventDate);
		System.out.println("Duration: " + eventDuration);
		System.out.println("Room: " + eventLocation);
		System.out.println(message);
	}
}
