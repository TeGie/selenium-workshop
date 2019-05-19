package pages.totaralearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ModFacetofaceEventsAddPage {

	WebDriver driver;
	@FindBy(xpath = "//a[contains(@class, 'dateremove')]")
	WebElement removeSession;
	@FindBy(id = "id_registrationtimestart_enabled")
	WebElement enableStart;
	@FindBy(id = "id_registrationtimefinish_enabled")
	WebElement enableFinish;
	@FindBy(id = "id_registrationtimestart_day")
	WebElement startDayDropdown;
	@FindBy(id = "id_registrationtimestart_month")
	WebElement startMonthDropdown;
	@FindBy(id = "id_registrationtimestart_year")
	WebElement startYearDropdown;
	@FindBy(id = "id_registrationtimestart_hour")
	WebElement startHourDropdown;
	@FindBy(id = "id_registrationtimestart_minute")
	WebElement startMinuteDropdown;
	@FindBy(id = "id_registrationtimestart_timezone")
	WebElement startTimeZoneDropdown;
	@FindBy(id = "id_registrationtimefinish_day")
	WebElement finishDayDropdown;
	@FindBy(id = "id_registrationtimefinish_month")
	WebElement finishMonthDropdown;
	@FindBy(id = "id_registrationtimefinish_year")
	WebElement finishYearDropdown;
	@FindBy(id = "id_registrationtimefinish_hour")
	WebElement finishHourDropdown;
	@FindBy(id = "id_registrationtimefinish_minute")
	WebElement finishMinuteDropdown;
	@FindBy(id = "id_registrationtimefinish_timezone")
	WebElement finishTimeZoneDropdown;
	@FindBy(id = "id_capacity")
	WebElement capacity;
	@FindBy(id = "id_allowoverbook")
	WebElement waitlist;
	@FindBy(id = "id_allowcancellations_1")
	WebElement cancellation;
	@FindBy(id = "id_mincapacity")
	WebElement mincapacity;
	@FindBy(id = "id_normalcost")
	WebElement normalcost;
	@FindBy(id = "id_discountcost")
	WebElement discountcost;
	@FindBy(id = "id_details_editoreditable")
	WebElement details;
	@FindBy(id = "id_trainerrole_3_13")
	WebElement editingTrainer;
	@FindBy(id = "id_trainerrole_4_4")
	WebElement trainer;
	@FindBy(id = "id_submitbutton")
	WebElement submit;

	public ModFacetofaceEventsAddPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectDateTime(WebElement element, String dateTime) {
		Select selectList = new Select(element);
		selectList.selectByVisibleText(dateTime);
	}

	public void setStartDateTime(String[] dateTime) {
		this.selectDateTime(startDayDropdown, dateTime[0]);
		this.selectDateTime(startMonthDropdown, dateTime[1]);
		this.selectDateTime(startYearDropdown, dateTime[2]);
		this.selectDateTime(startHourDropdown, dateTime[3]);
		this.selectDateTime(startMinuteDropdown, dateTime[4]);
		this.selectDateTime(startTimeZoneDropdown, dateTime[5]);
	}

	public void setFinishDateTime(String[] dateTime) {
		this.selectDateTime(finishDayDropdown, dateTime[0]);
		this.selectDateTime(finishMonthDropdown, dateTime[1]);
		this.selectDateTime(finishYearDropdown, dateTime[2]);
		this.selectDateTime(finishHourDropdown, dateTime[3]);
		this.selectDateTime(finishMinuteDropdown, dateTime[4]);
		this.selectDateTime(finishTimeZoneDropdown, dateTime[5]);
	}

	public void clickEnableStart() {
		enableStart.click();
	}

	public void clickEnableFinish() {
		enableFinish.click();
	}

	public void setCapacity(String cap) {
		capacity.sendKeys(cap);
	}

	public void clickWaitlist() {
		waitlist.click();
	}

	public void clickCancellation() {
		cancellation.click();
	}

	public void setMinCapacity(String mincap) {
		mincapacity.sendKeys(mincap);
	}

	public void setNormalcost(String ncost) {
		normalcost.sendKeys(ncost);
	}

	public void setDiscountcost(String dcost) {
		discountcost.sendKeys(dcost);
	}

	public void setDetails(String det) {
		details.sendKeys(det);
	}

	public void clickEditingTrainer() {
		editingTrainer.click();
	}

	public void clickTrainer() {
		trainer.click();
	}

	public void clickSubmit() {
		submit.click();
	}

	public void setStartDate(String[] dateTime) {
		this.clickEnableStart();
		this.setStartDateTime(dateTime);
	}

	public void setEndDate(String[] dateTime) {
		this.clickEnableFinish();
		this.setFinishDateTime(dateTime);
	}

	public void createEvent(String[] args) {
		this.setCapacity(args[0]);
		this.clickWaitlist();
		this.clickCancellation();
		this.setMinCapacity(args[1]);
		this.setNormalcost(args[2]);
		this.setDiscountcost(args[3]);
		this.setDetails(args[4]);
		this.clickEditingTrainer();
		this.clickTrainer();
		this.clickSubmit();
	}

	public void clickRemoveSession() {
		removeSession.click();
	}
}
