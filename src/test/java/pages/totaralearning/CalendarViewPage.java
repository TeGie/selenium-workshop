package pages.totaralearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarViewPage {
	
	WebDriver driver;
	@FindBy(xpath="//dd[1]")
	WebElement eventDateTime;
	@FindBy(xpath="//dd[2]")
	WebElement eventDuration;
	@FindBy(xpath="//dd[3]/span")
	WebElement eventRoom;
	@FindBy(linkText="Sign-up for this seminar event")
	WebElement signUp;
	public CalendarViewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getEventDateTime() {
		return eventDateTime.getText();
	}
	
	public String getEventDuration() {
		return eventDuration.getText();
	}
	
	public String getEventRoom() {
		return eventRoom.getText();
	}
	
	public void clickSignUp() {
		signUp.click();
	}
}
