package com.PRACTICE.pages;

import com.PRACTICE.utility.Driver;
import org.openqa.selenium.support.PageFactory;

public class CirclesPage extends BasePage{

    public CirclesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }




}
