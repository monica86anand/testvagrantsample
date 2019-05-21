package PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.javafx.PlatformUtil;
public class FlightBooking
{
	WebDriver driver;
	WebDriverWait wait; 
	/**
	 * All Web Elements are identified by @FindBy annotation
	 */
	@FindBy(id="OneWay")
	WebElement rdoOneWay;
	
	
	@FindBy(id="FromTag")
	WebElement txtFrom;
	
	
	@FindBy(xpath="//li[@class='list']//a[contains(text(),'Bangalore')]")
	WebElement lstFrom;
	
	
	
	
	@FindBy(id="ToTag")
	WebElement txtTo;
	
	
	@FindBy(xpath="//li[@class='list']//a[contains(text(),'Delhi')]")
	WebElement lstTo;
	
	
	@FindBy(xpath="//a[@class='ui-state-default ui-state-highlight ui-state-active ']")
	WebElement dtpFrom;
	
	
	
	@FindBy(id="SearchBtn")
	WebElement btnSearch;
	
	

	@FindBy(className="searchSummary")
	WebElement lblSearch;
	
	
	
	public FlightBooking(WebDriver driver){
		this.driver = driver;
		
		wait = new WebDriverWait(driver,30);
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	
   // checks if the element is present
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    //  pause execution for the specified time 
    public void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    
    //Click option "One Way"
    public void clickOneWayRadioButton()
    {
    	rdoOneWay.click();
    }
    
    //Set The state name from which the individual is going to start the journey 
    public void setFromState(String state )
    {
        txtFrom.clear();
        txtFrom.sendKeys(state);
    }
    
    //Set The destination state name 
    public void setToState(String state )
    {
        txtTo.clear();
        txtTo.sendKeys(state);
    }
    
    //Pick the airport name from which the individual is going to start the journey
    public void pickFromAirportName()
    {
    	lstFrom.click();
    }
	
	
    //Pick the destination airport name
    public void dropAtAirportName()
    {
    	lstTo.click();
    }
	
    //wait till boarding airport name is visible
    public void  waitTillVisible()
    {
    	 wait.until(ExpectedConditions.visibilityOf(lstFrom));
    }
    
    
    //wait till destination airport name is visible
    public void  waitTillDestAirportNameIsVisible()
    {
    	 wait.until(ExpectedConditions.visibilityOf(lstTo));
    }
    
   //select the flight boarding date as today
    public void selectStartDateAsTodaysDate()
    {
    	dtpFrom.click();
    }
    
    
    //Submit the details entered
   public void clickSubmit()
   {
	   btnSearch.click();
   }
    
   //Check is search results are displayed
   public boolean validateSearchResults()
   {
	   return lblSearch.isDisplayed();
   }
   
   
   //close the browser 
   public void quitBrowser()
   {
	   driver.quit();
   }
}