package com.PRACTICE.pages;

import com.PRACTICE.utility.Driver;
import org.openqa.selenium.support.PageFactory;

public class MailPage extends BasePage{

    public MailPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }




}
