package com.PRACTICE.pages;

import com.PRACTICE.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TalkPage extends BasePage{

    public TalkPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//input[@class='app-navigation-search__input']")
    public WebElement userSearchBar;

    @FindBy (xpath = "//div[@contenteditable='true']")
    public WebElement msgInputBox;

    @FindBy (xpath = "//button[@class='new-message-form__button submit icon-confirm-fade']")
    public WebElement msgSubmitBtn;

    @FindBy (xpath = "//div[@class='scroller']//div[@class='message']")
    public List<WebElement> allMessageElements;

    @FindBy (xpath = "//li[@class='acli_wrapper']")
    public List<WebElement> listOfAllUsers;

}
