package com.PRACTICE.step_def;

import com.PRACTICE.pages.FilesPage;
import com.PRACTICE.utility.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class US6_StepDef {

    FilesPage filesPage = new FilesPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Then("Verify that the {string} file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table(String fileName) {
        List<String> favoriteFilesNames = new ArrayList<>();

        for (WebElement each : filesPage.listAllFavoriteFilesAndFolders) {
            favoriteFilesNames.add(each.getAttribute("data-file"));
        }
        Assert.assertFalse(favoriteFilesNames.contains(fileName));
    }


    @Then("verify the file {string} is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page(String fileName) throws InterruptedException {
        Thread.sleep(1500);
       String verification="";
        for (WebElement each : filesPage.allFolderAndFiles) {
            if (each.getAttribute("data-file").contains(fileName)) {
                verification=fileName;
            }
        }
        Assert.assertEquals(fileName,verification);
    }
}
