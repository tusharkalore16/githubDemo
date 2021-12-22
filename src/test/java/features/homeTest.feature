Feature: Homepage Testing
Scenario Outline: HomePage feature Testing
Given user on  login page with url "https://opensource-demo.orangehrmlive.com/index.php/auth/login"
Given user logged in with  <username> and  <password> 
Then verify dashboard background color
Then Verify username as "Welcome Paul" on login page
Then quit the browser
Examples:
|username| |password|
|Admin   | |admin123|

