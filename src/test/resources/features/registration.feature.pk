@Registration
Feature: Registration

  Scenario Outline: Succesful registration
    Given Pepito wants to sign up in the application
    When Pepito send the required information to sign up
    |<name>|<last name>|<age>|<email>|<country>|
    Then Pepito should have a new account created
    Examples:
    |name|last name|age|email|country|
    |Antonio|Hernandez|31|antonio@gmail.com|Colombia|
    |Hilson|Suazo|29|hilson@gmail.com|Mexico|


  Scenario: Missing required fields for registration
    Given Pepito wants to sign up in the application
    When Pepito does not send the required information
    Then Pepito should be told all fields are required
    #When Pepito send the required information to sign up
    #Then Pepito should have a new account created

