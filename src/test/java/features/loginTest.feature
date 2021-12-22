Feature: Login into Application
Scenario Outline: Test validating login
Given Intialize the chrome browser
And Navigate to "https://opensource-demo.orangehrmlive.com/index.php/auth/login" site
When User enters <username> and <password> and logs in
Then Verify whether user logged in
Then close the browser

Examples:
|username|  |password|
|Admin   |  |admin123|
|Admin   |  |admin345|