package tests.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.theinterenet.LoginPage;

public class TestLogin {

	WebDriver driver;
	LoginPage objLogin;

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void loginLogout() {
		objLogin = new LoginPage(driver);
		objLogin.setUsername("tomsmith");
		objLogin.setPassword("SuperSecretPassword!");
		objLogin.clickLogin();
		String loginMessage = objLogin.getFlashMessage();
		objLogin.clickLogout();
		String logoutMessage = objLogin.getFlashMessage();

		Assert.assertTrue(loginMessage.contains("You logged into a secure area!"));
		Assert.assertTrue(logoutMessage.contains("You logged out of the secure area!"));
	}
}
