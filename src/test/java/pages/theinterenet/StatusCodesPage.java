package pages.theinterenet;

import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StatusCodesPage {

	WebDriver driver;

	public StatusCodesPage(WebDriver driver) {
		this.driver = driver;
	}

	public int getCode(String code) {
		WebElement link = driver.findElement(By.linkText(code));
		String href = link.getAttribute("href");
		return RestAssured.get(href).statusCode();
	}
}
