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
	
	@BeforeTest
	public void setup() throws InterruptedException{
		 if (PlatformUtil.isMac()) {
      	   System.setProperty ("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
      }
      if (PlatformUtil.isWindows()) {
      	  
      	  System.setProperty ("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
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
	 * This test connects to the clear trip flight ticket booking portal
	 * selects the boarding and destination airport 
	 * picks the journey start date as current date
	 * submits the details and then validates the search results
	 * @throws InterruptedException 
	 */
	@Test
	public void testFlightBooking() throws InterruptedException{
		//Create Flight Booking object
	flightBooking = new FlightBooking(driver);
	
	//click One way radio button
	flightBooking.clickOneWayRadioButton();
	//select from and destination airports 
	flightBooking.setFromState("Ban");
	flightBooking.pickFromAirportName();
	flightBooking.setToState("Delhi");
	flightBooking.dropAtAirportName();
	//
	//pick boarding date
	flightBooking.selectStartDateAsTodaysDate();
	//Submit details entered
	flightBooking.clickSubmit();
	//validate search results
	flightBooking.validateSearchResults();
	
	}
	
	@AfterTest
	public void quitBrowser()
	{
		flightBooking.quitBrowser(driver);
	}
	
	
	
}
