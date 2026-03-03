Feature: Login with valid credentials 
    
    @sanity @regression 
    Scenario: Successful login with valid credential 
        Given the user should navigate to login Page
        When the user should enter email as "krushna@gmail.com" and password as "krushna"
        And the user click on login button
        Then the user should be redirect to My Account page
         
   # @regression    
    #Scenario Outline: Login Data Driven
     #     Given the user should navigate to login Page
      #    When the user Enter email as "<email>" and password as "<password>"
       #   And the user click on login button
        #  Then the user should be redirect to My Account page  
          
   # Examples: 
       # |email                | password |
        #|krushna@gmail.com    | krushna  |
       # |shan@gmail.com       | shan     |      
          
          
             
