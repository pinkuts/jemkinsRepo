package com.cognizant.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "features" },
		glue = { "com.cognizant.steps" },
		plugin = { "pretty", "json:target/json-report/cucumber.json" },
		dryRun=false,
		//strict=false,
		monochrome=true,
		tags = {"@100"}
		//name={"Login"}
		)
public class TestRunner {
}
