package testcase;



import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import pageobject.loginobj;

public class TC01_Login extends baseclass {

	//only create one test 
	
	
	@Test
	
	public void test() throws InterruptedException, IOException {

		
		//driver.get(url);
		loggerob.info("url loaded");
		
		loginobj ob=new loginobj(driver);
		
		ob.username(username);
		loggerob.info("username entered");
		
		ob.password(password);
		loggerob.info("password entered");
		
		ob.loginbutton();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			
			Assert.assertTrue(true);		
			screenshot(driver,"logintest");
		}
		
		else {
			
			screenshot(driver,"logintest");
			Assert.assertTrue(false);
			
		}
		
}}
