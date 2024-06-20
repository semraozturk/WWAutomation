Feature: As user, I should be able to find a studio for workshop

  @findStudio @regression
  Scenario Outline: Find a workshop studio by zipcode
    Given user has navigated to the home page
    And verified the page title
    When user clicks on Studio button
    And user enters "<zipcode>" in the search field box
    And user prints the title and distance of the first search result
    And user clicks on the first search result
    And user verifies the displayed location title in the workshop detail page
    And user clicks on Business Hours button
    Then user should be able to print the business days and hours.

  
    Examples:
    |zipcode |
    | 10011   |
