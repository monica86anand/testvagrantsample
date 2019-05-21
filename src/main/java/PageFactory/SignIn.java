package PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SignIn extends UtilMethods
{
	WebDriver driver;
	WebDriverWait wait; 
	/**
	 * All Web Elements are identified by @FindBy annotation
	 */
	@FindBy(linkText="Your trips")
	WebElement lnkYourTrips;
	
	
	@FindBy(id="SignIn")
	WebElement btnSignIn;
	
	@FindBy(id="modal_window")
	WebElement iframeSignIn;
	
	
	@FindBy(id="signInButton")
	WebElement btnSignInButton;
	
	
	@FindBy(id="errors1")
	WebElement txtErrors;
	
	public SignIn(WebDriver driver){
		this.driver = driver;
		
		wait = new WebDriverWait(driver,30);
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
 //Click on Your Trips link in the landing page of clear trip
	public void clickYourTrips()
	{
		waitTillVisible(wait, lnkYourTrips);
		click(lnkYourTrips);
		
	}
	
	
	
//Click on Sign In Button to enter creds
	public void clickSignIn()
	{
		waitTillVisible(wait, btnSignIn);
		click(btnSignIn);
	}
	
	public void switchToIframe()
	{
		
		waitTillVisible(wait, iframeSignIn);
		switchToIframe(driver,iframeSignIn);
	}
	
	
//Click on Sign In Button in the pop up without entering creds
	public void clickSignInButtonInPopUp()
	{
		waitTillVisible(wait, btnSignInButton);
		click(btnSignInButton);
	}
	
	
	
	//Return error text
	public String getErrorText()
	{
		waitTillVisible(wait, txtErrors);
	    return	getText(txtErrors);
	}
  
}