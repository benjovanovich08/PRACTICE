package com.PRACTICE.step_def;

import com.PRACTICE.pages.ContactsPage;
import com.PRACTICE.utility.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class US14_StepDef {

    ContactsPage contactsPage=new ContactsPage();
    @When("the user clicks the magnifier icon on the right top")
    public void the_user_clicks_the_magnifier_icon_on_the_right_top() {
        contactsPage.searchBtn.click();
    }

    @When("users search any existing file-folder-user name")
    public void users_search_any_existing_file_folder_user_name() {
        contactsPage.searchBtnInputBox.sendKeys(ConfigurationReader.getProperty("searchFunctionData")+ Keys.ENTER);
    }
    @Then("verify the app displays the expected result option")
    public void verify_the_app_displays_the_expected_result_option()  {
        for(int i=0;i<contactsPage.allFileAndFolderSearchResults.size()-1;i++){
            Assert.assertTrue(contactsPage.allFileAndFolderSearchResults.get(i).getAttribute("href").contains(ConfigurationReader.getProperty("searchFunctionData")));
        }
        for(int i=0;i<contactsPage.allContactsSearchResults.size();i++){
            Assert.assertTrue(contactsPage.allContactsSearchResults.get(i).getAttribute("title").toLowerCase().contains(ConfigurationReader.getProperty("searchFunctionData")));
        }
    }
}
