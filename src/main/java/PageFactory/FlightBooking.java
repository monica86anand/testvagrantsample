package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightBooking extends UtilMethods {
	WebDriver driver;
	WebDriverWait wait;
	/**
	 * All Web Elements are identified by @FindBy annotation
	 */
	@FindBy(id = "OneWay")
	private WebElement rdoOneWay;

	@FindBy(id = "FromTag")
	private WebElement txtFrom;
	
	@FindBy(xpath = "//ul//li[@class='list']//a[contains(text(),'')]")
	private WebElement lstSourceDestination;

	@FindBy(xpath = "//li[@class='list']//a[contains(text(),'Bangalore')]")
	private WebElement lstFrom;

	@FindBy(id = "ToTag")
	private WebElement txtTo;

	@FindBy(xpath = "//li[@class='list']//a[contains(text(),'Delhi')]")
	private WebElement lstTo;
	
	@FindBy(xpath = "//i[@class='icon ir datePicker']")
	private WebElement imgDatePicker;

	@FindBy(xpath = "//a[@class='ui-state-default ui-state-highlight ui-state-active ']")
	private WebElement dtpFrom;

	@FindBy(id = "SearchBtn")
	private WebElement btnSearch;

	@FindBy(className = "searchSummary")
	private WebElement lblSearch;

	public FlightBooking(WebDriver driver) throws InterruptedException {
		this.driver = driver;

		wait = new WebDriverWait(driver, 30);
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	// Click option "One Way"
	public void clickOneWayRadioButton() {

		waitTillVisible(wait, rdoOneWay);
		click(rdoOneWay);
	}

	// Set The state name from which the individual is going to start the
	// journey
	public void setFromState(String state) {

		clearAndSetText(txtFrom, state);
	}

	// Set The destination state name
	public void setToState(String state) {

		clearAndSetText(txtTo, state);
	}

	// Pick the airport name from which the individual is going to start the
	// journey
	public void pickFromAirportName() {
		waitTillVisible(wait, lstFrom);
		click(lstFrom);
	}

	// Pick the destination airport name
	public void dropAtAirportName() {
		waitTillVisible(wait, lstTo);
		click(lstTo);
	}

	// select the flight boarding date as today
	public void selectStartDateAsTodaysDate() {
		click(imgDatePicker);
		waitTillVisible(wait, dtpFrom);
		click(dtpFrom);
	}

	// Submit the details entered
	public void clickSubmit() {

		click(btnSearch);
	}

	// Check is search results are displayed
	public boolean validateSearchResults() {
		waitTillVisible(wait, lblSearch);
		return lblSearch.isDisplayed();
	}
	
	public void selectBoardingAndDestinationAirport(String s) throws InterruptedException
	{
		selectValueFromDropdown(s,lstSourceDestination,wait,driver);
	}

}