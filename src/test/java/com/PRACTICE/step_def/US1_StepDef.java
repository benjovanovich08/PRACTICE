package com.PRACTICE.step_def;

import com.PRACTICE.pages.LoginPage;
import com.PRACTICE.utility.ConfigurationReader;
import com.PRACTICE.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US1_StepDef {

    LoginPage loginPage=new LoginPage();
    @Given("user on the trycloud login page")
    public void user_on_the_trycloud_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env3"));
    }
    @When("user use username {string} and passcode {string}")
    public void user_use_username_and_passcode(String username, String password) {
    loginPage.usernameInput.sendKeys(username);
    loginPage.passwordInput.sendKeys(password);
    }
    @When("user click the login button")
    public void user_click_the_login_button() {
    loginPage.loginBtn.click();
    }
    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));
    }


}
