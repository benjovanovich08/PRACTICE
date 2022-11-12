package com.PRACTICE.step_def;

import com.PRACTICE.pages.FilesPage;
import com.PRACTICE.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class US10_StepDef {

    FilesPage filesPage=new FilesPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
    @When("user clicks Settings on the left bottom corner")
    public void user_clicks_settings_on_the_left_bottom_corner() {
    filesPage.settingsBtn.click();

    }
    @Then("the user should be able to click any buttons")
    public void the_user_should_be_able_to_click_any_buttons() {

    for(int i=1;i<filesPage.extraFileSettings.size();i++){
        filesPage.extraFileSettings.get(i).click();
        Assert.assertFalse(filesPage.extraFileSettings.get(i).isSelected());
    }





    }


    public Integer getStorageAmount() {
       Integer storageAmount = Integer.parseInt(filesPage.storageUsed.getText().substring(0, 3));
       return storageAmount;
    }
    public Integer originalStorage=getStorageAmount();
    @When("user checks the current storage usage")
    public void user_checks_the_current_storage_usage() {
    //Done above step to hold value of storage amount and make accessible in assertion step
        filesPage.plusBtnTopScreen.click();
    }

    @When("user refresh the page")
    public void user_refresh_the_page() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@data-file='testUpload.txt']")));
        Driver.getDriver().navigate().refresh();
    }
    @Then("the user should be able to see storage usage is increased")
    public void the_user_should_be_able_to_see_storage_usage_is_increased() {
    wait.until(ExpectedConditions.visibilityOf(filesPage.storageUsed));
    Integer currentStorageAmount=getStorageAmount();
        System.out.println(originalStorage+"     "+currentStorageAmount);
    Assert.assertTrue(currentStorageAmount>originalStorage);
    }
}
