package pages.theinterenet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotificationMessagePage {

	WebDriver driver;
	By messageLink = By.linkText("Click here");
	By flash = By.id("flash");

	public NotificationMessagePage(WebDriver driver) {
		this.driver = driver;
	}

	public String clickUntilMessage() {
		while (true) {
			driver.findElement(messageLink).click();
			String flashMessage = driver.findElement(flash).getText();
			if (flashMessage.contains("Action unsuccesful, please try again")) {
				return flashMessage;
			}
		}
	}
}
