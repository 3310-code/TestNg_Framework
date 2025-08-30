package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

	Properties pob;   //create object of properties
	
	public ReadConfig() {             //when constructor is called for base class the file will be loaded
		
	File fob = new File("./configuration/config.properties");   //create object of file
	
	try {
		
		FileInputStream file =  new FileInputStream(fob);   // read the file
		pob = new Properties();                             // define the properties 
		pob.load(file);      // load the file
		
	} catch (Exception e) {
		
		System.out.print("Exception is "+ e.getMessage());
		
	}
	
	}
		
	
	public String geturl() {
		
		String url = pob.getProperty("url");
		return url;
	}
	
	
	public String getusername() {
		
		String username = pob.getProperty("username");
		return username;
	}
	
	
	public String getpassword() {
		
		String password= pob.getProperty("password");
		return password;
	}
	
	/*
	public String getchromedriver() {
		
		String driver=pob.getProperty("chromedriver");
		return driver;
	}
	
	
	*/
	
	
	
}
