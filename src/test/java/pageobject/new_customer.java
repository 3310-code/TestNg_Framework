package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class new_customer {

	
	WebDriver driver;
	
	public new_customer(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	
	
	@FindBy (xpath="/html/body/div[3]/div/ul/li[2]/a")
	WebElement pagelink;
	
	@FindBy (name="name")
	WebElement name;
	
	
	@FindBy (name="rad1")
	WebElement male;
	
	@FindBy (name="rad1")
	WebElement female;
	
	@FindBy (name="dob")
	WebElement dob;
	
	
	@FindBy (name="addr")
	WebElement adress;
	
	
	@FindBy (name="city")
	WebElement city;
	
	
	@FindBy (name="state")
	WebElement state;
	
	
	@FindBy (name="pinno")
	WebElement pincode;
	
	
	@FindBy (name="telephoneno")
	WebElement number;
	
	
	@FindBy (name="emailid")
	WebElement email;
	
	
	@FindBy (name="password")
	WebElement password;
	
	
	@FindBy (name="sub")
	WebElement submit;
	
	
	
	
	      public void pagelink() {
		
		    pagelink.click();
		    
	      }	     
	
          public void namemethod(String namedetail) {
		
        	  name.sendKeys(namedetail);     
          }
          
          
          public void gendermethod() {
        	  
        	  male.click();
          }
          
          
          public void dobmethod(String m, String d, String y) {
        	  
        	  dob.sendKeys(m);
        	  dob.sendKeys(d);
        	  dob.sendKeys(y);
          }
          
          public void adressmethod(String adressedtail) {
        	  
        	  adress.sendKeys(adressedtail);
          }
          
          public void citymethod(String citydetail) {
        	  
        	  city.sendKeys(citydetail);
          }
          
          public void statedetail(String statedetail) {
        	  
        	  state.sendKeys(statedetail);
          }
		
          public void pincodemethod(String pincodedetail) {
        	  
        	  pincode.sendKeys(pincodedetail);
          }
          
          
          public void numbermethod(String numberdetail) {
        	  
        	  number.sendKeys(numberdetail);
          }
          
          public void emailmethod(String emaildetail) {
        	  
        	  email.sendKeys(emaildetail);
          }
          
          
          public void passwordmethod(String passworddetail) {
        	  
        	  password.sendKeys(passworddetail);
          }
          
          public void submitmethod() {
        	  
        	  submit.click();
          }
          
         
	
	
	
	
}
