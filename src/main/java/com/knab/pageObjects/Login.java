package com.knab.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.knab.base.BaseDriver;

public class Login extends BaseDriver {
	WebDriver driver;

	public By userName = By.id("user");
	public By continueButton = By.id("login");
	public By password = By.id("password");
	public By loginSubmit = By.id("login-submit");

	public Login(WebDriver driver) {
		this.driver = driver;
	}

}
