package pages.totaralearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HierarchyFrameworkDeletePage {

	WebDriver driver;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueButton;

	public HierarchyFrameworkDeletePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void confirmRemoveOrganisation() {
		continueButton.click();
	}

}
