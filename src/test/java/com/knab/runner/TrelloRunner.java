package com.knab.runner;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import com.knab.util.EnvironmentSetup;

@CucumberOptions(features = { "src/test/resources/features" }, glue = { "com.knab.stepDefinations" }, plugin = {
		"json:target/cucumber.json"}, dryRun = false, monochrome = true, strict = true, tags = "@AllCases")

public class TrelloRunner extends AbstractTestNGCucumberTests {

	@BeforeClass
	public static void before_all() throws IOException{
		EnvironmentSetup.Env_setup();
	}
}