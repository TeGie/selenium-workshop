package pages.totaralearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HierarchyFrameworkEditPage {

	WebDriver driver;
	@FindBy(id = "id_fullname")
	WebElement name;
	@FindBy(id = "id_idnumber")
	WebElement number;
	@FindBy(id = "id_description_editoreditable")
	WebElement description;
	@FindBy(id = "id_submitbutton")
	WebElement submit;

	public HierarchyFrameworkEditPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterName(String strName) {
		name.sendKeys(strName);
	}

	public void enterIdNumber(String strNumber) {
		number.sendKeys(strNumber);
	}

	public void enterDescription(String strDesc) {
		description.sendKeys(strDesc);
	}

	public void clickSubmit() {
		submit.click();
	}

	public void addOrganisation(String strName, String strNumber, String strDesc) {
		this.enterName(strName);
		this.enterIdNumber(strNumber);
		this.enterDescription(strDesc);
		this.clickSubmit();
	}
}
