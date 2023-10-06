@Web
Feature: validate the Professional Account functionality

   @TC40 @Demo1
    Scenario Outline: create the new account. 
    Given Read the testdata "<TestData>" and "<SheetName>" from excel file
    Given user navigates to the application   
    When user enters the emailaddress and password
    When user clicked on the login button
    And click on the admin name
    And Select the admin "Settings" option
    And click on createuser button
    And Select the Countries "Nigeria" option
    And enters the  "firstName" in the field
    And enters the  "lastName" in the field
    And enters the  "userEmail" in the emailfield
    And Select the Group "Administrator" option
    And click on the "Continue" button
    And click on the admin name
    And Select the admin "Sign Out" option
     
    
        Examples:
      | TestData  | SheetName     | username | password |
      | Testdata1 | test          | Username | Password |

      