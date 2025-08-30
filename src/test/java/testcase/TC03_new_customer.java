package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import net.bytebuddy.utility.RandomString;
import pageobject.loginobj;
import pageobject.new_customer;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;


public class TC03_new_customer extends baseclass{

	
	@Test
	
	public void newcustomer() throws InterruptedException, IOException {
		
		
		loginobj loginob=new loginobj(driver);
		loginob.username(username);
		loginob.password(password);            // login first
		loginob.loginbutton();
		
		Thread.sleep(3000);
		
		
		new_customer customerob = new new_customer(driver);
		customerob.pagelink();
		customerob.namemethod("Arun");
		customerob.gendermethod();
		customerob.dobmethod("12","12", "2025");
		customerob.adressmethod("AAAA");
		customerob.citymethod("Alappuzha");
		customerob.statedetail("Kerala");
		customerob.pincodemethod("1234");
		
		String number = randomnumber();   // defined in base class
		customerob.numbermethod(number);
		
		String email = randomemail()+"@gmail.com";      // defined in base class
		customerob.emailmethod(email);
		
		customerob.submitmethod();
		
		
		//check the registration is sucess or not
		
		boolean res = driver.getPageSource().contains("FVustomer Registered Sucessfully");   // check the statement 
		                                                                                          //in page and return t or f
		
		
		if(res==true) {
			
			Assert.assertTrue(true);
		}
		else {
			
			screenshot(driver,"new_customer");
			Assert.assertTrue(false);
		}
		
		
	}
	
	
	
	
	  	
		
	}
	
	
	
	

