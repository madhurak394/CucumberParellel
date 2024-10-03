Feature: Login to OpenCart e-Commerce application

  Background:
Given I am on the OpenCart login page
  
  Scenario: Successful Login with valid user credentials
  Given User enters valid user credential
  When User clicks on Login button
  Then I validate user login successfully to OpenCart application
    
  Scenario Outline: Unsuccessful Login with invalid user credentials
  Given User navigates to login page
  When User enters invalid user "<username>" and "<password>" credential
  Then I validate user can see error message "<error message>"

  Examples: 
       | username                     | password            |error message                       |        
       | name1@gmail.com              | Test@246            |No match for E-Mail and/or Password.|
       | 4566                         | test                |No match for E-Mail and/or Password.| 
      