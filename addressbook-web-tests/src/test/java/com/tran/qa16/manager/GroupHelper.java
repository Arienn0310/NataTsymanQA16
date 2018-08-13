package com.tran.qa16.manager;

import com.tran.qa16.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
      super(wd);
    }

    public void returnToTheGroupsPage() {
        click();
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupsForm(GroupData group) {
        type(By.name("group_name"),group.getName());
        type(By.name("group_header"),group.getHeader());
        type(By.name("group_footer"),group.getFooter());
    }


    public void initGroupCreation() {
        click(By.xpath("//*[@value='New group'][2]"));
    }

    public int getGroupsCount(){
        return wd.findElements(By.cssSelector("span.group")).size();
    }

    public boolean isElementPresent(By locator){
        try{
            wd.findElement(locator);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public void goToGroupsPage() {
        if(!isElementPresent(By.xpath("//h1[contains(text(),'Groups')]"))
                && !isElementPresent(By.name("new"))){
            click(By.linkText("groups"));
        }
    }

    public void click() {
        click(By.linkText("groups"));
    }

    public void groupDeletion() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void selectGroupByIndex(int ind){
        wd.findElements(By.name("selected[]")).get(ind).click();
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void initGroupModification() {
        click(By.xpath("//*[@name='edit'][1]"));
    }

    public void selectGroupByindex(int index){
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void createGroup(){
        initGroupCreation();
        fillGroupsForm(new GroupData()
                .withName("testGroupName1")
                .withHeader("testGroupHeader1")
                .withFooter("testGroupFooter1"));
        submitGroupCreation();
        returnToTheGroupsPage();
    }

    public boolean isGroupPresent(){
        return isElementPresent(By.name("selected[]"));
    }

}
