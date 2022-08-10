package com.OpenCart.testCases;

import java.time.Duration;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import com.OpenCart.utilities.ReadConfig;


public class BaseClass {
	ReadConfig rc=new ReadConfig();
	String url="https://demo.opencart.com/";
	String browser="edge";
	Logger log;
	WebDriver driver;
	@BeforeClass
	public void setup() {
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\Drivers\\edgedriver.exe");
			driver=new EdgeDriver();
		}
		else{
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log=LogManager.getLogger(BaseClass.class.getName());
		//log.error("dfisfosofg");
		//System.out.println(url);
		
	}
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	

}
