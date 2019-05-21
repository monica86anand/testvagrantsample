package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelBooking extends UtilMethods {
	WebDriver driver;
	WebDriverWait wait;
	/**
	 * All Web Elements are identified by @FindBy annotation
	 */
	@FindBy(linkText = "Hotels")
	private WebElement lnkHotels;

	@FindBy(id = "Tags")
	private WebElement txtBoxLocality;

	@FindBy(id = "SearchHotelsButton")
	private WebElement btnSearch;

	@FindBy(id = "travellersOnhome")
	private WebElement lstRooms;

	public HotelBooking(WebDriver driver) {
		this.driver = driver;

		wait = new WebDriverWait(driver, 30);
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	// Click on hotel link
	public void clickHotelLink() {
		click(lnkHotels);
	}

	// Type in the location to search for hotels
	public void setLocation(String location) {
		waitTillVisible(wait, txtBoxLocality);
		clearAndSetText(txtBoxLocality, location);
	}

	// Select relevant option from drop down based on the no of rooms and people
	public void selectOption(String room) {
		selectOptionFromDropDown(lstRooms, room);
	}

	// Click search button
	public void clickSearchButton() {
		click(btnSearch);
	}

}