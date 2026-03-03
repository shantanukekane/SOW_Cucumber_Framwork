Feature: Loogin Data Driven Tes using Excel
    
    @regression
    Scenario: Login with DDT Excel file
       Given the user should navigate to login Page
       Then the user navigates to my account page by passing email and password with Excel row "<row_index>"
       
       Examples:
            |row_index|
            |        1|
            |        2|
            |        3|
            |        4|
            |        5|
            
            
       

     