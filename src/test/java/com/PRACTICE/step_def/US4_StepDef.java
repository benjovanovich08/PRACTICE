package com.PRACTICE.step_def;

import com.PRACTICE.pages.FilesPage;
import com.PRACTICE.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class US4_StepDef {

    FilesPage filesPage=new FilesPage();

    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String expectedTitle) {
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }



    @When("user click the top-left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        filesPage.selectAllFilesBtn.click();
    }
    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() throws InterruptedException {

        for(WebElement each:filesPage.allFilesCheckboxes){
            Assert.assertTrue(each.isSelected());
            }
        Thread.sleep(1500);
    }






}
