@AllCases
Feature: Create Board
  
  To create a board in trello, Authenticate as valid Trello API consumer

  Background: Sets authentication
    Given The user sets valid authentication to request

  @functional @APICases
  Scenario: Create, Retrive and Delete the Board
    When The user sends a POST request to "/boards" with board "New Board" and the following Json data
      """
      {
        "name" : "API Test Board",
        "desc" : "Description",
        "idOrganization": "64f04be84b9171946fb3557e"
      }
      """
    Then Verifies response should have the 200 status code
    And validate the dataService response list data contains "API Test Board,Description,64f04be84b9171946fb3557e"
    When The user sends a request to get the board "API Test Board"
    Then Verifies response should have the 200 status code
    And validate the dataService response list data contains "API Test Board,Description,64f04be84b9171946fb3557e"
    When The user sends a DELETE request to delete the board "API Test Board"
    Then Verifies response should have the 200 status code
  
  @functional @APICases
  Scenario: Create, Retrive and Delete the Board with List and Card,
    When The user sends a POST request to "/boards" with board "New Board" and the following Json data
      """
      {
        "name" : "API Test Board",
        "desc" : "Description",
        "idOrganization": "64f04be84b9171946fb3557e"
      }
      """
    Then Verifies response should have the 200 status code
    When The user sends a request to get the board "API Test Board"
    Then Verifies response should have the 200 status code
    And validate the dataService response list data contains "API Test Board,Description,64f04be84b9171946fb3557e"
    When The user sends a request to create the List "API List"
    Then Verifies response should have the 200 status code
    When The user sends a request to get the List "API List"
    Then Verifies response should have the 200 status code
    And validate the dataService response list data contains "API List"
    When The user sends a request to create the Card "API Card"
    Then Verifies response should have the 200 status code
    When The user sends a request to get the Card "API Card"
    Then Verifies response should have the 200 status code
    When The user sends a request to delete the Card "API Card"
    Then Verifies response should have the 200 status code
    When The user sends a DELETE request to delete the board "API Test Board"
    Then Verifies response should have the 200 status code
  
  @functional @APICases
  Scenario: Retrive the Invalid Cards 
    When The user sends a request to get the Card "64f2153a798ca877bb4cda71"
    Then Verifies response should have the 404 status code
