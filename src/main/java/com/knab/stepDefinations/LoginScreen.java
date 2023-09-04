package com.knab.stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.knab.base.BaseDriver;
import com.knab.pageObjects.Dashboard;
import com.knab.pageObjects.Home;
import com.knab.pageObjects.Login;
import com.knab.util.ElementAction;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginScreen extends BaseDriver {

	WebDriver driver = getDriver();
	Properties prop = init_properties();;
	ElementAction action = new ElementAction(driver);
	Login login = new Login(driver);
	Home home = new Home(driver);
	Dashboard boards = new Dashboard(driver);

	@When("^I enter the valid username and password$")
	public void enterCredetials() throws IOException, InterruptedException {
		action.doSendKeys(login.userName, prop.getProperty("username"));
		action.doClick(login.continueButton);
		Thread.sleep(2500);
		action.doSendKeys(login.password, prop.getProperty("password"));
		action.doClick(login.loginSubmit);
	}

	@Given("^I login with valid credetials$")
	public void logIn() throws IOException, InterruptedException {
		action.doClick(home.logIn);
		action.doSendKeys(login.userName, prop.getProperty("username"));
		action.doClick(login.continueButton);
		Thread.sleep(2500);
		action.doSendKeys(login.password, prop.getProperty("password"));
		action.doClick(login.loginSubmit);
		action.doIsDisplayed(boards.applicationSwitcher);
	}
}
