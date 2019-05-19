package pages.totaralearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HierarchyItemViewPage {

	WebDriver driver;
	WebDriverWait wait;
	By overlayDiv = By.xpath("//div[contains(@class, 'ui-widget-overlay')]");
	By createTraining = By.xpath("//*[@id='item_2']/a");
	@FindBy(xpath = "//*[@id=\"user-notifications\"]/div/div[2]")
	WebElement alertMessage;
	@FindBy(id = "show-assignedgoals-dialog")
	WebElement addGoal;
	@FindBy(xpath = "(//*[@id='page-admin-totara-hierarchy-framework-index']//button/span[text()='Save'])[1]")
	WebElement saveGoal;
	@FindBy(xpath = "//input[@value='Return to organisation framework']")
	WebElement returnToFramework;

	public HierarchyItemViewPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public void clickReturnToFramework() {
		wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(overlayDiv)));
		returnToFramework.click();
	}

	public String getAlertMsg() {
		return alertMessage.getText();
	}

	public void clickAddGoal() {
		addGoal.click();
	}

	public void clickcreateTraining() {
		WebElement createTrainingEnabled = wait.until(ExpectedConditions.presenceOfElementLocated(createTraining));
		createTrainingEnabled.click();
	}

	public void clickSaveGoal() {
		saveGoal.click();
	}

	public void addGoal() {
		this.clickAddGoal();
		this.clickcreateTraining();
		this.clickSaveGoal();
	}
}
