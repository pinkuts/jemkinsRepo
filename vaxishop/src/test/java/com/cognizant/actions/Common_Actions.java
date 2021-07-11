package com.cognizant.actions;

import org.openqa.selenium.WebDriver;

import com.cognizant.steps.Common_Steps;

public class Common_Actions {

	WebDriver driver;
	Common_Steps common_steps;
	
	public Common_Actions (Common_Steps common_steps){
		this.driver=common_steps.getDriver();
		}
	public void goToUrl(String url){
		driver.get(url);
	}
	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}
	public String getCurrentTitle(){
		return driver.getTitle();
	}
}



