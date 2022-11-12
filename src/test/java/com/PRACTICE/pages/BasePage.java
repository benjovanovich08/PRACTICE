package com.PRACTICE.pages;

import com.PRACTICE.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //LIST of ALL the module elements

    @FindBy (xpath = "//ul[@id='appmenu']//a")
    public List<WebElement> allModuleElements;



    //All the module pages across the top of trycloud pages

    @FindBy (xpath = "//li[@tabindex='-1']//a[@href='/index.php/apps/dashboard/']")
    public WebElement dashboardLink;

    @FindBy (xpath = "//li[@tabindex='-1']//a[@href='/index.php/apps/files/']")
    public WebElement filesLink;

    @FindBy (xpath = "//li[@tabindex='-1']//a[@href='/index.php/apps/photos/']")
    public WebElement photosLink;

    @FindBy (xpath = "//li[@tabindex='-1']//a[@href='/index.php/apps/activity/']")
    public WebElement activitiesLink;

    @FindBy (xpath = "//li[@tabindex='-1']//a[@href='http://qa3.trycloud.net/index.php/apps/spreed/']")
    public WebElement talkLink;

    @FindBy (xpath = "//li[@tabindex='-1']//a[@href='/index.php/apps/mail/']")
    public WebElement mailLink;

    @FindBy (xpath = "//li[@tabindex='-1']//a[@href='/index.php/apps/contacts/']")
    public WebElement contactsLink;

    @FindBy (xpath = "//li[@tabindex='-1']//a[@href='/index.php/apps/circles/']")
    public WebElement circlesLink;

    @FindBy (xpath = "//li[@tabindex='-1']//a[@href='/index.php/apps/calendar/']")
    public WebElement calendarLink;

    @FindBy (xpath = "//li[@tabindex='-1']//a[@href='/index.php/apps/deck/']")
    public WebElement deckLink;




    //This the "More" element that is ONLY VISIBLE ON SELENIUM IF NOT ALL MODULES ARE DISPLAYED ON SCREEN

    @FindBy (xpath = "//li[@id='more-apps']")
    public WebElement threeDotsMoreLink;




    //These are the elements on the top-right corner of screen beginning with Search button through the User's dropdown

    @FindBy (xpath = "//a[@aria-controls='header-menu-unified-search']")
    public WebElement searchBtn;

    @FindBy (xpath = "//div[@class='notifications-button menutoggle']")
    public WebElement notificationsBtn;

    @FindBy (xpath = "//div[@class='icon-contacts menutoggle']")
    public WebElement searchContactsBtn;

    @FindBy (xpath = "//div[@id='expand']")
    public WebElement userDropDownBtn;

    @FindBy (xpath = "//input[@class='unified-search__form-input']")
    public WebElement searchBtnInputBox;

    @FindBy (xpath = "//ul[@class='unified-search__results unified-search__results-files']//a")
    public List<WebElement> allFileAndFolderSearchResults;

    @FindBy (xpath = "//ul[@class='unified-search__results unified-search__results-contacts']//a//h3")
    public List<WebElement> allContactsSearchResults;
}

