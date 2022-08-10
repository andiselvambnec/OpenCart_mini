package com.OpenCart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='nav float-end']//li[2]//div")
	WebElement MyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Register;
	
	public void MyAccountClick() {
		MyAccount.click();
	}
	public void RegisterClick() {
		Register.click();
	}
}
