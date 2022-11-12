@regression
Feature: As a user, I should be able to remove files from favorites and upload a file directly

  Scenario: verify users to remove files to Favorites
    Given user on the dashboard page
    When the user clicks the "Files" module
    When user click action-icon  from "testdoc1.md" file on the page
    And  user choose the "Favorite" option
    And the user clicks the "Favorites" sub-module on the left side
    Then Verify that the "testdoc1.md" file is removed from the Favorites sub-module’s table


  Scenario: verify users to upload a file from Files
    Given user on the dashboard page
    When the user clicks the "Files" module
    When user clicks the add icon on the top
    And the user uploads a file with the upload file option
    Then verify the file "testUpload" is displayed on the page