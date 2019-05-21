package test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactory.FlightBooking;

import com.sun.javafx.PlatformUtil;

@SuppressWarnings("restriction")
public class FlightBookingTest {

	WebDriver driver;
	FlightBooking flightBooking;
	/**
	 * Create an instance of driver based on the platform and disable
	 * notifications
	 */
	@BeforeTest
	public void setup() {
		String path = System.getProperty("user.dir");
		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", path
					+ "\\src\\main\\resources\\chromedriver");
		}
		if (PlatformUtil.isWindows()) {

			System.setProperty("webdriver.chrome.driver", path
					+ "\\src\\main\\resources\\chromedriver.exe");

		}
		if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", path
					+ "\\src\\main\\resources\\chromedriver_linux");
		}
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		driver.get("https://www.cleartrip.com/");

	}

	/**
	 * This test connects to the clear trip flight ticket booking portal,
	 * selects the boarding and destination airport, picks the journey start
	 * date as current date ,submits the details and then validates the search
	 * results
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testFlightBooking() throws InterruptedException {
		// Create Flight Booking object
		flightBooking = new FlightBooking(driver);

		// click One way radio button
		flightBooking.clickOneWayRadioButton();
		// select from and destination airports
		System.out.println(System.getProperty("user.dir"));

		flightBooking.setToState("Delhi");
		flightBooking.selectBoardingAndDestinationAirport("Delhi");

		flightBooking.setFromState("Bangalore");
		flightBooking.selectBoardingAndDestinationAirport("Bangalore");

		// pick boarding date
		flightBooking.selectStartDateAsTodaysDate();
		// Submit details entered
		flightBooking.clickSubmit();
		// validate search results

		flightBooking.validateSearchResults();

	}

	@AfterTest
	public void quitBrowser() {
		flightBooking.quitBrowser(driver);
	}

}
