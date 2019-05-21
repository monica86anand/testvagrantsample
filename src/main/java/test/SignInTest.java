package test;


import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactory.SignIn;

import com.sun.javafx.PlatformUtil;





@SuppressWarnings("restriction")
public class SignInTest {

	WebDriver driver;
	SignIn signIn;
	
	/**
	 * Create an instance of driver based on the platform
	 * and disable notifications
	 */
	@BeforeTest
	public void setup(){
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
	 * clicks on the link "Your trips"
	 * clicks on sign in button
	 * clicks on sign in button in the popup without entering creds
	 * validates the error message displayed
	 */
	@Test
	public void testSignIn(){
		//Create Sign In object
	signIn = new SignIn(driver);
	
	//clicks link "Your trips"
	signIn.clickYourTrips();
	//wait till sign in button is displayed and then click on the button
	signIn.clickSignIn();
	//switch to iframe and click on sign in button in the iframe
	signIn.switchToIframe();
	//wait till sign in button in iframe is displayed and then click on the button
	signIn.clickSignInButtonInPopUp();
	//wait till error message is displayed and then validates the text
	String errors1 = signIn.getErrorText();
    Assert.assertTrue(errors1.contains("There were errors in your submission"));
	}
	
	@AfterTest
	public void quitBrowser()
	{
		signIn.quitBrowser(driver);
	}
	
	
	
}
