package com.PRACTICE.pages;

import com.PRACTICE.utility.Driver;
import org.openqa.selenium.support.PageFactory;

public class DeckPage extends BasePage{

    public DeckPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }





}
