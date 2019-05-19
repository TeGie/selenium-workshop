package pages.theinterenet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxesPage {
	
	WebDriver driver;
	By checkboxes = By.xpath("//*[@id='checkboxes']/input");
	public CheckboxesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickCheckbox(int checkboxNumber) {
		driver.findElements(checkboxes).get(checkboxNumber).click();
	}
	
	public String getChecked(int checkboxNumber) {
		return driver.findElements(checkboxes).get(checkboxNumber).getAttribute("checked");
	}
}
