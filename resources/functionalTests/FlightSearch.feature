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
@tag
Feature: Title of your feature
  I want to use this template for my feature file
    
  
  Scenario: Customare is able to navigate search result page for one way by providing required details.
    Given Navigated to flight search page for one way search.
    When Enter the search deatils for one way.
    Then Search result page is displayed for one.
    
  Scenario: Customare is able to navigate search result page for round trip by providing required details.
    Given Navigated to flight search page for round trip.
    When Enter the search deatils for round trip.
    Then Search result page is displayed for round trip.
    
   Scenario: Customare is able to navigate search result page for multi city by providing required details.
    Given Navigated to flight search page for multi city trip..
    When Enter the search deatils for multi city trip.
    Then Search result page is displayed for multi city trip.
    

   
 