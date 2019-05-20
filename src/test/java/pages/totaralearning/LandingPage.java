package pages.totaralearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;
	@FindBy(xpath = "//input[@value='Administrator']")
	WebElement adminLogin;
	@FindBy(xpath = "//input[@value='Manager']")
	WebElement managerLogin;
	@FindBy(xpath = "//input[@value='Course Creator']")
	WebElement courseCreatorLogin;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void logAsAdmin() {
		adminLogin.click();
	}

	public void logAsManager() {
		managerLogin.click();
	}

	public void logAsCourseCreator() {
		courseCreatorLogin.click();
	}
}
