package com.PRACTICE.step_def;

import com.PRACTICE.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US2_StepDef {

    LoginPage loginPage=new LoginPage();
    @When("user enter invalid {string} and {string}")
    public void user_enter_invalid_and(String invalidUsername, String invalidPassword) {
    loginPage.loginTryCloud(invalidUsername,invalidPassword);
    }
    @Then("verify {string} message should be displayed")
    public void verify_message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage,loginPage.wrongUserCredentialsWarningMsg.getText());
    }
}
