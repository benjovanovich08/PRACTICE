@regression
Feature: As a user, I should be able to write comments to files/folders.

  Scenario: Verify users to write comments to files/folder
    Given user on the dashboard page
    When the user clicks the "Files" module
    And user click action-icon  from "testfolder1" file on the page
    And user choose the "Details" option from dropdown
    And user write a comment inside the input box
    And user click the submit button to post it
    Then Verify the comment is displayed in the comment section.