package com.PRACTICE.step_def;

import com.PRACTICE.pages.LoginPage;
import com.PRACTICE.utility.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class US3_StepDef {

    LoginPage loginPage=new LoginPage();
    @When("the users  log in with valid credentials")
    public void the_users_log_in_with_valid_credentials() {
        loginPage.loginTryCloud(ConfigurationReader.getProperty("user7"),ConfigurationReader.getProperty("universalPassword"));
    }
    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> expectedModuleName) {

        List<String> actualModuleNames = new ArrayList<String>();

        for(WebElement each:loginPage.allModuleElements) {
            if (each.isDisplayed()) {
                actualModuleNames.add(each.getAttribute("aria-label"));
            }
        }
        Assert.assertEquals(expectedModuleName,actualModuleNames);
    }
}
