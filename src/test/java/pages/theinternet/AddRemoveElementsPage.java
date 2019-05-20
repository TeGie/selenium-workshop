package pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRemoveElementsPage {

	WebDriver driver;
	By addButton = By.xpath("//*[@id='content']/div/button");
	By deleteButtons = By.xpath("//*[@id='elements']/button");

	public AddRemoveElementsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddButton() {
		driver.findElement(addButton).click();
	}

	public void clickDeleteButton() {
		driver.findElements(deleteButtons).get(0).click();
	}

	public int countButtons() {
		return driver.findElements(deleteButtons).size();
	}
}
