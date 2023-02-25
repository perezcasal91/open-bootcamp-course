Feature: Users Management

  Scenario: Save User
    Given Initialize the User Service
    Given An user
      | username | name | lastname |
      | day      | Day  | Leon     |
    And If user doesn't exists "day"
    Then Save user
    Then Verify if "day" was saved