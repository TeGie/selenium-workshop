package pages.theinterenet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatusCodesPage {

	WebDriver driver;
	By statusCode = By.xpath("//*[@id='content']/div/p");

	public StatusCodesPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickPage(String code) {
		driver.findElement(By.linkText(code)).click();
	}

	public String getStatusCode() {
		return driver.findElement(statusCode).getText();
	}
}
