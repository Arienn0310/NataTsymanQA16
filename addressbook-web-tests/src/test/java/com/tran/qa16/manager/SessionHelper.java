package com.tran.qa16.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);

        click(By.xpath("//*[@value='Login']"));
    }

    public void openSite(String url) {
        wd.navigate().to(url);
    }

    public void logout() {
        click(By.xpath("//a[contains(text(),'Logout')]"));
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.xpath("//a[contains(text(),'Logout')]"));
    }
}
