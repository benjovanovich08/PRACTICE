package com.PRACTICE.pages;

import com.PRACTICE.utility.Driver;
import org.openqa.selenium.support.PageFactory;

public class ActivitiesPage extends BasePage {

    public ActivitiesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
