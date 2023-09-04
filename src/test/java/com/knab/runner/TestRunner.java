package com.knab.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features", glue = { "com.knab.stepDefinations" }, plugin = { "pretty",
		"html:target/cucumber-reports", "json:target/cucumber.json" }, tags = "@AllCases")

public class TestRunner {

}
