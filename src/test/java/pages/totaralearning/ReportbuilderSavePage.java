package pages.totaralearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportbuilderSavePage {
	
	WebDriver driver;
	@FindBy(id="id_submitbutton")
	WebElement searchNameSave;
	@FindBy(id="id_name")
	WebElement searchNameInput;
	public ReportbuilderSavePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void writeSearchName(String name) {
		searchNameInput.sendKeys(name);
	}
	
	public void clickSaveSearchName() {
		searchNameSave.click();
	}
	
	public void saveSearch(String name) {
		this.writeSearchName(name);
		this.clickSaveSearchName();
	}
}
