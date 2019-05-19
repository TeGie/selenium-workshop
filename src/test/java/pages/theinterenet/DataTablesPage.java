package pages.theinterenet;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DataTablesPage {

	WebDriver driver;

	public DataTablesPage(WebDriver driver) {
		this.driver = driver;
	}

	public void printCellText(String table, int row, int col) {
		String tableCell = "//*[@id='" + table + "']/tbody/tr[" + row + "]/td[" + col + "]";
		System.out.println(driver.findElement(By.xpath(tableCell)).getText());
	}

	public void printDueSum(String table) {
		String tableRows = "//*[@id='" + table + "']/tbody/tr";
		List<WebElement> rows = driver.findElements(By.xpath(tableRows));
		String pattern = "(\\d+.\\d{2})";
		Pattern r = Pattern.compile(pattern);
		double totalDue = 0;
		for (WebElement row : rows) {
			String strDue = row.getText();
			Matcher m = r.matcher(strDue);
			m.find();
			double dDue = Double.parseDouble(m.group(1));
			totalDue += dDue;
		}
		System.out.println(totalDue);
	}
}
