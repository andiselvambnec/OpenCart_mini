package com.OpenCart.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.OpenCart.pageObjects.HomePage;

public class TC002_Register2 extends BaseClass{
	
	@Test
	public void Register() {
		log.info("Register test Started");
		driver.get(url);
		log.info(url+" was opened Successfully");
		HomePage hp=new HomePage(driver);
		hp.MyAccountClick();
		hp.RegisterClick();
		log.info("Redirecting to Register Page Successful");
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("Register Account")){
			Assert.assertEquals("Register Account",title);
		}
		else{
			log.error("Title Not Matching & Redirect to Register Page failed");
			Assert.fail();
		}
		
	}

}
