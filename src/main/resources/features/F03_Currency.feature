@smoke
Feature: User could switch between currencies [$, €]


  Scenario: user can choose euro currency
    When user select “euro” from currency dropdown list
    Then  All the products change to euro symbol
