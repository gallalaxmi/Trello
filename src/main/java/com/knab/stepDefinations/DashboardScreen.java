package com.knab.stepDefinations;

import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;
import com.knab.base.BaseDriver;
import com.knab.pageObjects.Dashboard;
import com.knab.util.ElementAction;

import io.cucumber.java.en.Given;

public class DashboardScreen extends BaseDriver {

	WebDriver driver = getDriver();
	ElementAction action = new ElementAction(driver);
	Dashboard boards = new Dashboard(driver);
	Faker faker = new Faker();

	@Given("^I should see login succesful$")
	public void navigateToLoginPage() {
		action.doIsDisplayed(boards.applicationSwitcher);
	}

	@Given("^I create a new board with \"([^\"]*)\"$")
	public void createNewBoard(String boardName) {
		action.doClick(boards.createButton);
		action.doClick(boards.createBoardLink);
		if (boardName.equals("Random name"))
			action.doSendKeys(boards.boardTitle, faker.name().firstName());
		else
			action.doSendKeys(boards.boardTitle, boardName);
		action.doClick(boards.createSubmitButton);
	}

}
