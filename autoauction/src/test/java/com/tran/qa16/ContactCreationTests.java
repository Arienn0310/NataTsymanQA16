package com.tran.qa16;

import com.tran.qa16.tests.TestBase;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
            public void testContactCreation(){
        app.initContactCreation();
        app.fillContactForm(new ContactData()
                .setFirstname("")
                .setLastname("")
                .setAdress(""));
        app.createContact();

    }

}
