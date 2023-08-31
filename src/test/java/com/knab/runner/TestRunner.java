package com.knab.runner;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = { "com.knab.stepDefinations" }, plugin = { "pretty",
		"html:target/cucumber-reports", "json:target/cucumber.json" }, tags = "@Login")
public class TestRunner {

}
