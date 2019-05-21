package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilMethods {

	// close the browser
	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}

	// add sleep time
	public void sleep() throws InterruptedException {
		Thread.sleep(5);
	}

	// wait till a web element is visible
	public void waitTillVisible(WebDriverWait wait, WebElement webElement)

	{
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	// Click button
	public void click(WebElement webElement) {
		webElement.click();
	}

	// Clear and set text
	public void clearAndSetText(WebElement webElement, String text) {
		webElement.clear();
		webElement.sendKeys(text);
	}

	// switch to iframe
	public void switchToIframe(WebDriver driver, WebElement webElement) {
		driver.switchTo().frame(webElement);
	}

	// return text for eg of error message

	public String getText(WebElement webElement) {
		return webElement.getText();
	}
	
	//select by visible text
	public void selectOptionFromDropDown(WebElement webElement,String room)
	{
	new Select(webElement).selectByVisibleText(room);
	}
}