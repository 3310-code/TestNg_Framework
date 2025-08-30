package testcase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utility.ReadConfig;





public class baseclass {

	
	//specify all the commonly used things and all other test case will implement this class
	
	/*
	public String url = " https://demo.guru99.com/V4/index.php";
	public String username = "mngr616977";
	public String password= "AtYvyzu";
	public static WebDriver driver;
	
	*/
	
	
	// getting all the value from config file using readconfig file
	
	ReadConfig configob = new ReadConfig();      // create obejct of ReadConfig file
	
	public String url = configob.geturl();
	public String username = configob.getusername();       // call all the methods using object
	public String password= configob.getpassword();
	public static WebDriver driver;
	
	
	public static Logger loggerob;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browservalue) {
		
		
		if(browservalue.equals("chrome")) {
			
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\driver\\chromedriver.exe");		
		driver=new ChromeDriver();
		
		}
		
		else if(browservalue.equals("firefox")) {
						
			driver= new FirefoxDriver();

		}
		
		else if(browservalue.equals("internet explorer")) {
			
			driver=new InternetExplorerDriver();
		}
		
		
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		
		//loggerob = Logger.getLogger("Test_Example");    // this will create a logger for the category "ebanking". 
		                                                   //   ebanking is the name of the logger 
		//PropertyConfigurator.configure("D:\\Eclipse_Project\\eclipse-workspace\\Test_Example\\log");    // specify the log4j file
		
		loggerob = LogManager.getLogger("D:\\Eclipse_Project\\eclipse-workspace\\Test_Example\\log4j.properties");
		
		
	}
	
	
	@AfterClass
	public void exit() {
		
		driver.quit();
	}

	
	public void screenshot(WebDriver driver, String tname) throws IOException {   //pass driver and test case name
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"/screenshot/"+ tname +"/.png");
	    source.renameTo(destination);
	    System.out.println("Screenshot taken");
		
	}
	
	 
    public String randomnumber() {   //get random numv=berfs
    	
    	String no = RandomStringUtils.random(10);
    	return no;
    }


	public String randomemail() {   // gets random values
		
		String email = RandomStringUtils.randomAlphanumeric(5);     //specifies numnber of character get generated
		return email;
	
	}
	
	
}





