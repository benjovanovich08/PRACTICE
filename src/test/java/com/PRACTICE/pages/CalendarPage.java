package com.PRACTICE.pages;

import com.PRACTICE.utility.Driver;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends BasePage{

    public CalendarPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
