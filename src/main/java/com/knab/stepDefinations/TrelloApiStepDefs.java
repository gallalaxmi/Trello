package com.knab.stepDefinations;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.AssertJUnit;
import com.knab.util.EnvironmentSetup;
import com.knab.util.EnvironmentTrello;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TrelloApiStepDefs {
	private Scenario scenario;
    private Response response;
    private static Logger log = LogManager.getLogger(TrelloApiStepDefs.class.getName());
    private static final String BASE_URL_API = EnvironmentSetup.BASE_URL_API;
    private static final String API_KEY = EnvironmentSetup.API_KEY;
    private static final String API_TOKEN = EnvironmentSetup.API_TOKEN;
    private static final String KEY = "key";
    private static final String TOKEN = "token";
    String boardId = "";
    String listId = "";
    String cardId = "";
    
    @Before
	public void before(Scenario scenarioVal) throws IOException {
		this.scenario = scenarioVal;
	}

    /**
     * Sets valid authentication headers.
     */
    @Given("The user sets valid authentication to request")
    public void setsValidAuthenticationToRequest() {
    	response = RestAssured.given().contentType(ContentType.JSON).queryParam(KEY, API_KEY)
                .queryParam(TOKEN, API_TOKEN).get(BASE_URL_API);
    	EnvironmentTrello.verifyStatusCode(response, 200);
    }

    @Given("The user sends a POST request to {string} with board {string} and the following Json data")
    public void POST_request(String endpoint, String boardName, String requestBody) throws InterruptedException {
        // Set the base URI for your API
    	response = RestAssured.given().contentType(ContentType.JSON).queryParam("name", boardName).queryParam(KEY, API_KEY)
                .queryParam(TOKEN, API_TOKEN).body(requestBody).post(BASE_URL_API+ endpoint);
    	scenario.log("Response Received == " + response.asPrettyString());  
    	Thread.sleep(2500);
    	String id = response.jsonPath().getString("id");
    	boardId = id;
    	log.info(boardId);
    }
    
    @Given("The user sends a request to create the List {string}")
    public void POST_List_request(String listName) throws InterruptedException {
        // Set the base URI for your API
    	String requestBody = " {\"name\": \""+listName+"\", \"idBoard\": \""+boardId+"\"}";
    	response = RestAssured.given().contentType(ContentType.JSON).queryParam(KEY, API_KEY)
                .queryParam(TOKEN, API_TOKEN).body(requestBody).post(BASE_URL_API+"/lists");
    	scenario.log("Response Received == " + response.asPrettyString());  
    	Thread.sleep(2500);
    	String id = response.jsonPath().getString("id");
    	listId = id;
    	log.info(listId);
    }
    
    @Given("The user sends a request to get the List {string}")
    public void Get_List(String list) {
        // Set the base URI for your API
    	if(list.equals("API List"))
    		list = listId;
    	String uri = BASE_URL_API+ "/lists/"+listId;
    	response = RestAssured.given().contentType(ContentType.JSON).queryParam(KEY, API_KEY)
                .queryParam(TOKEN, API_TOKEN).get(uri);
    	scenario.log("Response Received == " + response.asPrettyString());    	
    }
    
    
    @Given("The user sends a request to create the Card {string}")
    public void POST_card_request(String cardName) throws InterruptedException {
        // Set the base URI for your API
    	String requestBody = " {\"name\": \""+cardName+"\", \"idList\": \""+listId+"\"}";
    	response = RestAssured.given().contentType(ContentType.JSON).queryParam(KEY, API_KEY)
                .queryParam(TOKEN, API_TOKEN).body(requestBody).post(BASE_URL_API+"/cards");
    	scenario.log("Response Received == " + response.asPrettyString());  
    	Thread.sleep(2500);
    	String id = response.jsonPath().getString("id");
    	cardId = id;
    	log.info(cardId);
    }
    
    @Given("The user sends a request to get the Card {string}")
    public void Get_cards(String card) {
        // Set the base URI for your API
    	if(card.equals("API Card"))
    		card = cardId;
    	String uri = BASE_URL_API+ "/cards/"+cardId;
    	response = RestAssured.given().contentType(ContentType.JSON).queryParam(KEY, API_KEY)
                .queryParam(TOKEN, API_TOKEN).get(uri);
    	scenario.log("Response Received == " + response.asPrettyString());    	
    }
    
    @Given("The user sends a request to delete the Card {string}")
    public void Delete_cards(String card) {
        // Set the base URI for your API
    	if(card.equals("API Card"))
    		card = cardId;
    	String uri = BASE_URL_API+ "/cards/"+cardId;
    	response = RestAssured.given().contentType(ContentType.JSON).queryParam(KEY, API_KEY)
                .queryParam(TOKEN, API_TOKEN).delete(uri);
    	scenario.log("Response Received == " + response.asPrettyString());    	
    }
    
    
    
    @Then("Verifies response should have the {int} status code")
	public void validate_statusCode(Integer statusCode) {
    	EnvironmentTrello.verifyStatusCode(response, statusCode);
	}
    
    @And("validate the dataService response list data contains {string}")
	public void validateResponseList(String listData) {
		String[] arrOfStr = listData.split(",");
		for (String a : arrOfStr)
			AssertJUnit.assertTrue(response.getBody().asString().contains(a));
	}
    
    @Given("The user sends a request to get the board {string}")
    public void Get_request(String board) {
        // Set the base URI for your API
    	if(board.equals("API Test Board"))
    		board = boardId;
    	String uri = BASE_URL_API+ "/boards/"+board;
    	response = RestAssured.given().contentType(ContentType.JSON).queryParam(KEY, API_KEY)
                .queryParam(TOKEN, API_TOKEN).get(uri);
    	scenario.log("Response Received == " + response.asPrettyString());    	
    }
    
    @Given("The user sends a DELETE request to delete the board {string}")
    public void Delete_request(String board) {
        // Set the base URI for your API
    	if(board.equals("API Test Board"))
    		board = boardId;
    	String uri = BASE_URL_API+ "/boards/"+board;
    	response = RestAssured.given().contentType(ContentType.JSON).queryParam(KEY, API_KEY)
                .queryParam(TOKEN, API_TOKEN).delete(uri);
    	scenario.log("Response Received == " + response.asPrettyString());    	
    }
}