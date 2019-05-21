package test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactory.HotelBooking;

import com.sun.javafx.PlatformUtil;

@SuppressWarnings("restriction")
public class HotelBookingTest {

	WebDriver driver;
	HotelBooking hotelBooking;

	/**
	 * Create an instance of driver based on the platform and disable
	 * notifications
	 */
	@BeforeTest
	public void setup() {
		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\chromedriver_win32\\chromedriver.exe");
		}
		if (PlatformUtil.isWindows()) {

			System.setProperty("webdriver.chrome.driver",
					"D:\\chromedriver_win32\\chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		}
		if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		}

		driver.get("https://www.cleartrip.com/");
	}

	/**
	 * This test connects to the clear trip portal ,Clicks on the Hotels link
	 * sets the location to search for hotels, selects the option
	 * "1 room, 2 adults" and then clicks on submit
	 */
	@Test
	public void testHotelBooking() {
		// Create Sign In object
		hotelBooking = new HotelBooking(driver);
        //Click on hotel link
		hotelBooking.clickHotelLink();
		//Sets the locality to search for hotels
		hotelBooking.setLocation("Indiranagar, Bangalore");
		//Selects the default room option from dropdown
		hotelBooking.selectOption("1 room, 2 adults");
		//Click the search button
		hotelBooking.clickSearchButton();
		
	}

	@AfterTest
	public void quitBrowser() {
		hotelBooking.quitBrowser(driver);
	}

}
