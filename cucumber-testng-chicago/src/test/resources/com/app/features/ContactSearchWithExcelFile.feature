Feature: Contact Search
@dev
Scenario: Contact Search with data from excel sheet
Given I logged into suiteCRM
And I validate contacts with data in excel sheet "test.xlsx" and "Sheet1"
Then I logout from application