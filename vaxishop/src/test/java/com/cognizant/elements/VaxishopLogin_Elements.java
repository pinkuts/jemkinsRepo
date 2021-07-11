package com.cognizant.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VaxishopLogin_Elements {
	
	WebDriver driver;
	
	@FindBy(id="j_username") public WebElement userName;
	@FindBy(xpath="//input[@id='j_password']") public WebElement password;
	@FindBy(xpath="//button[contains(text(),'Log in')]") public WebElement loginButton;
	@FindBy(xpath="//input[@id='accSubmit']") public WebElement accSubmitButton;
	@FindBy(xpath="//font[contains(text(),'Username or Password is incorrect.')]") public WebElement errorLogin;
		
	public VaxishopLogin_Elements (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
}
