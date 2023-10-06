@APItests
Feature: validating the Dash Api functionality

  @Apitest1 @Demo
  Scenario Outline: validating the post request
    Given read the data from "<Filename>"
    When i sent the post request to "<URL>" and device id is "<DeviceId>"
    Then I verify the status as "200"
    Then getting the access token

    Examples:
      | Filename | URL               | DeviceId     |  |
      | payload  | https://api-test.spektra.co/api/v2/auth/app-login | 71CF708BEE08 |  |

  @Apitest2 @Demo
  Scenario Outline: validating the second request
    When i sent the get request to "<URL>"
    Then I verify the status as "200"
    Examples:
      | URL       |  |  |
      | https://api-test.spektra.co/api/v1/floats |  |  |


  @Apitest3 @Demo
  Scenario Outline: validating the post request
      Given read the data from "<Filename>"
      When i sent the post request to "<Endpoint>" and device id is "<DeviceId>"
      Then I verify the status as "200"
      Then getting the access token

      Examples:
        | Filename | Endpoint      | DeviceId     |  |
        | username | https://api-test.spektra.co/api/v1/auth/login | 71CF708BEE08 |  |

  @Apitest4 @Demo
  Scenario Outline: validating the product summary by Using Start date and End Date 
    When i sent the get request to "<URL>"
    Then I verify the status as "200"
        Examples:
          | URL                                                                                  |  |  |
          | https://api-test.spektra.co/api/v1/rewards/product/summary?startDate=2022-06-28T12:12:12&endDate=2023-09-08T13:06:29 |  |  |

  @Apitest5 @Demo
  Scenario Outline: validating the User sign up by Using Start date and End Date 
    When i sent the get request to "<URL>"
    Then I verify the status as "200"
    Examples:
      | URL                                                   |  |  |
      | https://backoffice-dev-api.spektra.co/api/v3/reports/user-signups?from=2023-08-01&to=2023-08-28 |  |  |
      
  @Apitest6 @Demo
  Scenario Outline: validating the Country Filter request
    When i sent the get request to "<URL>"
    Then I verify the status as "200"
    Examples:
      | URL                                                   |  |  |
      | https://api-test.spektra.co/api/v1/stats/log-ins?startDate=2022-09-05T04:55:58&endDate=2023-09-05T04:55:58&country=GH |  |  |





