@MobileTest4
Feature: validating mobile test cases

  @Dashboard_01 @Demo1
  Scenario: Dashboard_validating the login functioanlity
    Given open the app on emulator "emulator-5554_11.0.0"
    When user clicks on the login button
    When user clicks on the continue button
    When user grants the permission
    When user enter the mobile number as "716177297"
    When user clicks on the continue button
    When user enters the pin "1","1","4","8"
    When user clicked on send button
    When user clicked on enter phone number
    When user enter the mobile number to send money
    When user clicks on the continue button
    When user enter the fund for transfer
    When user click on where to?
    When user click on checkbox
    When user clicks on the continue button
    When user clicks on the continue button
    When user clicks on skip Button
    When user select a catogory
    When user click on review and send
    When user click on send now button
    When user enters the pin "1","1","4","8"

  @Dash_02 
  Scenario: Dash_valiidate the for me functionality
    Given open the app on emulator "emulator-5554_11.0.0"
    When user clicks on the login button
    When user clicks on the continue button
    When user grants the permission
    When user enter the mobile number as "716177297"
    When user clicks on the continue button
    When user enters the pin "1","1","4","8"
    When user clicks on the Bills option
    When user clicks on the "Get started"
    When user clicks on the payonbill
    When user clicks on the "Airtime"
    When user clicks on the "Enter Amount"
    When user enter the amount
    When user clicks on the "Continue"
  @Dash_03 
  Scenario: Dash_validate the for others functionality
    Given open the app on emulator "Ishrar_11.0.0"
    When user clicks on the login button
    When user clicks on the continue button
    When user grants the permission
    When user enter the mobile number as "716177297"
    When user clicks on the continue button
    When user enters the pin "1","1","4","8"
    When user clicks on the Bills option
    When user clicks on the "Get started"
    When user clicks on the payonbill
    When user clicks on the "Airtime"
    When user clicks on the "For Others"
    When user clicks on the "Enter mobile number"
    When user enter the mobile number as "712345678"
    When user clicks on the "Enter Amount"

  #         When user enters the amount as "20"
  #         When user clicks on the "Review and buy"
  #         When user clicks on the "Buy airtime"
  #         When user enters the pin "1","1","4","8"
  #         Then user is able to see the successful sent screen
  #         When user clicks on the "Close"
  #         When user clicks on the "Close"
  #         Then user should be able to see the pay a bill screen
  @Dash_04 
  Scenario: Dash_validating the request functionality
    Given open the app on emulator "Ishrar_11.0.0"
    When user clicks on the login button
    When user clicks on the continue button
    When user grants the permission
    When user enter the mobile number as "716177297"
    When user clicks on the continue button
    When user enters the pin "1","1","4","8"
    When user clicks on the "Pay"
    When user clicks on the "Get started"
    When user clicks on the "Request money"
    When user clicks on the "Enter phone number"
    When user enter the mobile number as "712345678"
    When user clicks on the continue button
    When user enter the request amount
    When user clicks on the continue button
    When user select a catogory
    When user clicks on the "Review and request"
    When user clicks on the "Request  now"
    When user enters the pin "1","1","4","8"
    Then user is able to see the text "You’ve requested 1.00 from test new TestLast "
    When user clicks on the "Close"

  @Dash_05 
  Scenario: Dash_validating the withdraw functionality
    Given open the app on emulator "Ishrar_11.0.0"
    When user clicks on the login button
    When user clicks on the continue button
    When user grants the permission
    When user enter the mobile number as "716177297"
    When user clicks on the continue button
    When user enters the pin "1","1","4","8"
    When user clicks on the "Money"
    When user clicks on the "Get started"
    When user clicks on the "Withdraw"
    And user enter the withdraw amount
    When user clicks on the continue button
    When user select a catogory
    When user clicks on the "Review and withdraw"
    When user clicks on the "Withdraw now"
    When user enters the pin "1","1","4","8"
    Then user is able to see the text "Insufficient balance"
    When user clicks on the "Close"

  @Dash_06 
  Scenario: Dash_validating the invite friends functionality
    Given open the app on emulator "Ishrar_11.0.0"
    When user clicks on the login button
    When user clicks on the continue button
    When user grants the permission
    When user enter the mobile number as "716177297"
    When user clicks on the continue button
    When user enters the pin "1","1","4","8"
    When user clicks on the invite friends button
    When user clicks on the "Invite friend"
    When user clicks on the allow button
    When click on the plus button
    When user enter the mobile number as "345676777"
    When user clicks on the "Add"
    When user clicks on the "Send • 1 invitation"
    Then user is able to see the text "Invite sent"
    Then user is able to see the text "We will let you know as soon as your friend(s) accept your invite"
    When user clicks on the "Close"

  @Dash_07
  Scenario: Dash_validating the information on profile
    Given open the app on emulator "Ishrar_11.0.0"
    When user clicks on the login button
    When user clicks on the continue button
    When user grants the permission
    When user enter the mobile number as "716177297"
    When user clicks on the continue button
    When user enters the pin "1","1","4","8"
    When user clicks on the profile button
    When user clicks on the "Profile"
    Then user is able to see the text "Timothy Macharia"
    Then user is able to see the text "+254716177297"
    Then user is able to see the text "timothy@spektra.co"

  @Dash_08 
  Scenario: Mobile_validating the sign out functionality
    Given open the app on emulator "Ishrar_11.0.0"
    When user clicks on the login button
    When user clicks on the continue button
    When user grants the permission
    When user enter the mobile number as "716177297"
    When user clicks on the continue button
    When user enters the pin "1","1","4","8"
    When user clicks on the profile button
    When user click on three dots
    When user clicks on the "Log out"
    Then user is able to see the text "Login"

  @Dash_09 
  Scenario: Mobile_validating the invalid mobile number
    Given open the app on emulator "Ishrar_11.0.0"
    When user clicks on the login button
    When user clicks on the continue button
    When user grants the permission
    When user enter the mobile number as "716177234"
    When user clicks on the continue button
    Then user is able to see the text "User not found"

  @Dash_10 
  Scenario: Mobile_validating the invalid pin number
    Given open the app on emulator "Ishrar_11.0.0"
    When user clicks on the login button
    When user clicks on the continue button
    When user grants the permission
    When user enter the mobile number as "716177297"
    When user clicks on the continue button
    When user enters the pin "1","1","2","8"
    Then user is able to see the text "Unauthorized"
