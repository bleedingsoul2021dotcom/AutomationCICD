@tag1
Feature: verify the incorrect login id and password

Background:
Given I landed on ecommerce page



@errorvalidations123
Scenario Outline: Negative test of login credentials 
Given Loggedin with username <name> and password <password>
Then "Incorrect email or password." is displayed

Examples:
 | name                    |      password    |
 | arjunvkakade@gmail.com  |   Arjun@1     |