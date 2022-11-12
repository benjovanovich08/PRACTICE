package com.PRACTICE.step_def;

import com.PRACTICE.pages.FilesPage;
import com.PRACTICE.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class US7_StepDef {

    FilesPage filesPage=new FilesPage();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
    @When("user clicks the add icon on the top")
    public void user_clicks_the_add_icon_on_the_top() {
        wait.until(ExpectedConditions.visibilityOf(filesPage.plusBtnTopScreen)).click();
    }
    @When("user click new folder")
    public void user_click_new_folder()  {
        wait.until(ExpectedConditions.visibilityOf(filesPage.newFolderBtnInDropdown)).click();


    }
    @When("user write a folder {string}")
    public void user_write_a_folder(String folderName)  {
        wait.until(ExpectedConditions.visibilityOf(filesPage.newFolderNameInputBox)).sendKeys(folderName);

    }
    @When("the user click submit icon")
    public void the_user_click_submit_icon(){
        wait.until(ExpectedConditions.visibilityOf(filesPage.newFolderConfirmationBtn)).click();


    }
    @Then("Verify the folder {string} is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page(String folderName)  {
        wait.until(ExpectedConditions.visibilityOfAllElements(filesPage.allFolderAndFiles));
        boolean tcPassed=false;
    for(WebElement each:filesPage.allFolderAndFiles){
        if(each.getText().equals(folderName)){
           tcPassed=true;
        }
    }Assert.assertTrue(tcPassed=true);
    }






    @When("user choose a folder {string} from the page")
    public void user_choose_a_folder_from_the_page(String folderName) {
        wait.until(ExpectedConditions.visibilityOfAllElements(filesPage.allFolderAndFiles));
    for(WebElement each:filesPage.allFolderAndFiles){
        if(each.getAttribute("data-file").equals(folderName)){
            each.click();
        }
    }
    }

    @When("the user uploads a file with the upload file option")
    public void the_user_uploads_a_file_with_the_upload_file_option() throws AWTException {

        wait.until(ExpectedConditions.visibilityOf(filesPage.uploadFileBtnInDropdown)).click();

        Robot rb = new Robot();

        // copying File path to Clipboard
        StringSelection str = new StringSelection("\"C:\\Users\\james\\testUpload.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }
    @Then("Verify the file {string} is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page(String fileName) {
        boolean tcPass=false;
        wait.until(ExpectedConditions.visibilityOfAllElements(filesPage.filesUploadedInsideFolder));
        for(WebElement each: filesPage.filesUploadedInsideFolder){
            if(each.getAttribute("data-file").contains(fileName)){
                tcPass=true;
            }
        }Assert.assertTrue(tcPass=true);

    }

}
