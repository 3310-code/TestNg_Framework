package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

// Listner class used to generated extend report

public class extendreport implements ITestListener{

	  
	  
	  public ExtentSparkReporter sparkReporter; // UI of the report
	  public ExtentReports extent; //populate common info on the report like tester name, browser, operting system name 
	  public ExtentTest test; // creating test case entries in the report and update status of the test methods

	  public void onStart(ITestContext context) {

       String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
	   String repName="Test-Report-"+timeStamp+".html";
	   sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/report/"+repName);//specify location  
     //sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/report/myReport.html");//specify where the report 
	                                                                                       // be created and report name

	   
	  sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report               
	  sparkReporter.config().setReportName("Functional Testing"); // name of the report
	  sparkReporter.config().setTheme(Theme.DARK);  // theme of report, dark or white
		  
		  
	  extent=new ExtentReports();          
	  extent.attachReporter(sparkReporter); 

	  extent.setSystemInfo("Computer Name","localhost"); 
	  extent.setSystemInfo("Environment","QA");
	  extent.setSystemInfo("Tester Name","Arun");
	  extent.setSystemInfo("os","Windows10");
	  extent.setSystemInfo("Browser name","Chrome");
	  }
	  
	  
	  public void onTestSuccess(ITestResult result) {  //when any test method got passed this will got triggered

	  test = extent.createTest(result.getName()); // by using extend this will create a new entry in the report and  
	                                               // result.getname will get the name of the passed method and
	                                                //by test it will update in report 
	  test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s 
		  
		  
	  }

	  
	  public void onTestFailure(ITestResult result) {  //when any test method got failed this will got triggered

		  test = extent.createTest(result.getName());
		  test.log(Status.FAIL, "Test case FAILED is:" +result.getName());
		  test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());  //getthrowabalw will get the error msg
		  
		  
		  String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png"; // get the screenshot from 
		                                                                                                  //mentioned path
		  File f = new File(screenshotPath);
		  
		  if(f.exists()) {
			  
			  try {
				  test.fail("screenshot is below"+ test.addScreenCaptureFromPath(screenshotPath));
				  
			  }
			  catch(Exception e){
				  
				  e.printStackTrace();
				  
			  }
			  
		  }
		  
	  }

		  public void onTestSkipped(ITestResult result) {  //when any test method got skipped this will got triggered

		  test = extent.createTest(result.getName());
		  test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
	  
		  }
	  
		  public void onFinish(ITestContext context) {   // this method is required to run all the above specified methods
	                                                     // this will update the mentioned whole thing in report
			  extent. flush();                              
			  
		  }

	}
