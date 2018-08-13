package com.tran.qa16;


import com.tran.qa16.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {
    @Test
        public void contactDeletionTest() {
        int before = app.wd.findElements(By.name("selected[]")).size();
        selectContact();
        deleteContact();
        confirmAlert();
        int after = app.wd.findElements(By.name("selected[]")).size();

        Assert.assertEquals(after,before-1);
    }

    private void confirmAlert() {
        app.wd.switchTo().alert().accept();
    }

    private void dismissAlert(){
        app.wd.switchTo().alert().dismiss();
    }

    private void deleteContact() {
        app.wd.findElement(By.xpath("//*[@value='Delete']")).click();
    }

    private void selectContact() {
        app.wd.findElement(By.name("selected[]")).click();
    }
}
