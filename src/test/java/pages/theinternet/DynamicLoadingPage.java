package pages.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage {

	WebDriver driver;
	WebDriverWait wait;
	By loading1 = By.partialLinkText("Example 1");
	By loading2 = By.partialLinkText("Example 2");
	By startButton = By.xpath("//*[@id='start']/button");
	By finishDiv = By.id("finish");

	public DynamicLoadingPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public String waitForHelloExample1() {
		driver.findElement(loading1).click();
		driver.findElement(startButton).click();
		WebElement msgDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(finishDiv));
		return msgDiv.findElement(By.tagName("h4")).getText();
	}

	public String waitForHelloExample2() {
		driver.findElement(loading2).click();
		driver.findElement(startButton).click();
		WebElement msgDiv = wait.until(ExpectedConditions.presenceOfElementLocated(finishDiv));
		return msgDiv.findElement(By.tagName("h4")).getText();
	}
}
