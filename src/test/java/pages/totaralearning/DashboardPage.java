package pages.totaralearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	WebDriver driver;
	@FindBy(linkText="Manage organisations")
	WebElement manageOrgLink;
	@FindBy(linkText="Log out")
	WebElement logOutLink;
	@FindBy(xpath="//*[@id='inst621']/div[2]/ul/li[1]/a")
	WebElement certCompltLink;
	@FindBy(linkText="15")
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
