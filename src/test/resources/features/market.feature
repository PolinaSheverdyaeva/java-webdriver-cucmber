@market
   Feature: Marketing app test suite

     @market1
     Scenario: Market basic test
       Given I go to "quote" page
       And I print details in console
       Given I go to "google" page
       And I go to "quote" page
       And I go back and forward, then refresh the page
       When I fill out required fields
       And I submit the form

