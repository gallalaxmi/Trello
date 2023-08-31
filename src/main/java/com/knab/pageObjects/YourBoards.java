package com.knab.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.knab.base.BaseDriver;

public class YourBoards extends BaseDriver {

	WebDriver driver;

	public By listName = By.name("name");
	public By addListButton = By.xpath("//input[@value='Add list']");
	public By cancleList = By.xpath("//a[@aria-label='Cancel list editing']");
	public By addACardLink = By.xpath("//a[@data-testid='list-add-card-button']");
	public By cardTitle = By.xpath("//textarea[@data-testid='list-card-composer-textarea']");
	public By addCardButton = By.xpath("//input[@value='Add card']");

	public YourBoards(WebDriver driver) {
		this.driver = driver;
	}
}
