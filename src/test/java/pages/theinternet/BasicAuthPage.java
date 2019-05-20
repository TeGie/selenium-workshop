package pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicAuthPage {

	WebDriver driver;
	By basicAuthParagraph = By.cssSelector(".example p");

	public BasicAuthPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getBasicAuthMessage() {
		return driver.findElement(basicAuthParagraph).getText();
	}
}
