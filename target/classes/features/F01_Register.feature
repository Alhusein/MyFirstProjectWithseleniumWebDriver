@smoke

Feature:Users could register with new accounts


    Scenario: user full the data to be able to register to the website
        Given user navigate to register page
        And     user select gender type
        When    user enter valid data
        And   user click on register button
        Then   success message is displayed