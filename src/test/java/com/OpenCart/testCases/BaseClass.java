package com.OpenCart.testCases;

import java.time.Duration;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class BaseClass {
	String url="https://demo.opencart.com/";
	String browser="chrome";
	Logger log;
	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log=LogManager.getLogger(BaseClass.class.getName());
		//log.error("dfisfosofg");
		
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
