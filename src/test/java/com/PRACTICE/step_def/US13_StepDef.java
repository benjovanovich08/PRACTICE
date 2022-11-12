package com.PRACTICE.step_def;

import com.PRACTICE.pages.ContactsPage;
import com.PRACTICE.utility.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class US13_StepDef {
    ContactsPage contactsPage=new ContactsPage();


    @Then("verify the contact names are in the list")
    public void verify_the_contact_names_are_in_the_list() {
        if(contactsPage.allContactsList.size()>=2){
            for(int i=1;i<contactsPage.allContactsList.size();i++){
                Assert.assertFalse(contactsPage.allContactsList.get(i).getText().equals(""));
            }
        }
    }


}
