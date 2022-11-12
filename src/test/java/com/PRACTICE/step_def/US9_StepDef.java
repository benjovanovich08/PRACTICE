package com.PRACTICE.step_def;

import com.PRACTICE.pages.FilesPage;
import com.PRACTICE.utility.ConfigurationReader;
import com.PRACTICE.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class US9_StepDef {

    FilesPage filesPage=new FilesPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);

    @When("user choose the {string} option from dropdown")
    public void user_choose_the_option_from_dropdown(String dropDownOption) {
       filesPage.detailsBtn.click();
    }
    @When("user write a comment inside the input box")
    public void user_write_a_comment_inside_the_input_box() {
        wait.until(ExpectedConditions.visibilityOf(filesPage.commentsBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(filesPage.commentInputBox)).sendKeys(ConfigurationReader.getProperty("testMsg"));

    }
    @When("user click the submit button to post it")
    public void user_click_the_submit_button_to_post_it() {

        filesPage.commentSendKeysBtn.click();
    }
    @Then("Verify the comment is displayed in the comment section.")
    public void verify_the_comment_is_displayed_in_the_comment_section() throws InterruptedException {
        String containsComment="";
        Thread.sleep(1000);
        for(WebElement each:filesPage.allComments){
            if(each.getText().equals(ConfigurationReader.getProperty("testMsg"))){
                containsComment=ConfigurationReader.getProperty("testMsg");
            }
        }
        Thread.sleep(1000);
        Assert.assertEquals(ConfigurationReader.getProperty("testMsg"),containsComment);

    }
}
