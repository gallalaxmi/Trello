Feature: Validatie UI test cases for Trello Application

  @Login
  Scenario: Validate succesful login to trello application
    Given I navigate to application
    When I navigate to login screen
    And I enter the valid username and password
    Then I should see login succesful
    And I logout and quit browser
    
  @CreateBoard
  Scenario Outline: Create a board, add list and add card to it
    Given I navigate to application
    When I login withvalid credetials
    And I create a new board with "<boardName>"
    And I add a list "<listName>"
    And I add a card "<cardName>"
    And I logout and quit browser
    
    Examples:
			| boardName	| listName	| cardName		|
			|random name|		List1		|card1--card2	|