package com.PRACTICE.pages;

import com.PRACTICE.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy (xpath = "//input[@id='user']")
    public WebElement usernameInput;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy (xpath = "//input[@id='submit-form']")
    public WebElement loginBtn;

    @FindBy (xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement wrongUserCredentialsWarningMsg;

    //Login Method
    public void loginTryCloud(String username,String password){

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
}
