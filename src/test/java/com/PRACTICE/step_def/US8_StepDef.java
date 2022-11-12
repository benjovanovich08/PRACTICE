package com.PRACTICE.step_def;


import com.PRACTICE.pages.FilesPage;
import com.PRACTICE.pages.LoginPage;
import com.PRACTICE.utility.ConfigurationReader;
import com.PRACTICE.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class US8_StepDef {

    //Global objects of page classes and WebDriverWait class so they are accessible in any step
    LoginPage loginPage=new LoginPage();
    FilesPage filesPage=new FilesPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);


    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
    loginPage.loginTryCloud(ConfigurationReader.getProperty("user7"),ConfigurationReader.getProperty("universalPassword"));
    }

    //This step allows user to access any module based on argument given
    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String moduleName) {
        moduleName=moduleName.toLowerCase();
        switch (moduleName){
            case "dashboard" : loginPage.dashboardLink.click();break;
            case "files" : loginPage.filesLink.click();break;
            case "photos" : loginPage.photosLink.click();break;
            case "activity" : loginPage.activitiesLink.click();break;
            case "talk" : loginPage.talkLink.click();break;
            case "mail" : loginPage.mailLink.click();break;
            case "contacts" : loginPage.contactsLink.click();break;
            case "circles" : loginPage.circlesLink.click();break;
            case "calendar" : loginPage.calendarLink.click();break;
            case "deck" : loginPage.deckLink.click();break;
            default:
                System.out.println("Module name does not exist");
        }
    }


    //This step puts all files/folders into a List, loops through all elements until fileName passed in feature file matches fileName in list and holds the index number. Then it creates the custom locator for specific file actionsButton by adding the index number in brackets to dynamic locator base. Then clicks the unique actions button for specified file.
    @When("user click action-icon  from {string} file on the page")
    public void user_click_action_icon_from_file_on_the_page(String fileName)  {

    int indexHolder=1;

    for(WebElement each: filesPage.allFolderAndFiles) {
        indexHolder++;
        if (each.getAttribute("data-file").equalsIgnoreCase(fileName)) {

            String actionButtonIdentifier = ConfigurationReader.getProperty("filesActionsButtonDynamicLocatorBase") + "[" + indexHolder + "]";

            WebElement currentFileActionsBtn = Driver.getDriver().findElement(By.xpath(actionButtonIdentifier));
            currentFileActionsBtn.click();
        }
    }
    }

    //This step loops through actionButtonDropdownOptions and checks for matching requestedAction passed in feature. Then clicks matching requestedAction.
    @When("user choose the {string} option")
    public void user_choose_the_option(String requestedAction) {
        wait.until(ExpectedConditions.visibilityOf(filesPage.favoriteOptionActionDropdown));
        for (WebElement each : filesPage.fileActionsMenuElements) {
            if (each.getAttribute("data-action").contains(requestedAction)) {
                each.click();
                break;
            }
        }
    }

    //This step loops through all menu options on left side of files module and clicks on option matching menuOption passed in feature.
    @When("the user clicks the {string} sub-module on the left side")
    public void the_user_clicks_the_sub_module_on_the_left_side(String menuOption) {
    for(WebElement each: filesPage.leftSideMenuOptions){
        if(menuOption.equals(each.getText())){
            each.click();
            break;
        }
    }
    }


    //This step verifies the fileName passed is displayed in deleted files.
    @Then("Verify the {string} deleted file is displayed on the page.")
    public void verify_the_deleted_file_is_displayed_on_the_page(String fileName) throws InterruptedException {
       String verify="";

        filesPage.deletedFilesSortBtn.click();
        filesPage.deletedFilesSortBtn.click();

        wait.until(ExpectedConditions.visibilityOf(filesPage.bottomDeletedFilesPage));

    for(WebElement each:filesPage.allDeletedFiles){
        if(each.getAttribute("data-original-title").contains(fileName)){
        verify=fileName;
        break;
        }
    }
    Assert.assertEquals(fileName,verify);
    }

}
