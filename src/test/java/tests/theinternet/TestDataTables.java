package tests.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.theinterenet.DataTablesPage;

public class TestDataTables {

	WebDriver driver;
	DataTablesPage objDataTables;

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/tables");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void getDataFromTable() {
		objDataTables = new DataTablesPage(driver);
		objDataTables.printCellText("table1", 3, 1);
		objDataTables.printCellText("table1", 3, 2);
		objDataTables.printCellText("table1", 3, 3);
		objDataTables.printCellText("table1", 1, 5);
		objDataTables.printCellText("table1", 4, 5);
		objDataTables.printDueSum("table1");
	}
}
