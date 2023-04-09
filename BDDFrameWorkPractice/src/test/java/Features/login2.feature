Feature: LoginFeature check
Scenario: login check with different username and password

Given Login page is given 
When Title of login page is xyz
Then user enters username and password
|Kiran|admin123|
Then click ion login button
Then close the browser