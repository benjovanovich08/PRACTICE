package com.PRACTICE.pages;

import com.PRACTICE.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsPage extends BasePage{

    public ContactsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//div[@id='contacts-list']//div[@class='app-content-list-item-line-one']")
    public List<WebElement> allContactsList;

    @FindBy (xpath = "(//div[@id='contacts-list']//div[@class='app-content-list-item-line-one'])[2]")
    public WebElement secondContact;
}
