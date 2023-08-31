package com.knab.stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.knab.base.BaseDriver;
import com.knab.pageObjects.Dashboard;
import com.knab.pageObjects.Home;
import com.knab.util.ElementAction;

import io.cucumber.java.en.Given;

public class Background extends BaseDriver {

	Properties prop = init_properties();
	WebDriver driver = initDriver(prop);
	Dashboard dashboard = new Dashboard(driver);
	Home home = new Home(driver);
	ElementAction action = new ElementAction(driver);

	@Given("^I navigate to application$")
	public void openUrl() throws IOException, InterruptedException {
		driver = getDriver();
	}

	@Given("^I logout and quit browser$")
	public void logOut() throws IOException, InterruptedException {
		driver = getDriver();
		action.doClick(dashboard.memberMenuTooltip);
		action.doClick(dashboard.logoutButton1);
		action.doClick(dashboard.logoutButton2);
		action.doIsDisplayed(home.logIn);
		driver.quit();
	}
}
