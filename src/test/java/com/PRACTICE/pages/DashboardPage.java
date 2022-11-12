package com.PRACTICE.pages;

import com.PRACTICE.utility.Driver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage{

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
