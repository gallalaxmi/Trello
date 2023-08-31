package com.knab.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.knab.base.BaseDriver;

public class Home extends BaseDriver {
	WebDriver driver;

	public By logIn = By.xpath("(//a[contains(text(),'Log in')])[1]");

	public Home(WebDriver driver) {
		this.driver = driver;
	}
}
