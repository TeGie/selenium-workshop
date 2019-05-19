package pages.theinterenet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	By username = By.id("username");
	By password = By.id("password");
	By login = By.xpath("//*[@id='login']/button");
	By logout = By.xpath("//*[@id='content']/div/a");
	By flash = By.id("flash");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setUsername(String strUsername) {
		driver.findElement(username).sendKeys(strUsername);
	}

	public void setPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}

	public void clickLogin() {
		driver.findElement(login).click();
	}

	public void clickLogout() {
		driver.findElement(logout).click();
	}

	public String getFlashMessage() {
		return driver.findElement(flash).getText();
	}
}
