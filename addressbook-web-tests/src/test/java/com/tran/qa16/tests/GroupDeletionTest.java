package com.tran.qa16.tests;

import com.tran.qa16.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTest extends TestBase {

    @Test
    public void deletionLastGroupTest() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        if(!app.getGroupHelper().isGroupPresent()){
            app.getGroupHelper().createGroup();
        }
        List<GroupData> groupsListBefore = app.getGroupHelper().getGroupsList();

        //int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroupByIndex(groupsListBefore.size()-1);//last group
        app.getGroupHelper().groupDeletion();
        app.getGroupHelper().returnToTheGroupsPage();
        //int after = app.getGroupHelper().getGroupsCount();

        List<GroupData> groupsListAfter = app.getGroupHelper().getGroupsList();

        Assert.assertEquals(groupsListAfter.size(), groupsListBefore.size()-1);
        groupsListBefore.remove(groupsListBefore.size()-1);

        Assert.assertEquals(groupsListAfter, groupsListBefore);

    }

    @Test
    public void deletionFirstGroupTest() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        if(!app.getGroupHelper().isGroupPresent()){
            app.getGroupHelper().createGroup();
        }
        int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroup();//first group
        app.getGroupHelper().groupDeletion();
        app.getGroupHelper().returnToTheGroupsPage();
        int after = app.getGroupHelper().getGroupsCount();

        Assert.assertEquals(after, before-1);

    }
    @Test
    public void testGroupDeletion() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        if(!app.areEltsPresent(By.name("selected[]"))){
            app.getGroupHelper().createGroup();
        }
        int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroupByIndex(before-1);
        Thread.sleep(3000);
        app.getGroupHelper().groupDeletion();
        app.getGroupHelper().returnToTheGroupsPage();
        int after = app.getGroupHelper().getGroupsCount();

        Assert.assertEquals(after,before-1);

    }

}
