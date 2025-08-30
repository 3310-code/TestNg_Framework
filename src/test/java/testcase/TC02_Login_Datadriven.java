package testcase;

import static org.junit.Assert.*;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

import pageobject.loginobj;
import utility.XLUtility;

public class TC02_Login_Datadriven extends baseclass {

	@Test(dataProvider="loginData")
   
	public void test(String user, String password) throws InterruptedException  //date provider will pass two values 
	{
		
			loginobj ob = new loginobj(driver);     // create object of loginobj page
			ob.username(user);  // passs the value to method
			loggerob.info("username provided");
			ob.password(password);
			loggerob.info("password provided");
			ob.loginbutton();
			
			
			
			if(isAlertPresent() == true) {   // alert is available

				driver.switchTo().alert().accept();   //close failed log in alert
				driver.switchTo().defaultContent();  //  move control to default browser
				Assert.assertTrue(false);  //failed 
		  //    loggerob.warn("login failed");
				Thread.sleep(5000);
				
			}
				else {

				Assert.assertTrue(true);
				ob.logout();
				Thread.sleep(5000);
			//	loggerob.warn("login passed");
				driver.switchTo().alert().accept();//close logout alert
				driver.switchTo().defaultContent();
				}
			
		
	}

	
	
	
		public boolean isAlertPresent() {   // method to check alert
	
			try {
		
			driver.switchTo().alert();     // if alert id available it will swich so we return true
				return true;
			}
			catch(Exception e)
			{
			     return false;   // if alert is not available exeption will throw so we return false
			}
	
		}
	
	
		
		
		
		
		
	@DataProvider(name="logindata")
	
	public String[][] getdata() throws IOException {
		
		String path = System.getProperty("user.dir")+"\\driver\\sele_project.xlsx";  // specify the path 
		int rownum=XLUtility.getRowCount(path, "Sheet1");          // get the row count by calling the method defines in utility file
		int colcount=XLUtility.getCellCount(path,"Sheet1",1);

		String logindata[][]=new String[rownum][colcount];  // decalsre asrray of size as row and column
		
		
		for(int i=1;i <= rownum; i++)   // in exel data is available from 2 row so using 1 
		{

		for(int j=0;j<colcount;j++)     

		logindata[i-1][j]=XLUtility.getCellData(path,"Sheet1", i,j);//get 1 0     
		
		//in excel the data is available in second row so i=1 is correct but in array we need to add the value to first array
		// that is [0,0] so we use i-1
		
		
		}
		
		return logindata;
		
	}
	
	
	
	
	
	
	
	
	
}
