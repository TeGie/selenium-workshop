package tests.totaralearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.totaralearning.*;

public class TestCase1 {
	WebDriver driver;
	WebDriverWait wait;
	LandingPage objLandPage;
	DashboardPage objDashPage;
	HierarchyFrameworkEditPage objHFEditPage;
	HierarchyFrameworkIndexPage objHFIndexPage;
	HierarchyIndexPage objHIndexPage;
	HierarchyItemViewPage objHItemPage;

	public static final String LORE_IPSUM_1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
			+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, "
			+ "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute "
			+ "irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. "
			+ "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim "
			+ "id est laborum.";

	public static final String LORE_IPSUM_2 = "Morbi luctus, nisi eget tempus faucibus, justo massa iaculis "
			+ "odio, eget sollicitudin lectus justo ut neque. Aliquam ornare urna sed vestibulum vestibulum. "
			+ "Donec at enim arcu. Aenean volutpat aliquam maximus. Aenean id scelerisque dolor, eget congue eros. "
			+ "Integer a mi non velit cursus aliquam vitae eu libero. Aliquam rutrum lorem eu vehicula feugiat. "
			+ "In hac habitasse platea dictumst. Aliquam erat volutpat.";

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 20);
		driver.get("https://demo.totaralearning.com");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void testCase1() {
		objLandPage = new LandingPage(driver);
		objDashPage = new DashboardPage(driver);
		objHFIndexPage = new HierarchyFrameworkIndexPage(driver);
		objHFEditPage = new HierarchyFrameworkEditPage(driver);
		objHIndexPage = new HierarchyIndexPage(driver);
		objHItemPage = new HierarchyItemViewPage(driver, wait);

		objLandPage.logAsAdmin();
		objDashPage.clickManageOrganisations();
		objHFIndexPage.clickAddNewOrganisation();
		objHFEditPage.addOrganisation("New Test Organisation", "369", LORE_IPSUM_1);
		String addedOrgMsg = objHFIndexPage.getAlertMsg();
		objHFIndexPage.clickOrgLink();
		objHIndexPage.clickAddNewOrganisation();
		objHFEditPage.addOrganisation("Automation", Helpers.getRandom(), LORE_IPSUM_2);
		String addedNewOrgMsg = objHItemPage.getAlertMsg();
		objHItemPage.addGoal();
		objHItemPage.clickReturnToFramework();
		objDashPage.clickLogOut();

		Assert.assertEquals(addedOrgMsg, "The organisation framework \"New Test Organisation\" has been added");
		Assert.assertEquals(addedNewOrgMsg, "The organisation \"Automation\" has been added");
	}
}
