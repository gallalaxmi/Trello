package com.knab.stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.knab.base.BaseDriver;
import com.knab.pageObjects.YourBoards;
import com.knab.util.ElementAction;

import io.cucumber.java.en.Given;

public class YourBoardsScreen extends BaseDriver {

	WebDriver driver = getDriver();
	ElementAction action = new ElementAction(driver);
	YourBoards yourboards = new YourBoards(driver);

	@Given("^I add a list \"([^\"]*)\"$")
	public void addAList(String listName) {
		action.doSendKeys(yourboards.listName, listName);
		action.doClick(yourboards.addListButton);
		action.doIsDisplayed(By.xpath("//h2[text()='" + listName + "']"));
	}

	@Given("^I add a card \"([^\"]*)\"$")
	public void addACard(String cardName) {
		String cardNames[] = cardName.split("--");
		action.doClick(yourboards.addACardLink);
		for (String card : cardNames) {
			action.doSendKeys(yourboards.cardTitle, card);
			action.doClick(yourboards.addCardButton);
			action.doIsDisplayed(By.xpath("//span[text()='" + card + "']"));
		}
	}

}
