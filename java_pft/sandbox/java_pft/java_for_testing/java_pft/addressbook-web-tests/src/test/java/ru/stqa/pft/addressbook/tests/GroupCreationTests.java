package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase{


    @Test
    public void groupCreationTests() throws Exception {

        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().createGroup(new GroupData("Test1", null, null));
        List<GroupData> after = app.getGroupHelper().getGroupList();
       Assert.assertEquals(after.size(), before.size()+1);
       }

}
