package com.OpenCart.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import com.OpenCart.utilities.ReadConfig;


public class BaseClass {
	ReadConfig rc=new ReadConfig();
	String url="https://demo.opencart.com/";
	String browser="edge";
	Logger log;
	public WebDriver driver;
	@BeforeClass
	public void setup(ITestContext context) {
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
		 context.setAttribute("WebDriver1", driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log=LogManager.getLogger(BaseClass.class.getName());
		//log.error("dfisfosofg");
		//System.out.println(url);
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public String ScreenShotSelenium(WebDriver driver,String ScreenName) throws IOException {
		String TStamp = new SimpleDateFormat("yyyy.MM.dd-hh.mm.ss").format(new Date());
		String sname=ScreenName+TStamp+".png";
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String locationScreenshot=System.getProperty("user.dir")+"\\Screenshots\\"+sname;
	    File destination=new File(locationScreenshot);
		FileUtils.copyFile(src, destination);
		return locationScreenshot;
	}
	
	

}
