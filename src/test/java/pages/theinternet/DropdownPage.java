package pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

	WebDriver driver;
	By dropdown = By.id("dropdown");

	public DropdownPage(WebDriver driver) {
		this.driver = driver;
	}

	public String selectOption(String option) {
		WebElement dropdownList = driver.findElement(dropdown);
		Select selectList = new Select(dropdownList);
		selectList.selectByVisibleText(option);
		return selectList.getFirstSelectedOption().getText();
	}
}
