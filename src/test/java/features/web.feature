Feature: Automation web demo blaze

  @web
  Scenario: Login using valid username and password
    Given user is on login page
    And user click button login
    And user input username "herbet"
    And user input password "demo"
    When user click button login new
    Then user is on homepage

  @web
  Scenario: Login using valid username password and logout
    Given user is on login page
    And user click button login
    And user input username "herbet"
    And user input password "demo"
    And user click button login new
    And user is on homepage
    When user click button Log Out
    Then user is on login page

  @web
  Scenario: Login using invalid username and password
    Given user is on login page
    And user click button login
    And user input username "testinvalid"
    And user input password "12345"
    When user click button login new
    Then user will see popup message "User does not exist."

  @web
  Scenario: Login using valid username and invalid password
    Given user is on login page
    And user click button login
    And user input username "herbet"
    And user input password "12345"
    When user click button login new
    Then user will see popup message "Wrong password."

  @web
  Scenario: Login using invalid username and valid password
    Given user is on login page
    And user click button login
    And user input username "testinvalid"
    And user input password "demo"
    When user click button login new
    Then user will see popup message "User does not exist."

  @web
  Scenario: login with username without fill in password
    Given user is on login page
    And user click button login
    And user input username "herbet"
    When user click button login new
    Then user will see popup message "Please fill out Username and Password."

  @web
  Scenario: login with password without fill in username
    Given user is on login page
    And user click button login
    And user input password "demo"
    When user click button login new
    Then user will see popup message "Please fill out Username and Password."