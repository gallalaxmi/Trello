package com.knab.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {
	WebDriver driver;

	public By applicationSwitcher = By.xpath("//span[@data-testid='ApplicationSwitcherIcon']");
	public By memberMenuTooltip = By.xpath("//button[@aria-label='Open member menu']");
	public By logoutButton1 = By.xpath("//button[@data-testid='account-menu-logout']");
	public By logoutButton2 = By.id("logout-submit");
	public By createButton = By.xpath("//button[@data-testid='header-create-menu-button']");
	public By createBoardLink = By.xpath("//button[@data-testid='header-create-board-button']");
	public By boardTitle = By.xpath("//input[@data-testid='create-board-title-input']");
	public By createSubmitButton = By.xpath("//button[@data-testid='create-board-submit-button']");

	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}

}
