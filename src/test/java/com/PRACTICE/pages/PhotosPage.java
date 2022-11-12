package com.PRACTICE.pages;

import com.PRACTICE.utility.Driver;
import org.openqa.selenium.support.PageFactory;

public class PhotosPage extends BasePage{

    public PhotosPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
