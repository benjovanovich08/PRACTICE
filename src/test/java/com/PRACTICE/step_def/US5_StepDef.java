package com.PRACTICE.step_def;

import com.PRACTICE.pages.FilesPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class US5_StepDef {

    FilesPage filesPage=new FilesPage();

    @Then("Verify the {string} file is listed on the table")
    public void verify_the_file_is_listed_on_the_table(String fileName) {
        String verify="";
        for(WebElement each:filesPage.listAllFavoriteFilesAndFolders){
            if(each.getAttribute("data-file").equals(fileName)){
                verify=fileName;
            }
        }
        Assert.assertEquals(fileName,verify);
    }
}
