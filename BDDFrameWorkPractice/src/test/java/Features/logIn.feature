Feature: Login Feature
Scenario: Login Scenario

Given Login webPage
When title of login page is free CRM
Then user enters "<username>" and "<password>"
Then user click on login button


Examples:
|username|password|
|Admin   |admin123|
|kiran   |kiran123|