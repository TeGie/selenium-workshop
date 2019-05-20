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
		String sDay = Helpers.getDateTime("dd");
		String sMonth = Helpers.getDateTime("MMMM");
		String sYear = Helpers.getDateTime("yyyy");
		String sHour = Helpers.getDateTime("HH");
		String sMinute = Helpers.getDateTime("mm");
		String sTimeZone = "Europe/Warsaw";
		String[] sDateTime = { sDay, sMonth, sYear, sHour, sMinute, sTimeZone };
		objMFEventsAddPage.setStartDate(sDateTime);
		String[] eDateTime = { "29", "June", "2019", "14", "00", "Europe/Warsaw" };
		objMFEventsAddPage.setEndDate(eDateTime);
		String[] eventData = { "9", "2", "200PLN", "150PLN", "This is a simple test to add new events." };
		objMFEventsAddPage.createEvent(eventData);
		synchronized (driver) {
			driver.wait(10000);
		}
		objDashPage.clickLogOut();

		Assert.assertEquals(alertMsg, "The signup user has conflicting signups");

		System.out.println("### Resuscitation training ###");
		System.out.println("Event date/time: " + eventDate);
		System.out.println("Duration: " + eventDuration);
		System.out.println("Room: " + eventLocation);
		String message = String.format("The event will be on %s at %s in %s", eventDetails.get(0), eventDetails.get(1),
				eventDetails.get(2));
		System.out.println(message);
	}
}
