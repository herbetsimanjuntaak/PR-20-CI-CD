Feature: Automation web demo blaze

  @web
  Scenario: Login using valid user and password
    Given user is on login page
    And user click button login
    And user input username "herbet"
    And user input password "demo"
    When user click button login new
    Then user is on homepage