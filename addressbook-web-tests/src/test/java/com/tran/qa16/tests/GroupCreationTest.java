package com.tran.qa16.tests;

import com.tran.qa16.model.GroupData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupsCount();
        List<GroupData>groupsListBefore=app.getGroupHelper().getGroupsList();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupsForm(new GroupData()
                .withName("testGroupName1")
                .withHeader("testGroupHeader1")
                .withFooter("testGroupFooter1"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToTheGroupsPage();
        int after = app.getGroupHelper().getGroupsCount();
        List<GroupData>groupsListAfter=app.getGroupHelper().getGroupsList();
        Assert.assertEquals(groupsListAfter.size(),groupsListBefore.size()+1);

        //Assert.assertEquals(after,before+1);

        logger.info("Stop testGroupCreation");
    }

    @Test
    public void testGroupCreationWithEmptyFields() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupsForm(new GroupData()
                .withName("")
                .withHeader("")
                .withFooter(""));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToTheGroupsPage();
    }

    @Test
    public void testGroupCreationWithLongName() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupsForm(new GroupData()
                .withName("GroupNameeeeeeeeeeeeeeeeeeee")
                .withHeader("testGroupHeader1")
                .withFooter("testGroupFooter1"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToTheGroupsPage();
    }

}


