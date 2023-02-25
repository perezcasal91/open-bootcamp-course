Feature: Init with Gherkins and Cucumber

  Scenario: The assistant watch the environment
    Given Open the environment
    And I have assistants
    When They look the screen
    Then I said hi

  Scenario: Verify pay list
    Given User will pay with one of these methods
          | Card  |
          | Cash  |
          | Check |
    When We request that payment be made
    Then Check the requested method
