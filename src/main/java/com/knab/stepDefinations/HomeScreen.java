package com.knab.stepDefinations;

import org.openqa.selenium.WebDriver;

import com.knab.base.BaseDriver;
import com.knab.pageObjects.Home;
import com.knab.util.ElementAction;

import io.cucumber.java.en.Given;

public class HomeScreen extends BaseDriver {

	WebDriver driver = getDriver();
	ElementAction action = new ElementAction(driver);
	Home home = new Home(driver);

	@Given("^I navigate to login screen$")
	public void navigateToLoginPage() {
		action.doClick(home.logIn);
	}
}
