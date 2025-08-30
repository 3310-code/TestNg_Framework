package pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class loginobj {

	public WebDriver driver;

	
	public loginobj (WebDriver driver) {
		
	  this. driver = driver;
	  PageFactory.initElements(driver,this);
	}
	
	
	@FindBy (name="uid") 
	WebElement username;
	
	@FindBy (name="password")
	WebElement pass;
	
	@FindBy (name="btnLogin")
	WebElement loginbutton;
	
	
	@FindBy (xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement logout;
	
	
	
	
/*	WebElement username = driver.findElement(By.xpath("//input[@name='uid']"));
	WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
	WebElement loginbutton =  driver.findElement(By.xpath("//input[@name='btnLogin']"));
	
	*/

    
  
		public void username(String name) {
			
	      username.sendKeys(name);
		}
			
		public void password(String password) {
			
		  pass.sendKeys(password);
		
		}
		
		public void loginbutton() {
			
		  loginbutton.click();
		}
	
		
	
		public void logout() {
			
			logout.click();
		}
		
		

		
		
}
