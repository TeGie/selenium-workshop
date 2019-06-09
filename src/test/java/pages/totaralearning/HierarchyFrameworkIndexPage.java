package pages.totaralearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HierarchyFrameworkIndexPage {

	WebDriver driver;
	@FindBy(xpath = "//input[@value='Add new organisation framework']")
	WebElement addNewOrgFramework;
	@FindBy(xpath = "//*[@id='user-notifications']//div[@class='alert-message']")
	WebElement alertMessage;
	@FindBy(linkText = "New Test Organisation")
	WebElement organisationLink;
	@FindBy(xpath = "//td[a[text()='New Test Organisation']]/following-sibling::td//a[@title='Delete']")
	WebElement deleteNewTestOrganisation;
	@FindBy(linkText = "Manage organisations")
	WebElement manageOrganisationLink;

	public HierarchyFrameworkIndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAddNewOrganisation() {
		addNewOrgFramework.click();
	}

	public String getAlertMsg() {
		return alertMessage.getText();
	}

	public void clickOrgLink() {
		organisationLink.click();
	}
	
	public void deleteNewTestOrganization() {
		deleteNewTestOrganisation.click();
	}

	public void goToManageOrganization() {
		manageOrganisationLink.click();
	}
}
