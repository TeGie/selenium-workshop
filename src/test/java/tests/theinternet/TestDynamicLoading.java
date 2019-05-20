package tests.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.theinterenet.DynamicLoadingPage;

public class TestDynamicLoading {

	WebDriver driver;
	WebDriverWait wait;
	DynamicLoadingPage objDynamicLoading;

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 20);
		driver.get("https://the-internet.herokuapp.com/dynamic_loading");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void dynamicLoading() {
		objDynamicLoading = new DynamicLoadingPage(driver, wait);
		String message1 = objDynamicLoading.waitForHelloExample1();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		String message2 = objDynamicLoading.waitForHelloExample2();

		Assert.assertEquals(message1, "Hello World!");
		Assert.assertEquals(message2, "Hello World!");
	}
}
