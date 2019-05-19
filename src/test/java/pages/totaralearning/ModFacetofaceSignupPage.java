package pages.totaralearning;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModFacetofaceSignupPage {

	WebDriver driver;
	@FindBy(className = "alert-message")
	WebElement alertMessage;
	@FindBy(xpath = "(//a[@title='Seminar'])[2]")
	WebElement resusTrainingLink;
	@FindBy(xpath = "//div[@class=\"upcomingsessionlist\"]//tbody/tr")
	List<WebElement> upcomingEvents;
	@FindBy(linkText = "Add a new event")
	WebElement addNewEvent;

	public ModFacetofaceSignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getAlertMessage() {
		return alertMessage.getText();
	}

	public void clickResusTrainingLink() {
		resusTrainingLink.click();
	}

	public List<String> getEventDetails() {
		List<String> eventDetails = new ArrayList<String>();
		for (WebElement eventRow : upcomingEvents) {
			String date = eventRow.findElement(By.cssSelector(".cell.c0")).getText();
			if (date.contains("December")) {
				eventDetails.add(date);
				eventDetails.add(eventRow.findElement(By.cssSelector(".cell.c1")).getText());
				eventDetails.add(eventRow.findElement(By.cssSelector(".cell.c2")).getText());
			}
		}
		return eventDetails;
	}

	public void clickAddNewEvent() {
		addNewEvent.click();
	}
}
