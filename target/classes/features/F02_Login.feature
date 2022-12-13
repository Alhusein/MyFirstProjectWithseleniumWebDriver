@smoke

Feature:User should be able to login to the system


  Scenario: user login with valid data
    Given    user navigate to login page
    When     user enter "aalhussein.ibrahim@gmail.com" and "kkll2022"
    And    user click on login button
    Then    user could login successfully and go to home page


  Scenario: user login with invalid data
    Given    user navigate to login page
    When     user enter "aalhussein.ibra@gmail.com" and "llkk2022"
    And    user click on login button
    Then   user could not login successfully