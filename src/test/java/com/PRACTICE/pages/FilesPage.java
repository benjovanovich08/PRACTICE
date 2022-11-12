package com.PRACTICE.pages;

import com.PRACTICE.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage extends BasePage {

    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='icon icon-more'])")
    public WebElement actionsBtnsNOTUNIQUE;

    @FindBy(xpath = "//tr[@data-type]")
    public List<WebElement> allFolderAndFiles;

    @FindBy(xpath = "//div[@class='fileActionsMenu popovermenu bubble open menu']//li//a")
    public List<WebElement> fileActionsMenuElements;

    @FindBy(xpath = "(//div[@class='fileActionsMenu popovermenu bubble open menu'])//li[3]")
    public WebElement favoriteOptionActionDropdown;

    @FindBy(xpath = "//div[@id='app-navigation']//li//a")
    public List<WebElement> leftSideMenuOptions;

    @FindBy(xpath = "//tr[@data-quota='-1']//td[@class='filename']//a[@class='name']//span[@class='nametext extra-data']")
    public List<WebElement> allDeletedFiles;

    @FindBy(xpath = "(//th[@id='headerSelection'])[1]")
    public WebElement selectAllFilesBtn;

    @FindBy(xpath = "//td[@class='selection']")
    public List<WebElement> listOfEachFilesSelectCheckBox;

    @FindBy(xpath = "//div[@id='app-content-favorites']//tbody//tr")
    public List<WebElement> listAllFavoriteFilesAndFolders;

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement plusBtnTopScreen;

    @FindBy(xpath = "//a[@data-templatename='New folder']")
    public WebElement newFolderBtnInDropdown;

    @FindBy(xpath = "//input[@id='view13-input-folder']")
    public WebElement newFolderNameInputBox;

    @FindBy(xpath = "//span[.='Upload file']")
    public WebElement uploadFileBtnInDropdown;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement newFolderConfirmationBtn;

    @FindBy(xpath = "(//tbody[@id='fileList'])[1]//tr")
    public List<WebElement> filesUploadedInsideFolder;

    @FindBy (xpath = "//a[@id='commentsTabView']")
    public WebElement commentsBtn;

    @FindBy (xpath = "//div[@data-placeholder='New comment …']")
    public WebElement commentInputBox;

    @FindBy (xpath = "//input[@class='submit icon-confirm has-tooltip']")
    public WebElement commentSendKeysBtn;

    @FindBy (xpath = "//div[@id='commentsTabView']//div[@class='message']")
    public List<WebElement> allComments;

    @FindBy (xpath = "//div[@class='fileActionsMenu popovermenu bubble open menu']//li")
    public List<WebElement> actionsMenu;

    @FindBy (xpath = "//a[@class='menuitem action action-details permanent']")
    public WebElement detailsBtn;

    @FindBy (xpath = "//td[@class='selection']//input")
    public List<WebElement> allFilesCheckboxes;

    @FindBy (xpath = "(//span[@class='info'])[2]")
    public WebElement bottomDeletedFilesPage;

    @FindBy (xpath = "(//a[@id='modified'])[12]")
    public WebElement deletedFilesSortBtn;

    @FindBy (xpath = "//button[@class='settings-button']")
    public WebElement settingsBtn;

    @FindBy (xpath = "//div[@id='app-settings-content']//div[@id]")
    public List<WebElement> extraFileSettings;

    @FindBy (xpath = "//div[@id='files-setting-richworkspace']")
    public WebElement showWorkSpaceChkBox;

    @FindBy (xpath = "//a[@class='icon-quota svg']//p")
    public WebElement storageUsed;




    public boolean assertFileIsCreated(String folderOrFileNameSearching) {
        for (WebElement each : allFolderAndFiles) {
            if (each.getAttribute("data-file").contains(folderOrFileNameSearching)) {
                return true;
            }
        }return false;
    }


}