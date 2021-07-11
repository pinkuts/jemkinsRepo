package com.cognizant.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cognizant.elements.VaxishopLogin_Elements;
import com.cognizant.steps.Common_Steps;

public class VaxishopLogin_Actions {

	WebDriver driver;
	VaxishopLogin_Elements vaxishoplogin_elements;

	public VaxishopLogin_Actions(Common_Steps common_steps) {
		this.driver = common_steps.getDriver();
		vaxishoplogin_elements = new VaxishopLogin_Elements(driver);
	}

	public void userName(String usrName) {
		vaxishoplogin_elements.userName.sendKeys(usrName);
	}

	public void password(String pwd) {
		vaxishoplogin_elements.password.sendKeys(pwd);
	}

	public void login() {
		vaxishoplogin_elements.loginButton.click();
	}

	public void accSubmit() {
		vaxishoplogin_elements.accSubmitButton.click();
	}

	public void selectAccount(String string) {
		driver.findElement(By.xpath("//span[contains(text(),'" + string + "')]")).click();
	}

	public String errorLogin() {
		return vaxishoplogin_elements.errorLogin.getText();
	}
}
