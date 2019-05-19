package pages.totaralearning;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportbuilderReportPage {
	
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(id="id_user-fullname_op")
	WebElement userFullNameDropdown;
	@FindBy(id="id_user-fullname")
	WebElement userFullNameInput;
	@FindBy(id="id_submitgroupstandard_addfilter")
	WebElement searchTable;
	@FindBy(id="rb_69_r0_c2")
	WebElement dateDue;
	@FindBy(id="rb_69_r0_c6")
	WebElement userOrgsNames;
	@FindBy(xpath="//a[text()=\"User's Position Name(s)\"]/span")
	WebElement userPosNamesAsc;
	@FindBy(xpath="//input[@value='Save this search']")
	WebElement saveSearch;
	@FindBy(id="id_submitgroupstandard_clearstandardfilters")
	WebElement clearSearch;
	//@FindBy(id="id_certcompletion-status_op")
	//WebElement statusOptionDropdown;
	By statusOptionDropdown = By.id("id_certcompletion-status_op");
	@FindBy(id="id_certcompletion-status")
	WebElement statusDropdown;
	@FindBy(xpath="//td[contains(@class, 'user_namelink')]/a")
	List<WebElement> usersFullNames;
	@FindBy(name="sid")
	WebElement savedSearchesDropdown;
	public ReportbuilderReportPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSaveSearch() {
		saveSearch.click();
	}
	
	public void clickClear() {
		clearSearch.click();
	}
	
	public String getUserFullName() {
		return usersFullNames.get(0).getText();
	}
	
	public void selectSavedSearchDropdown(String savedSearch) {
		Select selectList = new Select(savedSearchesDropdown);
		selectList.selectByVisibleText(savedSearch);
	}
		
	public List<String> getUsersFullNames() {
		List<String> fullNames = new ArrayList<String>();
		for (WebElement cell : usersFullNames) {
			fullNames.add(cell.getText());
		}
		return fullNames;
	}
	
	public void selectStatusOption(String option) {
		WebElement statusOptionDropdownExists = wait.until(ExpectedConditions.presenceOfElementLocated(statusOptionDropdown));
		Select selectList = new Select(statusOptionDropdownExists);
		selectList.selectByVisibleText(option);
	}
	
	public void selectStatus(String status) {
		Select selectList = new Select(statusDropdown);
		selectList.selectByVisibleText(status);
	}
	
	public void selectSearchFullNameOption(String option) {
		Select selectList = new Select(userFullNameDropdown);
		selectList.selectByVisibleText(option);
	}
	
	public void writeToFullNameInput(String name) {
		userFullNameInput.sendKeys(name);
	}
	
	public void clickSearchTable() {
		searchTable.click();
	}
	
	public String getDateDue() {
		return dateDue.getText();
	}
	
	public String getUserOrganisationName() {
		return userOrgsNames.getText();
	}
	
	public String getUserPositionNameAsc() {
		return userPosNamesAsc.getText();
	}
	
	public void searchTableByFullName(String option, String name) {
		this.selectSearchFullNameOption(option);
		this.writeToFullNameInput(name);
		this.clickSearchTable();
	}
	
	public void searchTableByStatus(String option, String status) {
		this.selectStatusOption(option);
		this.selectStatus(status);
		this.clickSearchTable();
	}
}
