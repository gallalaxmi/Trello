package com.knab.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
	public static WebDriver driver;
	Properties prop;

	public static ThreadLocal<WebDriver> localDriver = new ThreadLocal<WebDriver>();

	public synchronized WebDriver getDriver() {
		return localDriver.get();
	}

	public WebDriver initDriver(Properties prop) {
		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			localDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			localDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			localDriver.set(new SafariDriver());
		} else {
			System.out.println("Please mention correct browser name");
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();

		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}

	public Properties init_properties() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/main/resources/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
