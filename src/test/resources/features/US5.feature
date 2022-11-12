@regression
Feature: As a user, I should be able to access to Files module - Favorites button
  Scenario: Verify users to add files to Favorites
    Given user on the dashboard page
    When the user clicks the "Files" module
    When user click action-icon  from "testdoc2.md" file on the page
    And user choose the "Favorite" option
    And the user clicks the "Favorites" sub-module on the left side
    Then Verify the "testdoc2.md" file is listed on the table