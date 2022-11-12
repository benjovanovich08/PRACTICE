package com.PRACTICE.step_def;

import com.PRACTICE.pages.TalkPage;
import com.PRACTICE.utility.ConfigurationReader;
import com.PRACTICE.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class US11_StepDef {
    TalkPage talkPage=new TalkPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);


    @When("user search user from the search box")
    public void user_search_user_from_the_search_box() {
        wait.until(ExpectedConditions.visibilityOfAllElements(talkPage.listOfAllUsers));
        talkPage.listOfAllUsers.get(1).click();
    }
    @When("user write a test message")
    public void user_write_a_test_message()  {
        talkPage.msgInputBox.sendKeys(ConfigurationReader.getProperty("testMsg"));
    }
    @When("user clicks to submit button")
    public void user_clicks_to_submit_button() throws InterruptedException {
        Thread.sleep(3000);
        talkPage.msgSubmitBtn.click();
    }
    @Then("the user should be able to see the message is displayed on the conversation log")
    public void the_user_should_be_able_to_see_the_message_is_displayed_on_the_conversation_log() throws InterruptedException {
        Thread.sleep(1500);
        for(WebElement each: talkPage.allMessageElements) {
            if (each.getText().equals(ConfigurationReader.getProperty("testMsg"))) {
                Assert.assertEquals(ConfigurationReader.getProperty("testMsg"), each.getText());
            }
        }
    }
}
