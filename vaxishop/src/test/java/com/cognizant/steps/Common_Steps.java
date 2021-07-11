package com.cognizant.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common_Steps {

	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("Global Before Hook Executed");
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
		//capture the failed screenshots
		if(scenario.isFailed()){
			final byte[] scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(scr,"image/png", scenario.getName());
		}
		driver.quit();
		Thread.sleep(1000);
		System.out.println("Global After Hook Executed");
	}

	public WebDriver getDriver() {
		return driver;
	}
}
