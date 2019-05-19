package tests.totaralearning;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.totaralearning.*;

public class TestCase2 {
	WebDriver driver;
	WebDriverWait wait;
	LandingPage objLandPage;
	DashboardPage objDashPage;
	ReportbuilderReportPage objRBReportPage;
	ReportbuilderSavePage objRBSavePage;
	
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
    public void testCase2() {
		objLandPage = new LandingPage(driver);
		objDashPage = new DashboardPage(driver);
		objRBReportPage = new ReportbuilderReportPage(driver, wait);
		objRBSavePage = new ReportbuilderSavePage(driver);
		
		objLandPage.logAsManager();
		objDashPage.clickCertificationCompltLink();
		objRBReportPage.searchTableByFullName("starts with", "Jason");
		String dateDue = objRBReportPage.getDateDue();
		String userPositionNameOrder = objRBReportPage.getUserPositionNameAsc();
		String userOrgName = objRBReportPage.getUserOrganisationName();
		objRBReportPage.clickSaveSearch();
		objRBSavePage.saveSearch("Search Jason");
		objRBReportPage.clickClear();
		objRBReportPage.searchTableByStatus("is equal to", "Expired");
		List<String> usersList = objRBReportPage.getUsersFullNames();
		objRBReportPage.selectSavedSearchDropdown("Search Jason");
		String userName = objRBReportPage.getUserFullName();
		objDashPage.clickLogOut();
		
		Assert.assertEquals(dateDue, "27 Jul 2018 at 09:55");
		Assert.assertEquals(userPositionNameOrder, "Sort by User's Position Name(s) Ascending");
		Assert.assertEquals(userOrgName, "Internal Helpdesk");
		Assert.assertEquals(userName, "Jason Cochran");
		
		for ( String user : usersList) {
			System.out.println(user);
		}		
	}
}