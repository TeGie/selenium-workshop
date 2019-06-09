package pages.totaralearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	WebDriver driver;
	@FindBy(linkText = "Manage organisations")
	WebElement manageOrgLink;
	@FindBy(linkText = "Log out")
	WebElement logOutLink;
	@FindBy(xpath = "//a[contains(normalize-space(),'Certification Completion')]")
	WebElement certCompltLink;
	@FindBy(xpath = "//a[@href=//a[text()='Resuscitation training']/@href]")
	WebElement resuscitationEventLink;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickResuscitationEventLink() {
		resuscitationEventLink.click();
	}

	public void clickManageOrganisations() {
		manageOrgLink.click();
	}

	public void clickLogOut() {
		logOutLink.click();
	}

	public void clickCertificationCompltLink() {
		certCompltLink.click();
	}
}
