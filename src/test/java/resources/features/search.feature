
Feature: Search functionality

  Background: Preconditions
    Given Home page is opened

  Scenario: Check Global Search functionality
    When Global search for "Aimprosoft"
    Then Search results page should be displayed with 10 results
    Then Search results should contain "1Aimprosoft"

  Scenario Outline: Check auto-filling functionality of Global Search drop-down list
    When Enter "<text>" into Global search field
    Then The values of Global search drop-down list should contain "<text>"
    Examples:
      | text        |
      | apple       |
      | apple juice |