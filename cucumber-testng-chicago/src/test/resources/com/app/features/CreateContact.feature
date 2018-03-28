Feature: Contact creation 

Background: Login to app
Given I logged into suiteCRM


Scenario Outline: contact creation and validation
And I go to create contact page
Then I create new contact using "<prefix>" "<firstName>" "<lastName>" "<phoneNumber>" "<title>"
And I validate new created contact info "<prefix>" "<firstName>" "<lastName>" "<phoneNumber>" "<title>"
Then I logout from application

Examples:
|prefix |	firstName| 	lastName	|	phoneNumber|title    |
|Prof.  | James		 | Bond		| 7733334400   | 007     |
|Dr.   | House		 | Gred		| 			   | Brain   |


Scenario: CRM Name and Modules
	Then CRM name should be SuiteCRM
	And Modules should be displayed
	Then I logout from application
