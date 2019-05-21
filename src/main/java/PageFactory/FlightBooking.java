package PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
public class FlightBooking extends UtilMethods
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
	
	
	
	public FlightBooking(WebDriver driver) throws InterruptedException{
		this.driver = driver;
		
		wait = new WebDriverWait(driver,30);
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
		
	}
	

    
    
   
    //Click option "One Way"
    public void clickOneWayRadioButton() 
    {
    
    	waitTillVisible(wait, rdoOneWay);
    	click(rdoOneWay);
    }
    
    //Set The state name from which the individual is going to start the journey 
    public void setFromState(String state )
    {
       
        clearAndSetText(txtFrom, state);
    }
    
    //Set The destination state name 
    public void setToState(String state )
    {
        
        clearAndSetText(txtTo, state);
    }
    
    //Pick the airport name from which the individual is going to start the journey
    public void pickFromAirportName()
    {
    	waitTillVisible(wait, lstFrom);
    	click(lstFrom);
    }
	
	
    //Pick the destination airport name
    public void dropAtAirportName()
    {
    	waitTillVisible(wait, lstTo);
    	click(lstTo);
    }
	
 
   
   
    
   //select the flight boarding date as today
    public void selectStartDateAsTodaysDate()
    {
    	waitTillVisible(wait, dtpFrom);
    	click(dtpFrom);
    }
    
    
    //Submit the details entered
   public void clickSubmit()
   {
	   
	   click(btnSearch);
   }
    
  
   
   //Check is search results are displayed
   public boolean validateSearchResults()
   {
	   waitTillVisible(wait, lblSearch);
	   return lblSearch.isDisplayed();
   }
   
   
   
   
   
   
}