package pages.theinterenet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPage {

	WebDriver driver;
	WebDriverWait wait;
	By inputButton = By.xpath("//*[@id='input-example']/button");
	By input = By.xpath("//*[@id='input-example']/input");
	By checkboxButton = By.xpath("//*[@id='checkbox-example']/button");
	By checkbox = By.xpath("//*[@id='checkbox']/input");
	By addedCheckbox = By.id("checkbox");
	By message = By.id("message");

	public DynamicControlsPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void writeIntoInput() {
		driver.findElement(inputButton).click();
		WebElement inputEnabled = wait.until(ExpectedConditions.elementToBeClickable(input));
		inputEnabled.sendKeys("Test");
	}

	public Boolean removeCheckbox() {
		driver.findElement(checkbox).click();
		driver.findElement(checkboxButton).click();
		return wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(checkbox)));
	}

	public Boolean disableInput() {
		driver.findElement(inputButton).click();
		return wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(input)));
	}

	public String addCheckbox() {
		driver.findElement(checkboxButton).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(addedCheckbox));
		return driver.findElement(message).getText();
	}
}
