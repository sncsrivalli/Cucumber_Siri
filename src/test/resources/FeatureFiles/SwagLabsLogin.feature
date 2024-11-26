#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Swag Labs Login

  Background: 
    Given I will navigate to swag labs app

  Scenario: Swag Labs login with valid credentials
    When I will enter valid username and password
    And I will click on LOGIN
    Then I should navigate to swag labs home page

  Scenario Outline: Swag labs login with multiple credentials
    When I enter <username> and <password>
    And I will click on LOGIN
    Then I should navigate to swag labs home page

    Examples: 
      | username        | password     |
      | locked_out_user | secret_sauce |
      | visual_user     | secret_sauce |
