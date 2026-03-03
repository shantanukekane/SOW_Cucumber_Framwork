Feature: Account Registration 
  
   @sanity @regression 
   Scenario: succesfully Account registration
      Given the user should be registration page
      When the user pass some valid sets of data into below field
        | firstName | krushna |
        | lastName  | kekane  |
        | telephone | 15423635|
        | password  | test123 |
      And the user click on subscription radio button
      And the user click on policy check button
      And the user click on continue button
      Then the user see the message account created successfully
      
