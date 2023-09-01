package com.knab.util;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import io.restassured.http.Cookies;
public class EnvironmentSetup {

	private static Logger log = LogManager.getLogger(EnvironmentSetup.class.getName());
	public static String BASE_URL_API, API_KEY, API_TOKEN;
	public static Cookies cookies;

	// To load the values before the test cases run
	public static void Env_setup() throws IOException {
		log.info("Env_setup function");
		EnvironmentTrello.loadProperties();
		BASE_URL_API = EnvironmentTrello.ReadProperty("url");
		API_KEY = EnvironmentTrello.ReadProperty("key");
		API_TOKEN = EnvironmentTrello.ReadProperty("token");
	}
}
